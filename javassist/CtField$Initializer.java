package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ConstPool;
import javassist.compiler.Javac;
import javassist.compiler.ast.ASTree;

public abstract class CtField$Initializer {
   public static CtField$Initializer constant(int i) {
      return new CtField$IntInitializer(i);
   }

   public static CtField$Initializer constant(boolean b) {
      return new CtField$IntInitializer(b ? 1 : 0);
   }

   public static CtField$Initializer constant(long l) {
      return new CtField$LongInitializer(l);
   }

   public static CtField$Initializer constant(float l) {
      return new CtField$FloatInitializer(l);
   }

   public static CtField$Initializer constant(double d) {
      return new CtField$DoubleInitializer(d);
   }

   public static CtField$Initializer constant(String s) {
      return new CtField$StringInitializer(s);
   }

   public static CtField$Initializer byParameter(int nth) {
      CtField$ParamInitializer i = new CtField$ParamInitializer();
      i.nthParam = nth;
      return i;
   }

   public static CtField$Initializer byNew(CtClass objectType) {
      CtField$NewInitializer i = new CtField$NewInitializer();
      i.objectType = objectType;
      i.stringParams = null;
      i.withConstructorParams = false;
      return i;
   }

   public static CtField$Initializer byNew(CtClass objectType, String[] stringParams) {
      CtField$NewInitializer i = new CtField$NewInitializer();
      i.objectType = objectType;
      i.stringParams = stringParams;
      i.withConstructorParams = false;
      return i;
   }

   public static CtField$Initializer byNewWithParams(CtClass objectType) {
      CtField$NewInitializer i = new CtField$NewInitializer();
      i.objectType = objectType;
      i.stringParams = null;
      i.withConstructorParams = true;
      return i;
   }

   public static CtField$Initializer byNewWithParams(CtClass objectType, String[] stringParams) {
      CtField$NewInitializer i = new CtField$NewInitializer();
      i.objectType = objectType;
      i.stringParams = stringParams;
      i.withConstructorParams = true;
      return i;
   }

   public static CtField$Initializer byCall(CtClass methodClass, String methodName) {
      CtField$MethodInitializer i = new CtField$MethodInitializer();
      i.objectType = methodClass;
      i.methodName = methodName;
      i.stringParams = null;
      i.withConstructorParams = false;
      return i;
   }

   public static CtField$Initializer byCall(CtClass methodClass, String methodName, String[] stringParams) {
      CtField$MethodInitializer i = new CtField$MethodInitializer();
      i.objectType = methodClass;
      i.methodName = methodName;
      i.stringParams = stringParams;
      i.withConstructorParams = false;
      return i;
   }

   public static CtField$Initializer byCallWithParams(CtClass methodClass, String methodName) {
      CtField$MethodInitializer i = new CtField$MethodInitializer();
      i.objectType = methodClass;
      i.methodName = methodName;
      i.stringParams = null;
      i.withConstructorParams = true;
      return i;
   }

   public static CtField$Initializer byCallWithParams(CtClass methodClass, String methodName, String[] stringParams) {
      CtField$MethodInitializer i = new CtField$MethodInitializer();
      i.objectType = methodClass;
      i.methodName = methodName;
      i.stringParams = stringParams;
      i.withConstructorParams = true;
      return i;
   }

   public static CtField$Initializer byNewArray(CtClass type, int size) throws NotFoundException {
      return new CtField$ArrayInitializer(type.getComponentType(), size);
   }

   public static CtField$Initializer byNewArray(CtClass type, int[] sizes) {
      return new CtField$MultiArrayInitializer(type, sizes);
   }

   public static CtField$Initializer byExpr(String source) {
      return new CtField$CodeInitializer(source);
   }

   static CtField$Initializer byExpr(ASTree source) {
      return new CtField$PtreeInitializer(source);
   }

   void check(String desc) throws CannotCompileException {
   }

   abstract int compile(CtClass var1, String var2, Bytecode var3, CtClass[] var4, Javac var5) throws CannotCompileException;

   abstract int compileIfStatic(CtClass var1, String var2, Bytecode var3, Javac var4) throws CannotCompileException;

   int getConstantValue(ConstPool cp, CtClass type) {
      return 0;
   }
}
