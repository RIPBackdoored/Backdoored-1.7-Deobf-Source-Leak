package org.spongepowered.asm.util;

interface ClassSignature$IToken {
   String WILDCARDS = "+-";

   String asType();

   String asBound();

   ClassSignature$Token asToken();

   ClassSignature$IToken setArray(boolean var1);

   ClassSignature$IToken setWildcard(char var1);
}
