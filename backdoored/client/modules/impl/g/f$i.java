package l.c.h.j.g;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class f$i implements ActionListener {
   int cq;
   // $FF: synthetic field
   final int ct;
   // $FF: synthetic field
   final String[] ce;
   // $FF: synthetic field
   final f cv;
   public static final int cu;
   public static final boolean ci;

   f$i(f var1, int var2, String[] var3) {
      this.cv = var1;
      this.ct = var2;
      this.ce = var3;
      this.cq = 0;
   }

   public void actionPerformed(ActionEvent var1) {
      if (this.cq < this.ct) {
         ++this.cq;
         if (this.cq == this.ct) {
            this.cq = 0;
         }
      }

   }
}
