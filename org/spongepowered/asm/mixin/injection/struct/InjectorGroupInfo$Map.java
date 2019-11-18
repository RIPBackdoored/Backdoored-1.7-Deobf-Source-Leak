package org.spongepowered.asm.mixin.injection.struct;

import java.util.HashMap;
import java.util.Iterator;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.Group;
import org.spongepowered.asm.mixin.injection.throwables.InjectionValidationException;
import org.spongepowered.asm.util.Annotations;

public final class InjectorGroupInfo$Map extends HashMap {
   private static final long serialVersionUID = 1L;
   private static final InjectorGroupInfo NO_GROUP = new InjectorGroupInfo("NONE", true);

   public InjectorGroupInfo get(Object key) {
      return this.forName(key.toString());
   }

   public InjectorGroupInfo forName(String name) {
      InjectorGroupInfo value = (InjectorGroupInfo)super.get(name);
      if (value == null) {
         value = new InjectorGroupInfo(name);
         this.put(name, value);
      }

      return value;
   }

   public InjectorGroupInfo parseGroup(MethodNode method, String defaultGroup) {
      return this.parseGroup(Annotations.getInvisible(method, Group.class), defaultGroup);
   }

   public InjectorGroupInfo parseGroup(AnnotationNode annotation, String defaultGroup) {
      if (annotation == null) {
         return NO_GROUP;
      } else {
         String name = (String)Annotations.getValue(annotation, "name");
         if (name == null || name.isEmpty()) {
            name = defaultGroup;
         }

         InjectorGroupInfo groupInfo = this.forName(name);
         Integer min = (Integer)Annotations.getValue(annotation, "min");
         if (min != null && min != -1) {
            groupInfo.setMinRequired(min);
         }

         Integer max = (Integer)Annotations.getValue(annotation, "max");
         if (max != null && max != -1) {
            groupInfo.setMaxAllowed(max);
         }

         return groupInfo;
      }
   }

   public void validateAll() throws InjectionValidationException {
      Iterator var1 = this.values().iterator();

      while(var1.hasNext()) {
         InjectorGroupInfo group = (InjectorGroupInfo)var1.next();
         group.validate();
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object get(Object var1) {
      return this.get(var1);
   }
}
