package javassist;

public abstract class CtMember {
   CtMember next;
   protected CtClass declaringClass;

   protected CtMember(CtClass clazz) {
      this.declaringClass = clazz;
      this.next = null;
   }

   final CtMember next() {
      return this.next;
   }

   void nameReplaced() {
   }

   public String toString() {
      StringBuffer buffer = new StringBuffer(this.getClass().getName());
      buffer.append("@");
      buffer.append(Integer.toHexString(this.hashCode()));
      buffer.append("[");
      buffer.append(Modifier.toString(this.getModifiers()));
      this.extendToString(buffer);
      buffer.append("]");
      return buffer.toString();
   }

   protected abstract void extendToString(StringBuffer var1);

   public CtClass getDeclaringClass() {
      return this.declaringClass;
   }

   public boolean visibleFrom(CtClass clazz) {
      int mod = this.getModifiers();
      if (Modifier.isPublic(mod)) {
         return true;
      } else if (Modifier.isPrivate(mod)) {
         return clazz == this.declaringClass;
      } else {
         String declName = this.declaringClass.getPackageName();
         String fromName = clazz.getPackageName();
         boolean visible;
         if (declName == null) {
            visible = fromName == null;
         } else {
            visible = declName.equals(fromName);
         }

         return !visible && Modifier.isProtected(mod) ? clazz.subclassOf(this.declaringClass) : visible;
      }
   }

   public abstract int getModifiers();

   public abstract void setModifiers(int var1);

   public boolean hasAnnotation(Class clz) {
      return this.hasAnnotation(clz.getName());
   }

   public abstract boolean hasAnnotation(String var1);

   public abstract Object getAnnotation(Class var1) throws ClassNotFoundException;

   public abstract Object[] getAnnotations() throws ClassNotFoundException;

   public abstract Object[] getAvailableAnnotations();

   public abstract String getName();

   public abstract String getSignature();

   public abstract String getGenericSignature();

   public abstract void setGenericSignature(String var1);

   public abstract byte[] getAttribute(String var1);

   public abstract void setAttribute(String var1, byte[] var2);
}
