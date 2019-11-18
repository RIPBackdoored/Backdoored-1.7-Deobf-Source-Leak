package org.spongepowered.asm.mixin.injection.modify;

import java.util.Collection;
import java.util.ListIterator;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint$AtCode;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.mixin.injection.struct.Target;

@InjectionPoint$AtCode("LOAD")
public class BeforeLoadLocal extends ModifyVariableInjector$ContextualInjectionPoint {
   private final Type returnType;
   private final LocalVariableDiscriminator discriminator;
   private final int opcode;
   private final int ordinal;
   private boolean opcodeAfter;

   protected BeforeLoadLocal(InjectionPointData data) {
      this(data, 21, false);
   }

   protected BeforeLoadLocal(InjectionPointData data, int opcode, boolean opcodeAfter) {
      super(data.getContext());
      this.returnType = data.getMethodReturnType();
      this.discriminator = data.getLocalVariableDiscriminator();
      this.opcode = data.getOpcode(this.returnType.getOpcode(opcode));
      this.ordinal = data.getOrdinal();
      this.opcodeAfter = opcodeAfter;
   }

   boolean find(Target target, Collection nodes) {
      BeforeLoadLocal$SearchState state = new BeforeLoadLocal$SearchState(this.ordinal, this.discriminator.printLVT());
      ListIterator iter = target.method.instructions.iterator();

      while(true) {
         while(iter.hasNext()) {
            AbstractInsnNode insn = (AbstractInsnNode)iter.next();
            int local;
            if (state.isPendingCheck()) {
               local = this.discriminator.findLocal(this.returnType, this.discriminator.isArgsOnly(), target, insn);
               state.check(nodes, insn, local);
            } else if (insn instanceof VarInsnNode && insn.getOpcode() == this.opcode && (this.ordinal == -1 || !state.success())) {
               state.register((VarInsnNode)insn);
               if (this.opcodeAfter) {
                  state.setPendingCheck();
               } else {
                  local = this.discriminator.findLocal(this.returnType, this.discriminator.isArgsOnly(), target, insn);
                  state.check(nodes, insn, local);
               }
            }
         }

         return state.success();
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean find(String var1, InsnList var2, Collection var3) {
      return super.find(var1, var2, var3);
   }
}
