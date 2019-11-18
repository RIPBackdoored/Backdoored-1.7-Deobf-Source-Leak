package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.escape.CharEscapers;

final class UriTemplate$CompositeOutput extends Enum {
   public static final UriTemplate$CompositeOutput PLUS = new UriTemplate$CompositeOutput("PLUS", 0, '+', "", ",", false, true);
   public static final UriTemplate$CompositeOutput HASH = new UriTemplate$CompositeOutput("HASH", 1, '#', "#", ",", false, true);
   public static final UriTemplate$CompositeOutput DOT = new UriTemplate$CompositeOutput("DOT", 2, '.', ".", ".", false, false);
   public static final UriTemplate$CompositeOutput FORWARD_SLASH = new UriTemplate$CompositeOutput("FORWARD_SLASH", 3, '/', "/", "/", false, false);
   public static final UriTemplate$CompositeOutput SEMI_COLON = new UriTemplate$CompositeOutput("SEMI_COLON", 4, ';', ";", ";", true, false);
   public static final UriTemplate$CompositeOutput QUERY = new UriTemplate$CompositeOutput("QUERY", 5, '?', "?", "&", true, false);
   public static final UriTemplate$CompositeOutput AMP = new UriTemplate$CompositeOutput("AMP", 6, '&', "&", "&", true, false);
   public static final UriTemplate$CompositeOutput SIMPLE = new UriTemplate$CompositeOutput("SIMPLE", 7, (Character)null, "", ",", false, false);
   private final Character propertyPrefix;
   private final String outputPrefix;
   private final String explodeJoiner;
   private final boolean requiresVarAssignment;
   private final boolean reservedExpansion;
   // $FF: synthetic field
   private static final UriTemplate$CompositeOutput[] $VALUES = new UriTemplate$CompositeOutput[]{PLUS, HASH, DOT, FORWARD_SLASH, SEMI_COLON, QUERY, AMP, SIMPLE};

   public static UriTemplate$CompositeOutput[] values() {
      return (UriTemplate$CompositeOutput[])$VALUES.clone();
   }

   public static UriTemplate$CompositeOutput valueOf(String name) {
      return (UriTemplate$CompositeOutput)Enum.valueOf(UriTemplate$CompositeOutput.class, name);
   }

   private UriTemplate$CompositeOutput(String var1, int var2, Character propertyPrefix, String outputPrefix, String explodeJoiner, boolean requiresVarAssignment, boolean reservedExpansion) {
      super(var1, var2);
      this.propertyPrefix = propertyPrefix;
      this.outputPrefix = (String)Preconditions.checkNotNull(outputPrefix);
      this.explodeJoiner = (String)Preconditions.checkNotNull(explodeJoiner);
      this.requiresVarAssignment = requiresVarAssignment;
      this.reservedExpansion = reservedExpansion;
      if (propertyPrefix != null) {
         UriTemplate.COMPOSITE_PREFIXES.put(propertyPrefix, this);
      }

   }

   String getOutputPrefix() {
      return this.outputPrefix;
   }

   String getExplodeJoiner() {
      return this.explodeJoiner;
   }

   boolean requiresVarAssignment() {
      return this.requiresVarAssignment;
   }

   int getVarNameStartIndex() {
      return this.propertyPrefix == null ? 0 : 1;
   }

   String getEncodedValue(String value) {
      String encodedValue;
      if (this.reservedExpansion) {
         encodedValue = CharEscapers.escapeUriPath(value);
      } else {
         encodedValue = CharEscapers.escapeUri(value);
      }

      return encodedValue;
   }

   boolean getReservedExpansion() {
      return this.reservedExpansion;
   }
}
