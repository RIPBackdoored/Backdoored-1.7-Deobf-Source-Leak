package l.c.c.h;

import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Post;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class a {
   public static final int ww;
   public static final boolean wn;

   a() {
   }

   public void qo() {
   }

   @SubscribeEvent
   public void f(Post var1) {
      if (var1.getType() == ElementType.HOTBAR) {
         this.qo();
      }
   }
}
