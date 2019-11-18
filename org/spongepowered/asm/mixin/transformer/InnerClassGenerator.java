package org.spongepowered.asm.mixin.transformer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.mixin.transformer.ext.IClassGenerator;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.transformers.MixinClassWriter;

final class InnerClassGenerator implements IClassGenerator {
   private static final Logger logger = LogManager.getLogger("mixin");
   private final Map innerClassNames = new HashMap();
   private final Map innerClasses = new HashMap();

   public String registerInnerClass(MixinInfo owner, String originalName, MixinTargetContext context) {
      String id = String.format("%s%s", originalName, context);
      String ref = (String)this.innerClassNames.get(id);
      if (ref == null) {
         ref = getUniqueReference(originalName, context);
         this.innerClassNames.put(id, ref);
         this.innerClasses.put(ref, new InnerClassGenerator$InnerClassInfo(ref, originalName, owner, context));
         logger.debug("Inner class {} in {} on {} gets unique name {}", new Object[]{originalName, owner.getClassRef(), context.getTargetClassRef(), ref});
      }

      return ref;
   }

   public byte[] generate(String name) {
      String ref = name.replace('.', '/');
      InnerClassGenerator$InnerClassInfo info = (InnerClassGenerator$InnerClassInfo)this.innerClasses.get(ref);
      return info != null ? this.generate(info) : null;
   }

   private byte[] generate(InnerClassGenerator$InnerClassInfo info) {
      byte[] var10000;
      try {
         logger.debug("Generating mapped inner class {} (originally {})", new Object[]{info.getName(), info.getOriginalName()});
         ClassReader cr = new ClassReader(info.getClassBytes());
         ClassWriter cw = new MixinClassWriter(cr, 0);
         cr.accept(new InnerClassGenerator$InnerClassAdapter(cw, info), 8);
         var10000 = cw.toByteArray();
      } catch (InvalidMixinException var4) {
         throw var4;
      } catch (Exception var5) {
         logger.catching(var5);
         return null;
      }

      return var10000;
   }

   private static String getUniqueReference(String originalName, MixinTargetContext context) {
      String name = originalName.substring(originalName.lastIndexOf(36) + 1);
      if (name.matches("^[0-9]+$")) {
         name = "Anonymous";
      }

      return String.format("%s$%s$%s", context.getTargetClassRef(), name, UUID.randomUUID().toString().replace("-", ""));
   }
}
