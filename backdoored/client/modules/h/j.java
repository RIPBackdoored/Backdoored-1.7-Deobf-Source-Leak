package l.c.h.h;

import l.c.h.j.w;

public abstract class j {
   private String fkp;
   private w fkz;
   private c fkb;
   private Object fky;
   private final Object fkx;
   public static final int fkl;
   public static final boolean fkh;

   public j(String var1, w var2, c var3, Object var4) {
      this.fkp = var1;
      this.fkz = var2;
      this.fkb = var3;
      this.fky = var4;
      this.fkx = var4;
      var3.iu.add(this);
      v.flc.add(this);
   }

   public String m() {
      return this.fkp;
   }

   public w tv() {
      return this.fkz;
   }

   public c tu() {
      return this.fkb;
   }

   public Object ti() {
      return this.fky;
   }

   public void k(Object var1) {
      this.fky = var1;
   }

   public Object td() {
      return this.fkx;
   }

   public abstract Class ft();

   public Number ts() {
      return null;
   }

   public Number tm() {
      return null;
   }

   public Enum[] tj() {
      return null;
   }
}
