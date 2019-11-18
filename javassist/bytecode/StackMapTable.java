package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import javassist.CannotCompileException;

public class StackMapTable extends AttributeInfo {
   public static final String tag = "StackMapTable";
   public static final int TOP = 0;
   public static final int INTEGER = 1;
   public static final int FLOAT = 2;
   public static final int DOUBLE = 3;
   public static final int LONG = 4;
   public static final int NULL = 5;
   public static final int THIS = 6;
   public static final int OBJECT = 7;
   public static final int UNINIT = 8;

   StackMapTable(ConstPool cp, byte[] newInfo) {
      super(cp, "StackMapTable", newInfo);
   }

   StackMapTable(ConstPool cp, int name_id, DataInputStream in) throws IOException {
      super(cp, name_id, in);
   }

   public AttributeInfo copy(ConstPool newCp, Map classnames) throws StackMapTable$RuntimeCopyException {
      StackMapTable var10000;
      try {
         var10000 = new StackMapTable(newCp, (new StackMapTable$Copier(this.constPool, this.info, newCp, classnames)).doit());
      } catch (BadBytecode var4) {
         throw new StackMapTable$RuntimeCopyException("bad bytecode. fatal?");
      }

      return var10000;
   }

   void write(DataOutputStream out) throws IOException {
      super.write(out);
   }

   public void insertLocal(int index, int tag, int classInfo) throws BadBytecode {
      byte[] data = (new StackMapTable$InsertLocal(this.get(), index, tag, classInfo)).doit();
      this.set(data);
   }

   public static int typeTagOf(char descriptor) {
      switch(descriptor) {
      case 'D':
         return 3;
      case 'F':
         return 2;
      case 'J':
         return 4;
      case 'L':
      case '[':
         return 7;
      default:
         return 1;
      }
   }

   public void println(PrintWriter w) {
      StackMapTable$Printer.print(this, w);
   }

   public void println(PrintStream ps) {
      StackMapTable$Printer.print(this, new PrintWriter(ps, true));
   }

   void shiftPc(int where, int gapSize, boolean exclusive) throws BadBytecode {
      (new StackMapTable$OffsetShifter(this, where, gapSize)).parse();
      (new StackMapTable$Shifter(this, where, gapSize, exclusive)).doit();
   }

   void shiftForSwitch(int where, int gapSize) throws BadBytecode {
      (new StackMapTable$SwitchShifter(this, where, gapSize)).doit();
   }

   public void removeNew(int where) throws CannotCompileException {
      try {
         byte[] data = (new StackMapTable$NewRemover(this.get(), where)).doit();
         this.set(data);
      } catch (BadBytecode var3) {
         throw new CannotCompileException("bad stack map table", var3);
      }

   }
}
