package org.spongepowered.tools.obfuscation;

import java.util.Iterator;
import javax.tools.Diagnostic.Kind;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

class AnnotatedMixinElementHandlerShadow extends AnnotatedMixinElementHandler {
   AnnotatedMixinElementHandlerShadow(IMixinAnnotationProcessor ap, AnnotatedMixin mixin) {
      super(ap, mixin);
   }

   public void registerShadow(AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow elem) {
      this.validateTarget(elem.getElement(), elem.getAnnotation(), elem.getName(), "@Shadow");
      if (elem.shouldRemap()) {
         Iterator var2 = this.mixin.getTargets().iterator();

         while(var2.hasNext()) {
            TypeHandle target = (TypeHandle)var2.next();
            this.registerShadowForTarget(elem, target);
         }

      }
   }

   private void registerShadowForTarget(AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow elem, TypeHandle target) {
      ObfuscationData obfData = elem.getObfuscationData(this.obf.getDataProvider(), target);
      if (obfData.isEmpty()) {
         String info = this.mixin.isMultiTarget() ? " in target " + target : "";
         if (target.isSimulated()) {
            elem.printMessage(this.ap, Kind.WARNING, "Unable to locate obfuscation mapping" + info + " for @Shadow " + elem);
         } else {
            elem.printMessage(this.ap, Kind.WARNING, "Unable to locate obfuscation mapping" + info + " for @Shadow " + elem);
         }

      } else {
         Iterator var4 = obfData.iterator();

         while(var4.hasNext()) {
            ObfuscationType type = (ObfuscationType)var4.next();

            try {
               elem.addMapping(type, (IMapping)obfData.get(type));
            } catch (Mappings$MappingConflictException var7) {
               elem.printMessage(this.ap, Kind.ERROR, "Mapping conflict for @Shadow " + elem + ": " + var7.getNew().getSimpleName() + " for target " + target + " conflicts with existing mapping " + var7.getOld().getSimpleName());
            }
         }

      }
   }
}
