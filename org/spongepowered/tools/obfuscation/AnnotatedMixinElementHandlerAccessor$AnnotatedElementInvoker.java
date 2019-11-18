package org.spongepowered.tools.obfuscation;

import javax.lang.model.element.ExecutableElement;
import org.spongepowered.asm.mixin.gen.AccessorInfo$AccessorType;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;

class AnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker extends AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor {
   public AnnotatedMixinElementHandlerAccessor$AnnotatedElementInvoker(ExecutableElement element, AnnotationHandle annotation, boolean shouldRemap) {
      super(element, annotation, shouldRemap);
   }

   public String getAccessorDesc() {
      return TypeUtils.getDescriptor((ExecutableElement)this.getElement());
   }

   public AccessorInfo$AccessorType getAccessorType() {
      return AccessorInfo$AccessorType.METHOD_PROXY;
   }

   public String getTargetTypeName() {
      return TypeUtils.getJavaSignature(this.getElement());
   }
}
