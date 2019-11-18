package org.reflections.scanners;

import com.google.common.base.Joiner;
import javassist.CannotCompileException;
import javassist.ClassPath;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.LoaderClassPath;
import javassist.bytecode.MethodInfo;
import javassist.expr.ExprEditor;
import org.reflections.ReflectionsException;
import org.reflections.util.ClasspathHelper;

public class MemberUsageScanner extends AbstractScanner {
   private ClassPool classPool;

   public void scan(Object cls) {
      try {
         CtClass ctClass = this.getClassPool().get(this.getMetadataAdapter().getClassName(cls));
         CtConstructor[] var3 = ctClass.getDeclaredConstructors();
         int var4 = var3.length;

         int var5;
         for(var5 = 0; var5 < var4; ++var5) {
            CtBehavior member = var3[var5];
            this.scanMember(member);
         }

         CtMethod[] var8 = ctClass.getDeclaredMethods();
         var4 = var8.length;

         for(var5 = 0; var5 < var4; ++var5) {
            CtBehavior member = var8[var5];
            this.scanMember(member);
         }

         ctClass.detach();
      } catch (Exception var7) {
         throw new ReflectionsException("Could not scan method usage for " + this.getMetadataAdapter().getClassName(cls), var7);
      }
   }

   void scanMember(CtBehavior member) throws CannotCompileException {
      String key = member.getDeclaringClass().getName() + "." + member.getMethodInfo().getName() + "(" + this.parameterNames(member.getMethodInfo()) + ")";
      member.instrument((ExprEditor)(new MemberUsageScanner$1(this, key)));
   }

   private void put(String key, int lineNumber, String value) {
      if (this.acceptResult(key)) {
         this.getStore().put(key, value + " #" + lineNumber);
      }

   }

   String parameterNames(MethodInfo info) {
      return Joiner.on(", ").join(this.getMetadataAdapter().getParameterNames(info));
   }

   private ClassPool getClassPool() {
      if (this.classPool == null) {
         synchronized(this) {
            this.classPool = new ClassPool();
            ClassLoader[] classLoaders = this.getConfiguration().getClassLoaders();
            if (classLoaders == null) {
               classLoaders = ClasspathHelper.classLoaders();
            }

            ClassLoader[] var3 = classLoaders;
            int var4 = classLoaders.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               ClassLoader classLoader = var3[var5];
               this.classPool.appendClassPath((ClassPath)(new LoaderClassPath(classLoader)));
            }
         }
      }

      return this.classPool;
   }

   // $FF: synthetic method
   static void access$000(MemberUsageScanner x0, String x1, int x2, String x3) {
      x0.put(x1, x2, x3);
   }
}
