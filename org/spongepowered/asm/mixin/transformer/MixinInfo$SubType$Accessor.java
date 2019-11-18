package org.spongepowered.asm.mixin.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;

class MixinInfo$SubType$Accessor extends MixinInfo$SubType {
   private final Collection interfaces = new ArrayList();

   MixinInfo$SubType$Accessor(MixinInfo info) {
      super(info, "@Mixin", false);
      this.interfaces.add(info.getClassRef());
   }

   boolean isLoadable() {
      return true;
   }

   Collection getInterfaces() {
      return this.interfaces;
   }

   void validateTarget(String targetName, ClassInfo targetInfo) {
      boolean targetIsInterface = targetInfo.isInterface();
      if (targetIsInterface && !MixinEnvironment.getCompatibilityLevel().supportsMethodsInInterfaces()) {
         throw new InvalidMixinException(this.mixin, "Accessor mixin targetting an interface is not supported in current enviromnment");
      }
   }

   void validate(MixinInfo$State state, List targetClasses) {
      ClassNode classNode = state.getClassNode();
      if (!"java/lang/Object".equals(classNode.superName)) {
         throw new InvalidMixinException(this.mixin, "Super class of " + this + " is invalid, found " + classNode.superName.replace('/', '.'));
      }
   }

   MixinPreProcessorStandard createPreProcessor(MixinInfo$MixinClassNode classNode) {
      return new MixinPreProcessorAccessor(this.mixin, classNode);
   }
}
