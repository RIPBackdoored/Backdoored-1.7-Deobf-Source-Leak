package com.google.api.client.http;

import com.google.api.client.util.ArrayValueMap;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Throwables;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UrlEncodedParser implements ObjectParser {
   public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
   public static final String MEDIA_TYPE;

   public static void parse(String content, Object data) {
      if (content != null) {
         try {
            parse((Reader)(new StringReader(content)), data);
         } catch (IOException var3) {
            throw Throwables.propagate(var3);
         }

      }
   }

   public static void parse(Reader reader, Object data) throws IOException {
      Class clazz = data.getClass();
      ClassInfo classInfo = ClassInfo.of(clazz);
      List context = Arrays.asList(clazz);
      GenericData genericData = GenericData.class.isAssignableFrom(clazz) ? (GenericData)data : null;
      Map map = Map.class.isAssignableFrom(clazz) ? (Map)data : null;
      ArrayValueMap arrayValueMap = new ArrayValueMap(data);
      StringWriter nameWriter = new StringWriter();
      StringWriter valueWriter = new StringWriter();
      boolean readingName = true;

      while(true) {
         while(true) {
            int read = reader.read();
            switch(read) {
            case -1:
            case 38:
               String name = CharEscapers.decodeUri(nameWriter.toString());
               if (name.length() != 0) {
                  String stringValue = CharEscapers.decodeUri(valueWriter.toString());
                  FieldInfo fieldInfo = classInfo.getFieldInfo(name);
                  if (fieldInfo != null) {
                     Type type = Data.resolveWildcardTypeOrTypeVariable(context, fieldInfo.getGenericType());
                     if (Types.isArray(type)) {
                        Class rawArrayComponentType = Types.getRawArrayComponentType(context, Types.getArrayComponentType(type));
                        arrayValueMap.put(fieldInfo.getField(), rawArrayComponentType, parseValue(rawArrayComponentType, context, stringValue));
                     } else if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType(context, type), Iterable.class)) {
                        Collection collection = (Collection)fieldInfo.getValue(data);
                        if (collection == null) {
                           collection = Data.newCollectionInstance(type);
                           fieldInfo.setValue(data, collection);
                        }

                        Type subFieldType = type == Object.class ? null : Types.getIterableParameter(type);
                        collection.add(parseValue(subFieldType, context, stringValue));
                     } else {
                        fieldInfo.setValue(data, parseValue(type, context, stringValue));
                     }
                  } else if (map != null) {
                     ArrayList listValue = (ArrayList)map.get(name);
                     if (listValue == null) {
                        listValue = new ArrayList();
                        if (genericData != null) {
                           genericData.set(name, listValue);
                        } else {
                           map.put(name, listValue);
                        }
                     }

                     listValue.add(stringValue);
                  }
               }

               readingName = true;
               nameWriter = new StringWriter();
               valueWriter = new StringWriter();
               if (read == -1) {
                  arrayValueMap.setValues();
                  return;
               }
               break;
            case 61:
               if (readingName) {
                  readingName = false;
               } else {
                  valueWriter.write(read);
               }
               break;
            default:
               if (readingName) {
                  nameWriter.write(read);
               } else {
                  valueWriter.write(read);
               }
            }
         }
      }
   }

   private static Object parseValue(Type valueType, List context, String value) {
      Type resolved = Data.resolveWildcardTypeOrTypeVariable(context, valueType);
      return Data.parsePrimitiveValue(resolved, value);
   }

   public Object parseAndClose(InputStream in, Charset charset, Class dataClass) throws IOException {
      InputStreamReader r = new InputStreamReader(in, charset);
      return this.parseAndClose(r, (Class)dataClass);
   }

   public Object parseAndClose(InputStream in, Charset charset, Type dataType) throws IOException {
      InputStreamReader r = new InputStreamReader(in, charset);
      return this.parseAndClose(r, (Type)dataType);
   }

   public Object parseAndClose(Reader reader, Class dataClass) throws IOException {
      return this.parseAndClose(reader, (Type)dataClass);
   }

   public Object parseAndClose(Reader reader, Type dataType) throws IOException {
      Preconditions.checkArgument(dataType instanceof Class, "dataType has to be of type Class<?>");
      Object newInstance = Types.newInstance((Class)dataType);
      parse((Reader)(new BufferedReader(reader)), newInstance);
      return newInstance;
   }

   static {
      MEDIA_TYPE = (new HttpMediaType("application/x-www-form-urlencoded")).setCharsetParameter(Charsets.UTF_8).build();
   }
}
