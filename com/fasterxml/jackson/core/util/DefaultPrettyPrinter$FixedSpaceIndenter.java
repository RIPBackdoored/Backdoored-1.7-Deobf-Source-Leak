package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class DefaultPrettyPrinter$FixedSpaceIndenter extends DefaultPrettyPrinter$NopIndenter {
   public static final DefaultPrettyPrinter$FixedSpaceIndenter instance = new DefaultPrettyPrinter$FixedSpaceIndenter();

   public void writeIndentation(JsonGenerator g, int level) throws IOException {
      g.writeRaw(' ');
   }

   public boolean isInline() {
      return true;
   }
}
