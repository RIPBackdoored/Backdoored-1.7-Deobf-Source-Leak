package l.c.c.d;

import org.lwjgl.opengl.GL11;

public class g extends a {
   private l.c.h.h.j fvn;
   public static final int fvr;
   public static final boolean fuk;

   public g(l.c.h.h.j var1) {
      super(var1);
      this.fvn = var1;
   }

   public void t(int var1, int var2) {
      GL11.glPushAttrib(1048575);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.0F, 0.0F);
      this.drawTexturedModalRect(this.sc + 1, this.so + this.sz - 2, 0, 0, (this.sp - 2) * ((Number)this.fvn.ti()).intValue() / Math.max(this.fvn.tm().intValue() - this.fvn.ts().intValue(), 1), 1);
      GL11.glPopMatrix();
      GL11.glPopAttrib();
   }

   public l.c.h.h.j fx() {
      return this.fvn;
   }
}
