package javassist.bytecode;

class AnnotationsAttribute$Walker {
   byte[] info;

   AnnotationsAttribute$Walker(byte[] attrInfo) {
      this.info = attrInfo;
   }

   final void parameters() throws Exception {
      int numParam = this.info[0] & 255;
      this.parameters(numParam, 1);
   }

   void parameters(int numParam, int pos) throws Exception {
      for(int i = 0; i < numParam; ++i) {
         pos = this.annotationArray(pos);
      }

   }

   final void annotationArray() throws Exception {
      this.annotationArray(0);
   }

   final int annotationArray(int pos) throws Exception {
      int num = ByteArray.readU16bit(this.info, pos);
      return this.annotationArray(pos + 2, num);
   }

   int annotationArray(int pos, int num) throws Exception {
      for(int i = 0; i < num; ++i) {
         pos = this.annotation(pos);
      }

      return pos;
   }

   final int annotation(int pos) throws Exception {
      int type = ByteArray.readU16bit(this.info, pos);
      int numPairs = ByteArray.readU16bit(this.info, pos + 2);
      return this.annotation(pos + 4, type, numPairs);
   }

   int annotation(int pos, int type, int numPairs) throws Exception {
      for(int j = 0; j < numPairs; ++j) {
         pos = this.memberValuePair(pos);
      }

      return pos;
   }

   final int memberValuePair(int pos) throws Exception {
      int nameIndex = ByteArray.readU16bit(this.info, pos);
      return this.memberValuePair(pos + 2, nameIndex);
   }

   int memberValuePair(int pos, int nameIndex) throws Exception {
      return this.memberValue(pos);
   }

   final int memberValue(int pos) throws Exception {
      int tag = this.info[pos] & 255;
      int index;
      if (tag == 101) {
         index = ByteArray.readU16bit(this.info, pos + 1);
         int constNameIndex = ByteArray.readU16bit(this.info, pos + 3);
         this.enumMemberValue(pos, index, constNameIndex);
         return pos + 5;
      } else if (tag == 99) {
         index = ByteArray.readU16bit(this.info, pos + 1);
         this.classMemberValue(pos, index);
         return pos + 3;
      } else if (tag == 64) {
         return this.annotationMemberValue(pos + 1);
      } else if (tag == 91) {
         index = ByteArray.readU16bit(this.info, pos + 1);
         return this.arrayMemberValue(pos + 3, index);
      } else {
         index = ByteArray.readU16bit(this.info, pos + 1);
         this.constValueMember(tag, index);
         return pos + 3;
      }
   }

   void constValueMember(int tag, int index) throws Exception {
   }

   void enumMemberValue(int pos, int typeNameIndex, int constNameIndex) throws Exception {
   }

   void classMemberValue(int pos, int index) throws Exception {
   }

   int annotationMemberValue(int pos) throws Exception {
      return this.annotation(pos);
   }

   int arrayMemberValue(int pos, int num) throws Exception {
      for(int i = 0; i < num; ++i) {
         pos = this.memberValue(pos);
      }

      return pos;
   }
}
