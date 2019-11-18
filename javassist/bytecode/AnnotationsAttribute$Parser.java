package javassist.bytecode;

import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.AnnotationMemberValue;
import javassist.bytecode.annotation.ArrayMemberValue;
import javassist.bytecode.annotation.BooleanMemberValue;
import javassist.bytecode.annotation.ByteMemberValue;
import javassist.bytecode.annotation.CharMemberValue;
import javassist.bytecode.annotation.ClassMemberValue;
import javassist.bytecode.annotation.DoubleMemberValue;
import javassist.bytecode.annotation.EnumMemberValue;
import javassist.bytecode.annotation.FloatMemberValue;
import javassist.bytecode.annotation.IntegerMemberValue;
import javassist.bytecode.annotation.LongMemberValue;
import javassist.bytecode.annotation.MemberValue;
import javassist.bytecode.annotation.ShortMemberValue;
import javassist.bytecode.annotation.StringMemberValue;

class AnnotationsAttribute$Parser extends AnnotationsAttribute$Walker {
   ConstPool pool;
   Annotation[][] allParams;
   Annotation[] allAnno;
   Annotation currentAnno;
   MemberValue currentMember;

   AnnotationsAttribute$Parser(byte[] info, ConstPool cp) {
      super(info);
      this.pool = cp;
   }

   Annotation[][] parseParameters() throws Exception {
      this.parameters();
      return this.allParams;
   }

   Annotation[] parseAnnotations() throws Exception {
      this.annotationArray();
      return this.allAnno;
   }

   MemberValue parseMemberValue() throws Exception {
      this.memberValue(0);
      return this.currentMember;
   }

   void parameters(int numParam, int pos) throws Exception {
      Annotation[][] params = new Annotation[numParam][];

      for(int i = 0; i < numParam; ++i) {
         pos = this.annotationArray(pos);
         params[i] = this.allAnno;
      }

      this.allParams = params;
   }

   int annotationArray(int pos, int num) throws Exception {
      Annotation[] array = new Annotation[num];

      for(int i = 0; i < num; ++i) {
         pos = this.annotation(pos);
         array[i] = this.currentAnno;
      }

      this.allAnno = array;
      return pos;
   }

   int annotation(int pos, int type, int numPairs) throws Exception {
      this.currentAnno = new Annotation(type, this.pool);
      return super.annotation(pos, type, numPairs);
   }

   int memberValuePair(int pos, int nameIndex) throws Exception {
      pos = super.memberValuePair(pos, nameIndex);
      this.currentAnno.addMemberValue(nameIndex, this.currentMember);
      return pos;
   }

   void constValueMember(int tag, int index) throws Exception {
      ConstPool cp = this.pool;
      Object m;
      switch(tag) {
      case 66:
         m = new ByteMemberValue(index, cp);
         break;
      case 67:
         m = new CharMemberValue(index, cp);
         break;
      case 68:
         m = new DoubleMemberValue(index, cp);
         break;
      case 70:
         m = new FloatMemberValue(index, cp);
         break;
      case 73:
         m = new IntegerMemberValue(index, cp);
         break;
      case 74:
         m = new LongMemberValue(index, cp);
         break;
      case 83:
         m = new ShortMemberValue(index, cp);
         break;
      case 90:
         m = new BooleanMemberValue(index, cp);
         break;
      case 115:
         m = new StringMemberValue(index, cp);
         break;
      default:
         throw new RuntimeException("unknown tag:" + tag);
      }

      this.currentMember = (MemberValue)m;
      super.constValueMember(tag, index);
   }

   void enumMemberValue(int pos, int typeNameIndex, int constNameIndex) throws Exception {
      this.currentMember = new EnumMemberValue(typeNameIndex, constNameIndex, this.pool);
      super.enumMemberValue(pos, typeNameIndex, constNameIndex);
   }

   void classMemberValue(int pos, int index) throws Exception {
      this.currentMember = new ClassMemberValue(index, this.pool);
      super.classMemberValue(pos, index);
   }

   int annotationMemberValue(int pos) throws Exception {
      Annotation anno = this.currentAnno;
      pos = super.annotationMemberValue(pos);
      this.currentMember = new AnnotationMemberValue(this.currentAnno, this.pool);
      this.currentAnno = anno;
      return pos;
   }

   int arrayMemberValue(int pos, int num) throws Exception {
      ArrayMemberValue amv = new ArrayMemberValue(this.pool);
      MemberValue[] elements = new MemberValue[num];

      for(int i = 0; i < num; ++i) {
         pos = this.memberValue(pos);
         elements[i] = this.currentMember;
      }

      amv.setValue(elements);
      this.currentMember = amv;
      return pos;
   }
}
