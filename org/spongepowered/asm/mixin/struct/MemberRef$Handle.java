package org.spongepowered.asm.mixin.struct;

import org.spongepowered.asm.mixin.transformer.throwables.MixinTransformerError;
import org.spongepowered.asm.util.Bytecode;

public final class MemberRef$Handle extends MemberRef {
   private org.spongepowered.asm.lib.Handle handle;

   public MemberRef$Handle(org.spongepowered.asm.lib.Handle handle) {
      this.handle = handle;
   }

   public org.spongepowered.asm.lib.Handle getMethodHandle() {
      return this.handle;
   }

   public boolean isField() {
      switch(this.handle.getTag()) {
      case 1:
      case 2:
      case 3:
      case 4:
         return true;
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
         return false;
      default:
         throw new MixinTransformerError("Invalid tag " + this.handle.getTag() + " for method handle " + this.handle + ".");
      }
   }

   public int getOpcode() {
      int opcode = MemberRef.opcodeFromTag(this.handle.getTag());
      if (opcode == 0) {
         throw new MixinTransformerError("Invalid tag " + this.handle.getTag() + " for method handle " + this.handle + ".");
      } else {
         return opcode;
      }
   }

   public void setOpcode(int opcode) {
      int tag = MemberRef.tagFromOpcode(opcode);
      if (tag == 0) {
         throw new MixinTransformerError("Invalid opcode " + Bytecode.getOpcodeName(opcode) + " for method handle " + this.handle + ".");
      } else {
         boolean itf = tag == 9;
         this.handle = new org.spongepowered.asm.lib.Handle(tag, this.handle.getOwner(), this.handle.getName(), this.handle.getDesc(), itf);
      }
   }

   public String getOwner() {
      return this.handle.getOwner();
   }

   public void setOwner(String owner) {
      boolean itf = this.handle.getTag() == 9;
      this.handle = new org.spongepowered.asm.lib.Handle(this.handle.getTag(), owner, this.handle.getName(), this.handle.getDesc(), itf);
   }

   public String getName() {
      return this.handle.getName();
   }

   public void setName(String name) {
      boolean itf = this.handle.getTag() == 9;
      this.handle = new org.spongepowered.asm.lib.Handle(this.handle.getTag(), this.handle.getOwner(), name, this.handle.getDesc(), itf);
   }

   public String getDesc() {
      return this.handle.getDesc();
   }

   public void setDesc(String desc) {
      boolean itf = this.handle.getTag() == 9;
      this.handle = new org.spongepowered.asm.lib.Handle(this.handle.getTag(), this.handle.getOwner(), this.handle.getName(), desc, itf);
   }
}
