package l.c.h.j.f;

final class z$i extends Enum {
   public static final z$i qks = new z$i("posX", 0);
   public static final z$i qkm = new z$i("posZ", 1);
   public static final z$i qkj = new z$i("negX", 2);
   public static final z$i qkc = new z$i("negZ", 3);
   // $FF: synthetic field
   private static final z$i[] $VALUES = new z$i[]{qks, qkm, qkj, qkc};
   public static final int qko;
   public static final boolean qkp;

   public static z$i[] values() {
      return (z$i[])$VALUES.clone();
   }

   public static z$i valueOf(String var0) {
      return (z$i)Enum.valueOf(z$i.class, var0);
   }

   private z$i(String var1, int var2) {
      super(var1, var2);
   }
}
