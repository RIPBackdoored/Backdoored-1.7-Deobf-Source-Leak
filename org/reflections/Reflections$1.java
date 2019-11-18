package org.reflections;

import java.net.URL;

class Reflections$1 implements Runnable {
   // $FF: synthetic field
   final URL val$url;
   // $FF: synthetic field
   final Reflections this$0;

   Reflections$1(Reflections this$0, URL var2) {
      this.this$0 = this$0;
      this.val$url = var2;
   }

   public void run() {
      if (Reflections.log != null && Reflections.log.isDebugEnabled()) {
         Reflections.log.debug("[" + Thread.currentThread().toString() + "] scanning " + this.val$url);
      }

      this.this$0.scan(this.val$url);
   }
}
