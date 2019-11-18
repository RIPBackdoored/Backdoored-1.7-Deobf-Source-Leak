package javassist.compiler;

import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.ClassFile;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Symbol;

public class MemberResolver implements TokenId {
   private ClassPool classPool;
   private static final int YES = 0;
   private static final int NO = -1;
   private static final String INVALID = "<invalid>";
   private static WeakHashMap invalidNamesMap = new WeakHashMap();
   private Hashtable invalidNames = null;

   public MemberResolver(ClassPool cp) {
      this.classPool = cp;
   }

   public ClassPool getClassPool() {
      return this.classPool;
   }

   private static void fatal() throws CompileError {
      throw new CompileError("fatal");
   }

   public MemberResolver$Method lookupMethod(CtClass clazz, CtClass currentClass, MethodInfo current, String methodName, int[] argTypes, int[] argDims, String[] argClassNames) throws CompileError {
      MemberResolver$Method maybe = null;
      if (current != null && clazz == currentClass && current.getName().equals(methodName)) {
         int res = this.compareSignature(current.getDescriptor(), argTypes, argDims, argClassNames);
         if (res != -1) {
            MemberResolver$Method r = new MemberResolver$Method(clazz, current, res);
            if (res == 0) {
               return r;
            }

            maybe = r;
         }
      }

      MemberResolver$Method m = this.lookupMethod(clazz, methodName, argTypes, argDims, argClassNames, maybe != null);
      return m != null ? m : maybe;
   }

   private MemberResolver$Method lookupMethod(CtClass clazz, String methodName, int[] argTypes, int[] argDims, String[] argClassNames, boolean onlyExact) throws CompileError {
      MemberResolver$Method maybe = null;
      ClassFile cf = clazz.getClassFile2();
      int i;
      MemberResolver$Method r;
      if (cf != null) {
         List list = cf.getMethods();
         int n = list.size();

         for(int i = 0; i < n; ++i) {
            MethodInfo minfo = (MethodInfo)list.get(i);
            if (minfo.getName().equals(methodName) && (minfo.getAccessFlags() & 64) == 0) {
               i = this.compareSignature(minfo.getDescriptor(), argTypes, argDims, argClassNames);
               if (i != -1) {
                  r = new MemberResolver$Method(clazz, minfo, i);
                  if (i == 0) {
                     return r;
                  }

                  if (maybe == null || maybe.notmatch > i) {
                     maybe = r;
                  }
               }
            }
         }
      }

      if (onlyExact) {
         maybe = null;
      } else if (maybe != null) {
         return maybe;
      }

      int mod = clazz.getModifiers();
      boolean isIntf = Modifier.isInterface(mod);

      MemberResolver$Method var10000;
      label77: {
         try {
            if (isIntf) {
               break label77;
            }

            CtClass pclazz = clazz.getSuperclass();
            if (pclazz == null) {
               break label77;
            }

            MemberResolver$Method r = this.lookupMethod(pclazz, methodName, argTypes, argDims, argClassNames, onlyExact);
            if (r == null) {
               break label77;
            }

            var10000 = r;
         } catch (NotFoundException var16) {
            break label77;
         }

         return var10000;
      }

      try {
         CtClass[] ifs = clazz.getInterfaces();
         int size = ifs.length;

         for(i = 0; i < size; ++i) {
            r = this.lookupMethod(ifs[i], methodName, argTypes, argDims, argClassNames, onlyExact);
            if (r != null) {
               var10000 = r;
               return var10000;
            }
         }

         if (isIntf) {
            CtClass pclazz = clazz.getSuperclass();
            if (pclazz != null) {
               r = this.lookupMethod(pclazz, methodName, argTypes, argDims, argClassNames, onlyExact);
               if (r != null) {
                  var10000 = r;
                  return var10000;
               }

               return maybe;
            }
         }

         return maybe;
      } catch (NotFoundException var15) {
         return maybe;
      }
   }

   private int compareSignature(String desc, int[] argTypes, int[] argDims, String[] argClassNames) throws CompileError {
      int result = 0;
      int i = 1;
      int nArgs = argTypes.length;
      if (nArgs != Descriptor.numOfParameters(desc)) {
         return -1;
      } else {
         int len = desc.length();

         for(int n = 0; i < len; ++n) {
            char c = desc.charAt(i++);
            if (c == ')') {
               return n == nArgs ? result : -1;
            }

            if (n >= nArgs) {
               return -1;
            }

            int dim;
            for(dim = 0; c == '['; c = desc.charAt(i++)) {
               ++dim;
            }

            if (argTypes[n] == 412) {
               if (dim == 0 && c != 'L') {
                  return -1;
               }

               if (c == 'L') {
                  i = desc.indexOf(59, i) + 1;
               }
            } else if (argDims[n] != dim) {
               if (dim != 0 || c != 'L' || !desc.startsWith("java/lang/Object;", i)) {
                  return -1;
               }

               i = desc.indexOf(59, i) + 1;
               ++result;
               if (i <= 0) {
                  return -1;
               }
            } else {
               int j;
               if (c == 'L') {
                  j = desc.indexOf(59, i);
                  if (j < 0 || argTypes[n] != 307) {
                     return -1;
                  }

                  String cname = desc.substring(i, j);
                  if (!cname.equals(argClassNames[n])) {
                     CtClass clazz = this.lookupClassByJvmName(argClassNames[n]);

                     try {
                        if (!clazz.subtypeOf(this.lookupClassByJvmName(cname))) {
                           byte var10000 = -1;
                           return var10000;
                        }

                        ++result;
                     } catch (NotFoundException var16) {
                        ++result;
                     }
                  }

                  i = j + 1;
               } else {
                  j = descToType(c);
                  int at = argTypes[n];
                  if (j != at) {
                     if (j != 324 || at != 334 && at != 303 && at != 306) {
                        return -1;
                     }

                     ++result;
                  }
               }
            }
         }

         return -1;
      }
   }

   public CtField lookupFieldByJvmName2(String jvmClassName, Symbol fieldSym, ASTree expr) throws NoFieldException {
      String field = fieldSym.get();
      CtClass cc = null;

      try {
         cc = this.lookupClass(jvmToJavaName(jvmClassName), true);
      } catch (CompileError var8) {
         throw new NoFieldException(jvmClassName + "/" + field, expr);
      }

      CtField var10000;
      try {
         var10000 = cc.getField(field);
      } catch (NotFoundException var7) {
         jvmClassName = javaToJvmName(cc.getName());
         throw new NoFieldException(jvmClassName + "$" + field, expr);
      }

      return var10000;
   }

   public CtField lookupFieldByJvmName(String jvmClassName, Symbol fieldName) throws CompileError {
      return this.lookupField(jvmToJavaName(jvmClassName), fieldName);
   }

   public CtField lookupField(String className, Symbol fieldName) throws CompileError {
      CtClass cc = this.lookupClass(className, false);

      CtField var10000;
      try {
         var10000 = cc.getField(fieldName.get());
      } catch (NotFoundException var5) {
         throw new CompileError("no such field: " + fieldName.get());
      }

      return var10000;
   }

   public CtClass lookupClassByName(ASTList name) throws CompileError {
      return this.lookupClass(Declarator.astToClassName(name, '.'), false);
   }

   public CtClass lookupClassByJvmName(String jvmName) throws CompileError {
      return this.lookupClass(jvmToJavaName(jvmName), false);
   }

   public CtClass lookupClass(Declarator decl) throws CompileError {
      return this.lookupClass(decl.getType(), decl.getArrayDim(), decl.getClassName());
   }

   public CtClass lookupClass(int type, int dim, String classname) throws CompileError {
      String cname = "";
      if (type == 307) {
         CtClass clazz = this.lookupClassByJvmName(classname);
         if (dim <= 0) {
            return clazz;
         }

         cname = clazz.getName();
      } else {
         cname = getTypeName(type);
      }

      while(dim-- > 0) {
         cname = cname + "[]";
      }

      return this.lookupClass(cname, false);
   }

   static String getTypeName(int type) throws CompileError {
      String cname = "";
      switch(type) {
      case 301:
         cname = "boolean";
         break;
      case 303:
         cname = "byte";
         break;
      case 306:
         cname = "char";
         break;
      case 312:
         cname = "double";
         break;
      case 317:
         cname = "float";
         break;
      case 324:
         cname = "int";
         break;
      case 326:
         cname = "long";
         break;
      case 334:
         cname = "short";
         break;
      case 344:
         cname = "void";
         break;
      default:
         fatal();
      }

      return cname;
   }

   public CtClass lookupClass(String name, boolean notCheckInner) throws CompileError {
      Hashtable cache = this.getInvalidNames();
      Object found = cache.get(name);
      if (found == "<invalid>") {
         throw new CompileError("no such class: " + name);
      } else {
         if (found != null) {
            label25: {
               CtClass var10000;
               try {
                  var10000 = this.classPool.get((String)found);
               } catch (NotFoundException var8) {
                  break label25;
               }

               return var10000;
            }
         }

         CtClass cc = null;

         try {
            cc = this.lookupClass0(name, notCheckInner);
         } catch (NotFoundException var7) {
            cc = this.searchImports(name);
         }

         cache.put(name, cc.getName());
         return cc;
      }
   }

   public static int getInvalidMapSize() {
      return invalidNamesMap.size();
   }

   private Hashtable getInvalidNames() {
      Hashtable ht = this.invalidNames;
      if (ht == null) {
         Class var2 = MemberResolver.class;
         synchronized(MemberResolver.class) {
            WeakReference ref = (WeakReference)invalidNamesMap.get(this.classPool);
            if (ref != null) {
               ht = (Hashtable)ref.get();
            }

            if (ht == null) {
               ht = new Hashtable();
               invalidNamesMap.put(this.classPool, new WeakReference(ht));
            }
         }

         this.invalidNames = ht;
      }

      return ht;
   }

   private CtClass searchImports(String orgName) throws CompileError {
      if (orgName.indexOf(46) < 0) {
         Iterator it = this.classPool.getImportedPackages();

         while(it.hasNext()) {
            String pac = (String)it.next();
            String fqName = pac + '.' + orgName;

            CtClass var10000;
            try {
               var10000 = this.classPool.get(fqName);
               return var10000;
            } catch (NotFoundException var8) {
               try {
                  if (pac.endsWith("." + orgName)) {
                     var10000 = this.classPool.get(pac);
                     return var10000;
                  }
               } catch (NotFoundException var7) {
               }
            }
         }
      }

      this.getInvalidNames().put(orgName, "<invalid>");
      throw new CompileError("no such class: " + orgName);
   }

   private CtClass lookupClass0(String classname, boolean notCheckInner) throws NotFoundException {
      CtClass cc = null;

      do {
         try {
            cc = this.classPool.get(classname);
         } catch (NotFoundException var7) {
            int i = classname.lastIndexOf(46);
            if (notCheckInner || i < 0) {
               throw var7;
            }

            StringBuffer sbuf = new StringBuffer(classname);
            sbuf.setCharAt(i, '$');
            classname = sbuf.toString();
         }
      } while(cc == null);

      return cc;
   }

   public String resolveClassName(ASTList name) throws CompileError {
      return name == null ? null : javaToJvmName(this.lookupClassByName(name).getName());
   }

   public String resolveJvmClassName(String jvmName) throws CompileError {
      return jvmName == null ? null : javaToJvmName(this.lookupClassByJvmName(jvmName).getName());
   }

   public static CtClass getSuperclass(CtClass c) throws CompileError {
      try {
         CtClass sc = c.getSuperclass();
         if (sc != null) {
            CtClass var10000 = sc;
            return var10000;
         }
      } catch (NotFoundException var2) {
      }

      throw new CompileError("cannot find the super class of " + c.getName());
   }

   public static CtClass getSuperInterface(CtClass c, String interfaceName) throws CompileError {
      try {
         CtClass[] intfs = c.getInterfaces();

         for(int i = 0; i < intfs.length; ++i) {
            if (intfs[i].getName().equals(interfaceName)) {
               CtClass var10000 = intfs[i];
               return var10000;
            }
         }
      } catch (NotFoundException var4) {
      }

      throw new CompileError("cannot find the super inetrface " + interfaceName + " of " + c.getName());
   }

   public static String javaToJvmName(String classname) {
      return classname.replace('.', '/');
   }

   public static String jvmToJavaName(String classname) {
      return classname.replace('/', '.');
   }

   public static int descToType(char c) throws CompileError {
      switch(c) {
      case 'B':
         return 303;
      case 'C':
         return 306;
      case 'D':
         return 312;
      case 'E':
      case 'G':
      case 'H':
      case 'K':
      case 'M':
      case 'N':
      case 'O':
      case 'P':
      case 'Q':
      case 'R':
      case 'T':
      case 'U':
      case 'W':
      case 'X':
      case 'Y':
      default:
         fatal();
         return 344;
      case 'F':
         return 317;
      case 'I':
         return 324;
      case 'J':
         return 326;
      case 'L':
      case '[':
         return 307;
      case 'S':
         return 334;
      case 'V':
         return 344;
      case 'Z':
         return 301;
      }
   }

   public static int getModifiers(ASTList mods) {
      int m = 0;

      while(mods != null) {
         Keyword k = (Keyword)mods.head();
         mods = mods.tail();
         switch(k.get()) {
         case 300:
            m |= 1024;
            break;
         case 315:
            m |= 16;
            break;
         case 330:
            m |= 2;
            break;
         case 331:
            m |= 4;
            break;
         case 332:
            m |= 1;
            break;
         case 335:
            m |= 8;
            break;
         case 338:
            m |= 32;
            break;
         case 342:
            m |= 128;
            break;
         case 345:
            m |= 64;
            break;
         case 347:
            m |= 2048;
         }
      }

      return m;
   }
}
