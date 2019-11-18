package org.spongepowered.tools.obfuscation.mapping.mcp;

import com.google.common.collect.BiMap;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.mcp.MappingFieldSrg;
import org.spongepowered.tools.obfuscation.mapping.common.MappingProvider;

public class MappingProviderSrg extends MappingProvider {
   public MappingProviderSrg(Messager messager, Filer filer) {
      super(messager, filer);
   }

   public void read(File input) throws IOException {
      BiMap packageMap = this.packageMap;
      BiMap classMap = this.classMap;
      BiMap fieldMap = this.fieldMap;
      BiMap methodMap = this.methodMap;
      Files.readLines(input, Charset.defaultCharset(), new MappingProviderSrg$1(this, packageMap, classMap, fieldMap, methodMap, input));
   }

   public MappingField getFieldMapping(MappingField field) {
      if (((MappingField)field).getDesc() != null) {
         field = new MappingFieldSrg((MappingField)field);
      }

      return (MappingField)this.fieldMap.get(field);
   }
}
