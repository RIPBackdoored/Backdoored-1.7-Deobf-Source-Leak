package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class ArrayValueMap {
   private final Map keyMap = ArrayMap.create();
   private final Map fieldMap = ArrayMap.create();
   private final Object destination;

   public ArrayValueMap(Object destination) {
      this.destination = destination;
   }

   public void setValues() {
      Iterator var1 = this.keyMap.entrySet().iterator();

      Entry entry;
      while(var1.hasNext()) {
         entry = (Entry)var1.next();
         Map destinationMap = (Map)this.destination;
         destinationMap.put(entry.getKey(), ((ArrayValueMap$ArrayValue)entry.getValue()).toArray());
      }

      var1 = this.fieldMap.entrySet().iterator();

      while(var1.hasNext()) {
         entry = (Entry)var1.next();
         FieldInfo.setFieldValue((Field)entry.getKey(), this.destination, ((ArrayValueMap$ArrayValue)entry.getValue()).toArray());
      }

   }

   public void put(Field field, Class arrayComponentType, Object value) {
      ArrayValueMap$ArrayValue arrayValue = (ArrayValueMap$ArrayValue)this.fieldMap.get(field);
      if (arrayValue == null) {
         arrayValue = new ArrayValueMap$ArrayValue(arrayComponentType);
         this.fieldMap.put(field, arrayValue);
      }

      arrayValue.addValue(arrayComponentType, value);
   }

   public void put(String keyName, Class arrayComponentType, Object value) {
      ArrayValueMap$ArrayValue arrayValue = (ArrayValueMap$ArrayValue)this.keyMap.get(keyName);
      if (arrayValue == null) {
         arrayValue = new ArrayValueMap$ArrayValue(arrayComponentType);
         this.keyMap.put(keyName, arrayValue);
      }

      arrayValue.addValue(arrayComponentType, value);
   }
}
