package l.c.n;

import  l. c. n. h;
import com.google.common.collect.HashBiMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class h {
   public static HashBiMap bs = HashBiMap.create();
   private static final Boolean[] bm = new Boolean[]{true, true};
   public static final boolean bj;
   public static final int bc;
   public static final boolean bo;

   public static String o(String var0) {
      if (bs.containsKey(var0)) {
         System.out.println("Grabbing username from hash map");
         return (String)bs.get(var0);
      } else {
         System.out.println("Grabbing username from Mojang Web Api");
         return k(var0, true);
      }
   }

   public static String p(String var0) {
      if (bs.containsValue(var0)) {
         System.out.println("Grabbing UUID from hash map");
         return (String)bs.inverse().get(var0);
      } else {
         System.out.println("Grabbing UUID from Mojang Web Api");
         return k(var0, false);
      }
   }

   private static String k(String var0, Boolean var1) {
      String var2;
      String var6;
      String var7;
      JSONObject var10;
      String var10000;
      if (var1) {
         var2 = var0;

         try {
            String var22 = "https://api.mojang.com/user/profiles/" + var0.replace("-", "") + "/names";
            URL var23 = new URL(var22);
            BufferedReader var24 = new BufferedReader(new InputStreamReader(var23.openStream()));
            var6 = "Popbob";
            var7 = var24.readLine();
            System.out.println(var7);
            var24.close();
            if (var7 != null) {
               JSONParser var25 = new JSONParser();
               JSONArray var26 = (JSONArray)var25.parse(var7);
               var10 = (JSONObject)var26.get(var26.size() - 1);
               var6 = var10.get("name").toString();
            }

            bs.put(var2, var6);
            var10000 = var6;
         } catch (MalformedURLException var16) {
            System.out.println("MALIGNED URL, CARBOLEMONS IS DUMB IF YOU ARE READING THIS, BECAUSE, WHAT, IMPOSSIBLE... LITCHERALLLY...");
            return "";
         } catch (IOException var17) {
            System.out.println("uh, something went horribly wrong if you are seeing this in your log.");
            return "";
         } catch (ParseException var18) {
            System.out.println("JSON userdata was parsed wrong, shit.");
            return "";
         }

         return var10000;
      } else {
         try {
            var2 = "https://api.mojang.com/users/profiles/minecraft/" + var0;
            URL var3 = new URL(var2);
            BufferedReader var4 = new BufferedReader(new InputStreamReader(var3.openStream()));
            String var5 = "00000000000000000000000000000000";
            var6 = "00000000-0000-0000-0000-000000000000";
            var7 = "Popbob";
            String var8 = var4.readLine();
            var4.close();
            if (var8 != null) {
               JSONParser var9 = new JSONParser();
               var10 = (JSONObject)var9.parse(var8);
               var5 = var10.get("id").toString();
               String var11 = new String(var5);
               StringBuilder var12 = new StringBuilder(var11);
               var12.insert(8, '-');
               var12.insert(13, '-');
               var12.insert(18, '-');
               var12.insert(23, '-');
               var6 = var12.toString();
            }

            bs.put(var6, var0);
            var10000 = var6;
         } catch (MalformedURLException var19) {
            System.out.println("MALIGNED URL, CARBOLEMONS IS DUMB IF YOU ARE READING THIS, BECAUSE, WHAT, IMPOSSIBLE... LITCHERALLLY...");
            return "";
         } catch (IOException var20) {
            System.out.println("uh, something went horribly wrong if you are seeing this in your log.");
            return "";
         } catch (ParseException var21) {
            System.out.println("JSON userdata was parsed wrong, shit.");
            return "";
         }

         return var10000;
      }
   }

   private static boolean fm() {
      return z("https://authserver.mojang.com/authenticate");
   }

   private static boolean fj() {
      return z("https://sessionserver.mojang.com/");
   }

   public static boolean fc() {
      // $FF: Couldn't be decompiled
   }

   public static boolean fo() {
      boolean var10000;
      synchronized(bm) {
         var10000 = bm[1];
      }

      return var10000;
   }

   private static boolean z(String var0) {
      boolean var10000;
      try {
         URL var1 = new URL(var0);
         HttpsURLConnection var2 = (HttpsURLConnection)var1.openConnection();
         var2.connect();
         var2.disconnect();
         var10000 = true;
      } catch (IOException var6) {
         var6.printStackTrace();
         return false;
      }

      return var10000;
   }

   // $FF: synthetic method
   private static void fp() {
      // $FF: Couldn't be decompiled
   }

   static {
      (new Thread( h::fp, "Status checker")).start();
   }
}
