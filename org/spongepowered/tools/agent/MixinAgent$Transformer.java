package org.spongepowered.tools.agent;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Iterator;
import java.util.List;
import org.spongepowered.asm.mixin.transformer.throwables.MixinReloadException;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.MixinService;

class MixinAgent$Transformer implements ClassFileTransformer {
   // $FF: synthetic field
   final MixinAgent this$0;

   MixinAgent$Transformer(MixinAgent this$0) {
      this.this$0 = this$0;
   }

   public byte[] transform(ClassLoader loader, String className, Class classBeingRedefined, ProtectionDomain domain, byte[] classfileBuffer) throws IllegalClassFormatException {
      if (classBeingRedefined == null) {
         return null;
      } else {
         byte[] mixinBytecode = MixinAgent.classLoader.getFakeMixinBytecode(classBeingRedefined);
         if (mixinBytecode != null) {
            List targets = this.reloadMixin(className, classfileBuffer);
            return targets != null && this.reApplyMixins(targets) ? mixinBytecode : MixinAgent.ERROR_BYTECODE;
         } else {
            byte[] var10000;
            try {
               MixinAgent.logger.info("Redefining class " + className);
               var10000 = this.this$0.classTransformer.transformClassBytes((String)null, className, classfileBuffer);
            } catch (Throwable var8) {
               MixinAgent.logger.error("Error while re-transforming class " + className, var8);
               return MixinAgent.ERROR_BYTECODE;
            }

            return var10000;
         }
      }
   }

   private List reloadMixin(String className, byte[] classfileBuffer) {
      MixinAgent.logger.info("Redefining mixin {}", new Object[]{className});

      try {
         List var10000 = this.this$0.classTransformer.reload(className.replace('/', '.'), classfileBuffer);
         return var10000;
      } catch (MixinReloadException var4) {
         MixinAgent.logger.error("Mixin {} cannot be reloaded, needs a restart to be applied: {} ", new Object[]{var4.getMixinInfo(), var4.getMessage()});
      } catch (Throwable var5) {
         MixinAgent.logger.error("Error while finding targets for mixin " + className, var5);
      }

      return null;
   }

   private boolean reApplyMixins(List targets) {
      IMixinService service = MixinService.getService();
      Iterator var3 = targets.iterator();

      while(true) {
         if (var3.hasNext()) {
            String target = (String)var3.next();
            String targetName = target.replace('/', '.');
            MixinAgent.logger.debug("Re-transforming target class {}", new Object[]{target});

            boolean var10000;
            try {
               Class targetClass = service.getClassProvider().findClass(targetName);
               byte[] targetBytecode = MixinAgent.classLoader.getOriginalTargetBytecode(targetName);
               if (targetBytecode != null) {
                  targetBytecode = this.this$0.classTransformer.transformClassBytes((String)null, targetName, targetBytecode);
                  MixinAgent.instrumentation.redefineClasses(new ClassDefinition[]{new ClassDefinition(targetClass, targetBytecode)});
                  continue;
               }

               MixinAgent.logger.error("Target class {} bytecode is not registered", new Object[]{targetName});
               var10000 = false;
            } catch (Throwable var8) {
               MixinAgent.logger.error("Error while re-transforming target class " + target, var8);
               return false;
            }

            return var10000;
         }

         return true;
      }
   }
}
