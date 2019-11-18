package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.injection.Surrogate;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;

class MixinInfo$MixinMethodNode extends MethodNode {
   private final String originalName;
   // $FF: synthetic field
   final MixinInfo this$0;

   public MixinInfo$MixinMethodNode(MixinInfo this$0, int access, String name, String desc, String signature, String[] exceptions) {
      super(327680, access, name, desc, signature, exceptions);
      this.this$0 = this$0;
      this.originalName = name;
   }

   public String toString() {
      return String.format("%s%s", this.originalName, this.desc);
   }

   public String getOriginalName() {
      return this.originalName;
   }

   public boolean isInjector() {
      return this.getInjectorAnnotation() != null || this.isSurrogate();
   }

   public boolean isSurrogate() {
      return this.getVisibleAnnotation(Surrogate.class) != null;
   }

   public boolean isSynthetic() {
      return Bytecode.hasFlag((MethodNode)this, 4096);
   }

   public AnnotationNode getVisibleAnnotation(Class annotationClass) {
      return Annotations.getVisible((MethodNode)this, annotationClass);
   }

   public AnnotationNode getInjectorAnnotation() {
      return InjectionInfo.getInjectorAnnotation(this.this$0, this);
   }

   public IMixinInfo getOwner() {
      return this.this$0;
   }
}
