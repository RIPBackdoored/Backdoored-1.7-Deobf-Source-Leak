package org.spongepowered.asm.mixin.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.FrameNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.util.Annotations;

public class ClassInfo$Method extends ClassInfo$Member {
   private final List frames;
   private boolean isAccessor;
   // $FF: synthetic field
   final ClassInfo this$0;

   public ClassInfo$Method(ClassInfo this$0, ClassInfo$Member member) {
      super(member);
      this.this$0 = this$0;
      this.frames = member instanceof ClassInfo$Method ? ((ClassInfo$Method)member).frames : null;
   }

   public ClassInfo$Method(ClassInfo this$0, MethodNode method) {
      this(this$0, method, false);
      this.setUnique(Annotations.getVisible(method, Unique.class) != null);
      this.isAccessor = Annotations.getSingleVisible(method, Accessor.class, Invoker.class) != null;
   }

   public ClassInfo$Method(ClassInfo this$0, MethodNode method, boolean injected) {
      super(ClassInfo$Member$Type.METHOD, method.name, method.desc, method.access, injected);
      this.this$0 = this$0;
      this.frames = this.gatherFrames(method);
      this.setUnique(Annotations.getVisible(method, Unique.class) != null);
      this.isAccessor = Annotations.getSingleVisible(method, Accessor.class, Invoker.class) != null;
   }

   public ClassInfo$Method(ClassInfo this$0, String name, String desc) {
      super(ClassInfo$Member$Type.METHOD, name, desc, 1, false);
      this.this$0 = this$0;
      this.frames = null;
   }

   public ClassInfo$Method(ClassInfo this$0, String name, String desc, int access) {
      super(ClassInfo$Member$Type.METHOD, name, desc, access, false);
      this.this$0 = this$0;
      this.frames = null;
   }

   public ClassInfo$Method(ClassInfo this$0, String name, String desc, int access, boolean injected) {
      super(ClassInfo$Member$Type.METHOD, name, desc, access, injected);
      this.this$0 = this$0;
      this.frames = null;
   }

   private List gatherFrames(MethodNode method) {
      List frames = new ArrayList();
      ListIterator iter = method.instructions.iterator();

      while(iter.hasNext()) {
         AbstractInsnNode insn = (AbstractInsnNode)iter.next();
         if (insn instanceof FrameNode) {
            frames.add(new ClassInfo$FrameData(method.instructions.indexOf(insn), (FrameNode)insn));
         }
      }

      return frames;
   }

   public List getFrames() {
      return this.frames;
   }

   public ClassInfo getOwner() {
      return this.this$0;
   }

   public boolean isAccessor() {
      return this.isAccessor;
   }

   public boolean equals(Object obj) {
      return !(obj instanceof ClassInfo$Method) ? false : super.equals(obj);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String toString() {
      return super.toString();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int hashCode() {
      return super.hashCode();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean equals(String var1, String var2) {
      return super.equals(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String remapTo(String var1) {
      return super.remapTo(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String renameTo(String var1) {
      return super.renameTo(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int getAccess() {
      return super.getAccess();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public ClassInfo getImplementor() {
      return super.getImplementor();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean matchesFlags(int var1) {
      return super.matchesFlags(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void setDecoratedFinal(boolean var1, boolean var2) {
      super.setDecoratedFinal(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isDecoratedMutable() {
      return super.isDecoratedMutable();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isDecoratedFinal() {
      return super.isDecoratedFinal();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void setUnique(boolean var1) {
      super.setUnique(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isUnique() {
      return super.isUnique();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isSynthetic() {
      return super.isSynthetic();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isFinal() {
      return super.isFinal();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isAbstract() {
      return super.isAbstract();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isStatic() {
      return super.isStatic();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isPrivate() {
      return super.isPrivate();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isRemapped() {
      return super.isRemapped();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isRenamed() {
      return super.isRenamed();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean isInjected() {
      return super.isInjected();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getDesc() {
      return super.getDesc();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getOriginalDesc() {
      return super.getOriginalDesc();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getName() {
      return super.getName();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public String getOriginalName() {
      return super.getOriginalName();
   }
}
