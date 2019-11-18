package javassist;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ByteArrayClassPath implements ClassPath {
   protected String classname;
   protected byte[] classfile;

   public ByteArrayClassPath(String name, byte[] classfile) {
      this.classname = name;
      this.classfile = classfile;
   }

   public void close() {
   }

   public String toString() {
      return "byte[]:" + this.classname;
   }

   public InputStream openClassfile(String classname) {
      return this.classname.equals(classname) ? new ByteArrayInputStream(this.classfile) : null;
   }

   public URL find(String classname) {
      if (this.classname.equals(classname)) {
         String cname = classname.replace('.', '/') + ".class";

         URL var10000;
         try {
            var10000 = new URL("file:/ByteArrayClassPath/" + cname);
         } catch (MalformedURLException var4) {
            return null;
         }

         return var10000;
      } else {
         return null;
      }
   }
}
