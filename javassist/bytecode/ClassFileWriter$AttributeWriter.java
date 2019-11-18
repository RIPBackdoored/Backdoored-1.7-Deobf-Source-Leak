package javassist.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public interface ClassFileWriter$AttributeWriter {
   int size();

   void write(DataOutputStream var1) throws IOException;
}
