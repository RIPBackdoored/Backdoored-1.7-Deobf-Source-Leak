package javassist.util;

import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventIterator;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.MethodEntryEvent;

class HotSwapper$1 extends Thread {
   // $FF: synthetic field
   final HotSwapper this$0;

   HotSwapper$1(HotSwapper this$0) {
      this.this$0 = this$0;
   }

   private void errorMsg(Throwable e) {
      System.err.print("Exception in thread \"HotSwap\" ");
      e.printStackTrace(System.err);
   }

   public void run() {
      EventSet events = null;

      try {
         events = this.this$0.waitEvent();
         EventIterator iter = events.eventIterator();

         while(iter.hasNext()) {
            Event event = iter.nextEvent();
            if (event instanceof MethodEntryEvent) {
               this.this$0.hotswap();
               break;
            }
         }
      } catch (Throwable var5) {
         this.errorMsg(var5);
      }

      try {
         if (events != null) {
            events.resume();
         }
      } catch (Throwable var4) {
         this.errorMsg(var4);
      }

   }
}
