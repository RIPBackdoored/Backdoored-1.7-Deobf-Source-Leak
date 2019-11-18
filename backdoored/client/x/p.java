package l.c.x;

import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class p {
   private static SystemTray qqd;
   private static TrayIcon qqs;
   public static final boolean qqm;
   public static final int qqj;
   public static final boolean qqc;

   public p() {
      // $FF: Couldn't be decompiled
   }

   public static void fm(String var0) {
      k("Backdoored", var0);
   }

   public static void k(String var0, String var1) {
      if (qqs == null) {
         new p();
      }

      qqs.displayMessage(var0, var1, MessageType.INFO);
   }
}
