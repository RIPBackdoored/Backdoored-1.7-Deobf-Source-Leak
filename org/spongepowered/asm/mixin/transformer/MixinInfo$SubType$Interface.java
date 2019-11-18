package org.spongepowered.asm.mixin.transformer;

import java.util.List;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;

class MixinInfo$SubType$Interface extends MixinInfo$SubType {
   MixinInfo$SubType$Interface(MixinInfo info) {
      super(info, "@Mixin", true);
   }

   void validate(MixinInfo$State state, List targetClasses) {
      if (!MixinEnvironment.getCompatibilityLevel().supportsMethodsInInterfaces()) {
         throw new InvalidMixinException(this.mixin, "Interface mixin not supported in current enviromnment");
      } else {
         ClassNode classNode = state.getClassNode();
         if (!"java/lang/Object".equals(classNode.superName)) {
            throw new InvalidMixinException(this.mixin, "Super class of " + this + " is invalid, found " + classNode.superName.replace('/', '.'));
         }
      }
   }

   MixinPreProcessorStandard createPreProcessor(MixinInfo$MixinClassNode classNode) {
      return new MixinPreProcessorInterface(this.mixin, classNode);
   }
}
