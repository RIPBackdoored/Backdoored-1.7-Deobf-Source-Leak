package org.spongepowered.asm.mixin.transformer;

import java.io.IOException;
import org.spongepowered.asm.lib.commons.Remapper;
import org.spongepowered.asm.service.MixinService;

class InnerClassGenerator$InnerClassInfo extends Remapper {
   private final String name;
   private final String originalName;
   private final MixinInfo owner;
   private final MixinTargetContext target;
   private final String ownerName;
   private final String targetName;

   InnerClassGenerator$InnerClassInfo(String name, String originalName, MixinInfo owner, MixinTargetContext target) {
      this.name = name;
      this.originalName = originalName;
      this.owner = owner;
      this.ownerName = owner.getClassRef();
      this.target = target;
      this.targetName = target.getTargetClassRef();
   }

   String getName() {
      return this.name;
   }

   String getOriginalName() {
      return this.originalName;
   }

   MixinInfo getOwner() {
      return this.owner;
   }

   MixinTargetContext getTarget() {
      return this.target;
   }

   String getOwnerName() {
      return this.ownerName;
   }

   String getTargetName() {
      return this.targetName;
   }

   byte[] getClassBytes() throws ClassNotFoundException, IOException {
      return MixinService.getService().getBytecodeProvider().getClassBytes(this.originalName, true);
   }

   public String mapMethodName(String owner, String name, String desc) {
      if (this.ownerName.equalsIgnoreCase(owner)) {
         ClassInfo$Method method = this.owner.getClassInfo().findMethod(name, desc, 10);
         if (method != null) {
            return method.getName();
         }
      }

      return super.mapMethodName(owner, name, desc);
   }

   public String map(String key) {
      if (this.originalName.equals(key)) {
         return this.name;
      } else {
         return this.ownerName.equals(key) ? this.targetName : key;
      }
   }

   public String toString() {
      return this.name;
   }
}
