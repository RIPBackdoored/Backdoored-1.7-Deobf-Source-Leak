package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.AnnotationsWriter;

public class AnnotationsAttribute extends AttributeInfo {
   public static final String visibleTag = "RuntimeVisibleAnnotations";
   public static final String invisibleTag = "RuntimeInvisibleAnnotations";

   public AnnotationsAttribute(ConstPool cp, String attrname, byte[] info) {
      super(cp, attrname, info);
   }

   public AnnotationsAttribute(ConstPool cp, String attrname) {
      this(cp, attrname, new byte[]{0, 0});
   }

   AnnotationsAttribute(ConstPool cp, int n, DataInputStream in) throws IOException {
      super(cp, n, in);
   }

   public int numAnnotations() {
      return ByteArray.readU16bit(this.info, 0);
   }

   public AttributeInfo copy(ConstPool newCp, Map classnames) {
      AnnotationsAttribute$Copier copier = new AnnotationsAttribute$Copier(this.info, this.constPool, newCp, classnames);

      AnnotationsAttribute var10000;
      try {
         copier.annotationArray();
         var10000 = new AnnotationsAttribute(newCp, this.getName(), copier.close());
      } catch (Exception var5) {
         throw new RuntimeException(var5);
      }

      return var10000;
   }

   public Annotation getAnnotation(String type) {
      Annotation[] annotations = this.getAnnotations();

      for(int i = 0; i < annotations.length; ++i) {
         if (annotations[i].getTypeName().equals(type)) {
            return annotations[i];
         }
      }

      return null;
   }

   public void addAnnotation(Annotation annotation) {
      String type = annotation.getTypeName();
      Annotation[] annotations = this.getAnnotations();

      for(int i = 0; i < annotations.length; ++i) {
         if (annotations[i].getTypeName().equals(type)) {
            annotations[i] = annotation;
            this.setAnnotations(annotations);
            return;
         }
      }

      Annotation[] newlist = new Annotation[annotations.length + 1];
      System.arraycopy(annotations, 0, newlist, 0, annotations.length);
      newlist[annotations.length] = annotation;
      this.setAnnotations(newlist);
   }

   public boolean removeAnnotation(String type) {
      Annotation[] annotations = this.getAnnotations();

      for(int i = 0; i < annotations.length; ++i) {
         if (annotations[i].getTypeName().equals(type)) {
            Annotation[] newlist = new Annotation[annotations.length - 1];
            System.arraycopy(annotations, 0, newlist, 0, i);
            if (i < annotations.length - 1) {
               System.arraycopy(annotations, i + 1, newlist, i, annotations.length - i - 1);
            }

            this.setAnnotations(newlist);
            return true;
         }
      }

      return false;
   }

   public Annotation[] getAnnotations() {
      Annotation[] var10000;
      try {
         var10000 = (new AnnotationsAttribute$Parser(this.info, this.constPool)).parseAnnotations();
      } catch (Exception var2) {
         throw new RuntimeException(var2);
      }

      return var10000;
   }

   public void setAnnotations(Annotation[] annotations) {
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      AnnotationsWriter writer = new AnnotationsWriter(output, this.constPool);

      try {
         int n = annotations.length;
         writer.numAnnotations(n);
         int i = 0;

         while(true) {
            if (i >= n) {
               writer.close();
               break;
            }

            annotations[i].write(writer);
            ++i;
         }
      } catch (IOException var6) {
         throw new RuntimeException(var6);
      }

      this.set(output.toByteArray());
   }

   public void setAnnotation(Annotation annotation) {
      this.setAnnotations(new Annotation[]{annotation});
   }

   void renameClass(String oldname, String newname) {
      HashMap map = new HashMap();
      map.put(oldname, newname);
      this.renameClass(map);
   }

   void renameClass(Map classnames) {
      AnnotationsAttribute$Renamer renamer = new AnnotationsAttribute$Renamer(this.info, this.getConstPool(), classnames);

      try {
         renamer.annotationArray();
      } catch (Exception var4) {
         throw new RuntimeException(var4);
      }

   }

   void getRefClasses(Map classnames) {
      this.renameClass(classnames);
   }

   public String toString() {
      Annotation[] a = this.getAnnotations();
      StringBuilder sbuf = new StringBuilder();
      int i = 0;

      while(i < a.length) {
         sbuf.append(a[i++].toString());
         if (i != a.length) {
            sbuf.append(", ");
         }
      }

      return sbuf.toString();
   }
}
