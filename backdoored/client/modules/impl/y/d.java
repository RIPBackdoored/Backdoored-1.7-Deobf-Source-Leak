package l.c.h.j.y;

import java.io.IOException;
import javax.script.ScriptException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class d {
   static final String nu = "Backdoored/chatbot.js";
   o ni;
   static final Logger nd = LogManager.getLogger("BackdooredChatBot");
   public static final boolean ns;
   public static final int nm;
   public static final boolean nj;

   d() throws Exception {
      this.ni = (new o()).fe(h("Backdoored/chatbot.js")).k(nd);
   }

   String v(String var1, String var2) throws ScriptException, NoSuchMethodException, IllegalStateException {
      return (String)this.ni.f("onChatRecieved", var1, var2);
   }

   public static String h(String param0) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
