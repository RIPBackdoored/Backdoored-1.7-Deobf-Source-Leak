package org.spongepowered.tools.obfuscation;

import javax.lang.model.element.VariableElement;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.IMapping$Type;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

class AnnotatedMixinElementHandlerShadow$AnnotatedElementShadowField extends AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow {
   // $FF: synthetic field
   final AnnotatedMixinElementHandlerShadow this$0;

   public AnnotatedMixinElementHandlerShadow$AnnotatedElementShadowField(AnnotatedMixinElementHandlerShadow this$0, VariableElement element, AnnotationHandle annotation, boolean shouldRemap) {
      super(element, annotation, shouldRemap, IMapping$Type.FIELD);
      this.this$0 = this$0;
   }

   public MappingField getMapping(TypeHandle owner, String name, String desc) {
      return new MappingField(owner.getName(), name, desc);
   }

   public void addMapping(ObfuscationType type, IMapping remapped) {
      this.this$0.addFieldMapping(type, this.setObfuscatedName(remapped), this.getDesc(), remapped.getDesc());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public IMapping getMapping(TypeHandle var1, String var2, String var3) {
      return this.getMapping(var1, var2, var3);
   }
}
