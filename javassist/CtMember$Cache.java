package javassist;

class CtMember$Cache extends CtMember {
   private CtMember methodTail = this;
   private CtMember consTail = this;
   private CtMember fieldTail = this;

   protected void extendToString(StringBuffer buffer) {
   }

   public boolean hasAnnotation(String clz) {
      return false;
   }

   public Object getAnnotation(Class clz) throws ClassNotFoundException {
      return null;
   }

   public Object[] getAnnotations() throws ClassNotFoundException {
      return null;
   }

   public byte[] getAttribute(String name) {
      return null;
   }

   public Object[] getAvailableAnnotations() {
      return null;
   }

   public int getModifiers() {
      return 0;
   }

   public String getName() {
      return null;
   }

   public String getSignature() {
      return null;
   }

   public void setAttribute(String name, byte[] data) {
   }

   public void setModifiers(int mod) {
   }

   public String getGenericSignature() {
      return null;
   }

   public void setGenericSignature(String sig) {
   }

   CtMember$Cache(CtClassType decl) {
      super(decl);
      this.fieldTail.next = this;
   }

   CtMember methodHead() {
      return this;
   }

   CtMember lastMethod() {
      return this.methodTail;
   }

   CtMember consHead() {
      return this.methodTail;
   }

   CtMember lastCons() {
      return this.consTail;
   }

   CtMember fieldHead() {
      return this.consTail;
   }

   CtMember lastField() {
      return this.fieldTail;
   }

   void addMethod(CtMember method) {
      method.next = this.methodTail.next;
      this.methodTail.next = method;
      if (this.methodTail == this.consTail) {
         this.consTail = method;
         if (this.methodTail == this.fieldTail) {
            this.fieldTail = method;
         }
      }

      this.methodTail = method;
   }

   void addConstructor(CtMember cons) {
      cons.next = this.consTail.next;
      this.consTail.next = cons;
      if (this.consTail == this.fieldTail) {
         this.fieldTail = cons;
      }

      this.consTail = cons;
   }

   void addField(CtMember field) {
      field.next = this;
      this.fieldTail.next = field;
      this.fieldTail = field;
   }

   static int count(CtMember head, CtMember tail) {
      int n;
      for(n = 0; head != tail; head = head.next) {
         ++n;
      }

      return n;
   }

   void remove(CtMember mem) {
      CtMember node;
      for(Object m = this; (node = ((CtMember)m).next) != this; m = ((CtMember)m).next) {
         if (node == mem) {
            ((CtMember)m).next = node.next;
            if (node == this.methodTail) {
               this.methodTail = (CtMember)m;
            }

            if (node == this.consTail) {
               this.consTail = (CtMember)m;
            }

            if (node == this.fieldTail) {
               this.fieldTail = (CtMember)m;
            }
            break;
         }
      }

   }
}
