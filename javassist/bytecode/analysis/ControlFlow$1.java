package javassist.bytecode.analysis;

import javassist.bytecode.stackmap.BasicBlock;
import javassist.bytecode.stackmap.BasicBlock$Maker;

class ControlFlow$1 extends BasicBlock$Maker {
   // $FF: synthetic field
   final ControlFlow this$0;

   ControlFlow$1(ControlFlow this$0) {
      this.this$0 = this$0;
   }

   protected BasicBlock makeBlock(int pos) {
      return new ControlFlow$Block(pos, ControlFlow.access$000(this.this$0));
   }

   protected BasicBlock[] makeArray(int size) {
      return new ControlFlow$Block[size];
   }
}
