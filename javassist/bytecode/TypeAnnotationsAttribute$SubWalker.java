package javassist.bytecode;

class TypeAnnotationsAttribute$SubWalker {
   byte[] info;

   TypeAnnotationsAttribute$SubWalker(byte[] attrInfo) {
      this.info = attrInfo;
   }

   final int targetInfo(int pos, int type) throws Exception {
      int offset;
      int index;
      switch(type) {
      case 0:
      case 1:
         offset = this.info[pos] & 255;
         this.typeParameterTarget(pos, type, offset);
         return pos + 1;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      default:
         throw new RuntimeException("invalid target type: " + type);
      case 16:
         offset = ByteArray.readU16bit(this.info, pos);
         this.supertypeTarget(pos, offset);
         return pos + 2;
      case 17:
      case 18:
         offset = this.info[pos] & 255;
         index = this.info[pos + 1] & 255;
         this.typeParameterBoundTarget(pos, type, offset, index);
         return pos + 2;
      case 19:
      case 20:
      case 21:
         this.emptyTarget(pos, type);
         return pos;
      case 22:
         offset = this.info[pos] & 255;
         this.formalParameterTarget(pos, offset);
         return pos + 1;
      case 23:
         offset = ByteArray.readU16bit(this.info, pos);
         this.throwsTarget(pos, offset);
         return pos + 2;
      case 64:
      case 65:
         offset = ByteArray.readU16bit(this.info, pos);
         return this.localvarTarget(pos + 2, type, offset);
      case 66:
         offset = ByteArray.readU16bit(this.info, pos);
         this.catchTarget(pos, offset);
         return pos + 2;
      case 67:
      case 68:
      case 69:
      case 70:
         offset = ByteArray.readU16bit(this.info, pos);
         this.offsetTarget(pos, type, offset);
         return pos + 2;
      case 71:
      case 72:
      case 73:
      case 74:
      case 75:
         offset = ByteArray.readU16bit(this.info, pos);
         index = this.info[pos + 2] & 255;
         this.typeArgumentTarget(pos, type, offset, index);
         return pos + 3;
      }
   }

   void typeParameterTarget(int pos, int targetType, int typeParameterIndex) throws Exception {
   }

   void supertypeTarget(int pos, int superTypeIndex) throws Exception {
   }

   void typeParameterBoundTarget(int pos, int targetType, int typeParameterIndex, int boundIndex) throws Exception {
   }

   void emptyTarget(int pos, int targetType) throws Exception {
   }

   void formalParameterTarget(int pos, int formalParameterIndex) throws Exception {
   }

   void throwsTarget(int pos, int throwsTypeIndex) throws Exception {
   }

   int localvarTarget(int pos, int targetType, int tableLength) throws Exception {
      for(int i = 0; i < tableLength; ++i) {
         int start = ByteArray.readU16bit(this.info, pos);
         int length = ByteArray.readU16bit(this.info, pos + 2);
         int index = ByteArray.readU16bit(this.info, pos + 4);
         this.localvarTarget(pos, targetType, start, length, index);
         pos += 6;
      }

      return pos;
   }

   void localvarTarget(int pos, int targetType, int startPc, int length, int index) throws Exception {
   }

   void catchTarget(int pos, int exceptionTableIndex) throws Exception {
   }

   void offsetTarget(int pos, int targetType, int offset) throws Exception {
   }

   void typeArgumentTarget(int pos, int targetType, int offset, int typeArgumentIndex) throws Exception {
   }

   final int typePath(int pos) throws Exception {
      int len = this.info[pos++] & 255;
      return this.typePath(pos, len);
   }

   int typePath(int pos, int pathLength) throws Exception {
      for(int i = 0; i < pathLength; ++i) {
         int kind = this.info[pos] & 255;
         int index = this.info[pos + 1] & 255;
         this.typePath(pos, kind, index);
         pos += 2;
      }

      return pos;
   }

   void typePath(int pos, int typePathKind, int typeArgumentIndex) throws Exception {
   }
}
