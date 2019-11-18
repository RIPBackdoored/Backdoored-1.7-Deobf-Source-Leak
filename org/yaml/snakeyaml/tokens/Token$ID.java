package org.yaml.snakeyaml.tokens;

public final class Token$ID extends Enum {
   public static final Token$ID Alias = new Token$ID("Alias", 0);
   public static final Token$ID Anchor = new Token$ID("Anchor", 1);
   public static final Token$ID BlockEnd = new Token$ID("BlockEnd", 2);
   public static final Token$ID BlockEntry = new Token$ID("BlockEntry", 3);
   public static final Token$ID BlockMappingStart = new Token$ID("BlockMappingStart", 4);
   public static final Token$ID BlockSequenceStart = new Token$ID("BlockSequenceStart", 5);
   public static final Token$ID Directive = new Token$ID("Directive", 6);
   public static final Token$ID DocumentEnd = new Token$ID("DocumentEnd", 7);
   public static final Token$ID DocumentStart = new Token$ID("DocumentStart", 8);
   public static final Token$ID FlowEntry = new Token$ID("FlowEntry", 9);
   public static final Token$ID FlowMappingEnd = new Token$ID("FlowMappingEnd", 10);
   public static final Token$ID FlowMappingStart = new Token$ID("FlowMappingStart", 11);
   public static final Token$ID FlowSequenceEnd = new Token$ID("FlowSequenceEnd", 12);
   public static final Token$ID FlowSequenceStart = new Token$ID("FlowSequenceStart", 13);
   public static final Token$ID Key = new Token$ID("Key", 14);
   public static final Token$ID Scalar = new Token$ID("Scalar", 15);
   public static final Token$ID StreamEnd = new Token$ID("StreamEnd", 16);
   public static final Token$ID StreamStart = new Token$ID("StreamStart", 17);
   public static final Token$ID Tag = new Token$ID("Tag", 18);
   public static final Token$ID Value = new Token$ID("Value", 19);
   public static final Token$ID Whitespace = new Token$ID("Whitespace", 20);
   public static final Token$ID Comment = new Token$ID("Comment", 21);
   public static final Token$ID Error = new Token$ID("Error", 22);
   // $FF: synthetic field
   private static final Token$ID[] $VALUES = new Token$ID[]{Alias, Anchor, BlockEnd, BlockEntry, BlockMappingStart, BlockSequenceStart, Directive, DocumentEnd, DocumentStart, FlowEntry, FlowMappingEnd, FlowMappingStart, FlowSequenceEnd, FlowSequenceStart, Key, Scalar, StreamEnd, StreamStart, Tag, Value, Whitespace, Comment, Error};

   public static Token$ID[] values() {
      return (Token$ID[])$VALUES.clone();
   }

   public static Token$ID valueOf(String name) {
      return (Token$ID)Enum.valueOf(Token$ID.class, name);
   }

   private Token$ID(String var1, int var2) {
      super(var1, var2);
   }
}
