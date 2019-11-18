package com.google.api.client.json;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class JsonParser {
   private static WeakHashMap cachedTypemapFields = new WeakHashMap();
   private static final Lock lock = new ReentrantLock();

   public abstract JsonFactory getFactory();

   public abstract void close() throws IOException;

   public abstract JsonToken nextToken() throws IOException;

   public abstract JsonToken getCurrentToken();

   public abstract String getCurrentName() throws IOException;

   public abstract JsonParser skipChildren() throws IOException;

   public abstract String getText() throws IOException;

   public abstract byte getByteValue() throws IOException;

   public abstract short getShortValue() throws IOException;

   public abstract int getIntValue() throws IOException;

   public abstract float getFloatValue() throws IOException;

   public abstract long getLongValue() throws IOException;

   public abstract double getDoubleValue() throws IOException;

   public abstract BigInteger getBigIntegerValue() throws IOException;

   public abstract BigDecimal getDecimalValue() throws IOException;

   public final Object parseAndClose(Class destinationClass) throws IOException {
      return this.parseAndClose((Class)destinationClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final Object parseAndClose(Class destinationClass, CustomizeJsonParser customizeParser) throws IOException {
      Object var3;
      try {
         var3 = this.parse(destinationClass, customizeParser);
      } finally {
         this.close();
      }

      return var3;
   }

   public final void skipToKey(String keyToFind) throws IOException {
      this.skipToKey(Collections.singleton(keyToFind));
   }

   public final String skipToKey(Set keysToFind) throws IOException {
      for(JsonToken curToken = this.startParsingObjectOrArray(); curToken == JsonToken.FIELD_NAME; curToken = this.nextToken()) {
         String key = this.getText();
         this.nextToken();
         if (keysToFind.contains(key)) {
            return key;
         }

         this.skipChildren();
      }

      return null;
   }

   private JsonToken startParsing() throws IOException {
      JsonToken currentToken = this.getCurrentToken();
      if (currentToken == null) {
         currentToken = this.nextToken();
      }

      Preconditions.checkArgument(currentToken != null, "no JSON input found");
      return currentToken;
   }

   private JsonToken startParsingObjectOrArray() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public final void parseAndClose(Object destination) throws IOException {
      this.parseAndClose((Object)destination, (CustomizeJsonParser)null);
   }

   @Beta
   public final void parseAndClose(Object destination, CustomizeJsonParser customizeParser) throws IOException {
      try {
         this.parse(destination, customizeParser);
      } finally {
         this.close();
      }

   }

   public final Object parse(Class destinationClass) throws IOException {
      return this.parse((Class)destinationClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final Object parse(Class destinationClass, CustomizeJsonParser customizeParser) throws IOException {
      Object result = this.parse(destinationClass, false, customizeParser);
      return result;
   }

   public Object parse(Type dataType, boolean close) throws IOException {
      return this.parse(dataType, close, (CustomizeJsonParser)null);
   }

   @Beta
   public Object parse(Type dataType, boolean close, CustomizeJsonParser customizeParser) throws IOException {
      Object var4;
      try {
         if (!Void.class.equals(dataType)) {
            this.startParsing();
         }

         var4 = this.parseValue((Field)null, dataType, new ArrayList(), (Object)null, customizeParser, true);
      } finally {
         if (close) {
            this.close();
         }

      }

      return var4;
   }

   public final void parse(Object destination) throws IOException {
      this.parse((Object)destination, (CustomizeJsonParser)null);
   }

   @Beta
   public final void parse(Object destination, CustomizeJsonParser customizeParser) throws IOException {
      ArrayList context = new ArrayList();
      context.add(destination.getClass());
      this.parse(context, destination, customizeParser);
   }

   private void parse(ArrayList context, Object destination, CustomizeJsonParser customizeParser) throws IOException {
      if (destination instanceof GenericJson) {
         ((GenericJson)destination).setFactory(this.getFactory());
      }

      JsonToken curToken = this.startParsingObjectOrArray();
      Class destinationClass = destination.getClass();
      ClassInfo classInfo = ClassInfo.of(destinationClass);
      boolean isGenericData = GenericData.class.isAssignableFrom(destinationClass);
      if (!isGenericData && Map.class.isAssignableFrom(destinationClass)) {
         Map destinationMap = (Map)destination;
         this.parseMap((Field)null, destinationMap, Types.getMapValueParameter(destinationClass), context, customizeParser);
      } else {
         for(; curToken == JsonToken.FIELD_NAME; curToken = this.nextToken()) {
            String key = this.getText();
            this.nextToken();
            if (customizeParser != null && customizeParser.stopAt(destination, key)) {
               return;
            }

            FieldInfo fieldInfo = classInfo.getFieldInfo(key);
            if (fieldInfo != null) {
               if (fieldInfo.isFinal() && !fieldInfo.isPrimitive()) {
                  throw new IllegalArgumentException("final array/object fields are not supported");
               }

               Field field = fieldInfo.getField();
               int contextSize = context.size();
               context.add(field.getGenericType());
               Object fieldValue = this.parseValue(field, fieldInfo.getGenericType(), context, destination, customizeParser, true);
               context.remove(contextSize);
               fieldInfo.setValue(destination, fieldValue);
            } else if (isGenericData) {
               GenericData object = (GenericData)destination;
               object.set(key, this.parseValue((Field)null, (Type)null, context, destination, customizeParser, true));
            } else {
               if (customizeParser != null) {
                  customizeParser.handleUnrecognizedKey(destination, key);
               }

               this.skipChildren();
            }
         }

      }
   }

   public final Collection parseArrayAndClose(Class destinationCollectionClass, Class destinationItemClass) throws IOException {
      return this.parseArrayAndClose((Class)destinationCollectionClass, destinationItemClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final Collection parseArrayAndClose(Class destinationCollectionClass, Class destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
      Collection var4;
      try {
         var4 = this.parseArray(destinationCollectionClass, destinationItemClass, customizeParser);
      } finally {
         this.close();
      }

      return var4;
   }

   public final void parseArrayAndClose(Collection destinationCollection, Class destinationItemClass) throws IOException {
      this.parseArrayAndClose((Collection)destinationCollection, destinationItemClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final void parseArrayAndClose(Collection destinationCollection, Class destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
      try {
         this.parseArray(destinationCollection, destinationItemClass, customizeParser);
      } finally {
         this.close();
      }

   }

   public final Collection parseArray(Class destinationCollectionClass, Class destinationItemClass) throws IOException {
      return this.parseArray((Class)destinationCollectionClass, destinationItemClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final Collection parseArray(Class destinationCollectionClass, Class destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
      Collection destinationCollection = Data.newCollectionInstance(destinationCollectionClass);
      this.parseArray(destinationCollection, destinationItemClass, customizeParser);
      return destinationCollection;
   }

   public final void parseArray(Collection destinationCollection, Class destinationItemClass) throws IOException {
      this.parseArray((Collection)destinationCollection, destinationItemClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final void parseArray(Collection destinationCollection, Class destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
      this.parseArray((Field)null, destinationCollection, destinationItemClass, new ArrayList(), customizeParser);
   }

   private void parseArray(Field fieldContext, Collection destinationCollection, Type destinationItemType, ArrayList context, CustomizeJsonParser customizeParser) throws IOException {
      for(JsonToken curToken = this.startParsingObjectOrArray(); curToken != JsonToken.END_ARRAY; curToken = this.nextToken()) {
         Object parsedValue = this.parseValue(fieldContext, destinationItemType, context, destinationCollection, customizeParser, true);
         destinationCollection.add(parsedValue);
      }

   }

   private void parseMap(Field fieldContext, Map destinationMap, Type valueType, ArrayList context, CustomizeJsonParser customizeParser) throws IOException {
      for(JsonToken curToken = this.startParsingObjectOrArray(); curToken == JsonToken.FIELD_NAME; curToken = this.nextToken()) {
         String key = this.getText();
         this.nextToken();
         if (customizeParser != null && customizeParser.stopAt(destinationMap, key)) {
            return;
         }

         Object value = this.parseValue(fieldContext, valueType, context, destinationMap, customizeParser, true);
         destinationMap.put(key, value);
      }

   }

   private final Object parseValue(Field fieldContext, Type valueType, ArrayList context, Object destination, CustomizeJsonParser customizeParser, boolean handlePolymorphic) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private static Field getCachedTypemapFieldFor(Class key) {
      if (key == null) {
         return null;
      } else {
         lock.lock();

         Field var16;
         try {
            Field value;
            if (cachedTypemapFields.containsKey(key)) {
               value = (Field)cachedTypemapFields.get(key);
               return value;
            }

            value = null;
            Collection fieldInfos = ClassInfo.of(key).getFieldInfos();
            Iterator var3 = fieldInfos.iterator();

            while(var3.hasNext()) {
               FieldInfo fieldInfo = (FieldInfo)var3.next();
               Field field = fieldInfo.getField();
               JsonPolymorphicTypeMap typemapAnnotation = (JsonPolymorphicTypeMap)field.getAnnotation(JsonPolymorphicTypeMap.class);
               if (typemapAnnotation != null) {
                  Preconditions.checkArgument(value == null, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", key);
                  Preconditions.checkArgument(Data.isPrimitive(field.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", key, field.getType());
                  value = field;
                  JsonPolymorphicTypeMap$TypeDef[] typeDefs = typemapAnnotation.typeDefinitions();
                  HashSet typeDefKeys = Sets.newHashSet();
                  Preconditions.checkArgument(typeDefs.length > 0, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                  JsonPolymorphicTypeMap$TypeDef[] var9 = typeDefs;
                  int var10 = typeDefs.length;

                  for(int var11 = 0; var11 < var10; ++var11) {
                     JsonPolymorphicTypeMap$TypeDef typeDef = var9[var11];
                     Preconditions.checkArgument(typeDefKeys.add(typeDef.key()), "Class contains two @TypeDef annotations with identical key: %s", typeDef.key());
                  }
               }
            }

            cachedTypemapFields.put(key, value);
            var16 = value;
         } finally {
            lock.unlock();
         }

         return var16;
      }
   }
}
