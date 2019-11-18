package org.spongepowered.asm.util;

import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PrettyPrinter$Table implements PrettyPrinter$IVariableWidthEntry {
   final List columns = new ArrayList();
   final List rows = new ArrayList();
   String format = "%s";
   int colSpacing = 2;
   boolean addHeader = true;

   void headerAdded() {
      this.addHeader = false;
   }

   void setColSpacing(int spacing) {
      this.colSpacing = Math.max(0, spacing);
      this.updateFormat();
   }

   PrettyPrinter$Table grow(int size) {
      while(this.columns.size() < size) {
         this.columns.add(new PrettyPrinter$Column(this));
      }

      this.updateFormat();
      return this;
   }

   PrettyPrinter$Column add(PrettyPrinter$Column column) {
      this.columns.add(column);
      return column;
   }

   PrettyPrinter$Row add(PrettyPrinter$Row row) {
      this.rows.add(row);
      return row;
   }

   PrettyPrinter$Column addColumn(String title) {
      return this.add(new PrettyPrinter$Column(this, title));
   }

   PrettyPrinter$Column addColumn(PrettyPrinter$Alignment align, int size, String title) {
      return this.add(new PrettyPrinter$Column(this, align, size, title));
   }

   PrettyPrinter$Row addRow(Object... args) {
      return this.add(new PrettyPrinter$Row(this, args));
   }

   void updateFormat() {
      String spacing = Strings.repeat(" ", this.colSpacing);
      StringBuilder format = new StringBuilder();
      boolean addSpacing = false;
      Iterator var4 = this.columns.iterator();

      while(var4.hasNext()) {
         PrettyPrinter$Column column = (PrettyPrinter$Column)var4.next();
         if (addSpacing) {
            format.append(spacing);
         }

         addSpacing = true;
         format.append(column.getFormat());
      }

      this.format = format.toString();
   }

   String getFormat() {
      return this.format;
   }

   Object[] getTitles() {
      List titles = new ArrayList();
      Iterator var2 = this.columns.iterator();

      while(var2.hasNext()) {
         PrettyPrinter$Column column = (PrettyPrinter$Column)var2.next();
         titles.add(column.getTitle());
      }

      return titles.toArray();
   }

   public String toString() {
      boolean nonEmpty = false;
      String[] titles = new String[this.columns.size()];

      for(int col = 0; col < this.columns.size(); ++col) {
         titles[col] = ((PrettyPrinter$Column)this.columns.get(col)).toString();
         nonEmpty |= !titles[col].isEmpty();
      }

      return nonEmpty ? String.format(this.format, (Object[])titles) : null;
   }

   public int getWidth() {
      String str = this.toString();
      return str != null ? str.length() : 0;
   }
}
