package javassist.runtime;

public class Cflow extends ThreadLocal {
   protected synchronized Object initialValue() {
      return new Cflow$Depth();
   }

   public void enter() {
      ((Cflow$Depth)this.get()).inc();
   }

   public void exit() {
      ((Cflow$Depth)this.get()).dec();
   }

   public int value() {
      return ((Cflow$Depth)this.get()).get();
   }
}
