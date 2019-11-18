package javassist;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;

public final class CtMethod extends CtBehavior {
   protected String cachedStringRep;

   CtMethod(MethodInfo minfo, CtClass declaring) {
      super(declaring, minfo);
      this.cachedStringRep = null;
   }

   public CtMethod(CtClass returnType, String mname, CtClass[] parameters, CtClass declaring) {
      this((MethodInfo)null, declaring);
      ConstPool cp = declaring.getClassFile2().getConstPool();
      String desc = Descriptor.ofMethod(returnType, parameters);
      this.methodInfo = new MethodInfo(cp, mname, desc);
      this.setModifiers(1025);
   }

   public CtMethod(CtMethod src, CtClass declaring, ClassMap map) throws CannotCompileException {
      this((MethodInfo)null, declaring);
      this.copy(src, false, map);
   }

   public static CtMethod make(String src, CtClass declaring) throws CannotCompileException {
      return CtNewMethod.make(src, declaring);
   }

   public static CtMethod make(MethodInfo minfo, CtClass declaring) throws CannotCompileException {
      if (declaring.getClassFile2().getConstPool() != minfo.getConstPool()) {
         throw new CannotCompileException("bad declaring class");
      } else {
         return new CtMethod(minfo, declaring);
      }
   }

   public int hashCode() {
      return this.getStringRep().hashCode();
   }

   void nameReplaced() {
      this.cachedStringRep = null;
   }

   final String getStringRep() {
      if (this.cachedStringRep == null) {
         this.cachedStringRep = this.methodInfo.getName() + Descriptor.getParamDescriptor(this.methodInfo.getDescriptor());
      }

      return this.cachedStringRep;
   }

   public boolean equals(Object obj) {
      return obj != null && obj instanceof CtMethod && ((CtMethod)obj).getStringRep().equals(this.getStringRep());
   }

   public String getLongName() {
      return this.getDeclaringClass().getName() + "." + this.getName() + Descriptor.toString(this.getSignature());
   }

   public String getName() {
      return this.methodInfo.getName();
   }

   public void setName(String newname) {
      this.declaringClass.checkModify();
      this.methodInfo.setName(newname);
   }

   public CtClass getReturnType() throws NotFoundException {
      return this.getReturnType0();
   }

   public boolean isEmpty() {
      CodeAttribute ca = this.getMethodInfo2().getCodeAttribute();
      if (ca == null) {
         return (this.getModifiers() & 1024) != 0;
      } else {
         CodeIterator it = ca.iterator();

         boolean var10000;
         try {
            var10000 = it.hasNext() && it.byteAt(it.next()) == 177 && !it.hasNext();
         } catch (BadBytecode var4) {
            return false;
         }

         return var10000;
      }
   }

   public void setBody(CtMethod src, ClassMap map) throws CannotCompileException {
      setBody0(src.declaringClass, src.methodInfo, this.declaringClass, this.methodInfo, map);
   }

   public void setWrappedBody(CtMethod mbody, CtMethod$ConstParameter constParam) throws CannotCompileException {
      this.declaringClass.checkModify();
      CtClass clazz = this.getDeclaringClass();

      CtClass[] params;
      CtClass retType;
      try {
         params = this.getParameterTypes();
         retType = this.getReturnType();
      } catch (NotFoundException var8) {
         throw new CannotCompileException(var8);
      }

      Bytecode code = CtNewWrappedMethod.makeBody(clazz, clazz.getClassFile2(), mbody, params, retType, constParam);
      CodeAttribute cattr = code.toCodeAttribute();
      this.methodInfo.setCodeAttribute(cattr);
      this.methodInfo.setAccessFlags(this.methodInfo.getAccessFlags() & -1025);
   }
}
