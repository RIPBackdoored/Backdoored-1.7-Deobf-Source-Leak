package l.c.x.x;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import l.c.q;
import l.c.z.d;
import net.minecraft.entity.player.EntityPlayer;

public class g {
   private static final String qtq = d.i(42);
   private static ArrayList qtt;
   public static final boolean qte;
   public static final int qtv;
   public static final boolean qtu;

   public static boolean vz() {
      if (qtt == null) {
         qtt = new g$d();
      }

      boolean var10000;
      try {
         PrintWriter var0 = new PrintWriter(qtq);
         var0.print("");
         BufferedWriter var1 = new BufferedWriter(new FileWriter(qtq));
         Iterator var2 = qtt.iterator();
         if (var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.write(var3);
            var1.newLine();
         }

         var1.flush();
         var1.close();
         var10000 = true;
      } catch (Exception var7) {
         System.out.println("Could not write friends.txt: " + var7.toString());
         var7.printStackTrace();
         System.out.println(qtt);
         return false;
      }

      return var10000;
   }

   public static boolean vb() {
      boolean var10000;
      try {
         try {
            qtt = new ArrayList();
            BufferedReader var0 = new BufferedReader(new FileReader(qtq));
            String var7;
            if ((var7 = var0.readLine()) != null) {
               qtt.add(var7);
            }

            var0.close();
            System.out.println("Successfully read friends: " + qtt.toString());
            var10000 = true;
            return var10000;
         } catch (FileNotFoundException var5) {
            File var1 = new File(qtq);
            var1.createNewFile();
            qtt = new g$f();
            var10000 = true;
         }
      } catch (Exception var6) {
         System.out.println("Could not read friends: " + var6.toString());
         var6.printStackTrace();
         return false;
      }

      return var10000;
   }

   public static ArrayList vy() {
      return qtt;
   }

   public static void fc(String var0) {
      if (qtt != null) {
         qtt.add(var0);
      }
   }

   public static void fo(String var0) {
      if (qtt != null) {
         qtt.remove(var0);
      }
   }

   public static boolean fp(String var0) {
      return qtt == null ? false : qtt.contains(var0);
   }

   public static boolean q(EntityPlayer var0) {
      if (qtt == null) {
         return false;
      } else {
         return q.mc.player.getUniqueID().equals(var0.getUniqueID()) ? true : fp(var0.getName());
      }
   }
}
