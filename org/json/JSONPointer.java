package org.json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JSONPointer {
   private static final String ENCODING = "utf-8";
   private final List refTokens;

   public static JSONPointer$Builder builder() {
      return new JSONPointer$Builder();
   }

   public JSONPointer(String pointer) {
      if (pointer == null) {
         throw new NullPointerException("pointer cannot be null");
      } else if (!pointer.isEmpty() && !pointer.equals("#")) {
         String refs;
         if (pointer.startsWith("#/")) {
            refs = pointer.substring(2);

            try {
               refs = URLDecoder.decode(refs, "utf-8");
            } catch (UnsupportedEncodingException var6) {
               throw new RuntimeException(var6);
            }
         } else {
            if (!pointer.startsWith("/")) {
               throw new IllegalArgumentException("a JSON pointer should start with '/' or '#/'");
            }

            refs = pointer.substring(1);
         }

         this.refTokens = new ArrayList();
         int slashIdx = -1;
         boolean var4 = false;

         do {
            int prevSlashIdx = slashIdx + 1;
            slashIdx = refs.indexOf(47, prevSlashIdx);
            if (prevSlashIdx != slashIdx && prevSlashIdx != refs.length()) {
               String token;
               if (slashIdx >= 0) {
                  token = refs.substring(prevSlashIdx, slashIdx);
                  this.refTokens.add(this.unescape(token));
               } else {
                  token = refs.substring(prevSlashIdx);
                  this.refTokens.add(this.unescape(token));
               }
            } else {
               this.refTokens.add("");
            }
         } while(slashIdx >= 0);

      } else {
         this.refTokens = Collections.emptyList();
      }
   }

   public JSONPointer(List refTokens) {
      this.refTokens = new ArrayList(refTokens);
   }

   private String unescape(String token) {
      return token.replace("~1", "/").replace("~0", "~").replace("\\\"", "\"").replace("\\\\", "\\");
   }

   public Object queryFrom(Object document) throws JSONPointerException {
      if (this.refTokens.isEmpty()) {
         return document;
      } else {
         Object current = document;
         Iterator var3 = this.refTokens.iterator();

         while(var3.hasNext()) {
            String token = (String)var3.next();
            if (current instanceof JSONObject) {
               current = ((JSONObject)current).opt(this.unescape(token));
            } else {
               if (!(current instanceof JSONArray)) {
                  throw new JSONPointerException(String.format("value [%s] is not an array or object therefore its key %s cannot be resolved", current, token));
               }

               current = this.readByIndexToken(current, token);
            }
         }

         return current;
      }
   }

   private Object readByIndexToken(Object current, String indexToken) throws JSONPointerException {
      Object var10000;
      try {
         int index = Integer.parseInt(indexToken);
         JSONArray currentArr = (JSONArray)current;
         if (index >= currentArr.length()) {
            throw new JSONPointerException(String.format("index %s is out of bounds - the array has %d elements", indexToken, currentArr.length()));
         }

         try {
            var10000 = currentArr.get(index);
         } catch (JSONException var6) {
            throw new JSONPointerException("Error reading value at index position " + index, var6);
         }
      } catch (NumberFormatException var7) {
         throw new JSONPointerException(String.format("%s is not an array index", indexToken), var7);
      }

      return var10000;
   }

   public String toString() {
      StringBuilder rval = new StringBuilder("");
      Iterator var2 = this.refTokens.iterator();

      while(var2.hasNext()) {
         String token = (String)var2.next();
         rval.append('/').append(this.escape(token));
      }

      return rval.toString();
   }

   private String escape(String token) {
      return token.replace("~", "~0").replace("/", "~1").replace("\\", "\\\\").replace("\"", "\\\"");
   }

   public String toURIFragment() {
      try {
         StringBuilder rval = new StringBuilder("#");
         Iterator var2 = this.refTokens.iterator();

         while(var2.hasNext()) {
            String token = (String)var2.next();
            rval.append('/').append(URLEncoder.encode(token, "utf-8"));
         }

         String var10000 = rval.toString();
         return var10000;
      } catch (UnsupportedEncodingException var4) {
         throw new RuntimeException(var4);
      }
   }
}
