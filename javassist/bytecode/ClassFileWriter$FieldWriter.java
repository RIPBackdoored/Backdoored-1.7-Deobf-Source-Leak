package javassist.bytecode;

import java.io.IOException;
import java.io.OutputStream;

public final class ClassFileWriter$FieldWriter {
   protected ByteStream output = new ByteStream(128);
   protected ClassFileWriter$ConstPoolWriter constPool;
   private int fieldCount;

   ClassFileWriter$FieldWriter(ClassFileWriter$ConstPoolWriter cp) {
      this.constPool = cp;
      this.fieldCount = 0;
   }

   public void add(int accessFlags, String name, String descriptor, ClassFileWriter$AttributeWriter aw) {
      int nameIndex = this.constPool.addUtf8Info(name);
      int descIndex = this.constPool.addUtf8Info(descriptor);
      this.add(accessFlags, nameIndex, descIndex, aw);
   }

   public void add(int accessFlags, int name, int descriptor, ClassFileWriter$AttributeWriter aw) {
      ++this.fieldCount;
      this.output.writeShort(accessFlags);
      this.output.writeShort(name);
      this.output.writeShort(descriptor);
      ClassFileWriter.writeAttribute(this.output, aw, 0);
   }

   int size() {
      return this.fieldCount;
   }

   int dataSize() {
      return this.output.size();
   }

   void write(OutputStream out) throws IOException {
      this.output.writeTo(out);
   }
}
