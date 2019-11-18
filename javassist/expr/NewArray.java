package javassist.expr;

import javassist.CannotCompileException;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtPrimitiveType;
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

public class NewArray extends Expr {
   int opcode;

   protected NewArray(int pos, CodeIterator i, CtClass declaring, MethodInfo m, int op) {
      super(pos, i, declaring, m);
      this.opcode = op;
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

   public CtClass[] mayThrow() {
      return super.mayThrow();
   }

   public CtClass getComponentType() throws NotFoundException {
      int index;
      if (this.opcode == 188) {
         index = this.iterator.byteAt(this.currentPos + 1);
         return this.getPrimitiveType(index);
      } else if (this.opcode != 189 && this.opcode != 197) {
         throw new RuntimeException("bad opcode: " + this.opcode);
      } else {
         index = this.iterator.u16bitAt(this.currentPos + 1);
         String desc = this.getConstPool().getClassInfo(index);
         int dim = Descriptor.arrayDimension(desc);
         desc = Descriptor.toArrayComponent(desc, dim);
         return Descriptor.toCtClass(desc, this.thisClass.getClassPool());
      }
   }

   CtClass getPrimitiveType(int atype) {
      switch(atype) {
      case 4:
         return CtClass.booleanType;
      case 5:
         return CtClass.charType;
      case 6:
         return CtClass.floatType;
      case 7:
         return CtClass.doubleType;
      case 8:
         return CtClass.byteType;
      case 9:
         return CtClass.shortType;
      case 10:
         return CtClass.intType;
      case 11:
         return CtClass.longType;
      default:
         throw new RuntimeException("bad atype: " + atype);
      }
   }

   public int getDimension() {
      if (this.opcode == 188) {
         return 1;
      } else if (this.opcode != 189 && this.opcode != 197) {
         throw new RuntimeException("bad opcode: " + this.opcode);
      } else {
         int index = this.iterator.u16bitAt(this.currentPos + 1);
         String desc = this.getConstPool().getClassInfo(index);
         return Descriptor.arrayDimension(desc) + (this.opcode == 189 ? 1 : 0);
      }
   }

   public int getCreatedDimensions() {
      return this.opcode == 197 ? this.iterator.byteAt(this.currentPos + 3) : 1;
   }

   public void replace(String statement) throws CannotCompileException {
      try {
         this.replace2(statement);
      } catch (CompileError var3) {
         throw new CannotCompileException(var3);
      } catch (NotFoundException var4) {
         throw new CannotCompileException(var4);
      } catch (BadBytecode var5) {
         throw new CannotCompileException("broken method");
      }

   }

   private void replace2(String statement) throws CompileError, NotFoundException, BadBytecode, CannotCompileException {
      this.thisClass.getClassFile();
      ConstPool constPool = this.getConstPool();
      int pos = this.currentPos;
      int index = false;
      int dim = 1;
      byte codeLength;
      String desc;
      int index;
      if (this.opcode == 188) {
         index = this.iterator.byteAt(this.currentPos + 1);
         CtPrimitiveType cpt = (CtPrimitiveType)this.getPrimitiveType(index);
         desc = "[" + cpt.getDescriptor();
         codeLength = 2;
      } else if (this.opcode == 189) {
         index = this.iterator.u16bitAt(pos + 1);
         desc = constPool.getClassInfo(index);
         if (desc.startsWith("[")) {
            desc = "[" + desc;
         } else {
            desc = "[L" + desc + ";";
         }

         codeLength = 3;
      } else {
         if (this.opcode != 197) {
            throw new RuntimeException("bad opcode: " + this.opcode);
         }

         index = this.iterator.u16bitAt(this.currentPos + 1);
         desc = constPool.getClassInfo(index);
         dim = this.iterator.byteAt(this.currentPos + 3);
         codeLength = 4;
      }

      CtClass retType = Descriptor.toCtClass(desc, this.thisClass.getClassPool());
      Javac jc = new Javac(this.thisClass);
      CodeAttribute ca = this.iterator.get();
      CtClass[] params = new CtClass[dim];

      int paramVar;
      for(paramVar = 0; paramVar < dim; ++paramVar) {
         params[paramVar] = CtClass.intType;
      }

      paramVar = ca.getMaxLocals();
      jc.recordParams("java.lang.Object", params, true, paramVar, this.withinStatic());
      checkResultValue(retType, statement);
      int retVar = jc.recordReturnType(retType, true);
      jc.recordProceed(new NewArray$ProceedForArray(retType, this.opcode, index, dim));
      Bytecode bytecode = jc.getBytecode();
      storeStack(params, true, paramVar, bytecode);
      jc.recordLocalVariables(ca, pos);
      bytecode.addOpcode(1);
      bytecode.addAstore(retVar);
      jc.compileStmnt(statement);
      bytecode.addAload(retVar);
      this.replace0(pos, bytecode, codeLength);
   }
}
