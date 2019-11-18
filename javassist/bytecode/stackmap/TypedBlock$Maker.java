package javassist.bytecode.stackmap;

public class TypedBlock$Maker extends BasicBlock$Maker {
   protected BasicBlock makeBlock(int pos) {
      return new TypedBlock(pos);
   }

   protected BasicBlock[] makeArray(int size) {
      return new TypedBlock[size];
   }
}
