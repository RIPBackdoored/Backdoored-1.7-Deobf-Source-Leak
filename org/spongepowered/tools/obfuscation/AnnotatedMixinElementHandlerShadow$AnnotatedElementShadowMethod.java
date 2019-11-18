package org.spongepowered.tools.obfuscation;

import javax.lang.model.element.ExecutableElement;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.IMapping$Type;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

class AnnotatedMixinElementHandlerShadow$AnnotatedElementShadowMethod extends AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow {
   // $FF: synthetic field
   final AnnotatedMixinElementHandlerShadow this$0;

   public AnnotatedMixinElementHandlerShadow$AnnotatedElementShadowMethod(AnnotatedMixinElementHandlerShadow this$0, ExecutableElement element, AnnotationHandle annotation, boolean shouldRemap) {
      super(element, annotation, shouldRemap, IMapping$Type.METHOD);
      this.this$0 = this$0;
   }

   public MappingMethod getMapping(TypeHandle owner, String name, String desc) {
      return owner.getMappingMethod(name, desc);
   }

   public void addMapping(ObfuscationType type, IMapping remapped) {
      this.this$0.addMethodMapping(type, this.setObfuscatedName(remapped), this.getDesc(), remapped.getDesc());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IMapping getMapping(TypeHandle var1, String var2, String var3) {
      return this.getMapping(var1, var2, var3);
   }
}
