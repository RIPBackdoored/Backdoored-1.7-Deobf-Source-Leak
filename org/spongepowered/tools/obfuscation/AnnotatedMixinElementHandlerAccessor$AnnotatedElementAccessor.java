package org.spongepowered.tools.obfuscation;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import org.spongepowered.asm.mixin.gen.AccessorInfo$AccessorType;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;

class AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor extends AnnotatedMixinElementHandler$AnnotatedElement {
   private final boolean shouldRemap;
   private final TypeMirror returnType;
   private String targetName;

   public AnnotatedMixinElementHandlerAccessor$AnnotatedElementAccessor(ExecutableElement element, AnnotationHandle annotation, boolean shouldRemap) {
      super(element, annotation);
      this.shouldRemap = shouldRemap;
      this.returnType = ((ExecutableElement)this.getElement()).getReturnType();
   }

   public boolean shouldRemap() {
      return this.shouldRemap;
   }

   public String getAnnotationValue() {
      return (String)this.getAnnotation().getValue();
   }

   public TypeMirror getTargetType() {
      // $FF: Couldn't be decompiled
   }

   public String getTargetTypeName() {
      return TypeUtils.getTypeName(this.getTargetType());
   }

   public String getAccessorDesc() {
      return TypeUtils.getInternalName(this.getTargetType());
   }

   public MemberInfo getContext() {
      return new MemberInfo(this.getTargetName(), (String)null, this.getAccessorDesc());
   }

   public AccessorInfo$AccessorType getAccessorType() {
      return this.returnType.getKind() == TypeKind.VOID ? AccessorInfo$AccessorType.FIELD_SETTER : AccessorInfo$AccessorType.FIELD_GETTER;
   }

   public void setTargetName(String targetName) {
      this.targetName = targetName;
   }

   public String getTargetName() {
      return this.targetName;
   }

   public String toString() {
      return this.targetName != null ? this.targetName : "<invalid>";
   }
}
