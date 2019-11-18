package org.spongepowered.asm.mixin.injection.modify;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.util.Annotations;

public class LocalVariableDiscriminator {
   private final boolean argsOnly;
   private final int ordinal;
   private final int index;
   private final Set names;
   private final boolean print;

   public LocalVariableDiscriminator(boolean argsOnly, int ordinal, int index, Set names, boolean print) {
      this.argsOnly = argsOnly;
      this.ordinal = ordinal;
      this.index = index;
      this.names = Collections.unmodifiableSet(names);
      this.print = print;
   }

   public boolean isArgsOnly() {
      return this.argsOnly;
   }

   public int getOrdinal() {
      return this.ordinal;
   }

   public int getIndex() {
      return this.index;
   }

   public Set getNames() {
      return this.names;
   }

   public boolean hasNames() {
      return !this.names.isEmpty();
   }

   public boolean printLVT() {
      return this.print;
   }

   protected boolean isImplicit(LocalVariableDiscriminator$Context context) {
      return this.ordinal < 0 && this.index < context.baseArgIndex && this.names.isEmpty();
   }

   public int findLocal(Type returnType, boolean argsOnly, Target target, AbstractInsnNode node) {
      int var10000;
      try {
         var10000 = this.findLocal(new LocalVariableDiscriminator$Context(returnType, argsOnly, target, node));
      } catch (InvalidImplicitDiscriminatorException var6) {
         return -2;
      }

      return var10000;
   }

   public int findLocal(LocalVariableDiscriminator$Context context) {
      return this.isImplicit(context) ? this.findImplicitLocal(context) : this.findExplicitLocal(context);
   }

   private int findImplicitLocal(LocalVariableDiscriminator$Context context) {
      int found = 0;
      int count = 0;

      for(int index = context.baseArgIndex; index < context.locals.length; ++index) {
         LocalVariableDiscriminator$Context$Local local = context.locals[index];
         if (local != null && local.type.equals(context.returnType)) {
            ++count;
            found = index;
         }
      }

      if (count == 1) {
         return found;
      } else {
         throw new InvalidImplicitDiscriminatorException("Found " + count + " candidate variables but exactly 1 is required.");
      }
   }

   private int findExplicitLocal(LocalVariableDiscriminator$Context context) {
      for(int index = context.baseArgIndex; index < context.locals.length; ++index) {
         LocalVariableDiscriminator$Context$Local local = context.locals[index];
         if (local != null && local.type.equals(context.returnType)) {
            if (this.ordinal > -1) {
               if (this.ordinal == local.ord) {
                  return index;
               }
            } else if (this.index >= context.baseArgIndex) {
               if (this.index == index) {
                  return index;
               }
            } else if (this.names.contains(local.name)) {
               return index;
            }
         }
      }

      return -1;
   }

   public static LocalVariableDiscriminator parse(AnnotationNode annotation) {
      boolean argsOnly = (Boolean)Annotations.getValue(annotation, "argsOnly", (Object)Boolean.FALSE);
      int ordinal = (Integer)Annotations.getValue(annotation, "ordinal", (int)-1);
      int index = (Integer)Annotations.getValue(annotation, "index", (int)-1);
      boolean print = (Boolean)Annotations.getValue(annotation, "print", (Object)Boolean.FALSE);
      Set names = new HashSet();
      List namesList = (List)Annotations.getValue(annotation, "name", (Object)((List)null));
      if (namesList != null) {
         names.addAll(namesList);
      }

      return new LocalVariableDiscriminator(argsOnly, ordinal, index, names, print);
   }
}
