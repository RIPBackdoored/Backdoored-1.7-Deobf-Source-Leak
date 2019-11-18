package org.spongepowered.asm.mixin.struct;

import org.spongepowered.asm.lib.tree.FieldInsnNode;

public final class MemberRef$Field extends MemberRef {
   private static final int OPCODES = 183;
   public final FieldInsnNode insn;

   public MemberRef$Field(FieldInsnNode insn) {
      this.insn = insn;
   }

   public boolean isField() {
      return true;
   }

   public int getOpcode() {
      return this.insn.getOpcode();
   }

   public void setOpcode(int opcode) {
      if ((opcode & 183) == 0) {
         throw new IllegalArgumentException("Invalid opcode for field instruction: 0x" + Integer.toHexString(opcode));
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
