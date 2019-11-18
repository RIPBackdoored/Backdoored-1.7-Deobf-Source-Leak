package javassist.bytecode.analysis;

import java.util.ArrayList;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.stackmap.BasicBlock;
import javassist.bytecode.stackmap.BasicBlock$Catch;

public class ControlFlow$Block extends BasicBlock {
   public Object clientData = null;
   int index;
   MethodInfo method;
   ControlFlow$Block[] entrances;

   ControlFlow$Block(int pos, MethodInfo minfo) {
      super(pos);
      this.method = minfo;
   }

   protected void toString2(StringBuffer sbuf) {
      super.toString2(sbuf);
      sbuf.append(", incoming{");

      for(int i = 0; i < this.entrances.length; ++i) {
         sbuf.append(this.entrances[i].position).append(", ");
      }

      sbuf.append("}");
   }

   BasicBlock[] getExit() {
      return this.exit;
   }

   public int index() {
      return this.index;
   }

   public int position() {
      return this.position;
   }

   public int length() {
      return this.length;
   }

   public int incomings() {
      return this.incoming;
   }

   public ControlFlow$Block incoming(int n) {
      return this.entrances[n];
   }

   public int exits() {
      return this.exit == null ? 0 : this.exit.length;
   }

   public ControlFlow$Block exit(int n) {
      return (ControlFlow$Block)this.exit[n];
   }

   public ControlFlow$Catcher[] catchers() {
      ArrayList catchers = new ArrayList();

      for(BasicBlock$Catch c = this.toCatch; c != null; c = c.next) {
         catchers.add(new ControlFlow$Catcher(c));
      }

      return (ControlFlow$Catcher[])((ControlFlow$Catcher[])catchers.toArray(new ControlFlow$Catcher[catchers.size()]));
   }
}
