package org.spongepowered.asm.util;

class PrettyPrinter$Column {
   private final PrettyPrinter$Table table;
   private PrettyPrinter$Alignment align;
   private int minWidth;
   private int maxWidth;
   private int size;
   private String title;
   private String format;

   PrettyPrinter$Column(PrettyPrinter$Table table) {
      this.align = PrettyPrinter$Alignment.LEFT;
      this.minWidth = 1;
      this.maxWidth = 0;
      this.size = 0;
      this.title = "";
      this.format = "%s";
      this.table = table;
   }

   PrettyPrinter$Column(PrettyPrinter$Table table, String title) {
      this(table);
      this.title = title;
      this.minWidth = title.length();
      this.updateFormat();
   }

   PrettyPrinter$Column(PrettyPrinter$Table table, PrettyPrinter$Alignment align, int size, String title) {
      this(table, title);
      this.align = align;
      this.size = size;
   }

   void setAlignment(PrettyPrinter$Alignment align) {
      this.align = align;
      this.updateFormat();
   }

   void setWidth(int width) {
      if (width > this.size) {
         this.size = width;
         this.updateFormat();
      }

   }

   void setMinWidth(int width) {
      if (width > this.minWidth) {
         this.minWidth = width;
         this.updateFormat();
      }

   }

   void setMaxWidth(int width) {
      this.size = Math.min(this.size, this.maxWidth);
      this.maxWidth = Math.max(1, width);
      this.updateFormat();
   }

   void setTitle(String title) {
      this.title = title;
      this.setWidth(title.length());
   }

   private void updateFormat() {
      int width = Math.min(this.maxWidth, this.size == 0 ? this.minWidth : this.size);
      this.format = "%" + (this.align == PrettyPrinter$Alignment.RIGHT ? "" : "-") + width + "s";
      this.table.updateFormat();
   }

   int getMaxWidth() {
      return this.maxWidth;
   }

   String getTitle() {
      return this.title;
   }

   String getFormat() {
      return this.format;
   }

   public String toString() {
      return this.title.length() > this.maxWidth ? this.title.substring(0, this.maxWidth) : this.title;
   }
}
