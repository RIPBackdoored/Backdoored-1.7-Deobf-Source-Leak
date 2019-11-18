package org.spongepowered.asm.mixin.injection.modify;

import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.Locals;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.PrettyPrinter$IPrettyPrintable;
import org.spongepowered.asm.util.SignaturePrinter;

public class LocalVariableDiscriminator$Context implements PrettyPrinter$IPrettyPrintable {
   final Target target;
   final Type returnType;
   final AbstractInsnNode node;
   final int baseArgIndex;
   final LocalVariableDiscriminator$Context$Local[] locals;
   private final boolean isStatic;

   public LocalVariableDiscriminator$Context(Type returnType, boolean argsOnly, Target target, AbstractInsnNode node) {
      this.isStatic = Bytecode.methodIsStatic(target.method);
      this.returnType = returnType;
      this.target = target;
      this.node = node;
      this.baseArgIndex = this.isStatic ? 0 : 1;
      this.locals = this.initLocals(target, argsOnly, node);
      this.initOrdinals();
   }

   private LocalVariableDiscriminator$Context$Local[] initLocals(Target target, boolean argsOnly, AbstractInsnNode node) {
      if (!argsOnly) {
         LocalVariableNode[] locals = Locals.getLocalsAt(target.classNode, target.method, node);
         if (locals != null) {
            LocalVariableDiscriminator$Context$Local[] lvt = new LocalVariableDiscriminator$Context$Local[locals.length];

            for(int l = 0; l < locals.length; ++l) {
               if (locals[l] != null) {
                  lvt[l] = new LocalVariableDiscriminator$Context$Local(this, locals[l].name, Type.getType(locals[l].desc));
               }
            }

            return lvt;
         }
      }

      LocalVariableDiscriminator$Context$Local[] lvt = new LocalVariableDiscriminator$Context$Local[this.baseArgIndex + target.arguments.length];
      if (!this.isStatic) {
         lvt[0] = new LocalVariableDiscriminator$Context$Local(this, "this", Type.getType(target.classNode.name));
      }

      for(int local = this.baseArgIndex; local < lvt.length; ++local) {
         Type arg = target.arguments[local - this.baseArgIndex];
         lvt[local] = new LocalVariableDiscriminator$Context$Local(this, "arg" + local, arg);
      }

      return lvt;
   }

   private void initOrdinals() {
      Map ordinalMap = new HashMap();

      for(int l = 0; l < this.locals.length; ++l) {
         Integer ordinal = 0;
         if (this.locals[l] != null) {
            ordinal = (Integer)ordinalMap.get(this.locals[l].type);
            ordinalMap.put(this.locals[l].type, ordinal = ordinal == null ? 0 : ordinal + 1);
            this.locals[l].ord = ordinal;
         }
      }

   }

   public void print(PrettyPrinter printer) {
      printer.add("%5s  %7s  %30s  %-50s  %s", "INDEX", "ORDINAL", "TYPE", "NAME", "CANDIDATE");

      for(int l = this.baseArgIndex; l < this.locals.length; ++l) {
         LocalVariableDiscriminator$Context$Local local = this.locals[l];
         if (local != null) {
            Type localType = local.type;
            String localName = local.name;
            int ordinal = local.ord;
            String candidate = this.returnType.equals(localType) ? "YES" : "-";
            printer.add("[%3d]    [%3d]  %30s  %-50s  %s", l, ordinal, SignaturePrinter.getTypeName(localType, false), localName, candidate);
         } else if (l > 0) {
            LocalVariableDiscriminator$Context$Local prevLocal = this.locals[l - 1];
            boolean isTop = prevLocal != null && prevLocal.type != null && prevLocal.type.getSize() > 1;
            printer.add("[%3d]           %30s", l, isTop ? "<top>" : "-");
         }
      }

   }
}
