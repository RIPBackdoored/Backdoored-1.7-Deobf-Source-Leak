package org.spongepowered.asm.mixin.injection.invoke;

class RedirectInjector$Meta {
   public static final String KEY = "redirector";
   final int priority;
   final boolean isFinal;
   final String name;
   final String desc;
   // $FF: synthetic field
   final RedirectInjector this$0;

   public RedirectInjector$Meta(RedirectInjector this$0, int priority, boolean isFinal, String name, String desc) {
      this.this$0 = this$0;
      this.priority = priority;
      this.isFinal = isFinal;
      this.name = name;
      this.desc = desc;
   }

   RedirectInjector getOwner() {
      return this.this$0;
   }
}
