package org.spongepowered.asm.mixin.transformer;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;

abstract class MixinInfo$SubType {
   protected final MixinInfo mixin;
   protected final String annotationType;
   protected final boolean targetMustBeInterface;
   protected boolean detached;

   MixinInfo$SubType(MixinInfo info, String annotationType, boolean targetMustBeInterface) {
      this.mixin = info;
      this.annotationType = annotationType;
      this.targetMustBeInterface = targetMustBeInterface;
   }

   Collection getInterfaces() {
      return Collections.emptyList();
   }

   boolean isDetachedSuper() {
      return this.detached;
   }

   boolean isLoadable() {
      return false;
   }

   void validateTarget(String targetName, ClassInfo targetInfo) {
      boolean targetIsInterface = targetInfo.isInterface();
      if (targetIsInterface != this.targetMustBeInterface) {
         String not = targetIsInterface ? "" : "not ";
         throw new InvalidMixinException(this.mixin, this.annotationType + " target type mismatch: " + targetName + " is " + not + "an interface in " + this);
      }
   }

   abstract void validate(MixinInfo$State var1, List var2);

   abstract MixinPreProcessorStandard createPreProcessor(MixinInfo$MixinClassNode var1);

   static MixinInfo$SubType getTypeFor(MixinInfo mixin) {
      if (!mixin.getClassInfo().isInterface()) {
         return new MixinInfo$SubType$Standard(mixin);
      } else {
         boolean containsNonAccessorMethod = false;

         ClassInfo$Method method;
         for(Iterator var2 = mixin.getClassInfo().getMethods().iterator(); var2.hasNext(); containsNonAccessorMethod |= !method.isAccessor()) {
            method = (ClassInfo$Method)var2.next();
         }

         if (containsNonAccessorMethod) {
            return new MixinInfo$SubType$Interface(mixin);
         } else {
            return new MixinInfo$SubType$Accessor(mixin);
         }
      }
   }
}
