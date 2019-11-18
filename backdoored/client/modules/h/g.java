package l.c.h.h;

import java.util.Iterator;
import l.c.h.j.w;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import org.lwjgl.input.Keyboard;

public class g {
   public static final boolean li;
   public static final int ld;
   public static final boolean ls;

   @SubscribeEvent(
      receiveCanceled = true
   )
   public void k(KeyInputEvent var1) {
      if (Keyboard.getEventKeyState()) {
         int var2 = Keyboard.getEventKey();
         if (var2 != 0) {
            String var3 = Keyboard.getKeyName(var2);
            if (!var3.equalsIgnoreCase("NONE")) {
               Iterator var4 = c.ur.r().iterator();
               if (var4.hasNext()) {
                  j var5 = (j)var4.next();
                  if (var3.equalsIgnoreCase((String)var5.ti())) {
                     w var10000 = var5.tv();
                     if (!var5.tv().qm()) {
                        boolean var10001 = true;
                     }

                     var10000.f(false);
                  }
               }
            }
         }
      }

   }
}
