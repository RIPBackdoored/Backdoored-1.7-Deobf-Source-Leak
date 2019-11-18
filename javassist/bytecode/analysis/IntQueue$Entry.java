package javassist.bytecode.analysis;

class IntQueue$Entry {
   private IntQueue$Entry next;
   private int value;

   private IntQueue$Entry(int value) {
      this.value = value;
   }

   // $FF: synthetic method
   IntQueue$Entry(int x0, IntQueue$1 x1) {
      this(x0);
   }

   // $FF: synthetic method
   static IntQueue$Entry access$102(IntQueue$Entry x0, IntQueue$Entry x1) {
      return x0.next = x1;
   }

   // $FF: synthetic method
   static int access$200(IntQueue$Entry x0) {
      return x0.value;
   }

   // $FF: synthetic method
   static IntQueue$Entry access$100(IntQueue$Entry x0) {
      return x0.next;
   }
}
