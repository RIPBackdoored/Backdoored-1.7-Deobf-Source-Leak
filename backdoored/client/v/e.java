package l.c.v;

import l.c.x.d.a;

public class e extends d {
   private String[] fvh = new String[]{"add", "del", "list"};
   public static final boolean fva;
   public static final int fvg;
   public static final boolean fvw;

   public e() {
      super("friend", "friends", "f");
   }

   public boolean k(String[] var1) {
      if (!this.k(var1, this.fvh, "name")) {
         return false;
      } else if (var1[0].equals("add") && !var1[var1.length - 1].equals("add")) {
         if (!l.c.x.x.g.fp(var1[1])) {
            l.c.x.x.g.fc(var1[1]);
            a.m("Added '" + var1[1] + "' to your friends!", "green");
         }

         a.m("'" + var1[1] + "' was already a friend", "red");
         return true;
      } else if (var1[0].equals("del") && !var1[var1.length - 1].equals("del")) {
         if (l.c.x.x.g.fp(var1[1])) {
            l.c.x.x.g.fo(var1[1]);
            a.m("Removed '" + var1[1] + "' from your friends!", "green");
         }

         a.m("'" + var1[1] + "' wasnt a friend", "red");
         return true;
      } else if (var1[0].equals("list")) {
         StringBuilder var2 = new StringBuilder("Friends: ");
         byte var3 = 0;
         if (var3 <= l.c.x.x.g.vy().size() - 1) {
            if (var3 == l.c.x.x.g.vy().size() - 1) {
               var2.append((String)l.c.x.x.g.vy().get(var3));
            }

            var2.append((String)l.c.x.x.g.vy().get(var3)).append(", ");
            int var7 = var3 + 1;
         }

         a.m(var2.toString(), "red");
         return true;
      } else {
         return false;
      }
   }

   public String v() {
      return "-friend add cookiedragon234\n-friend del 2b2tnews\n-friend list";
   }
}
