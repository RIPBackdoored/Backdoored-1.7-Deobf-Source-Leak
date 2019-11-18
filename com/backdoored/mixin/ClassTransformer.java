package com.backdoored.mixin;

import net.minecraft.launchwrapper.IClassTransformer;

public class ClassTransformer implements IClassTransformer {
   public byte[] transform(String className, String transformedName, byte[] classfileBuffer) {
      return classfileBuffer;
   }
}
