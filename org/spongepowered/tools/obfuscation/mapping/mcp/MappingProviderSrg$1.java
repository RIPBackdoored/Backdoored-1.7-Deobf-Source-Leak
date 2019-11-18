package org.spongepowered.tools.obfuscation.mapping.mcp;

import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.io.LineProcessor;
import java.io.File;
import java.io.IOException;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.asm.obfuscation.mapping.mcp.MappingFieldSrg;

class MappingProviderSrg$1 implements LineProcessor {
   // $FF: synthetic field
   final BiMap val$packageMap;
   // $FF: synthetic field
   final BiMap val$classMap;
   // $FF: synthetic field
   final BiMap val$fieldMap;
   // $FF: synthetic field
   final BiMap val$methodMap;
   // $FF: synthetic field
   final File val$input;
   // $FF: synthetic field
   final MappingProviderSrg this$0;

   MappingProviderSrg$1(MappingProviderSrg this$0, BiMap var2, BiMap var3, BiMap var4, BiMap var5, File var6) {
      this.this$0 = this$0;
      this.val$packageMap = var2;
      this.val$classMap = var3;
      this.val$fieldMap = var4;
      this.val$methodMap = var5;
      this.val$input = var6;
   }

   public String getResult() {
      return null;
   }

   public boolean processLine(String line) throws IOException {
      if (!Strings.isNullOrEmpty(line) && !line.startsWith("#")) {
         String type = line.substring(0, 2);
         String[] args = line.substring(4).split(" ");
         if (type.equals("PK")) {
            this.val$packageMap.forcePut(args[0], args[1]);
         } else if (type.equals("CL")) {
            this.val$classMap.forcePut(args[0], args[1]);
         } else if (type.equals("FD")) {
            this.val$fieldMap.forcePut((new MappingFieldSrg(args[0])).copy(), (new MappingFieldSrg(args[1])).copy());
         } else {
            if (!type.equals("MD")) {
               throw new MixinException("Invalid SRG file: " + this.val$input);
            }

            this.val$methodMap.forcePut(new MappingMethod(args[0], args[1]), new MappingMethod(args[2], args[3]));
         }

         return true;
      } else {
         return true;
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object getResult() {
      return this.getResult();
   }
}
