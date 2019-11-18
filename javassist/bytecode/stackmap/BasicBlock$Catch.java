package javassist.bytecode.stackmap;

public class BasicBlock$Catch {
   public BasicBlock$Catch next;
   public BasicBlock body;
   public int typeIndex;

   BasicBlock$Catch(BasicBlock b, int i, BasicBlock$Catch c) {
      this.body = b;
      this.typeIndex = i;
      this.next = c;
   }
}
