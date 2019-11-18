package org.spongepowered.tools.obfuscation;

import java.util.Iterator;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic.Kind;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.struct.InjectorRemap;

class AnnotatedMixinElementHandlerInjector$AnnotatedElementInjector extends AnnotatedMixinElementHandler$AnnotatedElement {
   private final InjectorRemap state;

   public AnnotatedMixinElementHandlerInjector$AnnotatedElementInjector(ExecutableElement element, AnnotationHandle annotation, InjectorRemap shouldRemap) {
      super(element, annotation);
      this.state = shouldRemap;
   }

   public boolean shouldRemap() {
      return this.state.shouldRemap();
   }

   public boolean hasCoerceArgument() {
      if (!this.annotation.toString().equals("@Inject")) {
         return false;
      } else {
         Iterator var1 = ((ExecutableElement)this.element).getParameters().iterator();
         if (var1.hasNext()) {
            VariableElement param = (VariableElement)var1.next();
            return AnnotationHandle.of(param, Coerce.class).exists();
         } else {
            return false;
         }
      }
   }

   public void addMessage(Kind kind, CharSequence msg, Element element, AnnotationHandle annotation) {
      this.state.addMessage(kind, msg, element, annotation);
   }

   public String toString() {
      return this.getAnnotation().toString();
   }
}
