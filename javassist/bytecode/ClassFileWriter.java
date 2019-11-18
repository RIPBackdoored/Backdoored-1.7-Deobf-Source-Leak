package javassist.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class ClassFileWriter {
   private ByteStream output = new ByteStream(512);
   private ClassFileWriter$ConstPoolWriter constPool;
   private ClassFileWriter$FieldWriter fields;
   private ClassFileWriter$MethodWriter methods;
   int thisClass;
   int superClass;

   public ClassFileWriter(int major, int minor) {
      this.output.writeInt(-889275714);
      this.output.writeShort(minor);
      this.output.writeShort(major);
      this.constPool = new ClassFileWriter$ConstPoolWriter(this.output);
      this.fields = new ClassFileWriter$FieldWriter(this.constPool);
      this.methods = new ClassFileWriter$MethodWriter(this.constPool);
   }

   public ClassFileWriter$ConstPoolWriter getConstPool() {
      return this.constPool;
   }

   public ClassFileWriter$FieldWriter getFieldWriter() {
      return this.fields;
   }

   public ClassFileWriter$MethodWriter getMethodWriter() {
      return this.methods;
   }

   public byte[] end(int accessFlags, int thisClass, int superClass, int[] interfaces, ClassFileWriter$AttributeWriter aw) {
      this.constPool.end();
      this.output.writeShort(accessFlags);
      this.output.writeShort(thisClass);
      this.output.writeShort(superClass);
      if (interfaces == null) {
         this.output.writeShort(0);
      } else {
         int n = interfaces.length;
         this.output.writeShort(n);

         for(int i = 0; i < n; ++i) {
            this.output.writeShort(interfaces[i]);
         }
      }

      this.output.enlarge(this.fields.dataSize() + this.methods.dataSize() + 6);

      try {
         this.output.writeShort(this.fields.size());
         this.fields.write(this.output);
         this.output.writeShort(this.methods.numOfMethods());
         this.methods.write(this.output);
      } catch (IOException var8) {
      }

      writeAttribute(this.output, aw, 0);
      return this.output.toByteArray();
   }

   public void end(DataOutputStream out, int accessFlags, int thisClass, int superClass, int[] interfaces, ClassFileWriter$AttributeWriter aw) throws IOException {
      this.constPool.end();
      this.output.writeTo(out);
      out.writeShort(accessFlags);
      out.writeShort(thisClass);
      out.writeShort(superClass);
      if (interfaces == null) {
         out.writeShort(0);
      } else {
         int n = interfaces.length;
         out.writeShort(n);

         for(int i = 0; i < n; ++i) {
            out.writeShort(interfaces[i]);
         }
      }

      out.writeShort(this.fields.size());
      this.fields.write(out);
      out.writeShort(this.methods.numOfMethods());
      this.methods.write(out);
      if (aw == null) {
         out.writeShort(0);
      } else {
         out.writeShort(aw.size());
         aw.write(out);
      }

   }

   static void writeAttribute(ByteStream bs, ClassFileWriter$AttributeWriter aw, int attrCount) {
      if (aw == null) {
         bs.writeShort(attrCount);
      } else {
         bs.writeShort(aw.size() + attrCount);
         DataOutputStream dos = new DataOutputStream(bs);

         try {
            aw.write(dos);
            dos.flush();
         } catch (IOException var5) {
         }

      }
   }
}
