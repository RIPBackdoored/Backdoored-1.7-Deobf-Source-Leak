package org.spongepowered.asm.mixin.injection.code;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;

class MethodSlice$InsnListSlice$SliceIterator implements ListIterator {
   private final ListIterator iter;
   private int start;
   private int end;
   private int index;

   public MethodSlice$InsnListSlice$SliceIterator(ListIterator iter, int start, int end, int index) {
      this.iter = iter;
      this.start = start;
      this.end = end;
      this.index = index;
   }

   public boolean hasNext() {
      return this.index <= this.end && this.iter.hasNext();
   }

   public AbstractInsnNode next() {
      if (this.index > this.end) {
         throw new NoSuchElementException();
      } else {
         ++this.index;
         return (AbstractInsnNode)this.iter.next();
      }
   }

   public boolean hasPrevious() {
      return this.index > this.start;
   }

   public AbstractInsnNode previous() {
      if (this.index <= this.start) {
         throw new NoSuchElementException();
      } else {
         --this.index;
         return (AbstractInsnNode)this.iter.previous();
      }
   }

   public int nextIndex() {
      return this.index - this.start;
   }

   public int previousIndex() {
      return this.index - this.start - 1;
   }

   public void remove() {
      throw new UnsupportedOperationException("Cannot remove insn from slice");
   }

   public void set(AbstractInsnNode e) {
      throw new UnsupportedOperationException("Cannot set insn using slice");
   }

   public void add(AbstractInsnNode e) {
      throw new UnsupportedOperationException("Cannot add insn using slice");
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void add(Object var1) {
      this.add((AbstractInsnNode)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void set(Object var1) {
      this.set((AbstractInsnNode)var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object previous() {
      return this.previous();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object next() {
      return this.next();
   }
}
