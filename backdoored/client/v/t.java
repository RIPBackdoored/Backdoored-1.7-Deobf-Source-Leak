package l.c.v;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import l.c.x.d.a;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

public class t extends d {
   public static final boolean ic;
   public static final int io;
   public static final boolean ip;

   public t() {
      super("import", "importfriends");
   }

   public boolean k(String[] var1) {
      if (var1.length == 1) {
         try {
            String var2;
            BufferedReader var3;
            String var4;
            String var5;
            if (var1[0].equalsIgnoreCase("impact")) {
               var2 = "Impact/friends.cfg";
               var3 = new BufferedReader(new FileReader(var2));
               if ((var4 = var3.readLine()) != null) {
                  var5 = var4.split(":")[0];
                  if (!l.c.x.x.g.fp(var5)) {
                     l.c.x.x.g.fc(var5);
                     a.m("Added '" + var5 + "' to your friends!", "green");
                  }

                  a.m("'" + var5 + "' was already a friend", "red");
               }

               var3.close();
               System.out.println("Successfully imported friends");
            }

            if (var1[0].equalsIgnoreCase("wwe")) {
               var2 = "WWE/friends.txt";
               var3 = new BufferedReader(new FileReader(var2));
               if ((var4 = var3.readLine()) != null) {
                  var5 = var4.split(" ")[0];
                  if (!l.c.x.x.g.fp(var5)) {
                     l.c.x.x.g.fc(var5);
                     a.m("Added '" + var5 + "' to your friends!", "green");
                  }

                  a.m("'" + var5 + "' was already a friend", "red");
               }

               var3.close();
               System.out.println("Successfully imported friends");
            }

            if (var1[0].equalsIgnoreCase("future")) {
               var2 = System.getProperty("user.home") + "/Future/friends.json";
               String var16 = FileUtils.readFileToString(new File(var2), Charset.defaultCharset());
               JSONObject var17 = new JSONObject(var16);
               JSONObject var18 = var17.getJSONObject("friend-label");
               Object[] var6 = var18.keySet().toArray();
               int var8 = var6.length;
               byte var9 = 0;
               if (var9 < var8) {
                  Object var10 = var6[var9];
                  String var11 = var10.toString();
                  if (!l.c.x.x.g.fp(var11)) {
                     l.c.x.x.g.fc(var11);
                     a.m("Added '" + var11 + "' to your friends!", "green");
                  }

                  a.m("'" + var11 + "' was already a friend", "red");
                  int var19 = var9 + 1;
               }

               System.out.println("Successfully imported friends");
            }
         } catch (Exception var15) {
            System.out.println("Could not import to friends.txt: " + var15.toString());
            var15.printStackTrace();
            System.out.println(l.c.x.x.g.vy());
            return false;
         }

         throw null;
      } else {
         return false;
      }
   }

   public String v() {
      return "-import <Impact/WWE only ones supported now>";
   }
}
