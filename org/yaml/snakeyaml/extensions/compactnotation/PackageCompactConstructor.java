package org.yaml.snakeyaml.extensions.compactnotation;

public class PackageCompactConstructor extends CompactConstructor {
   private String packageName;

   public PackageCompactConstructor(String packageName) {
      this.packageName = packageName;
   }

   protected Class getClassForName(String name) throws ClassNotFoundException {
      if (name.indexOf(46) < 0) {
         Class var10000;
         try {
            Class clazz = Class.forName(this.packageName + "." + name);
            var10000 = clazz;
         } catch (ClassNotFoundException var3) {
            return super.getClassForName(name);
         }

         return var10000;
      } else {
         return super.getClassForName(name);
      }
   }
}
