package org.reflections.vfs;

public abstract class Vfs$DefaultUrlTypes extends Enum implements Vfs$UrlType {
   public static final Vfs$DefaultUrlTypes jarFile = new Vfs$DefaultUrlTypes$1("jarFile", 0);
   public static final Vfs$DefaultUrlTypes jarUrl = new Vfs$DefaultUrlTypes$2("jarUrl", 1);
   public static final Vfs$DefaultUrlTypes directory = new Vfs$DefaultUrlTypes$3("directory", 2);
   public static final Vfs$DefaultUrlTypes jboss_vfs = new Vfs$DefaultUrlTypes$4("jboss_vfs", 3);
   public static final Vfs$DefaultUrlTypes jboss_vfsfile = new Vfs$DefaultUrlTypes$5("jboss_vfsfile", 4);
   public static final Vfs$DefaultUrlTypes bundle = new Vfs$DefaultUrlTypes$6("bundle", 5);
   public static final Vfs$DefaultUrlTypes jarInputStream = new Vfs$DefaultUrlTypes$7("jarInputStream", 6);
   // $FF: synthetic field
   private static final Vfs$DefaultUrlTypes[] $VALUES = new Vfs$DefaultUrlTypes[]{jarFile, jarUrl, directory, jboss_vfs, jboss_vfsfile, bundle, jarInputStream};

   public static Vfs$DefaultUrlTypes[] values() {
      return (Vfs$DefaultUrlTypes[])$VALUES.clone();
   }

   public static Vfs$DefaultUrlTypes valueOf(String name) {
      return (Vfs$DefaultUrlTypes)Enum.valueOf(Vfs$DefaultUrlTypes.class, name);
   }

   private Vfs$DefaultUrlTypes(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   Vfs$DefaultUrlTypes(String x0, int x1, Vfs$1 x2) {
      this(x0, x1);
   }
}
