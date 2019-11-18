package org.spongepowered.asm.mixin.injection.struct;

import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.util.Bytecode;

public class InjectionNodes$InjectionNode implements Comparable {
   private static int nextId = 0;
   private final int id;
   private final AbstractInsnNode originalTarget;
   private AbstractInsnNode currentTarget;
   private Map decorations;

   public InjectionNodes$InjectionNode(AbstractInsnNode node) {
      this.currentTarget = this.originalTarget = node;
      this.id = nextId++;
   }

   public int getId() {
      return this.id;
   }

   public AbstractInsnNode getOriginalTarget() {
      return this.originalTarget;
   }

   public AbstractInsnNode getCurrentTarget() {
      return this.currentTarget;
   }

   public InjectionNodes$InjectionNode replace(AbstractInsnNode target) {
      this.currentTarget = target;
      return this;
   }

   public InjectionNodes$InjectionNode remove() {
      this.currentTarget = null;
      return this;
   }

   public boolean matches(AbstractInsnNode node) {
      return this.originalTarget == node || this.currentTarget == node;
   }

   public boolean isReplaced() {
      return this.originalTarget != this.currentTarget;
   }

   public boolean isRemoved() {
      return this.currentTarget == null;
   }

   public InjectionNodes$InjectionNode decorate(String key, Object value) {
      if (this.decorations == null) {
         this.decorations = new HashMap();
      }

      this.decorations.put(key, value);
      return this;
   }

   public boolean hasDecoration(String key) {
      return this.decorations != null && this.decorations.get(key) != null;
   }

   public Object getDecoration(String key) {
      return this.decorations == null ? null : this.decorations.get(key);
   }

   public int compareTo(InjectionNodes$InjectionNode other) {
      return other == null ? 0 : this.hashCode() - other.hashCode();
   }

   public String toString() {
      return String.format("InjectionNode[%s]", Bytecode.describeNode(this.currentTarget).replaceAll("\\s+", " "));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compareTo(Object var1) {
      return this.compareTo((InjectionNodes$InjectionNode)var1);
   }
}
