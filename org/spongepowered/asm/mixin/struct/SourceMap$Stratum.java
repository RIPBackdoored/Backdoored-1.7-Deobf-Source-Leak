package org.spongepowered.asm.mixin.struct;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class SourceMap$Stratum {
   private static final String STRATUM_MARK = "*S";
   private static final String FILE_MARK = "*F";
   private static final String LINES_MARK = "*L";
   public final String name;
   private final Map files = new LinkedHashMap();

   public SourceMap$Stratum(String name) {
      this.name = name;
   }

   public SourceMap$File addFile(int lineOffset, int size, String sourceFileName, String sourceFilePath) {
      SourceMap$File file = (SourceMap$File)this.files.get(sourceFilePath);
      if (file == null) {
         file = new SourceMap$File(this.files.size() + 1, lineOffset, size, sourceFileName, sourceFilePath);
         this.files.put(sourceFilePath, file);
      }

      return file;
   }

   void appendTo(StringBuilder sb) {
      sb.append("*S").append(" ").append(this.name).append("\n");
      sb.append("*F").append("\n");
      Iterator var2 = this.files.values().iterator();

      SourceMap$File file;
      while(var2.hasNext()) {
         file = (SourceMap$File)var2.next();
         file.appendFile(sb);
      }

      sb.append("*L").append("\n");
      var2 = this.files.values().iterator();

      while(var2.hasNext()) {
         file = (SourceMap$File)var2.next();
         file.appendLines(sb);
      }

   }
}
