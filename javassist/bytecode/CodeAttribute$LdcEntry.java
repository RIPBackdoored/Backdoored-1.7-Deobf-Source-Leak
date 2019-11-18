package javassist.bytecode;

class CodeAttribute$LdcEntry {
   CodeAttribute$LdcEntry next;
   int where;
   int index;

   static byte[] doit(byte[] code, CodeAttribute$LdcEntry ldc, ExceptionTable etable, CodeAttribute ca) throws BadBytecode {
      if (ldc != null) {
         code = CodeIterator.changeLdcToLdcW(code, etable, ca, ldc);
      }

      return code;
   }
}
