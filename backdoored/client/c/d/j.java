package l.c.c.d;

import java.util.ArrayList;

public class j extends c {
   private static ArrayList fnk = new ArrayList();
   private ArrayList fnf = new ArrayList();
   public static final int fnq = 100;
   public static final int fnt = 20;
   private static final int fne = 25;
   private static int fnv = 25;
   private l.c.h.d.a fnu;
   int fni = 1;
   public boolean fnd = false;
   public int fns = 0;
   public int fnm = 0;
   public static final boolean fnj;
   public static final int fnc;
   public static final boolean fno;

   public j(l.c.h.d.a var1) {
      super(25, fnv, 100, 20, var1.m(), true, new float[]{1.0F, 0.0F, 0.0F, 1.0F});
      this.fnu = var1;
      fnv += 21;
      fnk.add(this);
   }

   public l.c.h.d.a en() {
      return this.fnu;
   }

   public ArrayList er() {
      return this.fnf;
   }

   public static ArrayList r() {
      return fnk;
   }

   public static ArrayList vk() {
      ArrayList var0 = new ArrayList();
      int var1 = r().size() - 1;
      if (var1 >= 0) {
         var0.add(r().get(var1));
         --var1;
      }

      return var0;
   }
}
