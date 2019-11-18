package org.spongepowered.tools.obfuscation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.lang.model.element.ExecutableElement;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.struct.InjectorRemap;

class AnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint extends AnnotatedMixinElementHandler$AnnotatedElement {
   private final AnnotationHandle at;
   private Map args;
   private final InjectorRemap state;

   public AnnotatedMixinElementHandlerInjector$AnnotatedElementInjectionPoint(ExecutableElement element, AnnotationHandle inject, AnnotationHandle at, InjectorRemap state) {
      super(element, inject);
      this.at = at;
      this.state = state;
   }

   public boolean shouldRemap() {
      return this.at.getBoolean("remap", this.state.shouldRemap());
   }

   public AnnotationHandle getAt() {
      return this.at;
   }

   public String getAtArg(String key) {
      if (this.args == null) {
         this.args = new HashMap();
         Iterator var2 = this.at.getList("args").iterator();

         while(var2.hasNext()) {
            String arg = (String)var2.next();
            if (arg != null) {
               int eqPos = arg.indexOf(61);
               if (eqPos > -1) {
                  this.args.put(arg.substring(0, eqPos), arg.substring(eqPos + 1));
               } else {
                  this.args.put(arg, "");
               }
            }
         }
      }

      return (String)this.args.get(key);
   }

   public void notifyRemapped() {
      this.state.notifyRemapped();
   }
}
