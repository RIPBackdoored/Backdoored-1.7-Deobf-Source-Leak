package org.spongepowered.asm.lib.tree;

import java.util.ListIterator;
import java.util.NoSuchElementException;

final class InsnList$InsnListIterator implements ListIterator {
   AbstractInsnNode next;
   AbstractInsnNode prev;
   AbstractInsnNode remove;
   // $FF: synthetic field
   final InsnList this$0;

   InsnList$InsnListIterator(InsnList var1, int index) {
      this.this$0 = var1;
      if (index == var1.size()) {
         this.next = null;
         this.prev = var1.getLast();
      } else {
         this.next = var1.get(index);
         this.prev = this.next.prev;
      }

   }

   public boolean hasNext() {
      return this.next != null;
   }

   public Object next() {
      if (this.next == null) {
         throw new NoSuchElementException();
      } else {
         AbstractInsnNode result = this.next;
         this.prev = result;
         this.next = result.next;
         this.remove = result;
         return result;
      }
   }

   public void remove() {
      if (this.remove != null) {
         if (this.remove == this.next) {
            this.next = this.next.next;
         } else {
            this.prev = this.prev.prev;
         }

         this.this$0.remove(this.remove);
         this.remove = null;
      } else {
         throw new IllegalStateException();
      }
   }

   public boolean hasPrevious() {
      return this.prev != null;
   }

   public Object previous() {
      AbstractInsnNode result = this.prev;
      this.next = result;
      this.prev = result.prev;
      this.remove = result;
      return result;
   }

   public int nextIndex() {
      if (this.next == null) {
         return this.this$0.size();
      } else {
         if (this.this$0.cache == null) {
            this.this$0.cache = this.this$0.toArray();
         }

         return this.next.index;
      }
   }

   public int previousIndex() {
      if (this.prev == null) {
         return -1;
      } else {
         if (this.this$0.cache == null) {
            this.this$0.cache = this.this$0.toArray();
         }

         return this.prev.index;
      }
   }

   public void add(Object o) {
      if (this.next != null) {
         this.this$0.insertBefore(this.next, (AbstractInsnNode)o);
      } else if (this.prev != null) {
         this.this$0.insert(this.prev, (AbstractInsnNode)o);
      } else {
         this.this$0.add((AbstractInsnNode)o);
      }

      this.prev = (AbstractInsnNode)o;
      this.remove = null;
   }

   public void set(Object o) {
      if (this.remove != null) {
         this.this$0.set(this.remove, (AbstractInsnNode)o);
         if (this.remove == this.prev) {
            this.prev = (AbstractInsnNode)o;
         } else {
            this.next = (AbstractInsnNode)o;
         }

      } else {
         throw new IllegalStateException();
      }
   }
}
