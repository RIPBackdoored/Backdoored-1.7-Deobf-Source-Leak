package org.spongepowered.asm.util.throwables;

import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.util.Bytecode;

public final class SyntheticBridgeException$Problem extends Enum {
   public static final SyntheticBridgeException$Problem BAD_INSN = new SyntheticBridgeException$Problem("BAD_INSN", 0, "Conflicting opcodes %4$s and %5$s at offset %3$d in synthetic bridge method %1$s%2$s");
   public static final SyntheticBridgeException$Problem BAD_LOAD = new SyntheticBridgeException$Problem("BAD_LOAD", 1, "Conflicting variable access at offset %3$d in synthetic bridge method %1$s%2$s");
   public static final SyntheticBridgeException$Problem BAD_CAST = new SyntheticBridgeException$Problem("BAD_CAST", 2, "Conflicting type cast at offset %3$d in synthetic bridge method %1$s%2$s");
   public static final SyntheticBridgeException$Problem BAD_INVOKE_NAME = new SyntheticBridgeException$Problem("BAD_INVOKE_NAME", 3, "Conflicting synthetic bridge target method name in synthetic bridge method %1$s%2$s Existing:%6$s Incoming:%7$s");
   public static final SyntheticBridgeException$Problem BAD_INVOKE_DESC = new SyntheticBridgeException$Problem("BAD_INVOKE_DESC", 4, "Conflicting synthetic bridge target method descriptor in synthetic bridge method %1$s%2$s Existing:%8$s Incoming:%9$s");
   public static final SyntheticBridgeException$Problem BAD_LENGTH = new SyntheticBridgeException$Problem("BAD_LENGTH", 5, "Mismatched bridge method length for synthetic bridge method %1$s%2$s unexpected extra opcode at offset %3$d");
   private final String message;
   // $FF: synthetic field
   private static final SyntheticBridgeException$Problem[] $VALUES = new SyntheticBridgeException$Problem[]{BAD_INSN, BAD_LOAD, BAD_CAST, BAD_INVOKE_NAME, BAD_INVOKE_DESC, BAD_LENGTH};

   public static SyntheticBridgeException$Problem[] values() {
      return (SyntheticBridgeException$Problem[])$VALUES.clone();
   }

   public static SyntheticBridgeException$Problem valueOf(String name) {
      return (SyntheticBridgeException$Problem)Enum.valueOf(SyntheticBridgeException$Problem.class, name);
   }

   private SyntheticBridgeException$Problem(String var1, int var2, String message) {
      super(var1, var2);
      this.message = message;
   }

   String getMessage(String name, String desc, int index, AbstractInsnNode a, AbstractInsnNode b) {
      return String.format(this.message, name, desc, index, Bytecode.getOpcodeName(a), Bytecode.getOpcodeName(a), getInsnName(a), getInsnName(b), getInsnDesc(a), getInsnDesc(b));
   }

   private static String getInsnName(AbstractInsnNode node) {
      return node instanceof MethodInsnNode ? ((MethodInsnNode)node).name : "";
   }

   private static String getInsnDesc(AbstractInsnNode node) {
      return node instanceof MethodInsnNode ? ((MethodInsnNode)node).desc : "";
   }
}
