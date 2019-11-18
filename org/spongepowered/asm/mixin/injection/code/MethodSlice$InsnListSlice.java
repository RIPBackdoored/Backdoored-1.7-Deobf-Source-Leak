package org.spongepowered.asm.mixin.injection.code;

import java.util.ListIterator;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;

final class MethodSlice$InsnListSlice extends ReadOnlyInsnList {
   private final int start;
   private final int end;

   protected MethodSlice$InsnListSlice(InsnList inner, int start, int end) {
      super(inner);
      this.start = start;
      this.end = end;
   }

   public ListIterator iterator() {
      return this.iterator(0);
   }

   public ListIterator iterator(int index) {
      return new MethodSlice$InsnListSlice$SliceIterator(super.iterator(this.start + index), this.start, this.end, this.start + index);
   }

   public AbstractInsnNode[] toArray() {
      AbstractInsnNode[] all = super.toArray();
      AbstractInsnNode[] subset = new AbstractInsnNode[this.size()];
      System.arraycopy(all, this.start, subset, 0, subset.length);
      return subset;
   }

   public int size() {
      return this.end - this.start + 1;
   }

   public AbstractInsnNode getFirst() {
      return super.get(this.start);
   }

   public AbstractInsnNode getLast() {
      return super.get(this.end);
   }

   public AbstractInsnNode get(int index) {
      return super.get(this.start + index);
   }

   public boolean contains(AbstractInsnNode insn) {
      AbstractInsnNode[] var2 = this.toArray();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         AbstractInsnNode node = var2[var4];
         if (node == insn) {
            return true;
         }
      }

      return false;
   }

   public int indexOf(AbstractInsnNode insn) {
      int index = super.indexOf(insn);
      return index >= this.start && index <= this.end ? index - this.start : -1;
   }

   public int realIndexOf(AbstractInsnNode insn) {
      return super.indexOf(insn);
   }
}
