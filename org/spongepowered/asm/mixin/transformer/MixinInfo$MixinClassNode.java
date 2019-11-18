package org.spongepowered.asm.mixin.transformer;

import java.util.List;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.MethodNode;

class MixinInfo$MixinClassNode extends ClassNode {
   public final List mixinMethods;
   // $FF: synthetic field
   final MixinInfo this$0;

   public MixinInfo$MixinClassNode(MixinInfo this$0, MixinInfo mixin) {
      this(this$0, 327680);
   }

   public MixinInfo$MixinClassNode(MixinInfo this$0, int api) {
      super(api);
      this.this$0 = this$0;
      this.mixinMethods = (List)this.methods;
   }

   public MixinInfo getMixin() {
      return this.this$0;
   }

   public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
      MethodNode method = new MixinInfo$MixinMethodNode(this.this$0, access, name, desc, signature, exceptions);
      this.methods.add(method);
      return method;
   }
}
