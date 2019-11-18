package org.reflections.scanners;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import javassist.expr.ConstructorCall;
import javassist.expr.ExprEditor;
import javassist.expr.FieldAccess;
import javassist.expr.MethodCall;
import javassist.expr.NewExpr;
import org.reflections.ReflectionsException;

class MemberUsageScanner$1 extends ExprEditor {
   // $FF: synthetic field
   final String val$key;
   // $FF: synthetic field
   final MemberUsageScanner this$0;

   MemberUsageScanner$1(MemberUsageScanner this$0, String var2) {
      this.this$0 = this$0;
      this.val$key = var2;
   }

   public void edit(NewExpr e) throws CannotCompileException {
      try {
         MemberUsageScanner.access$000(this.this$0, e.getConstructor().getDeclaringClass().getName() + ".<init>(" + this.this$0.parameterNames(e.getConstructor().getMethodInfo()) + ")", e.getLineNumber(), this.val$key);
      } catch (NotFoundException var3) {
         throw new ReflectionsException("Could not find new instance usage in " + this.val$key, var3);
      }

   }

   public void edit(MethodCall m) throws CannotCompileException {
      try {
         MemberUsageScanner.access$000(this.this$0, m.getMethod().getDeclaringClass().getName() + "." + m.getMethodName() + "(" + this.this$0.parameterNames(m.getMethod().getMethodInfo()) + ")", m.getLineNumber(), this.val$key);
      } catch (NotFoundException var3) {
         throw new ReflectionsException("Could not find member " + m.getClassName() + " in " + this.val$key, var3);
      }

   }

   public void edit(ConstructorCall c) throws CannotCompileException {
      try {
         MemberUsageScanner.access$000(this.this$0, c.getConstructor().getDeclaringClass().getName() + ".<init>(" + this.this$0.parameterNames(c.getConstructor().getMethodInfo()) + ")", c.getLineNumber(), this.val$key);
      } catch (NotFoundException var3) {
         throw new ReflectionsException("Could not find member " + c.getClassName() + " in " + this.val$key, var3);
      }

   }

   public void edit(FieldAccess f) throws CannotCompileException {
      try {
         MemberUsageScanner.access$000(this.this$0, f.getField().getDeclaringClass().getName() + "." + f.getFieldName(), f.getLineNumber(), this.val$key);
      } catch (NotFoundException var3) {
         throw new ReflectionsException("Could not find member " + f.getFieldName() + " in " + this.val$key, var3);
      }

   }
}
