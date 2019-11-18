package javassist.expr;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

public class NewExpr extends Expr {
   String newTypeName;
   int newPos;

   protected NewExpr(int pos, CodeIterator i, CtClass declaring, MethodInfo m, String type, int np) {
      super(pos, i, declaring, m);
      this.newTypeName = type;
      this.newPos = np;
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

   private CtClass getCtClass() throws NotFoundException {
      return this.thisClass.getClassPool().get(this.newTypeName);
   }

   public String getClassName() {
      return this.newTypeName;
   }

   public String getSignature() {
      ConstPool constPool = this.getConstPool();
      int methodIndex = this.iterator.u16bitAt(this.currentPos + 1);
      return constPool.getMethodrefType(methodIndex);
   }

   public CtConstructor getConstructor() throws NotFoundException {
      ConstPool cp = this.getConstPool();
      int index = this.iterator.u16bitAt(this.currentPos + 1);
      String desc = cp.getMethodrefType(index);
      return this.getCtClass().getConstructor(desc);
   }

   public CtClass[] mayThrow() {
      return super.mayThrow();
   }

   private int canReplace() throws CannotCompileException {
      int op = this.iterator.byteAt(this.newPos + 3);
      if (op != 89) {
         return op == 90 && this.iterator.byteAt(this.newPos + 4) == 95 ? 5 : 3;
      } else {
         return this.iterator.byteAt(this.newPos + 4) == 94 && this.iterator.byteAt(this.newPos + 5) == 88 ? 6 : 4;
      }
   }

   public void replace(String statement) throws CannotCompileException {
      this.thisClass.getClassFile();
      int bytecodeSize = true;
      int pos = this.newPos;
      int newIndex = this.iterator.u16bitAt(pos + 1);
      int codeSize = this.canReplace();
      int end = pos + codeSize;

      for(int i = pos; i < end; ++i) {
         this.iterator.writeByte(0, i);
      }

      ConstPool constPool = this.getConstPool();
      pos = this.currentPos;
      int methodIndex = this.iterator.u16bitAt(pos + 1);
      String signature = constPool.getMethodrefType(methodIndex);
      Javac jc = new Javac(this.thisClass);
      ClassPool cp = this.thisClass.getClassPool();
      CodeAttribute ca = this.iterator.get();

      try {
         CtClass[] params = Descriptor.getParameterTypes(signature, cp);
         CtClass newType = cp.get(this.newTypeName);
         int paramVar = ca.getMaxLocals();
         jc.recordParams(this.newTypeName, params, true, paramVar, this.withinStatic());
         int retVar = jc.recordReturnType(newType, true);
         jc.recordProceed(new NewExpr$ProceedForNew(newType, newIndex, methodIndex));
         checkResultValue(newType, statement);
         Bytecode bytecode = jc.getBytecode();
         storeStack(params, true, paramVar, bytecode);
         jc.recordLocalVariables(ca, pos);
         bytecode.addConstZero(newType);
         bytecode.addStore(retVar, newType);
         jc.compileStmnt(statement);
         if (codeSize > 3) {
            bytecode.addAload(retVar);
         }

         this.replace0(pos, bytecode, 3);
      } catch (CompileError var18) {
         throw new CannotCompileException(var18);
      } catch (NotFoundException var19) {
         throw new CannotCompileException(var19);
      } catch (BadBytecode var20) {
         throw new CannotCompileException("broken method");
      }

   }
}
