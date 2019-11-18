package com.google.api.client.util;

import java.util.ArrayList;

class ArrayValueMap$ArrayValue {
   final Class componentType;
   final ArrayList values = new ArrayList();

   ArrayValueMap$ArrayValue(Class componentType) {
      this.componentType = componentType;
   }

   Object toArray() {
      return Types.toArray(this.values, this.componentType);
   }

   void addValue(Class componentType, Object value) {
      Preconditions.checkArgument(componentType == this.componentType);
      this.values.add(value);
   }
}
