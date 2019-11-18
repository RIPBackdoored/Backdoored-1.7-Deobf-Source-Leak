package l.c.h.j.y;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.apache.logging.log4j.Logger;

public class o {
   private final ScriptEngine fsd = (new ScriptEngineManager((ClassLoader)null)).getEngineByName("nashorn");
   public static final int fss;
   public static final boolean fsm;

   public o fe(String var1) throws ScriptException {
      this.fsd.eval(var1);
      return this;
   }

   public o k(Logger var1) {
      this.fsd.put("logger", var1);
      return this;
   }

   public Object f(String var1, Object... var2) throws ScriptException, NoSuchMethodException {
      return ((Invocable)this.fsd).invokeFunction(var1, var2);
   }
}
