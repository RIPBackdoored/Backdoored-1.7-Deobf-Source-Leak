package org.yaml.snakeyaml.util;

import java.util.Collections;
import java.util.List;

public class ArrayUtils {
   private ArrayUtils() {
   }

   public static List toUnmodifiableList(Object... elements) {
      return (List)(elements.length == 0 ? Collections.emptyList() : new ArrayUtils$UnmodifiableArrayList(elements));
   }

   public static List toUnmodifiableCompositeList(Object[] array1, Object[] array2) {
      Object result;
      if (array1.length == 0) {
         result = toUnmodifiableList(array2);
      } else if (array2.length == 0) {
         result = toUnmodifiableList(array1);
      } else {
         result = new ArrayUtils$CompositeUnmodifiableArrayList(array1, array2);
      }

      return (List)result;
   }
}
