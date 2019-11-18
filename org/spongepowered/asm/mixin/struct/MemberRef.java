package org.spongepowered.asm.mixin.struct;

import org.spongepowered.asm.util.Bytecode;

public abstract class MemberRef {
   private static final int[] H_OPCODES = new int[]{0, 180, 178, 181, 179, 182, 184, 183, 183, 185};

   public abstract boolean isField();

   public abstract int getOpcode();

   public abstract void setOpcode(int var1);

   public abstract String getOwner();

   public abstract void setOwner(String var1);

   public abstract String getName();

   public abstract void setName(String var1);

   public abstract String getDesc();

   public abstract void setDesc(String var1);

   public String toString() {
      String name = Bytecode.getOpcodeName(this.getOpcode());
      return String.format("%s for %s.%s%s%s", name, this.getOwner(), this.getName(), this.isField() ? ":" : "", this.getDesc());
   }

   public boolean equals(Object obj) {
      if (!(obj instanceof MemberRef)) {
         return false;
      } else {
         MemberRef other = (MemberRef)obj;
         return this.getOpcode() == other.getOpcode() && this.getOwner().equals(other.getOwner()) && this.getName().equals(other.getName()) && this.getDesc().equals(other.getDesc());
      }
   }

   public int hashCode() {
      return this.toString().hashCode();
   }

   static int opcodeFromTag(int tag) {
      return tag >= 0 && tag < H_OPCODES.length ? H_OPCODES[tag] : 0;
   }

   static int tagFromOpcode(int opcode) {
      for(int tag = 1; tag < H_OPCODES.length; ++tag) {
         if (H_OPCODES[tag] == opcode) {
            return tag;
         }
      }

      return 0;
   }
}
