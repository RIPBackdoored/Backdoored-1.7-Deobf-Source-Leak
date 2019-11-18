package javassist.expr;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

public class Cast extends Expr {
   protected Cast(int pos, CodeIterator i, CtClass declaring, MethodInfo m) {
      super(pos, i, declaring, m);
   }

   public CtBehavior where() {
      return super.where();
   }

   public int getLineNumber() {
      return super.getLineNumber();
   }

   public String getFileName() {
      return super.getFileName();
   }

   public CtClass getType() throws NotFoundException {
      ConstPool cp = this.getConstPool();
      int pos = this.currentPos;
      int index = this.iterator.u16bitAt(pos + 1);
      String name = cp.getClassInfo(index);
      return this.thisClass.getClassPool().getCtClass(name);
   }

   public CtClass[] mayThrow() {
      return super.mayThrow();
   }

   public void replace(String statement) throws CannotCompileException {
      this.thisClass.getClassFile();
      ConstPool constPool = this.getConstPool();
      int pos = this.currentPos;
      int index = this.iterator.u16bitAt(pos + 1);
      Javac jc = new Javac(this.thisClass);
      ClassPool cp = this.thisClass.getClassPool();
      CodeAttribute ca = this.iterator.get();

      try {
         CtClass[] params = new CtClass[]{cp.get("java.lang.Object")};
         CtClass retType = this.getType();
         int paramVar = ca.getMaxLocals();
         jc.recordParams("java.lang.Object", params, true, paramVar, this.withinStatic());
         int retVar = jc.recordReturnType(retType, true);
         jc.recordProceed(new Cast$ProceedForCast(index, retType));
         checkResultValue(retType, statement);
         Bytecode bytecode = jc.getBytecode();
         storeStack(params, true, paramVar, bytecode);
         jc.recordLocalVariables(ca, pos);
         bytecode.addConstZero(retType);
         bytecode.addStore(retVar, retType);
         jc.compileStmnt(statement);
         bytecode.addLoad(retVar, retType);
         this.replace0(pos, bytecode, 3);
      } catch (CompileError var13) {
         throw new CannotCompileException(var13);
      } catch (NotFoundException var14) {
         throw new CannotCompileException(var14);
      } catch (BadBytecode var15) {
         throw new CannotCompileException("broken method");
      }

   }
}
