package javassist.bytecode.analysis;

import javassist.bytecode.stackmap.BasicBlock;

class ControlFlow$2 extends ControlFlow$Access {
   // $FF: synthetic field
   final ControlFlow this$0;

   ControlFlow$2(ControlFlow this$0, ControlFlow$Node[] nodes) {
      super(nodes);
      this.this$0 = this$0;
   }

   BasicBlock[] exits(ControlFlow$Node n) {
      return ControlFlow$Node.access$200(n).getExit();
   }

   BasicBlock[] entrances(ControlFlow$Node n) {
      return ControlFlow$Node.access$200(n).entrances;
   }
}
