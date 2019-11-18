package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import javassist.bytecode.annotation.AnnotationsWriter;

class AnnotationsAttribute$Copier extends AnnotationsAttribute$Walker {
   ByteArrayOutputStream output;
   AnnotationsWriter writer;
   ConstPool srcPool;
   ConstPool destPool;
   Map classnames;

   AnnotationsAttribute$Copier(byte[] info, ConstPool src, ConstPool dest, Map map) {
      this(info, src, dest, map, true);
   }

   AnnotationsAttribute$Copier(byte[] info, ConstPool src, ConstPool dest, Map map, boolean makeWriter) {
      super(info);
      this.output = new ByteArrayOutputStream();
      if (makeWriter) {
         this.writer = new AnnotationsWriter(this.output, dest);
      }

      this.srcPool = src;
      this.destPool = dest;
      this.classnames = map;
   }

   byte[] close() throws IOException {
      this.writer.close();
      return this.output.toByteArray();
   }

   void parameters(int numParam, int pos) throws Exception {
      this.writer.numParameters(numParam);
      super.parameters(numParam, pos);
   }

   int annotationArray(int pos, int num) throws Exception {
      this.writer.numAnnotations(num);
      return super.annotationArray(pos, num);
   }

   int annotation(int pos, int type, int numPairs) throws Exception {
      this.writer.annotation(this.copyType(type), numPairs);
      return super.annotation(pos, type, numPairs);
   }

   int memberValuePair(int pos, int nameIndex) throws Exception {
      this.writer.memberValuePair(this.copy(nameIndex));
      return super.memberValuePair(pos, nameIndex);
   }

   void constValueMember(int tag, int index) throws Exception {
      this.writer.constValueIndex(tag, this.copy(index));
      super.constValueMember(tag, index);
   }

   void enumMemberValue(int pos, int typeNameIndex, int constNameIndex) throws Exception {
      this.writer.enumConstValue(this.copyType(typeNameIndex), this.copy(constNameIndex));
      super.enumMemberValue(pos, typeNameIndex, constNameIndex);
   }

   void classMemberValue(int pos, int index) throws Exception {
      this.writer.classInfoIndex(this.copyType(index));
      super.classMemberValue(pos, index);
   }

   int annotationMemberValue(int pos) throws Exception {
      this.writer.annotationValue();
      return super.annotationMemberValue(pos);
   }

   int arrayMemberValue(int pos, int num) throws Exception {
      this.writer.arrayValue(num);
      return super.arrayMemberValue(pos, num);
   }

   int copy(int srcIndex) {
      return this.srcPool.copy(srcIndex, this.destPool, this.classnames);
   }

   int copyType(int srcIndex) {
      String name = this.srcPool.getUtf8Info(srcIndex);
      String newName = Descriptor.rename(name, this.classnames);
      return this.destPool.addUtf8Info(newName);
   }
}
