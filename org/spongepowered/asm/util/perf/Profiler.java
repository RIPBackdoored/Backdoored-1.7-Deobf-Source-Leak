package org.spongepowered.asm.util.perf;

import com.google.common.base.Joiner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.PrettyPrinter$Alignment;

public final class Profiler {
   public static final int ROOT = 1;
   public static final int FINE = 2;
   private final Map sections = new TreeMap();
   private final List phases = new ArrayList();
   private final Deque stack = new LinkedList();
   private boolean active;

   public Profiler() {
      this.phases.add("Initial");
   }

   public void setActive(boolean active) {
      if (!this.active && active || !active) {
         this.reset();
      }

      this.active = active;
   }

   public void reset() {
      Iterator var1 = this.sections.values().iterator();

      while(var1.hasNext()) {
         Profiler$Section section = (Profiler$Section)var1.next();
         section.invalidate();
      }

      this.sections.clear();
      this.phases.clear();
      this.phases.add("Initial");
      this.stack.clear();
   }

   public Profiler$Section get(String name) {
      Profiler$Section section = (Profiler$Section)this.sections.get(name);
      if (section == null) {
         section = this.active ? new Profiler$LiveSection(this, name, this.phases.size() - 1) : new Profiler$Section(this, name);
         this.sections.put(name, section);
      }

      return (Profiler$Section)section;
   }

   private Profiler$Section getSubSection(String name, String baseName, Profiler$Section root) {
      Profiler$Section section = (Profiler$Section)this.sections.get(name);
      if (section == null) {
         section = new Profiler$SubSection(this, name, this.phases.size() - 1, baseName, root);
         this.sections.put(name, section);
      }

      return (Profiler$Section)section;
   }

   boolean isHead(Profiler$Section section) {
      return this.stack.peek() == section;
   }

   public Profiler$Section begin(String... path) {
      return this.begin(0, (String[])path);
   }

   public Profiler$Section begin(int flags, String... path) {
      return this.begin(flags, Joiner.on('.').join(path));
   }

   public Profiler$Section begin(String name) {
      return this.begin(0, (String)name);
   }

   public Profiler$Section begin(int flags, String name) {
      boolean root = (flags & 1) != 0;
      boolean fine = (flags & 2) != 0;
      String path = name;
      Profiler$Section head = (Profiler$Section)this.stack.peek();
      if (head != null) {
         path = head.getName() + (root ? " -> " : ".") + name;
         if (head.isRoot() && !root) {
            int pos = head.getName().lastIndexOf(" -> ");
            name = (pos > -1 ? head.getName().substring(pos + 4) : head.getName()) + "." + name;
            root = true;
         }
      }

      Profiler$Section section = this.get(root ? name : path);
      if (root && head != null && this.active) {
         section = this.getSubSection(path, head.getName(), section);
      }

      section.setFine(fine).setRoot(root);
      this.stack.push(section);
      return section.start();
   }

   void end(Profiler$Section section) {
      try {
         Profiler$Section head = (Profiler$Section)this.stack.pop();

         for(Profiler$Section next = head; next != section; next = (Profiler$Section)this.stack.pop()) {
            if (next == null && this.active) {
               if (head == null) {
                  throw new IllegalStateException("Attempted to pop " + section + " but the stack is empty");
               }

               throw new IllegalStateException("Attempted to pop " + section + " which was not in the stack, head was " + head);
            }
         }
      } catch (NoSuchElementException var4) {
         if (this.active) {
            throw new IllegalStateException("Attempted to pop " + section + " but the stack is empty");
         }
      }

   }

   public void mark(String phase) {
      long currentPhaseTime = 0L;

      Iterator var4;
      Profiler$Section section;
      for(var4 = this.sections.values().iterator(); var4.hasNext(); currentPhaseTime += section.getTime()) {
         section = (Profiler$Section)var4.next();
      }

      if (currentPhaseTime == 0L) {
         int size = this.phases.size();
         this.phases.set(size - 1, phase);
      } else {
         this.phases.add(phase);
         var4 = this.sections.values().iterator();

         while(var4.hasNext()) {
            section = (Profiler$Section)var4.next();
            section.mark();
         }

      }
   }

   public Collection getSections() {
      return Collections.unmodifiableCollection(this.sections.values());
   }

   public PrettyPrinter printer(boolean includeFine, boolean group) {
      PrettyPrinter printer = new PrettyPrinter();
      int colCount = this.phases.size() + 4;
      int[] columns = new int[]{0, 1, 2, colCount - 2, colCount - 1};
      Object[] headers = new Object[colCount * 2];
      int col = 0;

      for(int pos = 0; col < colCount; pos = col * 2) {
         headers[pos + 1] = PrettyPrinter$Alignment.RIGHT;
         if (col == columns[0]) {
            headers[pos] = (group ? "" : "  ") + "Section";
            headers[pos + 1] = PrettyPrinter$Alignment.LEFT;
         } else if (col == columns[1]) {
            headers[pos] = "    TOTAL";
         } else if (col == columns[3]) {
            headers[pos] = "    Count";
         } else if (col == columns[4]) {
            headers[pos] = "Avg. ";
         } else if (col - columns[2] < this.phases.size()) {
            headers[pos] = this.phases.get(col - columns[2]);
         } else {
            headers[pos] = "";
         }

         ++col;
      }

      printer.table(headers).th().hr().add();
      Iterator var12 = this.sections.values().iterator();

      label78:
      while(true) {
         Profiler$Section section;
         do {
            do {
               do {
                  if (!var12.hasNext()) {
                     return printer.add();
                  }

                  section = (Profiler$Section)var12.next();
               } while(section.isFine() && !includeFine);
            } while(group && section.getDelegate() != section);

            this.printSectionRow(printer, colCount, columns, section, group);
         } while(!group);

         Iterator var9 = this.sections.values().iterator();

         while(true) {
            Profiler$Section subSection;
            Profiler$Section delegate;
            do {
               if (!var9.hasNext()) {
                  continue label78;
               }

               subSection = (Profiler$Section)var9.next();
               delegate = subSection.getDelegate();
            } while(subSection.isFine() && !includeFine);

            if (delegate == section && delegate != subSection) {
               this.printSectionRow(printer, colCount, columns, subSection, group);
            }
         }
      }
   }

   private void printSectionRow(PrettyPrinter printer, int colCount, int[] columns, Profiler$Section section, boolean group) {
      boolean isDelegate = section.getDelegate() != section;
      Object[] values = new Object[colCount];
      int col = 1;
      if (group) {
         values[0] = isDelegate ? "  > " + section.getBaseName() : section.getName();
      } else {
         values[0] = (isDelegate ? "+ " : "  ") + section.getName();
      }

      long[] times = section.getTimes();
      long[] var10 = times;
      int var11 = times.length;

      for(int var12 = 0; var12 < var11; ++var12) {
         long time = var10[var12];
         if (col == columns[1]) {
            values[col++] = section.getTotalTime() + " ms";
         }

         if (col >= columns[2] && col < values.length) {
            values[col++] = time + " ms";
         }
      }

      values[columns[3]] = section.getTotalCount();
      values[columns[4]] = (new DecimalFormat("   ###0.000 ms")).format(section.getTotalAverageTime());

      for(int i = 0; i < values.length; ++i) {
         if (values[i] == null) {
            values[i] = "-";
         }
      }

      printer.tr(values);
   }
}
