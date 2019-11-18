package javassist.bytecode;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javassist.CannotCompileException;

public class StackMap extends AttributeInfo {
   public static final String tag = "StackMap";
   public static final int TOP = 0;
   public static final int INTEGER = 1;
   public static final int FLOAT = 2;
   public static final int DOUBLE = 3;
   public static final int LONG = 4;
   public static final int NULL = 5;
   public static final int THIS = 6;
   public static final int OBJECT = 7;
   public static final int UNINIT = 8;

   StackMap(ConstPool cp, byte[] newInfo) {
      super(cp, "StackMap", newInfo);
   }

   StackMap(ConstPool cp, int name_id, DataInputStream in) throws IOException {
      super(cp, name_id, in);
   }

   public int numOfEntries() {
      return ByteArray.readU16bit(this.info, 0);
   }

   public AttributeInfo copy(ConstPool newCp, Map classnames) {
      StackMap$Copier copier = new StackMap$Copier(this, newCp, classnames);
      copier.visit();
      return copier.getStackMap();
   }

   public void insertLocal(int index, int tag, int classInfo) throws BadBytecode {
      byte[] data = (new StackMap$InsertLocal(this, index, tag, classInfo)).doit();
      this.set(data);
   }

   void shiftPc(int where, int gapSize, boolean exclusive) throws BadBytecode {
      (new StackMap$Shifter(this, where, gapSize, exclusive)).visit();
   }

   void shiftForSwitch(int where, int gapSize) throws BadBytecode {
      (new StackMap$SwitchShifter(this, where, gapSize)).visit();
   }

   public void removeNew(int where) throws CannotCompileException {
      byte[] data = (new StackMap$NewRemover(this, where)).doit();
      this.set(data);
   }

   public void print(PrintWriter out) {
      (new StackMap$Printer(this, out)).print();
   }
}
