package org.yaml.snakeyaml;

public final class DumperOptions$LineBreak extends Enum {
   public static final DumperOptions$LineBreak WIN = new DumperOptions$LineBreak("WIN", 0, "\r\n");
   public static final DumperOptions$LineBreak MAC = new DumperOptions$LineBreak("MAC", 1, "\r");
   public static final DumperOptions$LineBreak UNIX = new DumperOptions$LineBreak("UNIX", 2, "\n");
   private String lineBreak;
   // $FF: synthetic field
   private static final DumperOptions$LineBreak[] $VALUES = new DumperOptions$LineBreak[]{WIN, MAC, UNIX};

   public static DumperOptions$LineBreak[] values() {
      return (DumperOptions$LineBreak[])$VALUES.clone();
   }

   public static DumperOptions$LineBreak valueOf(String name) {
      return (DumperOptions$LineBreak)Enum.valueOf(DumperOptions$LineBreak.class, name);
   }

   private DumperOptions$LineBreak(String var1, int var2, String lineBreak) {
      super(var1, var2);
      this.lineBreak = lineBreak;
   }

   public String getString() {
      return this.lineBreak;
   }

   public String toString() {
      return "Line break: " + this.name();
   }

   public static DumperOptions$LineBreak getPlatformLineBreak() {
      String platformLineBreak = System.getProperty("line.separator");
      DumperOptions$LineBreak[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         DumperOptions$LineBreak lb = var1[var3];
         if (lb.lineBreak.equals(platformLineBreak)) {
            return lb;
         }
      }

      return UNIX;
   }
}
