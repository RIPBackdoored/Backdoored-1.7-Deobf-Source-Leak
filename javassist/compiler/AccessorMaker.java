package javassist.compiler;

import java.util.HashMap;
import java.util.Map;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.SyntheticAttribute;

public class AccessorMaker {
   private CtClass clazz;
   private int uniqueNumber;
   private HashMap accessors;
   static final String lastParamType = "javassist.runtime.Inner";

   public AccessorMaker(CtClass c) {
      this.clazz = c;
      this.uniqueNumber = 1;
      this.accessors = new HashMap();
   }

   public String getConstructor(CtClass c, String desc, MethodInfo orig) throws CompileError {
      String key = "<init>:" + desc;
      String consDesc = (String)this.accessors.get(key);
      if (consDesc != null) {
         return consDesc;
      } else {
         consDesc = Descriptor.appendParameter("javassist.runtime.Inner", desc);
         ClassFile cf = this.clazz.getClassFile();

         try {
            ConstPool cp = cf.getConstPool();
            ClassPool pool = this.clazz.getClassPool();
            MethodInfo minfo = new MethodInfo(cp, "<init>", consDesc);
            minfo.setAccessFlags(0);
            minfo.addAttribute(new SyntheticAttribute(cp));
            ExceptionsAttribute ea = orig.getExceptionsAttribute();
            if (ea != null) {
               minfo.addAttribute(ea.copy(cp, (Map)null));
            }

            CtClass[] params = Descriptor.getParameterTypes(desc, pool);
            Bytecode code = new Bytecode(cp);
            code.addAload(0);
            int regno = 1;
            int i = 0;

            while(true) {
               if (i >= params.length) {
                  code.setMaxLocals(regno + 1);
                  code.addInvokespecial(this.clazz, "<init>", desc);
                  code.addReturn((CtClass)null);
                  minfo.setCodeAttribute(code.toCodeAttribute());
                  cf.addMethod(minfo);
                  break;
               }

               regno += code.addLoad(regno, params[i]);
               ++i;
            }
         } catch (CannotCompileException var15) {
            throw new CompileError(var15);
         } catch (NotFoundException var16) {
            throw new CompileError(var16);
         }

         this.accessors.put(key, consDesc);
         return consDesc;
      }
   }

   public String getMethodAccessor(String name, String desc, String accDesc, MethodInfo orig) throws CompileError {
      String key = name + ":" + desc;
      String accName = (String)this.accessors.get(key);
      if (accName != null) {
         return accName;
      } else {
         ClassFile cf = this.clazz.getClassFile();
         accName = this.findAccessorName(cf);

         try {
            ConstPool cp = cf.getConstPool();
            ClassPool pool = this.clazz.getClassPool();
            MethodInfo minfo = new MethodInfo(cp, accName, accDesc);
            minfo.setAccessFlags(8);
            minfo.addAttribute(new SyntheticAttribute(cp));
            ExceptionsAttribute ea = orig.getExceptionsAttribute();
            if (ea != null) {
               minfo.addAttribute(ea.copy(cp, (Map)null));
            }

            CtClass[] params = Descriptor.getParameterTypes(accDesc, pool);
            int regno = 0;
            Bytecode code = new Bytecode(cp);

            for(int i = 0; i < params.length; ++i) {
               regno += code.addLoad(regno, params[i]);
            }

            code.setMaxLocals(regno);
            if (desc == accDesc) {
               code.addInvokestatic(this.clazz, name, desc);
            } else {
               code.addInvokevirtual(this.clazz, name, desc);
            }

            code.addReturn(Descriptor.getReturnType(desc, pool));
            minfo.setCodeAttribute(code.toCodeAttribute());
            cf.addMethod(minfo);
         } catch (CannotCompileException var16) {
            throw new CompileError(var16);
         } catch (NotFoundException var17) {
            throw new CompileError(var17);
         }

         this.accessors.put(key, accName);
         return accName;
      }
   }

   public MethodInfo getFieldGetter(FieldInfo finfo, boolean is_static) throws CompileError {
      String fieldName = finfo.getName();
      String key = fieldName + ":getter";
      Object res = this.accessors.get(key);
      if (res != null) {
         return (MethodInfo)res;
      } else {
         ClassFile cf = this.clazz.getClassFile();
         String accName = this.findAccessorName(cf);

         MethodInfo var10000;
         try {
            ConstPool cp = cf.getConstPool();
            ClassPool pool = this.clazz.getClassPool();
            String fieldType = finfo.getDescriptor();
            String accDesc;
            if (is_static) {
               accDesc = "()" + fieldType;
            } else {
               accDesc = "(" + Descriptor.of(this.clazz) + ")" + fieldType;
            }

            MethodInfo minfo = new MethodInfo(cp, accName, accDesc);
            minfo.setAccessFlags(8);
            minfo.addAttribute(new SyntheticAttribute(cp));
            Bytecode code = new Bytecode(cp);
            if (is_static) {
               code.addGetstatic(Bytecode.THIS, fieldName, fieldType);
            } else {
               code.addAload(0);
               code.addGetfield(Bytecode.THIS, fieldName, fieldType);
               code.setMaxLocals(1);
            }

            code.addReturn(Descriptor.toCtClass(fieldType, pool));
            minfo.setCodeAttribute(code.toCodeAttribute());
            cf.addMethod(minfo);
            this.accessors.put(key, minfo);
            var10000 = minfo;
         } catch (CannotCompileException var14) {
            throw new CompileError(var14);
         } catch (NotFoundException var15) {
            throw new CompileError(var15);
         }

         return var10000;
      }
   }

   public MethodInfo getFieldSetter(FieldInfo finfo, boolean is_static) throws CompileError {
      String fieldName = finfo.getName();
      String key = fieldName + ":setter";
      Object res = this.accessors.get(key);
      if (res != null) {
         return (MethodInfo)res;
      } else {
         ClassFile cf = this.clazz.getClassFile();
         String accName = this.findAccessorName(cf);

         MethodInfo var10000;
         try {
            ConstPool cp = cf.getConstPool();
            ClassPool pool = this.clazz.getClassPool();
            String fieldType = finfo.getDescriptor();
            String accDesc;
            if (is_static) {
               accDesc = "(" + fieldType + ")V";
            } else {
               accDesc = "(" + Descriptor.of(this.clazz) + fieldType + ")V";
            }

            MethodInfo minfo = new MethodInfo(cp, accName, accDesc);
            minfo.setAccessFlags(8);
            minfo.addAttribute(new SyntheticAttribute(cp));
            Bytecode code = new Bytecode(cp);
            int reg;
            if (is_static) {
               reg = code.addLoad(0, Descriptor.toCtClass(fieldType, pool));
               code.addPutstatic(Bytecode.THIS, fieldName, fieldType);
            } else {
               code.addAload(0);
               reg = code.addLoad(1, Descriptor.toCtClass(fieldType, pool)) + 1;
               code.addPutfield(Bytecode.THIS, fieldName, fieldType);
            }

            code.addReturn((CtClass)null);
            code.setMaxLocals(reg);
            minfo.setCodeAttribute(code.toCodeAttribute());
            cf.addMethod(minfo);
            this.accessors.put(key, minfo);
            var10000 = minfo;
         } catch (CannotCompileException var15) {
            throw new CompileError(var15);
         } catch (NotFoundException var16) {
            throw new CompileError(var16);
         }

         return var10000;
      }
   }

   private String findAccessorName(ClassFile cf) {
      String accName;
      do {
         accName = "access$" + this.uniqueNumber++;
      } while(cf.getMethod(accName) != null);

      return accName;
   }
}
