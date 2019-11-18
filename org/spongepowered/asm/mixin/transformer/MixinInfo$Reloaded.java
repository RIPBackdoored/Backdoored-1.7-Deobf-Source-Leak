package org.spongepowered.asm.mixin.transformer;

import java.util.HashSet;
import java.util.List;
import org.spongepowered.asm.mixin.transformer.throwables.MixinReloadException;

class MixinInfo$Reloaded extends MixinInfo$State {
   private final MixinInfo$State previous;
   // $FF: synthetic field
   final MixinInfo this$0;

   MixinInfo$Reloaded(MixinInfo this$0, MixinInfo$State previous, byte[] mixinBytes) {
      super(this$0, mixinBytes, previous.getClassInfo());
      this.this$0 = this$0;
      this.previous = previous;
   }

   protected void validateChanges(MixinInfo$SubType type, List targetClasses) {
      if (!this.syntheticInnerClasses.equals(this.previous.syntheticInnerClasses)) {
         throw new MixinReloadException(this.this$0, "Cannot change inner classes");
      } else if (!this.interfaces.equals(this.previous.interfaces)) {
         throw new MixinReloadException(this.this$0, "Cannot change interfaces");
      } else if (!(new HashSet(this.softImplements)).equals(new HashSet(this.previous.softImplements))) {
         throw new MixinReloadException(this.this$0, "Cannot change soft interfaces");
      } else {
         List targets = this.this$0.readTargetClasses(this.classNode, true);
         if (!(new HashSet(targets)).equals(new HashSet(targetClasses))) {
            throw new MixinReloadException(this.this$0, "Cannot change target classes");
         } else {
            int priority = this.this$0.readPriority(this.classNode);
            if (priority != this.this$0.getPriority()) {
               throw new MixinReloadException(this.this$0, "Cannot change mixin priority");
            }
         }
      }
   }
}
