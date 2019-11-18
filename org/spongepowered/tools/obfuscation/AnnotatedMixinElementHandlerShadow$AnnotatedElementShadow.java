package org.spongepowered.tools.obfuscation;

import javax.lang.model.element.Element;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.IMapping$Type;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationDataProvider;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

abstract class AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow extends AnnotatedMixinElementHandler$AnnotatedElement {
   private final boolean shouldRemap;
   private final AnnotatedMixinElementHandler$ShadowElementName name;
   private final IMapping$Type type;

   protected AnnotatedMixinElementHandlerShadow$AnnotatedElementShadow(Element element, AnnotationHandle annotation, boolean shouldRemap, IMapping$Type type) {
      super(element, annotation);
      this.shouldRemap = shouldRemap;
      this.name = new AnnotatedMixinElementHandler$ShadowElementName(element, annotation);
      this.type = type;
   }

   public boolean shouldRemap() {
      return this.shouldRemap;
   }

   public AnnotatedMixinElementHandler$ShadowElementName getName() {
      return this.name;
   }

   public IMapping$Type getElementType() {
      return this.type;
   }

   public String toString() {
      return this.getElementType().name().toLowerCase();
   }

   public AnnotatedMixinElementHandler$ShadowElementName setObfuscatedName(IMapping name) {
      return this.setObfuscatedName(name.getSimpleName());
   }

   public AnnotatedMixinElementHandler$ShadowElementName setObfuscatedName(String name) {
      return this.getName().setObfuscatedName(name);
   }

   public ObfuscationData getObfuscationData(IObfuscationDataProvider provider, TypeHandle owner) {
      return provider.getObfEntry(this.getMapping(owner, this.getName().toString(), this.getDesc()));
   }

   public abstract IMapping getMapping(TypeHandle var1, String var2, String var3);

   public abstract void addMapping(ObfuscationType var1, IMapping var2);
}
