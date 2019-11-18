package l.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Objects;
import java.util.Vector;

public class t {
   private static Field nc;
   public static final boolean no;
   public static final int np;
   public static final boolean nz;

   public static String[] k(ClassLoader var0) {
      String[] var10000;
      try {
         Vector var1 = (Vector)nc.get(var0);
         var10000 = (String[])var1.toArray(new String[0]);
      } catch (Exception var5) {
         var5.printStackTrace();
         return new String[0];
      }

      return var10000;
   }

   public static void a(String var0) throws IOException {
      ClassLoader var1 = ClassLoader.getSystemClassLoader();
      File var2 = new File(((URL)Objects.requireNonNull(var1.getResource(var0))).getFile());
      System.out.println(var2.getAbsolutePath());
      FileInputStream var3 = new FileInputStream(var2);
      byte[] var4 = new byte[1024];
      boolean var5 = true;
      File var6 = File.createTempFile(var0, "");
      FileOutputStream var7 = new FileOutputStream(var6);
      int var11;
      if ((var11 = var3.read(var4)) != -1) {
         var7.write(var4, 0, var11);
      }

      var7.close();
      System.out.println(var6.getAbsolutePath());
      System.load(var6.getAbsolutePath());
   }

   public static void qp() {
      // $FF: Couldn't be decompiled
   }

   public static String g(String var0) {
      return u(var0, a.qfj);
   }

   public static native String w(String var0);

   public static native String u(String var0, String var1);

   public static native String qz();

   static {
      // $FF: Couldn't be decompiled
   }
}
