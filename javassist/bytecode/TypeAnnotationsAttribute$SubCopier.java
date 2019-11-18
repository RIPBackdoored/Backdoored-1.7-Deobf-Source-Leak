package javassist.bytecode;

import java.util.Map;
import javassist.bytecode.annotation.TypeAnnotationsWriter;

class TypeAnnotationsAttribute$SubCopier extends TypeAnnotationsAttribute$SubWalker {
   ConstPool srcPool;
   ConstPool destPool;
   Map classnames;
   TypeAnnotationsWriter writer;

   TypeAnnotationsAttribute$SubCopier(byte[] attrInfo, ConstPool src, ConstPool dest, Map map, TypeAnnotationsWriter w) {
      super(attrInfo);
      this.srcPool = src;
      this.destPool = dest;
      this.classnames = map;
      this.writer = w;
   }

   void typeParameterTarget(int pos, int targetType, int typeParameterIndex) throws Exception {
      this.writer.typeParameterTarget(targetType, typeParameterIndex);
   }

   void supertypeTarget(int pos, int superTypeIndex) throws Exception {
      this.writer.supertypeTarget(superTypeIndex);
   }

   void typeParameterBoundTarget(int pos, int targetType, int typeParameterIndex, int boundIndex) throws Exception {
      this.writer.typeParameterBoundTarget(targetType, typeParameterIndex, boundIndex);
   }

   void emptyTarget(int pos, int targetType) throws Exception {
      this.writer.emptyTarget(targetType);
   }

   void formalParameterTarget(int pos, int formalParameterIndex) throws Exception {
      this.writer.formalParameterTarget(formalParameterIndex);
   }

   void throwsTarget(int pos, int throwsTypeIndex) throws Exception {
      this.writer.throwsTarget(throwsTypeIndex);
   }

   int localvarTarget(int pos, int targetType, int tableLength) throws Exception {
      this.writer.localVarTarget(targetType, tableLength);
      return super.localvarTarget(pos, targetType, tableLength);
   }

   void localvarTarget(int pos, int targetType, int startPc, int length, int index) throws Exception {
      this.writer.localVarTargetTable(startPc, length, index);
   }

   void catchTarget(int pos, int exceptionTableIndex) throws Exception {
      this.writer.catchTarget(exceptionTableIndex);
   }

   void offsetTarget(int pos, int targetType, int offset) throws Exception {
      this.writer.offsetTarget(targetType, offset);
   }

   void typeArgumentTarget(int pos, int targetType, int offset, int typeArgumentIndex) throws Exception {
      this.writer.typeArgumentTarget(targetType, offset, typeArgumentIndex);
   }

   int typePath(int pos, int pathLength) throws Exception {
      this.writer.typePath(pathLength);
      return super.typePath(pos, pathLength);
   }

   void typePath(int pos, int typePathKind, int typeArgumentIndex) throws Exception {
      this.writer.typePathPath(typePathKind, typeArgumentIndex);
   }
}
