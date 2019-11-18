package javassist;

import java.util.ListIterator;
import java.util.Map;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.SignatureAttribute;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
import javassist.compiler.ast.ASTree;

public class CtField extends CtMember {
   static final String javaLangString = "java.lang.String";
   protected FieldInfo fieldInfo;

   public CtField(CtClass type, String name, CtClass declaring) throws CannotCompileException {
      this(Descriptor.of(type), name, declaring);
   }

   public CtField(CtField src, CtClass declaring) throws CannotCompileException {
      this(src.fieldInfo.getDescriptor(), src.fieldInfo.getName(), declaring);
      ListIterator iterator = src.fieldInfo.getAttributes().listIterator();
      FieldInfo fi = this.fieldInfo;
      fi.setAccessFlags(src.fieldInfo.getAccessFlags());
      ConstPool cp = fi.getConstPool();

      while(iterator.hasNext()) {
         AttributeInfo ainfo = (AttributeInfo)iterator.next();
         fi.addAttribute(ainfo.copy(cp, (Map)null));
      }

   }

   private CtField(String typeDesc, String name, CtClass clazz) throws CannotCompileException {
      super(clazz);
      ClassFile cf = clazz.getClassFile2();
      if (cf == null) {
         throw new CannotCompileException("bad declaring class: " + clazz.getName());
      } else {
         this.fieldInfo = new FieldInfo(cf.getConstPool(), name, typeDesc);
      }
   }

   CtField(FieldInfo fi, CtClass clazz) {
      super(clazz);
      this.fieldInfo = fi;
   }

   public String toString() {
      return this.getDeclaringClass().getName() + "." + this.getName() + ":" + this.fieldInfo.getDescriptor();
   }

   protected void extendToString(StringBuffer buffer) {
      buffer.append(' ');
      buffer.append(this.getName());
      buffer.append(' ');
      buffer.append(this.fieldInfo.getDescriptor());
   }

   protected ASTree getInitAST() {
      return null;
   }

   CtField$Initializer getInit() {
      ASTree tree = this.getInitAST();
      return tree == null ? null : CtField$Initializer.byExpr(tree);
   }

   public static CtField make(String src, CtClass declaring) throws CannotCompileException {
      Javac compiler = new Javac(declaring);

      try {
         CtMember obj = compiler.compile(src);
         if (obj instanceof CtField) {
            CtField var10000 = (CtField)obj;
            return var10000;
         }
      } catch (CompileError var4) {
         throw new CannotCompileException(var4);
      }

      throw new CannotCompileException("not a field");
   }

   public FieldInfo getFieldInfo() {
      this.declaringClass.checkModify();
      return this.fieldInfo;
   }

   public FieldInfo getFieldInfo2() {
      return this.fieldInfo;
   }

   public CtClass getDeclaringClass() {
      return super.getDeclaringClass();
   }

   public String getName() {
      return this.fieldInfo.getName();
   }

   public void setName(String newName) {
      this.declaringClass.checkModify();
      this.fieldInfo.setName(newName);
   }

   public int getModifiers() {
      return AccessFlag.toModifier(this.fieldInfo.getAccessFlags());
   }

   public void setModifiers(int mod) {
      this.declaringClass.checkModify();
      this.fieldInfo.setAccessFlags(AccessFlag.of(mod));
   }

   public boolean hasAnnotation(String typeName) {
      FieldInfo fi = this.getFieldInfo2();
      AnnotationsAttribute ainfo = (AnnotationsAttribute)fi.getAttribute("RuntimeInvisibleAnnotations");
      AnnotationsAttribute ainfo2 = (AnnotationsAttribute)fi.getAttribute("RuntimeVisibleAnnotations");
      return CtClassType.hasAnnotationType(typeName, this.getDeclaringClass().getClassPool(), ainfo, ainfo2);
   }

   public Object getAnnotation(Class clz) throws ClassNotFoundException {
      FieldInfo fi = this.getFieldInfo2();
      AnnotationsAttribute ainfo = (AnnotationsAttribute)fi.getAttribute("RuntimeInvisibleAnnotations");
      AnnotationsAttribute ainfo2 = (AnnotationsAttribute)fi.getAttribute("RuntimeVisibleAnnotations");
      return CtClassType.getAnnotationType(clz, this.getDeclaringClass().getClassPool(), ainfo, ainfo2);
   }

   public Object[] getAnnotations() throws ClassNotFoundException {
      return this.getAnnotations(false);
   }

   public Object[] getAvailableAnnotations() {
      Object[] var10000;
      try {
         var10000 = this.getAnnotations(true);
      } catch (ClassNotFoundException var2) {
         throw new RuntimeException("Unexpected exception", var2);
      }

      return var10000;
   }

   private Object[] getAnnotations(boolean ignoreNotFound) throws ClassNotFoundException {
      FieldInfo fi = this.getFieldInfo2();
      AnnotationsAttribute ainfo = (AnnotationsAttribute)fi.getAttribute("RuntimeInvisibleAnnotations");
      AnnotationsAttribute ainfo2 = (AnnotationsAttribute)fi.getAttribute("RuntimeVisibleAnnotations");
      return CtClassType.toAnnotationType(ignoreNotFound, this.getDeclaringClass().getClassPool(), ainfo, ainfo2);
   }

   public String getSignature() {
      return this.fieldInfo.getDescriptor();
   }

   public String getGenericSignature() {
      SignatureAttribute sa = (SignatureAttribute)this.fieldInfo.getAttribute("Signature");
      return sa == null ? null : sa.getSignature();
   }

   public void setGenericSignature(String sig) {
      this.declaringClass.checkModify();
      this.fieldInfo.addAttribute(new SignatureAttribute(this.fieldInfo.getConstPool(), sig));
   }

   public CtClass getType() throws NotFoundException {
      return Descriptor.toCtClass(this.fieldInfo.getDescriptor(), this.declaringClass.getClassPool());
   }

   public void setType(CtClass clazz) {
      this.declaringClass.checkModify();
      this.fieldInfo.setDescriptor(Descriptor.of(clazz));
   }

   public Object getConstantValue() {
      int index = this.fieldInfo.getConstantValue();
      if (index == 0) {
         return null;
      } else {
         ConstPool cp = this.fieldInfo.getConstPool();
         switch(cp.getTag(index)) {
         case 3:
            int value = cp.getIntegerInfo(index);
            if ("Z".equals(this.fieldInfo.getDescriptor())) {
               return new Boolean(value != 0);
            }

            return new Integer(value);
         case 4:
            return new Float(cp.getFloatInfo(index));
         case 5:
            return new Long(cp.getLongInfo(index));
         case 6:
            return new Double(cp.getDoubleInfo(index));
         case 7:
         default:
            throw new RuntimeException("bad tag: " + cp.getTag(index) + " at " + index);
         case 8:
            return cp.getStringInfo(index);
         }
      }
   }

   public byte[] getAttribute(String name) {
      AttributeInfo ai = this.fieldInfo.getAttribute(name);
      return ai == null ? null : ai.get();
   }

   public void setAttribute(String name, byte[] data) {
      this.declaringClass.checkModify();
      this.fieldInfo.addAttribute(new AttributeInfo(this.fieldInfo.getConstPool(), name, data));
   }
}
