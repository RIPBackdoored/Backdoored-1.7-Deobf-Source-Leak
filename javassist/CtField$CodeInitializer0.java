package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.DoubleConst;
import javassist.compiler.ast.IntConst;
import javassist.compiler.ast.StringL;

abstract class CtField$CodeInitializer0 extends CtField$Initializer {
   abstract void compileExpr(Javac var1) throws CompileError;

   int compile(CtClass type, String name, Bytecode code, CtClass[] parameters, Javac drv) throws CannotCompileException {
      int var10000;
      try {
         code.addAload(0);
         this.compileExpr(drv);
         code.addPutfield(Bytecode.THIS, name, Descriptor.of(type));
         var10000 = code.getMaxStack();
      } catch (CompileError var7) {
         throw new CannotCompileException(var7);
      }

      return var10000;
   }

   int compileIfStatic(CtClass type, String name, Bytecode code, Javac drv) throws CannotCompileException {
      int var10000;
      try {
         this.compileExpr(drv);
         code.addPutstatic(Bytecode.THIS, name, Descriptor.of(type));
         var10000 = code.getMaxStack();
      } catch (CompileError var6) {
         throw new CannotCompileException(var6);
      }

      return var10000;
   }

   int getConstantValue2(ConstPool cp, CtClass type, ASTree tree) {
      if (type.isPrimitive()) {
         if (tree instanceof IntConst) {
            long value = ((IntConst)tree).get();
            if (type == CtClass.doubleType) {
               return cp.addDoubleInfo((double)value);
            }

            if (type == CtClass.floatType) {
               return cp.addFloatInfo((float)value);
            }

            if (type == CtClass.longType) {
               return cp.addLongInfo(value);
            }

            if (type != CtClass.voidType) {
               return cp.addIntegerInfo((int)value);
            }
         } else if (tree instanceof DoubleConst) {
            double value = ((DoubleConst)tree).get();
            if (type == CtClass.floatType) {
               return cp.addFloatInfo((float)value);
            }

            if (type == CtClass.doubleType) {
               return cp.addDoubleInfo(value);
            }
         }
      } else if (tree instanceof StringL && type.getName().equals("java.lang.String")) {
         return cp.addStringInfo(((StringL)tree).get());
      }

      return 0;
   }
}
