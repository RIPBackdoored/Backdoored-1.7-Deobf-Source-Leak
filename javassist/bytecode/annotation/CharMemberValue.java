package javassist.bytecode.annotation;

import java.io.IOException;
import java.lang.reflect.Method;
import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class CharMemberValue extends MemberValue {
   int valueIndex;

   public CharMemberValue(int index, ConstPool cp) {
      super('C', cp);
      this.valueIndex = index;
   }

   public CharMemberValue(char c, ConstPool cp) {
      super('C', cp);
      this.setValue(c);
   }

   public CharMemberValue(ConstPool cp) {
      super('C', cp);
      this.setValue('\u0000');
   }

   Object getValue(ClassLoader cl, ClassPool cp, Method m) {
      return new Character(this.getValue());
   }

   Class getType(ClassLoader cl) {
      return Character.TYPE;
   }

   public char getValue() {
      return (char)this.cp.getIntegerInfo(this.valueIndex);
   }

   public void setValue(char newValue) {
      this.valueIndex = this.cp.addIntegerInfo(newValue);
   }

   public String toString() {
      return Character.toString(this.getValue());
   }

   public void write(AnnotationsWriter writer) throws IOException {
      writer.constValueIndex(this.getValue());
   }

   public void accept(MemberValueVisitor visitor) {
      visitor.visitCharMemberValue(this);
   }
}
