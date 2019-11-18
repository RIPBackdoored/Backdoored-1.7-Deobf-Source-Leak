package org.spongepowered.asm.mixin.transformer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.InnerClassNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.MixinEnvironment$CompatibilityLevel;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.util.Annotations;

class MixinInfo$State {
   private byte[] mixinBytes;
   private final ClassInfo classInfo;
   private boolean detachedSuper;
   private boolean unique;
   protected final Set interfaces;
   protected final List softImplements;
   protected final Set syntheticInnerClasses;
   protected final Set innerClasses;
   protected MixinInfo$MixinClassNode classNode;
   // $FF: synthetic field
   final MixinInfo this$0;

   MixinInfo$State(MixinInfo this$0, byte[] mixinBytes) {
      this(this$0, mixinBytes, (ClassInfo)null);
   }

   MixinInfo$State(MixinInfo this$0, byte[] mixinBytes, ClassInfo classInfo) {
      this.this$0 = this$0;
      this.interfaces = new HashSet();
      this.softImplements = new ArrayList();
      this.syntheticInnerClasses = new HashSet();
      this.innerClasses = new HashSet();
      this.mixinBytes = mixinBytes;
      this.connect();
      this.classInfo = classInfo != null ? classInfo : ClassInfo.fromClassNode(this.getClassNode());
   }

   private void connect() {
      this.classNode = this.createClassNode(0);
   }

   private void complete() {
      this.classNode = null;
   }

   ClassInfo getClassInfo() {
      return this.classInfo;
   }

   byte[] getClassBytes() {
      return this.mixinBytes;
   }

   MixinInfo$MixinClassNode getClassNode() {
      return this.classNode;
   }

   boolean isDetachedSuper() {
      return this.detachedSuper;
   }

   boolean isUnique() {
      return this.unique;
   }

   List getSoftImplements() {
      return this.softImplements;
   }

   Set getSyntheticInnerClasses() {
      return this.syntheticInnerClasses;
   }

   Set getInnerClasses() {
      return this.innerClasses;
   }

   Set getInterfaces() {
      return this.interfaces;
   }

   MixinInfo$MixinClassNode createClassNode(int flags) {
      MixinInfo$MixinClassNode classNode = new MixinInfo$MixinClassNode(this.this$0, this.this$0);
      ClassReader classReader = new ClassReader(this.mixinBytes);
      classReader.accept(classNode, flags);
      return classNode;
   }

   void validate(MixinInfo$SubType type, List targetClasses) {
      MixinPreProcessorStandard preProcessor = type.createPreProcessor(this.getClassNode()).prepare();
      Iterator var4 = targetClasses.iterator();

      while(var4.hasNext()) {
         ClassInfo target = (ClassInfo)var4.next();
         preProcessor.conform(target);
      }

      type.validate(this, targetClasses);
      this.detachedSuper = type.isDetachedSuper();
      this.unique = Annotations.getVisible((ClassNode)this.getClassNode(), Unique.class) != null;
      this.validateInner();
      this.validateClassVersion();
      this.validateRemappables(targetClasses);
      this.readImplementations(type);
      this.readInnerClasses();
      this.validateChanges(type, targetClasses);
      this.complete();
   }

   private void validateInner() {
      if (!this.classInfo.isProbablyStatic()) {
         throw new InvalidMixinException(this.this$0, "Inner class mixin must be declared static");
      }
   }

   private void validateClassVersion() {
      if (this.classNode.version > MixinEnvironment.getCompatibilityLevel().classVersion()) {
         String helpText = ".";
         MixinEnvironment$CompatibilityLevel[] var2 = MixinEnvironment$CompatibilityLevel.values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            MixinEnvironment$CompatibilityLevel level = var2[var4];
            if (level.classVersion() >= this.classNode.version) {
               helpText = String.format(". Mixin requires compatibility level %s or above.", level.name());
            }
         }

         throw new InvalidMixinException(this.this$0, "Unsupported mixin class version " + this.classNode.version + helpText);
      }
   }

   private void validateRemappables(List targetClasses) {
      if (targetClasses.size() > 1) {
         Iterator var2 = this.classNode.fields.iterator();

         while(var2.hasNext()) {
            FieldNode field = (FieldNode)var2.next();
            this.validateRemappable(Shadow.class, field.name, Annotations.getVisible(field, Shadow.class));
         }

         var2 = this.classNode.methods.iterator();

         AnnotationNode overwrite;
         MethodNode method;
         do {
            if (!var2.hasNext()) {
               return;
            }

            method = (MethodNode)var2.next();
            this.validateRemappable(Shadow.class, method.name, Annotations.getVisible(method, Shadow.class));
            overwrite = Annotations.getVisible(method, Overwrite.class);
         } while(overwrite == null || (method.access & 8) != 0 && (method.access & 1) != 0);

         throw new InvalidMixinException(this.this$0, "Found @Overwrite annotation on " + method.name + " in " + this.this$0);
      }
   }

   private void validateRemappable(Class annotationClass, String name, AnnotationNode annotation) {
      if (annotation != null && (Boolean)Annotations.getValue(annotation, "remap", (Object)Boolean.TRUE)) {
         throw new InvalidMixinException(this.this$0, "Found a remappable @" + annotationClass.getSimpleName() + " annotation on " + name + " in " + this);
      }
   }

   void readImplementations(MixinInfo$SubType type) {
      this.interfaces.addAll(this.classNode.interfaces);
      this.interfaces.addAll(type.getInterfaces());
      AnnotationNode implementsAnnotation = Annotations.getInvisible((ClassNode)this.classNode, Implements.class);
      if (implementsAnnotation != null) {
         List interfaces = (List)Annotations.getValue(implementsAnnotation);
         if (interfaces != null) {
            Iterator var4 = interfaces.iterator();

            while(var4.hasNext()) {
               AnnotationNode interfaceNode = (AnnotationNode)var4.next();
               InterfaceInfo interfaceInfo = InterfaceInfo.fromAnnotation(this.this$0, interfaceNode);
               this.softImplements.add(interfaceInfo);
               this.interfaces.add(interfaceInfo.getInternalName());
               if (!(this instanceof MixinInfo$Reloaded)) {
                  this.classInfo.addInterface(interfaceInfo.getInternalName());
               }
            }

         }
      }
   }

   void readInnerClasses() {
      Iterator var1 = this.classNode.innerClasses.iterator();

      while(true) {
         while(true) {
            InnerClassNode inner;
            ClassInfo innerClass;
            do {
               if (!var1.hasNext()) {
                  return;
               }

               inner = (InnerClassNode)var1.next();
               innerClass = ClassInfo.forName(inner.name);
            } while((inner.outerName == null || !inner.outerName.equals(this.classInfo.getName())) && !inner.name.startsWith(this.classNode.name + "$"));

            if (innerClass.isProbablyStatic() && innerClass.isSynthetic()) {
               this.syntheticInnerClasses.add(inner.name);
            } else {
               this.innerClasses.add(inner.name);
            }
         }
      }
   }

   protected void validateChanges(MixinInfo$SubType type, List targetClasses) {
      type.createPreProcessor(this.classNode).prepare();
   }
}
