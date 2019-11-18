package com.google.api.client.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public final class Maps {
   public static HashMap newHashMap() {
      return new HashMap();
   }

   public static LinkedHashMap newLinkedHashMap() {
      return new LinkedHashMap();
   }

   public static TreeMap newTreeMap() {
      return new TreeMap();
   }

   private Maps() {
   }
}
