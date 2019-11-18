package javassist.bytecode;

public final class ClassFileWriter$ConstPoolWriter {
   ByteStream output;
   protected int startPos;
   protected int num;

   ClassFileWriter$ConstPoolWriter(ByteStream out) {
      this.output = out;
      this.startPos = out.getPos();
      this.num = 1;
      this.output.writeShort(1);
   }

   public int[] addClassInfo(String[] classNames) {
      int n = classNames.length;
      int[] result = new int[n];

      for(int i = 0; i < n; ++i) {
         result[i] = this.addClassInfo(classNames[i]);
      }

      return result;
   }

   public int addClassInfo(String jvmname) {
      int utf8 = this.addUtf8Info(jvmname);
      this.output.write(7);
      this.output.writeShort(utf8);
      return this.num++;
   }

   public int addClassInfo(int name) {
      this.output.write(7);
      this.output.writeShort(name);
      return this.num++;
   }

   public int addNameAndTypeInfo(String name, String type) {
      return this.addNameAndTypeInfo(this.addUtf8Info(name), this.addUtf8Info(type));
   }

   public int addNameAndTypeInfo(int name, int type) {
      this.output.write(12);
      this.output.writeShort(name);
      this.output.writeShort(type);
      return this.num++;
   }

   public int addFieldrefInfo(int classInfo, int nameAndTypeInfo) {
      this.output.write(9);
      this.output.writeShort(classInfo);
      this.output.writeShort(nameAndTypeInfo);
      return this.num++;
   }

   public int addMethodrefInfo(int classInfo, int nameAndTypeInfo) {
      this.output.write(10);
      this.output.writeShort(classInfo);
      this.output.writeShort(nameAndTypeInfo);
      return this.num++;
   }

   public int addInterfaceMethodrefInfo(int classInfo, int nameAndTypeInfo) {
      this.output.write(11);
      this.output.writeShort(classInfo);
      this.output.writeShort(nameAndTypeInfo);
      return this.num++;
   }

   public int addMethodHandleInfo(int kind, int index) {
      this.output.write(15);
      this.output.write(kind);
      this.output.writeShort(index);
      return this.num++;
   }

   public int addMethodTypeInfo(int desc) {
      this.output.write(16);
      this.output.writeShort(desc);
      return this.num++;
   }

   public int addInvokeDynamicInfo(int bootstrap, int nameAndTypeInfo) {
      this.output.write(18);
      this.output.writeShort(bootstrap);
      this.output.writeShort(nameAndTypeInfo);
      return this.num++;
   }

   public int addStringInfo(String str) {
      int utf8 = this.addUtf8Info(str);
      this.output.write(8);
      this.output.writeShort(utf8);
      return this.num++;
   }

   public int addIntegerInfo(int i) {
      this.output.write(3);
      this.output.writeInt(i);
      return this.num++;
   }

   public int addFloatInfo(float f) {
      this.output.write(4);
      this.output.writeFloat(f);
      return this.num++;
   }

   public int addLongInfo(long l) {
      this.output.write(5);
      this.output.writeLong(l);
      int n = this.num;
      this.num += 2;
      return n;
   }

   public int addDoubleInfo(double d) {
      this.output.write(6);
      this.output.writeDouble(d);
      int n = this.num;
      this.num += 2;
      return n;
   }

   public int addUtf8Info(String utf8) {
      this.output.write(1);
      this.output.writeUTF(utf8);
      return this.num++;
   }

   void end() {
      this.output.writeShort(this.startPos, this.num);
   }
}
