package javassist.bytecode.analysis;

import javassist.bytecode.stackmap.BasicBlock$Catch;

public class ControlFlow$Catcher {
   private ControlFlow$Block node;
   private int typeIndex;

   ControlFlow$Catcher(BasicBlock$Catch c) {
      this.node = (ControlFlow$Block)c.body;
      this.typeIndex = c.typeIndex;
   }

   public ControlFlow$Block block() {
      return this.node;
   }

   public String type() {
      return this.typeIndex == 0 ? "java.lang.Throwable" : this.node.method.getConstPool().getClassInfo(this.typeIndex);
   }

   // $FF: synthetic method
   static ControlFlow$Block access$100(ControlFlow$Catcher x0) {
      return x0.node;
   }
}
