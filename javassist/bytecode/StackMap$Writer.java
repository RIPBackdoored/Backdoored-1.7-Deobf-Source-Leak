package javassist.bytecode;

import java.io.ByteArrayOutputStream;

public class StackMap$Writer {
   private ByteArrayOutputStream output = new ByteArrayOutputStream();

   public byte[] toByteArray() {
      return this.output.toByteArray();
   }

   public StackMap toStackMap(ConstPool cp) {
      return new StackMap(cp, this.output.toByteArray());
   }

   public void writeVerifyTypeInfo(int tag, int data) {
      this.output.write(tag);
      if (tag == 7 || tag == 8) {
         this.write16bit(data);
      }

   }

   public void write16bit(int value) {
      this.output.write(value >>> 8 & 255);
      this.output.write(value & 255);
   }
}
