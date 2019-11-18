package l.c.x;

public final class b$a extends Enum {
   public static final b$a fzt = new b$a("DARKRED", 0, "Dark Red");
   public static final b$a fze = new b$a("RED", 1, "Red");
   public static final b$a fzv = new b$a("GOLD", 2, "Gold");
   public static final b$a fzu = new b$a("YELLOW", 3, "Yellow");
   public static final b$a fzi = new b$a("DARKGREEN", 4, "Dark Green");
   public static final b$a fzd = new b$a("GREEN", 5, "Green");
   public static final b$a fzs = new b$a("AQUA", 6, "Aqua");
   public static final b$a fzm = new b$a("DARKAQUA", 7, "Dark Aqua");
   public static final b$a fzj = new b$a("DARKBLUE", 8, "Dark Blue");
   public static final b$a fzc = new b$a("BLUE", 9, "Blue");
   public static final b$a fzo = new b$a("LIGHTPURPLE", 10, "Light Purple");
   public static final b$a fzp = new b$a("DARKPURPLE", 11, "Dark Purple");
   public static final b$a fzz = new b$a("WHITE", 12, "White");
   public static final b$a fzb = new b$a("GRAY", 13, "Gray");
   public static final b$a fzy = new b$a("DARKGRAY", 14, "Dark Gray");
   public static final b$a fzx = new b$a("BLACK", 15, "Black");
   private String fzl;
   // $FF: synthetic field
   private static final b$a[] $VALUES;
   public static final int fzh;
   public static final boolean fza;

   public static b$a[] values() {
      return (b$a[])$VALUES.clone();
   }

   public static b$a valueOf(String var0) {
      return (b$a)Enum.valueOf(b$a.class, var0);
   }

   private b$a(String var1, int var2, String var3) {
      super(var1, var2);
      this.fzl = var3;
   }

   public String toString() {
      return this.fzl;
   }
}
