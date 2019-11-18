package l.c.h.d;

import java.util.ArrayList;

public class a {
   private static ArrayList fmy = new ArrayList();
   private ArrayList fmx = new ArrayList();
   private String fml;
   public static final int fmh;
   public static final boolean fma;

   a(String var1) {
      this.fml = var1;
      fmy.add(this);
   }

   public String m() {
      return this.fml;
   }

   public ArrayList et() {
      return this.fmx;
   }

   public String toString() {
      return this.m();
   }

   public static ArrayList r() {
      System.out.println("Categories: " + fmy.toString());
      return fmy;
   }
}
