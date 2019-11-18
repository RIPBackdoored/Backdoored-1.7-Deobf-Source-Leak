package org.json;

import java.util.ArrayList;
import java.util.List;

public class JSONPointer$Builder {
   private final List refTokens = new ArrayList();

   public JSONPointer build() {
      return new JSONPointer(this.refTokens);
   }

   public JSONPointer$Builder append(String token) {
      if (token == null) {
         throw new NullPointerException("token cannot be null");
      } else {
         this.refTokens.add(token);
         return this;
      }
   }

   public JSONPointer$Builder append(int arrayIndex) {
      this.refTokens.add(String.valueOf(arrayIndex));
      return this;
   }
}
