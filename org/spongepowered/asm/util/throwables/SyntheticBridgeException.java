package org.spongepowered.asm.util.throwables;

import java.util.ListIterator;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.meta.MixinMerged;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.PrettyPrinter;

public class SyntheticBridgeException extends MixinException {
   private static final long serialVersionUID = 1L;
   private final SyntheticBridgeException$Problem problem;
   private final String name;
   private final String desc;
   private final int index;
   private final AbstractInsnNode a;
   private final AbstractInsnNode b;

   public SyntheticBridgeException(SyntheticBridgeException$Problem problem, String name, String desc, int index, AbstractInsnNode a, AbstractInsnNode b) {
      super(problem.getMessage(name, desc, index, a, b));
      this.problem = problem;
      this.name = name;
      this.desc = desc;
      this.index = index;
      this.a = a;
      this.b = b;
   }

   public void printAnalysis(IMixinContext context, MethodNode mda, MethodNode mdb) {
      PrettyPrinter printer = new PrettyPrinter();
      printer.addWrapped(100, this.getMessage()).hr();
      printer.add().kv("Method", this.name + this.desc).kv("Problem Type", this.problem).add().hr();
      String merged = (String)Annotations.getValue(Annotations.getVisible(mda, MixinMerged.class), "mixin");
      String owner = merged != null ? merged : context.getTargetClassRef().replace('/', '.');
      this.printMethod(printer.add("Existing method").add().kv("Owner", owner).add(), mda).hr();
      this.printMethod(printer.add("Incoming method").add().kv("Owner", context.getClassRef().replace('/', '.')).add(), mdb).hr();
      this.printProblem(printer, context, mda, mdb).print(System.err);
   }

   private PrettyPrinter printMethod(PrettyPrinter printer, MethodNode method) {
      int index = 0;

      for(ListIterator iter = method.instructions.iterator(); iter.hasNext(); ++index) {
         printer.kv(index == this.index ? ">>>>" : "", Bytecode.describeNode((AbstractInsnNode)iter.next()));
      }

      return printer.add();
   }

   private PrettyPrinter printProblem(PrettyPrinter printer, IMixinContext context, MethodNode mda, MethodNode mdb) {
      // $FF: Couldn't be decompiled
   }

   private PrettyPrinter printTypeComparison(PrettyPrinter printer, String index, Type tpa, Type tpb) {
      printer.kv("Target " + index, "%s", tpa);
      printer.kv("Incoming " + index, "%s", tpb);
      if (tpa.equals(tpb)) {
         printer.kv("Analysis", "Types match: %s", tpa);
      } else if (tpa.getSort() != tpb.getSort()) {
         printer.kv("Analysis", "Types are incompatible");
      } else if (tpa.getSort() == 10) {
         ClassInfo superClass = ClassInfo.getCommonSuperClassOrInterface(tpa, tpb);
         printer.kv("Analysis", "Common supertype: L%s;", superClass);
      }

      return printer.add();
   }
}
