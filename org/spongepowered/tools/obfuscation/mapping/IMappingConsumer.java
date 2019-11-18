package org.spongepowered.tools.obfuscation.mapping;

import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationType;

public interface IMappingConsumer {
   void clear();

   void addFieldMapping(ObfuscationType var1, MappingField var2, MappingField var3);

   void addMethodMapping(ObfuscationType var1, MappingMethod var2, MappingMethod var3);

   IMappingConsumer$MappingSet getFieldMappings(ObfuscationType var1);

   IMappingConsumer$MappingSet getMethodMappings(ObfuscationType var1);
}
