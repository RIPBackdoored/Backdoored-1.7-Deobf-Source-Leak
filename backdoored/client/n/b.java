package l.c.n;

import com.mojang.authlib.exceptions.AuthenticationException;
import l.c.q;

public class b implements q {
   public static final boolean fkt;
   public static final int fke;
   public static final boolean fkv;

   public static boolean i(String param0, String param1) throws AuthenticationException {
      // $FF: Couldn't be decompiled
   }

   public static String qn() {
      return q.mc.getSession().getUsername();
   }

   public static String qr() {
      return q.mc.getSession().getProfile().getId().toString();
   }
}
