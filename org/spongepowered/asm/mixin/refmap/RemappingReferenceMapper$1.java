package org.spongepowered.asm.mixin.refmap;

import com.google.common.base.Strings;
import com.google.common.io.LineProcessor;
import java.io.IOException;
import java.util.Map;

final class RemappingReferenceMapper$1 implements LineProcessor {
   // $FF: synthetic field
   final Map val$map;

   RemappingReferenceMapper$1(Map var1) {
      this.val$map = var1;
   }

   public Object getResult() {
      return null;
   }

   public boolean processLine(String line) throws IOException {
      if (!Strings.isNullOrEmpty(line) && !line.startsWith("#")) {
         int fromPos = 0;
         int toPos = false;
         int toPos;
         if ((toPos = line.startsWith("MD: ") ? 2 : (line.startsWith("FD: ") ? 1 : 0)) > 0) {
            String[] entries = line.substring(4).split(" ", 4);
            this.val$map.put(entries[fromPos].substring(entries[fromPos].lastIndexOf(47) + 1), entries[toPos].substring(entries[toPos].lastIndexOf(47) + 1));
         }

         return true;
      } else {
         return true;
      }
   }
}
