package org.spongepowered.asm.mixin.injection.struct;

import java.util.ArrayList;
import java.util.Iterator;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;

public class InjectionNodes extends ArrayList {
   private static final long serialVersionUID = 1L;

   public InjectionNodes$InjectionNode add(AbstractInsnNode node) {
      InjectionNodes$InjectionNode injectionNode = this.get(node);
      if (injectionNode == null) {
         injectionNode = new InjectionNodes$InjectionNode(node);
         this.add(injectionNode);
      }

      return injectionNode;
   }

   public InjectionNodes$InjectionNode get(AbstractInsnNode node) {
      Iterator var2 = this.iterator();

      InjectionNodes$InjectionNode injectionNode;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         injectionNode = (InjectionNodes$InjectionNode)var2.next();
      } while(!injectionNode.matches(node));

      return injectionNode;
   }

   public boolean contains(AbstractInsnNode node) {
      return this.get(node) != null;
   }

   public void replace(AbstractInsnNode oldNode, AbstractInsnNode newNode) {
      InjectionNodes$InjectionNode injectionNode = this.get(oldNode);
      if (injectionNode != null) {
         injectionNode.replace(newNode);
      }

   }

   public void remove(AbstractInsnNode node) {
      InjectionNodes$InjectionNode injectionNode = this.get(node);
      if (injectionNode != null) {
         injectionNode.remove();
      }

   }
}
