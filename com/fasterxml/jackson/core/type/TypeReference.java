package com.fasterxml.jackson.core.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference implements Comparable {
   protected final Type _type;

   protected TypeReference() {
      Type superClass = this.getClass().getGenericSuperclass();
      if (superClass instanceof Class) {
         throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
      } else {
         this._type = ((ParameterizedType)superClass).getActualTypeArguments()[0];
      }
   }

   public Type getType() {
      return this._type;
   }

   public int compareTo(TypeReference o) {
      return 0;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compareTo(Object x0) {
      return this.compareTo((TypeReference)x0);
   }
}
