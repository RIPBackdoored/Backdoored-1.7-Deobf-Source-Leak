package javassist.bytecode.analysis;

class Analyzer$ExceptionInfo {
   private int end;
   private int handler;
   private int start;
   private Type type;

   private Analyzer$ExceptionInfo(int start, int end, int handler, Type type) {
      this.start = start;
      this.end = end;
      this.handler = handler;
      this.type = type;
   }

   // $FF: synthetic method
   Analyzer$ExceptionInfo(int x0, int x1, int x2, Type x3, Analyzer$1 x4) {
      this(x0, x1, x2, x3);
   }

   // $FF: synthetic method
   static int access$100(Analyzer$ExceptionInfo x0) {
      return x0.start;
   }

   // $FF: synthetic method
   static int access$200(Analyzer$ExceptionInfo x0) {
      return x0.end;
   }

   // $FF: synthetic method
   static Type access$300(Analyzer$ExceptionInfo x0) {
      return x0.type;
   }

   // $FF: synthetic method
   static int access$400(Analyzer$ExceptionInfo x0) {
      return x0.handler;
   }
}
