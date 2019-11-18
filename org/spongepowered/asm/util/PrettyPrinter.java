package org.spongepowered.asm.util;

import com.google.common.base.Strings;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrettyPrinter {
   private final PrettyPrinter$HorizontalRule horizontalRule;
   private final List lines;
   private PrettyPrinter$Table table;
   private boolean recalcWidth;
   protected int width;
   protected int wrapWidth;
   protected int kvKeyWidth;
   protected String kvFormat;

   public PrettyPrinter() {
      this(100);
   }

   public PrettyPrinter(int width) {
      this.horizontalRule = new PrettyPrinter$HorizontalRule(this, new char[]{'*'});
      this.lines = new ArrayList();
      this.recalcWidth = false;
      this.width = 100;
      this.wrapWidth = 80;
      this.kvKeyWidth = 10;
      this.kvFormat = makeKvFormat(this.kvKeyWidth);
      this.width = width;
   }

   public PrettyPrinter wrapTo(int wrapWidth) {
      this.wrapWidth = wrapWidth;
      return this;
   }

   public int wrapTo() {
      return this.wrapWidth;
   }

   public PrettyPrinter table() {
      this.table = new PrettyPrinter$Table();
      return this;
   }

   public PrettyPrinter table(String... titles) {
      this.table = new PrettyPrinter$Table();
      String[] var2 = titles;
      int var3 = titles.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String title = var2[var4];
         this.table.addColumn(title);
      }

      return this;
   }

   public PrettyPrinter table(Object... format) {
      this.table = new PrettyPrinter$Table();
      PrettyPrinter$Column column = null;
      Object[] var3 = format;
      int var4 = format.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Object entry = var3[var5];
         if (entry instanceof String) {
            column = this.table.addColumn((String)entry);
         } else if (entry instanceof Integer && column != null) {
            int width = (Integer)entry;
            if (width > 0) {
               column.setWidth(width);
            } else if (width < 0) {
               column.setMaxWidth(-width);
            }
         } else if (entry instanceof PrettyPrinter$Alignment && column != null) {
            column.setAlignment((PrettyPrinter$Alignment)entry);
         } else if (entry != null) {
            column = this.table.addColumn(entry.toString());
         }
      }

      return this;
   }

   public PrettyPrinter spacing(int spacing) {
      if (this.table == null) {
         this.table = new PrettyPrinter$Table();
      }

      this.table.setColSpacing(spacing);
      return this;
   }

   public PrettyPrinter th() {
      return this.th(false);
   }

   private PrettyPrinter th(boolean onlyIfNeeded) {
      if (this.table == null) {
         this.table = new PrettyPrinter$Table();
      }

      if (!onlyIfNeeded || this.table.addHeader) {
         this.table.headerAdded();
         this.addLine(this.table);
      }

      return this;
   }

   public PrettyPrinter tr(Object... args) {
      this.th(true);
      this.addLine(this.table.addRow(args));
      this.recalcWidth = true;
      return this;
   }

   public PrettyPrinter add() {
      this.addLine("");
      return this;
   }

   public PrettyPrinter add(String string) {
      this.addLine(string);
      this.width = Math.max(this.width, string.length());
      return this;
   }

   public PrettyPrinter add(String format, Object... args) {
      String line = String.format(format, args);
      this.addLine(line);
      this.width = Math.max(this.width, line.length());
      return this;
   }

   public PrettyPrinter add(Object[] array) {
      return this.add(array, "%s");
   }

   public PrettyPrinter add(Object[] array, String format) {
      Object[] var3 = array;
      int var4 = array.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Object element = var3[var5];
         this.add(format, element);
      }

      return this;
   }

   public PrettyPrinter addIndexed(Object[] array) {
      int indexWidth = String.valueOf(array.length - 1).length();
      String format = "[%" + indexWidth + "d] %s";

      for(int index = 0; index < array.length; ++index) {
         this.add(format, index, array[index]);
      }

      return this;
   }

   public PrettyPrinter addWithIndices(Collection c) {
      return this.addIndexed(c.toArray());
   }

   public PrettyPrinter add(PrettyPrinter$IPrettyPrintable printable) {
      if (printable != null) {
         printable.print(this);
      }

      return this;
   }

   public PrettyPrinter add(Throwable th) {
      return this.add((Throwable)th, 4);
   }

   public PrettyPrinter add(Throwable th, int indent) {
      while(th != null) {
         this.add("%s: %s", th.getClass().getName(), th.getMessage());
         this.add(th.getStackTrace(), indent);
         th = th.getCause();
      }

      return this;
   }

   public PrettyPrinter add(StackTraceElement[] stackTrace, int indent) {
      String margin = Strings.repeat(" ", indent);
      StackTraceElement[] var4 = stackTrace;
      int var5 = stackTrace.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         StackTraceElement st = var4[var6];
         this.add("%s%s", margin, st);
      }

      return this;
   }

   public PrettyPrinter add(Object object) {
      return this.add((Object)object, 0);
   }

   public PrettyPrinter add(Object object, int indent) {
      String margin = Strings.repeat(" ", indent);
      return this.append(object, indent, margin);
   }

   private PrettyPrinter append(Object object, int indent, String margin) {
      if (object instanceof String) {
         return this.add("%s%s", margin, object);
      } else if (!(object instanceof Iterable)) {
         if (object instanceof Map) {
            this.kvWidth(indent);
            return this.add((Map)object);
         } else if (object instanceof PrettyPrinter$IPrettyPrintable) {
            return this.add((PrettyPrinter$IPrettyPrintable)object);
         } else if (object instanceof Throwable) {
            return this.add((Throwable)object, indent);
         } else {
            return object.getClass().isArray() ? this.add((Object[])((Object[])object), indent + "%s") : this.add("%s%s", margin, object);
         }
      } else {
         Iterator var4 = ((Iterable)object).iterator();

         while(var4.hasNext()) {
            Object entry = var4.next();
            this.append(entry, indent, margin);
         }

         return this;
      }
   }

   public PrettyPrinter addWrapped(String format, Object... args) {
      return this.addWrapped(this.wrapWidth, format, args);
   }

   public PrettyPrinter addWrapped(int width, String format, Object... args) {
      String indent = "";
      String line = String.format(format, args).replace("\t", "    ");
      Matcher indentMatcher = Pattern.compile("^(\\s+)(.*)$").matcher(line);
      if (indentMatcher.matches()) {
         indent = indentMatcher.group(1);
      }

      try {
         Iterator var7 = this.getWrapped(width, line, indent).iterator();

         while(var7.hasNext()) {
            String wrappedLine = (String)var7.next();
            this.addLine(wrappedLine);
         }
      } catch (Exception var9) {
         this.add(line);
      }

      return this;
   }

   private List getWrapped(int width, String line, String indent) {
      ArrayList lines;
      int wrapPoint;
      for(lines = new ArrayList(); line.length() > width; line = indent + line.substring(wrapPoint + 1)) {
         wrapPoint = line.lastIndexOf(32, width);
         if (wrapPoint < 10) {
            wrapPoint = width;
         }

         String head = line.substring(0, wrapPoint);
         lines.add(head);
      }

      if (line.length() > 0) {
         lines.add(line);
      }

      return lines;
   }

   public PrettyPrinter kv(String key, String format, Object... args) {
      return this.kv(key, String.format(format, args));
   }

   public PrettyPrinter kv(String key, Object value) {
      this.addLine(new PrettyPrinter$KeyValue(this, key, value));
      return this.kvWidth(key.length());
   }

   public PrettyPrinter kvWidth(int width) {
      if (width > this.kvKeyWidth) {
         this.kvKeyWidth = width;
         this.kvFormat = makeKvFormat(width);
      }

      this.recalcWidth = true;
      return this;
   }

   public PrettyPrinter add(Map map) {
      Iterator var2 = map.entrySet().iterator();

      while(var2.hasNext()) {
         Entry entry = (Entry)var2.next();
         String key = entry.getKey() == null ? "null" : entry.getKey().toString();
         this.kv(key, entry.getValue());
      }

      return this;
   }

   public PrettyPrinter hr() {
      return this.hr('*');
   }

   public PrettyPrinter hr(char ruleChar) {
      this.addLine(new PrettyPrinter$HorizontalRule(this, new char[]{ruleChar}));
      return this;
   }

   public PrettyPrinter centre() {
      if (!this.lines.isEmpty()) {
         Object lastLine = this.lines.get(this.lines.size() - 1);
         if (lastLine instanceof String) {
            this.addLine(new PrettyPrinter$CentredText(this, this.lines.remove(this.lines.size() - 1)));
         }
      }

      return this;
   }

   private void addLine(Object line) {
      if (line != null) {
         this.lines.add(line);
         this.recalcWidth |= line instanceof PrettyPrinter$IVariableWidthEntry;
      }
   }

   public PrettyPrinter trace() {
      return this.trace(getDefaultLoggerName());
   }

   public PrettyPrinter trace(Level level) {
      return this.trace(getDefaultLoggerName(), level);
   }

   public PrettyPrinter trace(String logger) {
      return this.trace(System.err, LogManager.getLogger(logger));
   }

   public PrettyPrinter trace(String logger, Level level) {
      return this.trace(System.err, LogManager.getLogger(logger), level);
   }

   public PrettyPrinter trace(Logger logger) {
      return this.trace(System.err, logger);
   }

   public PrettyPrinter trace(Logger logger, Level level) {
      return this.trace(System.err, logger, level);
   }

   public PrettyPrinter trace(PrintStream stream) {
      return this.trace(stream, getDefaultLoggerName());
   }

   public PrettyPrinter trace(PrintStream stream, Level level) {
      return this.trace(stream, getDefaultLoggerName(), level);
   }

   public PrettyPrinter trace(PrintStream stream, String logger) {
      return this.trace(stream, LogManager.getLogger(logger));
   }

   public PrettyPrinter trace(PrintStream stream, String logger, Level level) {
      return this.trace(stream, LogManager.getLogger(logger), level);
   }

   public PrettyPrinter trace(PrintStream stream, Logger logger) {
      return this.trace(stream, logger, Level.DEBUG);
   }

   public PrettyPrinter trace(PrintStream stream, Logger logger, Level level) {
      this.log(logger, level);
      this.print(stream);
      return this;
   }

   public PrettyPrinter print() {
      return this.print(System.err);
   }

   public PrettyPrinter print(PrintStream stream) {
      this.updateWidth();
      this.printSpecial(stream, this.horizontalRule);
      Iterator var2 = this.lines.iterator();

      while(var2.hasNext()) {
         Object line = var2.next();
         if (line instanceof PrettyPrinter$ISpecialEntry) {
            this.printSpecial(stream, (PrettyPrinter$ISpecialEntry)line);
         } else {
            this.printString(stream, line.toString());
         }
      }

      this.printSpecial(stream, this.horizontalRule);
      return this;
   }

   private void printSpecial(PrintStream stream, PrettyPrinter$ISpecialEntry line) {
      stream.printf("/*%s*/\n", line.toString());
   }

   private void printString(PrintStream stream, String string) {
      if (string != null) {
         stream.printf("/* %-" + this.width + "s */\n", string);
      }

   }

   public PrettyPrinter log(Logger logger) {
      return this.log(logger, Level.INFO);
   }

   public PrettyPrinter log(Logger logger, Level level) {
      this.updateWidth();
      this.logSpecial(logger, level, this.horizontalRule);
      Iterator var3 = this.lines.iterator();

      while(var3.hasNext()) {
         Object line = var3.next();
         if (line instanceof PrettyPrinter$ISpecialEntry) {
            this.logSpecial(logger, level, (PrettyPrinter$ISpecialEntry)line);
         } else {
            this.logString(logger, level, line.toString());
         }
      }

      this.logSpecial(logger, level, this.horizontalRule);
      return this;
   }

   private void logSpecial(Logger logger, Level level, PrettyPrinter$ISpecialEntry line) {
      logger.log(level, "/*{}*/", new Object[]{line.toString()});
   }

   private void logString(Logger logger, Level level, String line) {
      if (line != null) {
         logger.log(level, String.format("/* %-" + this.width + "s */", line));
      }

   }

   private void updateWidth() {
      if (this.recalcWidth) {
         this.recalcWidth = false;
         Iterator var1 = this.lines.iterator();

         while(var1.hasNext()) {
            Object line = var1.next();
            if (line instanceof PrettyPrinter$IVariableWidthEntry) {
               this.width = Math.min(4096, Math.max(this.width, ((PrettyPrinter$IVariableWidthEntry)line).getWidth()));
            }
         }
      }

   }

   private static String makeKvFormat(int keyWidth) {
      return String.format("%%%ds : %%s", keyWidth);
   }

   private static String getDefaultLoggerName() {
      String name = (new Throwable()).getStackTrace()[2].getClassName();
      int pos = name.lastIndexOf(46);
      return pos == -1 ? name : name.substring(pos + 1);
   }

   public static void dumpStack() {
      (new PrettyPrinter()).add((Throwable)(new Exception("Stack trace"))).print(System.err);
   }

   public static void print(Throwable th) {
      (new PrettyPrinter()).add(th).print(System.err);
   }
}
