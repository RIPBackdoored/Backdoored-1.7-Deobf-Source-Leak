package org.spongepowered.tools.obfuscation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer$MappingSet;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer$MappingSet$Pair;

class Mappings implements IMappingConsumer {
   private final Map fieldMappings = new HashMap();
   private final Map methodMappings = new HashMap();
   private Mappings$UniqueMappings unique;

   public Mappings() {
      this.init();
   }

   private void init() {
      Iterator var1 = ObfuscationType.types().iterator();

      while(var1.hasNext()) {
         ObfuscationType obfType = (ObfuscationType)var1.next();
         this.fieldMappings.put(obfType, new IMappingConsumer$MappingSet());
         this.methodMappings.put(obfType, new IMappingConsumer$MappingSet());
      }

   }

   public IMappingConsumer asUnique() {
      if (this.unique == null) {
         this.unique = new Mappings$UniqueMappings(this);
      }

      return this.unique;
   }

   public IMappingConsumer$MappingSet getFieldMappings(ObfuscationType type) {
      IMappingConsumer$MappingSet mappings = (IMappingConsumer$MappingSet)this.fieldMappings.get(type);
      return mappings != null ? mappings : new IMappingConsumer$MappingSet();
   }

   public IMappingConsumer$MappingSet getMethodMappings(ObfuscationType type) {
      IMappingConsumer$MappingSet mappings = (IMappingConsumer$MappingSet)this.methodMappings.get(type);
      return mappings != null ? mappings : new IMappingConsumer$MappingSet();
   }

   public void clear() {
      this.fieldMappings.clear();
      this.methodMappings.clear();
      if (this.unique != null) {
         this.unique.clearMaps();
      }

      this.init();
   }

   public void addFieldMapping(ObfuscationType type, MappingField from, MappingField to) {
      IMappingConsumer$MappingSet mappings = (IMappingConsumer$MappingSet)this.fieldMappings.get(type);
      if (mappings == null) {
         mappings = new IMappingConsumer$MappingSet();
         this.fieldMappings.put(type, mappings);
      }

      mappings.add(new IMappingConsumer$MappingSet$Pair(from, to));
   }

   public void addMethodMapping(ObfuscationType type, MappingMethod from, MappingMethod to) {
      IMappingConsumer$MappingSet mappings = (IMappingConsumer$MappingSet)this.methodMappings.get(type);
      if (mappings == null) {
         mappings = new IMappingConsumer$MappingSet();
         this.methodMappings.put(type, mappings);
      }

      mappings.add(new IMappingConsumer$MappingSet$Pair(from, to));
   }
}
