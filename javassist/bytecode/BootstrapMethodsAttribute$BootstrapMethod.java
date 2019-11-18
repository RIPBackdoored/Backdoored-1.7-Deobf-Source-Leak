package javassist.bytecode;

public class BootstrapMethodsAttribute$BootstrapMethod {
   public int methodRef;
   public int[] arguments;

   public BootstrapMethodsAttribute$BootstrapMethod(int method, int[] args) {
      this.methodRef = method;
      this.arguments = args;
   }
}
