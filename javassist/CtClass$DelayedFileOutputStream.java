package javassist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class CtClass$DelayedFileOutputStream extends OutputStream {
   private FileOutputStream file = null;
   private String filename;

   CtClass$DelayedFileOutputStream(String name) {
      this.filename = name;
   }

   private void init() throws IOException {
      if (this.file == null) {
         this.file = new FileOutputStream(this.filename);
      }

   }

   public void write(int b) throws IOException {
      this.init();
      this.file.write(b);
   }

   public void write(byte[] b) throws IOException {
      this.init();
      this.file.write(b);
   }

   public void write(byte[] b, int off, int len) throws IOException {
      this.init();
      this.file.write(b, off, len);
   }

   public void flush() throws IOException {
      this.init();
      this.file.flush();
   }

   public void close() throws IOException {
      this.init();
      this.file.close();
   }
}
