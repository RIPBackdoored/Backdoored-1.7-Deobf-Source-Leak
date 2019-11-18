package javassist.bytecode;

import java.io.IOException;
import java.io.OutputStream;

public final class ClassFileWriter$MethodWriter {
   protected ByteStream output = new ByteStream(256);
   protected ClassFileWriter$ConstPoolWriter constPool;
   private int methodCount;
   protected int codeIndex;
   protected int throwsIndex;
   protected int stackIndex;
   private int startPos;
   private boolean isAbstract;
   private int catchPos;
   private int catchCount;

   ClassFileWriter$MethodWriter(ClassFileWriter$ConstPoolWriter cp) {
      this.constPool = cp;
      this.methodCount = 0;
      this.codeIndex = 0;
      this.throwsIndex = 0;
      this.stackIndex = 0;
   }

   public void begin(int accessFlags, String name, String descriptor, String[] exceptions, ClassFileWriter$AttributeWriter aw) {
      int nameIndex = this.constPool.addUtf8Info(name);
      int descIndex = this.constPool.addUtf8Info(descriptor);
      int[] intfs;
      if (exceptions == null) {
         intfs = null;
      } else {
         intfs = this.constPool.addClassInfo(exceptions);
      }

      this.begin(accessFlags, nameIndex, descIndex, intfs, aw);
   }

   public void begin(int accessFlags, int name, int descriptor, int[] exceptions, ClassFileWriter$AttributeWriter aw) {
      ++this.methodCount;
      this.output.writeShort(accessFlags);
      this.output.writeShort(name);
      this.output.writeShort(descriptor);
      this.isAbstract = (accessFlags & 1024) != 0;
      int attrCount = this.isAbstract ? 0 : 1;
      if (exceptions != null) {
         ++attrCount;
      }

      ClassFileWriter.writeAttribute(this.output, aw, attrCount);
      if (exceptions != null) {
         this.writeThrows(exceptions);
      }

      if (!this.isAbstract) {
         if (this.codeIndex == 0) {
            this.codeIndex = this.constPool.addUtf8Info("Code");
         }

         this.startPos = this.output.getPos();
         this.output.writeShort(this.codeIndex);
         this.output.writeBlank(12);
      }

      this.catchPos = -1;
      this.catchCount = 0;
   }

   private void writeThrows(int[] exceptions) {
      if (this.throwsIndex == 0) {
         this.throwsIndex = this.constPool.addUtf8Info("Exceptions");
      }

      this.output.writeShort(this.throwsIndex);
      this.output.writeInt(exceptions.length * 2 + 2);
      this.output.writeShort(exceptions.length);

      for(int i = 0; i < exceptions.length; ++i) {
         this.output.writeShort(exceptions[i]);
      }

   }

   public void add(int b) {
      this.output.write(b);
   }

   public void add16(int b) {
      this.output.writeShort(b);
   }

   public void add32(int b) {
      this.output.writeInt(b);
   }

   public void addInvoke(int opcode, String targetClass, String methodName, String descriptor) {
      int target = this.constPool.addClassInfo(targetClass);
      int nt = this.constPool.addNameAndTypeInfo(methodName, descriptor);
      int method = this.constPool.addMethodrefInfo(target, nt);
      this.add(opcode);
      this.add16(method);
   }

   public void codeEnd(int maxStack, int maxLocals) {
      if (!this.isAbstract) {
         this.output.writeShort(this.startPos + 6, maxStack);
         this.output.writeShort(this.startPos + 8, maxLocals);
         this.output.writeInt(this.startPos + 10, this.output.getPos() - this.startPos - 14);
         this.catchPos = this.output.getPos();
         this.catchCount = 0;
         this.output.writeShort(0);
      }

   }

   public void addCatch(int startPc, int endPc, int handlerPc, int catchType) {
      ++this.catchCount;
      this.output.writeShort(startPc);
      this.output.writeShort(endPc);
      this.output.writeShort(handlerPc);
      this.output.writeShort(catchType);
   }

   public void end(StackMapTable$Writer smap, ClassFileWriter$AttributeWriter aw) {
      if (!this.isAbstract) {
         this.output.writeShort(this.catchPos, this.catchCount);
         int attrCount = smap == null ? 0 : 1;
         ClassFileWriter.writeAttribute(this.output, aw, attrCount);
         if (smap != null) {
            if (this.stackIndex == 0) {
               this.stackIndex = this.constPool.addUtf8Info("StackMapTable");
            }

            this.output.writeShort(this.stackIndex);
            byte[] data = smap.toByteArray();
            this.output.writeInt(data.length);
            this.output.write(data);
         }

         this.output.writeInt(this.startPos + 2, this.output.getPos() - this.startPos - 6);
      }
   }

   public int size() {
      return this.output.getPos() - this.startPos - 14;
   }

   int numOfMethods() {
      return this.methodCount;
   }

   int dataSize() {
      return this.output.size();
   }

   void write(OutputStream out) throws IOException {
      this.output.writeTo(out);
   }
}
