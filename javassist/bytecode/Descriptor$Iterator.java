package javassist.bytecode;

public class Descriptor$Iterator {
   private String desc;
   private int index;
   private int curPos;
   private boolean param;

   public Descriptor$Iterator(String s) {
      this.desc = s;
      this.index = this.curPos = 0;
      this.param = false;
   }

   public boolean hasNext() {
      return this.index < this.desc.length();
   }

   public boolean isParameter() {
      return this.param;
   }

   public char currentChar() {
      return this.desc.charAt(this.curPos);
   }

   public boolean is2byte() {
      char c = this.currentChar();
      return c == 'D' || c == 'J';
   }

   public int next() {
      int nextPos = this.index;
      char c = this.desc.charAt(nextPos);
      if (c == '(') {
         ++this.index;
         ++nextPos;
         c = this.desc.charAt(nextPos);
         this.param = true;
      }

      if (c == ')') {
         ++this.index;
         ++nextPos;
         c = this.desc.charAt(nextPos);
         this.param = false;
      }

      while(c == '[') {
         ++nextPos;
         c = this.desc.charAt(nextPos);
      }

      if (c == 'L') {
         nextPos = this.desc.indexOf(59, nextPos) + 1;
         if (nextPos <= 0) {
            throw new IndexOutOfBoundsException("bad descriptor");
         }
      } else {
         ++nextPos;
      }

      this.curPos = this.index;
      this.index = nextPos;
      return this.curPos;
   }
}
