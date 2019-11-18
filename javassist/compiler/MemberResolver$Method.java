package javassist.compiler;

import javassist.CtClass;
import javassist.bytecode.MethodInfo;

public class MemberResolver$Method {
   public CtClass declaring;
   public MethodInfo info;
   public int notmatch;

   public MemberResolver$Method(CtClass c, MethodInfo i, int n) {
      this.declaring = c;
      this.info = i;
      this.notmatch = n;
   }

   public boolean isStatic() {
      int acc = this.info.getAccessFlags();
      return (acc & 8) != 0;
   }
}
