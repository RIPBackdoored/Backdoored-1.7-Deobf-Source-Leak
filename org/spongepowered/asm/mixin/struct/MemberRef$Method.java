package org.spongepowered.asm.mixin.struct;

import org.spongepowered.asm.lib.tree.MethodInsnNode;

public final class MemberRef$Method extends MemberRef {
   private static final int OPCODES = 191;
   public final MethodInsnNode insn;

   public MemberRef$Method(MethodInsnNode insn) {
      this.insn = insn;
   }

   public boolean isField() {
      return false;
   }

   public int getOpcode() {
      return this.insn.getOpcode();
   }

   public void setOpcode(int opcode) {
      if ((opcode & 191) == 0) {
         throw new IllegalArgumentException("Invalid opcode for method instruction: 0x" + Integer.toHexString(opcode));
      } else {
         this.insn.setOpcode(opcode);
      }
   }

   public String getOwner() {
      return this.insn.owner;
   }

   public void setOwner(String owner) {
      this.insn.owner = owner;
   }

   public String getName() {
      return this.insn.name;
   }

   public void setName(String name) {
      this.insn.name = name;
   }

   public String getDesc() {
      return this.insn.desc;
   }

   public void setDesc(String desc) {
      this.insn.desc = desc;
   }
}
