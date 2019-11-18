package com.google.api.client.http;

import com.google.api.client.repackaged.com.google.common.base.Splitter;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

public class UriTemplate {
   static final Map COMPOSITE_PREFIXES = new HashMap();
   private static final String COMPOSITE_NON_EXPLODE_JOINER = ",";

   static UriTemplate$CompositeOutput getCompositeOutput(String propertyName) {
      UriTemplate$CompositeOutput compositeOutput = (UriTemplate$CompositeOutput)COMPOSITE_PREFIXES.get(propertyName.charAt(0));
      return compositeOutput == null ? UriTemplate$CompositeOutput.SIMPLE : compositeOutput;
   }

   private static Map getMap(Object obj) {
      Map map = new LinkedHashMap();
      Iterator var2 = Data.mapOf(obj).entrySet().iterator();

      while(var2.hasNext()) {
         Entry entry = (Entry)var2.next();
         Object value = entry.getValue();
         if (value != null && !Data.isNull(value)) {
            map.put(entry.getKey(), value);
         }
      }

      return map;
   }

   public static String expand(String baseUrl, String uriTemplate, Object parameters, boolean addUnusedParamsAsQueryParams) {
      String pathUri;
      if (uriTemplate.startsWith("/")) {
         GenericUrl url = new GenericUrl(baseUrl);
         url.setRawPath((String)null);
         pathUri = url.build() + uriTemplate;
      } else if (!uriTemplate.startsWith("http://") && !uriTemplate.startsWith("https://")) {
         pathUri = baseUrl + uriTemplate;
      } else {
         pathUri = uriTemplate;
      }

      return expand(pathUri, parameters, addUnusedParamsAsQueryParams);
   }

   public static String expand(String pathUri, Object parameters, boolean addUnusedParamsAsQueryParams) {
      Map variableMap = getMap(parameters);
      StringBuilder pathBuf = new StringBuilder();
      int cur = 0;
      int length = pathUri.length();

      label85:
      while(cur < length) {
         int next = pathUri.indexOf(123, cur);
         if (next == -1) {
            if (cur == 0 && !addUnusedParamsAsQueryParams) {
               return pathUri;
            }

            pathBuf.append(pathUri.substring(cur));
            break;
         }

         pathBuf.append(pathUri.substring(cur, next));
         int close = pathUri.indexOf(125, next + 2);
         cur = close + 1;
         String templates = pathUri.substring(next + 1, close);
         UriTemplate$CompositeOutput compositeOutput = getCompositeOutput(templates);
         ListIterator templateIterator = Splitter.on(',').splitToList(templates).listIterator();
         boolean isFirstParameter = true;

         while(true) {
            boolean containsExplodeModifier;
            String varName;
            Object value;
            do {
               if (!templateIterator.hasNext()) {
                  continue label85;
               }

               String template = (String)templateIterator.next();
               containsExplodeModifier = template.endsWith("*");
               int varNameStartIndex = templateIterator.nextIndex() == 1 ? compositeOutput.getVarNameStartIndex() : 0;
               int varNameEndIndex = template.length();
               if (containsExplodeModifier) {
                  --varNameEndIndex;
               }

               varName = template.substring(varNameStartIndex, varNameEndIndex);
               value = variableMap.remove(varName);
            } while(value == null);

            if (!isFirstParameter) {
               pathBuf.append(compositeOutput.getExplodeJoiner());
            } else {
               pathBuf.append(compositeOutput.getOutputPrefix());
               isFirstParameter = false;
            }

            Iterator iterator;
            if (value instanceof Iterator) {
               iterator = (Iterator)value;
               value = getListPropertyValue(varName, iterator, containsExplodeModifier, compositeOutput);
            } else if (!(value instanceof Iterable) && !value.getClass().isArray()) {
               if (value.getClass().isEnum()) {
                  String name = FieldInfo.of((Enum)value).getName();
                  if (name != null) {
                     if (compositeOutput.requiresVarAssignment()) {
                        value = String.format("%s=%s", varName, value);
                     }

                     value = CharEscapers.escapeUriPath(value.toString());
                  }
               } else if (!Data.isValueOfPrimitiveType(value)) {
                  Map map = getMap(value);
                  value = getMapPropertyValue(varName, map, containsExplodeModifier, compositeOutput);
               } else {
                  if (compositeOutput.requiresVarAssignment()) {
                     value = String.format("%s=%s", varName, value);
                  }

                  if (compositeOutput.getReservedExpansion()) {
                     value = CharEscapers.escapeUriPathWithoutReserved(value.toString());
                  } else {
                     value = CharEscapers.escapeUriPath(value.toString());
                  }
               }
            } else {
               iterator = Types.iterableOf(value).iterator();
               value = getListPropertyValue(varName, iterator, containsExplodeModifier, compositeOutput);
            }

            pathBuf.append(value);
         }
      }

      if (addUnusedParamsAsQueryParams) {
         GenericUrl.addQueryParams(variableMap.entrySet(), pathBuf);
      }

      return pathBuf.toString();
   }

   private static String getListPropertyValue(String varName, Iterator iterator, boolean containsExplodeModifier, UriTemplate$CompositeOutput compositeOutput) {
      if (!iterator.hasNext()) {
         return "";
      } else {
         StringBuilder retBuf = new StringBuilder();
         String joiner;
         if (containsExplodeModifier) {
            joiner = compositeOutput.getExplodeJoiner();
         } else {
            joiner = ",";
            if (compositeOutput.requiresVarAssignment()) {
               retBuf.append(CharEscapers.escapeUriPath(varName));
               retBuf.append("=");
            }
         }

         while(iterator.hasNext()) {
            if (containsExplodeModifier && compositeOutput.requiresVarAssignment()) {
               retBuf.append(CharEscapers.escapeUriPath(varName));
               retBuf.append("=");
            }

            retBuf.append(compositeOutput.getEncodedValue(iterator.next().toString()));
            if (iterator.hasNext()) {
               retBuf.append(joiner);
            }
         }

         return retBuf.toString();
      }
   }

   private static String getMapPropertyValue(String varName, Map map, boolean containsExplodeModifier, UriTemplate$CompositeOutput compositeOutput) {
      if (map.isEmpty()) {
         return "";
      } else {
         StringBuilder retBuf = new StringBuilder();
         String joiner;
         String mapElementsJoiner;
         if (containsExplodeModifier) {
            joiner = compositeOutput.getExplodeJoiner();
            mapElementsJoiner = "=";
         } else {
            joiner = ",";
            mapElementsJoiner = ",";
            if (compositeOutput.requiresVarAssignment()) {
               retBuf.append(CharEscapers.escapeUriPath(varName));
               retBuf.append("=");
            }
         }

         Iterator mapIterator = map.entrySet().iterator();

         while(mapIterator.hasNext()) {
            Entry entry = (Entry)mapIterator.next();
            String encodedKey = compositeOutput.getEncodedValue((String)entry.getKey());
            String encodedValue = compositeOutput.getEncodedValue(entry.getValue().toString());
            retBuf.append(encodedKey);
            retBuf.append(mapElementsJoiner);
            retBuf.append(encodedValue);
            if (mapIterator.hasNext()) {
               retBuf.append(joiner);
            }
         }

         return retBuf.toString();
      }
   }

   static {
      UriTemplate$CompositeOutput.values();
   }
}
