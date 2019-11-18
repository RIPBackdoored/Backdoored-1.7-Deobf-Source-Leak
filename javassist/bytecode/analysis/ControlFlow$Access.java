package javassist.bytecode.analysis;

import javassist.bytecode.stackmap.BasicBlock;

abstract class ControlFlow$Access {
   ControlFlow$Node[] all;

   ControlFlow$Access(ControlFlow$Node[] nodes) {
      this.all = nodes;
   }

   ControlFlow$Node node(BasicBlock b) {
      return this.all[((ControlFlow$Block)b).index];
   }

   abstract BasicBlock[] exits(ControlFlow$Node var1);

   abstract BasicBlock[] entrances(ControlFlow$Node var1);
}
