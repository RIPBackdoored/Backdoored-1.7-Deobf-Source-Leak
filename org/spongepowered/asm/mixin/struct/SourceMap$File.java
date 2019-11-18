package org.spongepowered.asm.mixin.struct;

import java.util.Iterator;
import java.util.ListIterator;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.LineNumberNode;
import org.spongepowered.asm.lib.tree.MethodNode;

public class SourceMap$File {
   public final int id;
   public final int lineOffset;
   public final int size;
   public final String sourceFileName;
   public final String sourceFilePath;

   public SourceMap$File(int id, int lineOffset, int size, String sourceFileName) {
      this(id, lineOffset, size, sourceFileName, (String)null);
   }

   public SourceMap$File(int id, int lineOffset, int size, String sourceFileName, String sourceFilePath) {
      this.id = id;
      this.lineOffset = lineOffset;
      this.size = size;
      this.sourceFileName = sourceFileName;
      this.sourceFilePath = sourceFilePath;
   }

   public void applyOffset(ClassNode classNode) {
      Iterator var2 = classNode.methods.iterator();

      while(var2.hasNext()) {
         MethodNode method = (MethodNode)var2.next();
         this.applyOffset(method);
      }

   }

   public void applyOffset(MethodNode method) {
      ListIterator iter = method.instructions.iterator();

      while(iter.hasNext()) {
         AbstractInsnNode node = (AbstractInsnNode)iter.next();
         if (node instanceof LineNumberNode) {
            ((LineNumberNode)node).line += this.lineOffset - 1;
         }
      }

   }

   void appendFile(StringBuilder sb) {
      if (this.sourceFilePath != null) {
         sb.append("+ ").append(this.id).append(" ").append(this.sourceFileName).append("\n");
         sb.append(this.sourceFilePath).append("\n");
      } else {
         sb.append(this.id).append(" ").append(this.sourceFileName).append("\n");
      }

   }

   public void appendLines(StringBuilder sb) {
      sb.append("1#").append(this.id).append(",").append(this.size).append(":").append(this.lineOffset).append("\n");
   }
}
