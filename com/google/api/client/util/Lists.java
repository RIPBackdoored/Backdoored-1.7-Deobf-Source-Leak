package com.google.api.client.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class Lists {
   public static ArrayList newArrayList() {
      return new ArrayList();
   }

   public static ArrayList newArrayListWithCapacity(int initialArraySize) {
      return new ArrayList(initialArraySize);
   }

   public static ArrayList newArrayList(Iterable elements) {
      return elements instanceof Collection ? new ArrayList(Collections2.cast(elements)) : newArrayList(elements.iterator());
   }

   public static ArrayList newArrayList(Iterator elements) {
      ArrayList list = newArrayList();

      while(elements.hasNext()) {
         list.add(elements.next());
      }

      return list;
   }

   private Lists() {
   }
}
