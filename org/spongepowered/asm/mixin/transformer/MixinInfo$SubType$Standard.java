package org.spongepowered.asm.mixin.transformer;

import java.util.Iterator;
import java.util.List;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;

class MixinInfo$SubType$Standard extends MixinInfo$SubType {
   MixinInfo$SubType$Standard(MixinInfo info) {
      super(info, "@Mixin", false);
   }

   void validate(MixinInfo$State state, List targetClasses) {
      ClassNode classNode = state.getClassNode();
      Iterator var4 = targetClasses.iterator();

      while(var4.hasNext()) {
         ClassInfo targetClass = (ClassInfo)var4.next();
         if (!classNode.superName.equals(targetClass.getSuperName())) {
            if (!targetClass.hasSuperClass(classNode.superName, ClassInfo$Traversal.SUPER)) {
               ClassInfo superClass = ClassInfo.forName(classNode.superName);
               if (superClass.isMixin()) {
                  Iterator var7 = superClass.getTargets().iterator();

                  while(var7.hasNext()) {
                     ClassInfo superTarget = (ClassInfo)var7.next();
                     if (targetClasses.contains(superTarget)) {
                        throw new InvalidMixinException(this.mixin, "Illegal hierarchy detected. Derived mixin " + this + " targets the same class " + superTarget.getClassName() + " as its superclass " + superClass.getClassName());
                     }
                  }
               }

               throw new InvalidMixinException(this.mixin, "Super class '" + classNode.superName.replace('/', '.') + "' of " + this.mixin.getName() + " was not found in the hierarchy of target class '" + targetClass + "'");
            }

            this.detached = true;
         }
      }

   }

   MixinPreProcessorStandard createPreProcessor(MixinInfo$MixinClassNode classNode) {
      return new MixinPreProcessorStandard(this.mixin, classNode);
   }
}
