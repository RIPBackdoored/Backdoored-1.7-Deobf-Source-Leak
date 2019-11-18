package com.google.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

public class FieldInfo {
   private static final Map CACHE = new WeakHashMap();
   private final boolean isPrimitive;
   private final Field field;
   private final String name;

   public static FieldInfo of(Enum enumValue) {
      FieldInfo var10000;
      try {
         FieldInfo result = of(enumValue.getClass().getField(enumValue.name()));
         Preconditions.checkArgument(result != null, "enum constant missing @Value or @NullValue annotation: %s", enumValue);
         var10000 = result;
      } catch (NoSuchFieldException var2) {
         throw new RuntimeException(var2);
      }

      return var10000;
   }

   public static FieldInfo of(Field field) {
      if (field == null) {
         return null;
      } else {
         synchronized(CACHE) {
            FieldInfo fieldInfo = (FieldInfo)CACHE.get(field);
            boolean isEnumContant = field.isEnumConstant();
            FieldInfo var10000;
            if (fieldInfo == null && (isEnumContant || !Modifier.isStatic(field.getModifiers()))) {
               String fieldName;
               if (isEnumContant) {
                  Value value = (Value)field.getAnnotation(Value.class);
                  if (value != null) {
                     fieldName = value.value();
                  } else {
                     NullValue nullValue = (NullValue)field.getAnnotation(NullValue.class);
                     if (nullValue == null) {
                        var10000 = null;
                        return var10000;
                     }

                     fieldName = null;
                  }
               } else {
                  Key key = (Key)field.getAnnotation(Key.class);
                  if (key == null) {
                     var10000 = null;
                     return var10000;
                  }

                  fieldName = key.value();
                  field.setAccessible(true);
               }

               if ("##default".equals(fieldName)) {
                  fieldName = field.getName();
               }

               fieldInfo = new FieldInfo(field, fieldName);
               CACHE.put(field, fieldInfo);
            }

            var10000 = fieldInfo;
            return var10000;
         }
      }
   }

   FieldInfo(Field field, String name) {
      this.field = field;
      this.name = name == null ? null : name.intern();
      this.isPrimitive = Data.isPrimitive(this.getType());
   }

   public Field getField() {
      return this.field;
   }

   public String getName() {
      return this.name;
   }

   public Class getType() {
      return this.field.getType();
   }

   public Type getGenericType() {
      return this.field.getGenericType();
   }

   public boolean isFinal() {
      return Modifier.isFinal(this.field.getModifiers());
   }

   public boolean isPrimitive() {
      return this.isPrimitive;
   }

   public Object getValue(Object obj) {
      return getFieldValue(this.field, obj);
   }

   public void setValue(Object obj, Object value) {
      setFieldValue(this.field, obj, value);
   }

   public ClassInfo getClassInfo() {
      return ClassInfo.of(this.field.getDeclaringClass());
   }

   public Enum enumValue() {
      return Enum.valueOf(this.field.getDeclaringClass(), this.field.getName());
   }

   public static Object getFieldValue(Field field, Object obj) {
      Object var10000;
      try {
         var10000 = field.get(obj);
      } catch (IllegalAccessException var3) {
         throw new IllegalArgumentException(var3);
      }

      return var10000;
   }

   public static void setFieldValue(Field field, Object obj, Object value) {
      if (Modifier.isFinal(field.getModifiers())) {
         Object finalValue = getFieldValue(field, obj);
         if (value == null) {
            if (finalValue != null) {
               throw new IllegalArgumentException("expected final value <" + finalValue + "> but was <" + value + "> on " + field.getName() + " field in " + obj.getClass().getName());
            }
         } else if (!value.equals(finalValue)) {
            throw new IllegalArgumentException("expected final value <" + finalValue + "> but was <" + value + "> on " + field.getName() + " field in " + obj.getClass().getName());
         }
      } else {
         try {
            field.set(obj, value);
         } catch (SecurityException var4) {
            throw new IllegalArgumentException(var4);
         } catch (IllegalAccessException var5) {
            throw new IllegalArgumentException(var5);
         }
      }

   }
}
