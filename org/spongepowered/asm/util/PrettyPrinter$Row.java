package org.spongepowered.asm.util;

class PrettyPrinter$Row implements PrettyPrinter$IVariableWidthEntry {
   final PrettyPrinter$Table table;
   final String[] args;

   public PrettyPrinter$Row(PrettyPrinter$Table table, Object... args) {
      this.table = table.grow(args.length);
      this.args = new String[args.length];

      for(int i = 0; i < args.length; ++i) {
         this.args[i] = args[i].toString();
         ((PrettyPrinter$Column)this.table.columns.get(i)).setMinWidth(this.args[i].length());
      }

   }

   public String toString() {
      Object[] args = new Object[this.table.columns.size()];

      for(int col = 0; col < args.length; ++col) {
         PrettyPrinter$Column column = (PrettyPrinter$Column)this.table.columns.get(col);
         if (col >= this.args.length) {
            args[col] = "";
         } else {
            args[col] = this.args[col].length() > column.getMaxWidth() ? this.args[col].substring(0, column.getMaxWidth()) : this.args[col];
         }
      }

      return String.format(this.table.format, args);
   }

   public int getWidth() {
      return this.toString().length();
   }
}
