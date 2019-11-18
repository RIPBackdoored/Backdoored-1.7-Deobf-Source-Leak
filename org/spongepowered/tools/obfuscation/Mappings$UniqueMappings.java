package org.spongepowered.tools.obfuscation;

import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer$MappingSet;

class Mappings$UniqueMappings implements IMappingConsumer {
   private final IMappingConsumer mappings;
   private final Map fields = new HashMap();
   private final Map methods = new HashMap();

   public Mappings$UniqueMappings(IMappingConsumer mappings) {
      this.mappings = mappings;
   }

   public void clear() {
      this.clearMaps();
      this.mappings.clear();
   }

   protected void clearMaps() {
      this.fields.clear();
      this.methods.clear();
   }

   public void addFieldMapping(ObfuscationType type, MappingField from, MappingField to) {
      if (!this.checkForExistingMapping(type, from, to, this.fields)) {
         this.mappings.addFieldMapping(type, from, to);
      }

   }

   public void addMethodMapping(ObfuscationType type, MappingMethod from, MappingMethod to) {
      if (!this.checkForExistingMapping(type, from, to, this.methods)) {
         this.mappings.addMethodMapping(type, from, to);
      }

   }

   private boolean checkForExistingMapping(ObfuscationType type, IMapping from, IMapping to, Map mappings) throws Mappings$MappingConflictException {
      Map existingMappings = (Map)mappings.get(type);
      if (existingMappings == null) {
         existingMappings = new HashMap();
         mappings.put(type, existingMappings);
      }

      IMapping existing = (IMapping)((Map)existingMappings).get(from);
      if (existing != null) {
         if (existing.equals(to)) {
            return true;
         } else {
            throw new Mappings$MappingConflictException(existing, to);
         }
      } else {
         ((Map)existingMappings).put(from, to);
         return false;
      }
   }

   public IMappingConsumer$MappingSet getFieldMappings(ObfuscationType type) {
      return this.mappings.getFieldMappings(type);
   }

   public IMappingConsumer$MappingSet getMethodMappings(ObfuscationType type) {
      return this.mappings.getMethodMappings(type);
   }
}
