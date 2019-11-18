package javassist.compiler;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtPrimitiveType;
import javassist.NotFoundException;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.Symbol;

public class JvstTypeChecker extends TypeChecker {
   private JvstCodeGen codeGen;

   public JvstTypeChecker(CtClass cc, ClassPool cp, JvstCodeGen gen) {
      super(cc, cp);
      this.codeGen = gen;
   }

   public void addNullIfVoid() {
      if (this.exprType == 344) {
         this.exprType = 307;
         this.arrayDim = 0;
         this.className = "java/lang/Object";
      }

   }

   public void atMember(Member mem) throws CompileError {
      String name = mem.get();
      if (name.equals(this.codeGen.paramArrayName)) {
         this.exprType = 307;
         this.arrayDim = 1;
         this.className = "java/lang/Object";
      } else if (name.equals("$sig")) {
         this.exprType = 307;
         this.arrayDim = 1;
         this.className = "java/lang/Class";
      } else if (!name.equals("$type") && !name.equals("$class")) {
         super.atMember(mem);
      } else {
         this.exprType = 307;
         this.arrayDim = 0;
         this.className = "java/lang/Class";
      }

   }

   protected void atFieldAssign(Expr expr, int op, ASTree left, ASTree right) throws CompileError {
      if (left instanceof Member && ((Member)left).get().equals(this.codeGen.paramArrayName)) {
         right.accept(this);
         CtClass[] params = this.codeGen.paramTypeList;
         if (params == null) {
            return;
         }

         int n = params.length;

         for(int i = 0; i < n; ++i) {
            this.compileUnwrapValue(params[i]);
         }
      } else {
         super.atFieldAssign(expr, op, left, right);
      }

   }

   public void atCastExpr(CastExpr expr) throws CompileError {
      ASTList classname = expr.getClassName();
      if (classname != null && expr.getArrayDim() == 0) {
         ASTree p = classname.head();
         if (p instanceof Symbol && classname.tail() == null) {
            String typename = ((Symbol)p).get();
            if (typename.equals(this.codeGen.returnCastName)) {
               this.atCastToRtype(expr);
               return;
            }

            if (typename.equals("$w")) {
               this.atCastToWrapper(expr);
               return;
            }
         }
      }

      super.atCastExpr(expr);
   }

   protected void atCastToRtype(CastExpr expr) throws CompileError {
      CtClass returnType = this.codeGen.returnType;
      expr.getOprand().accept(this);
      if (this.exprType != 344 && !CodeGen.isRefType(this.exprType) && this.arrayDim <= 0) {
         if (returnType instanceof CtPrimitiveType) {
            CtPrimitiveType pt = (CtPrimitiveType)returnType;
            int destType = MemberResolver.descToType(pt.getDescriptor());
            this.exprType = destType;
            this.arrayDim = 0;
            this.className = null;
         }
      } else {
         this.compileUnwrapValue(returnType);
      }

   }

   protected void atCastToWrapper(CastExpr expr) throws CompileError {
      expr.getOprand().accept(this);
      if (!CodeGen.isRefType(this.exprType) && this.arrayDim <= 0) {
         CtClass clazz = this.resolver.lookupClass(this.exprType, this.arrayDim, this.className);
         if (clazz instanceof CtPrimitiveType) {
            this.exprType = 307;
            this.arrayDim = 0;
            this.className = "java/lang/Object";
         }

      }
   }

   public void atCallExpr(CallExpr expr) throws CompileError {
      ASTree method = expr.oprand1();
      if (method instanceof Member) {
         String name = ((Member)method).get();
         if (this.codeGen.procHandler != null && name.equals(this.codeGen.proceedName)) {
            this.codeGen.procHandler.setReturnType(this, (ASTList)expr.oprand2());
            return;
         }

         if (name.equals("$cflow")) {
            this.atCflow((ASTList)expr.oprand2());
            return;
         }
      }

      super.atCallExpr(expr);
   }

   protected void atCflow(ASTList cname) throws CompileError {
      this.exprType = 324;
      this.arrayDim = 0;
      this.className = null;
   }

   public boolean isParamListName(ASTList args) {
      if (this.codeGen.paramTypeList != null && args != null && args.tail() == null) {
         ASTree left = args.head();
         return left instanceof Member && ((Member)left).get().equals(this.codeGen.paramListName);
      } else {
         return false;
      }
   }

   public int getMethodArgsLength(ASTList args) {
      String pname = this.codeGen.paramListName;

      int n;
      for(n = 0; args != null; args = args.tail()) {
         ASTree a = args.head();
         if (a instanceof Member && ((Member)a).get().equals(pname)) {
            if (this.codeGen.paramTypeList != null) {
               n += this.codeGen.paramTypeList.length;
            }
         } else {
            ++n;
         }
      }

      return n;
   }

   public void atMethodArgs(ASTList args, int[] types, int[] dims, String[] cnames) throws CompileError {
      CtClass[] params = this.codeGen.paramTypeList;
      String pname = this.codeGen.paramListName;

      for(int i = 0; args != null; args = args.tail()) {
         ASTree a = args.head();
         if (a instanceof Member && ((Member)a).get().equals(pname)) {
            if (params != null) {
               int n = params.length;

               for(int k = 0; k < n; ++k) {
                  CtClass p = params[k];
                  this.setType(p);
                  types[i] = this.exprType;
                  dims[i] = this.arrayDim;
                  cnames[i] = this.className;
                  ++i;
               }
            }
         } else {
            a.accept(this);
            types[i] = this.exprType;
            dims[i] = this.arrayDim;
            cnames[i] = this.className;
            ++i;
         }
      }

   }

   void compileInvokeSpecial(ASTree target, String classname, String methodname, String descriptor, ASTList args) throws CompileError {
      target.accept(this);
      int nargs = this.getMethodArgsLength(args);
      this.atMethodArgs(args, new int[nargs], new int[nargs], new String[nargs]);
      this.setReturnType(descriptor);
      this.addNullIfVoid();
   }

   protected void compileUnwrapValue(CtClass type) throws CompileError {
      if (type == CtClass.voidType) {
         this.addNullIfVoid();
      } else {
         this.setType(type);
      }

   }

   public void setType(CtClass type) throws CompileError {
      this.setType(type, 0);
   }

   private void setType(CtClass type, int dim) throws CompileError {
      if (type.isPrimitive()) {
         CtPrimitiveType pt = (CtPrimitiveType)type;
         this.exprType = MemberResolver.descToType(pt.getDescriptor());
         this.arrayDim = dim;
         this.className = null;
      } else if (type.isArray()) {
         try {
            this.setType(type.getComponentType(), dim + 1);
         } catch (NotFoundException var4) {
            throw new CompileError("undefined type: " + type.getName());
         }
      } else {
         this.exprType = 307;
         this.arrayDim = dim;
         this.className = MemberResolver.javaToJvmName(type.getName());
      }

   }
}
