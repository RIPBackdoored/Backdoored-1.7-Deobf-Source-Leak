package org.spongepowered.asm.mixin.struct;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.util.Bytecode;

public class SourceMap {
   private static final String DEFAULT_STRATUM = "Mixin";
   private static final String NEWLINE = "\n";
   private final String sourceFile;
   private final Map strata = new LinkedHashMap();
   private int nextLineOffset = 1;
   private String defaultStratum = "Mixin";

   public SourceMap(String sourceFile) {
      this.sourceFile = sourceFile;
   }

   public String getSourceFile() {
      return this.sourceFile;
   }

   public String getPseudoGeneratedSourceFile() {
      return this.sourceFile.replace(".java", "$mixin.java");
   }

   public SourceMap$File addFile(ClassNode classNode) {
      return this.addFile(this.defaultStratum, classNode);
   }

   public SourceMap$File addFile(String stratumName, ClassNode classNode) {
      return this.addFile(stratumName, classNode.sourceFile, classNode.name + ".java", Bytecode.getMaxLineNumber(classNode, 500, 50));
   }

   public SourceMap$File addFile(String sourceFileName, String sourceFilePath, int size) {
      return this.addFile(this.defaultStratum, sourceFileName, sourceFilePath, size);
   }

   public SourceMap$File addFile(String stratumName, String sourceFileName, String sourceFilePath, int size) {
      SourceMap$Stratum stratum = (SourceMap$Stratum)this.strata.get(stratumName);
      if (stratum == null) {
         stratum = new SourceMap$Stratum(stratumName);
         this.strata.put(stratumName, stratum);
      }

      SourceMap$File file = stratum.addFile(this.nextLineOffset, size, sourceFileName, sourceFilePath);
      this.nextLineOffset += size;
      return file;
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      this.appendTo(sb);
      return sb.toString();
   }

   private void appendTo(StringBuilder sb) {
      sb.append("SMAP").append("\n");
      sb.append(this.getSourceFile()).append("\n");
      sb.append(this.defaultStratum).append("\n");
      Iterator var2 = this.strata.values().iterator();

      while(var2.hasNext()) {
         SourceMap$Stratum stratum = (SourceMap$Stratum)var2.next();
         stratum.appendTo(sb);
      }

      sb.append("*E").append("\n");
   }
}
