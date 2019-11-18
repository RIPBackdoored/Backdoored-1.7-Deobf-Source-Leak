package org.spongepowered.tools.obfuscation.interfaces;

public final class IMixinAnnotationProcessor$CompilerEnvironment extends Enum {
   public static final IMixinAnnotationProcessor$CompilerEnvironment JAVAC = new IMixinAnnotationProcessor$CompilerEnvironment("JAVAC", 0);
   public static final IMixinAnnotationProcessor$CompilerEnvironment JDT = new IMixinAnnotationProcessor$CompilerEnvironment("JDT", 1);
   // $FF: synthetic field
   private static final IMixinAnnotationProcessor$CompilerEnvironment[] $VALUES = new IMixinAnnotationProcessor$CompilerEnvironment[]{JAVAC, JDT};

   public static IMixinAnnotationProcessor$CompilerEnvironment[] values() {
      return (IMixinAnnotationProcessor$CompilerEnvironment[])$VALUES.clone();
   }

   public static IMixinAnnotationProcessor$CompilerEnvironment valueOf(String name) {
      return (IMixinAnnotationProcessor$CompilerEnvironment)Enum.valueOf(IMixinAnnotationProcessor$CompilerEnvironment.class, name);
   }

   private IMixinAnnotationProcessor$CompilerEnvironment(String var1, int var2) {
      super(var1, var2);
   }
}
