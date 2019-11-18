package com.google.api.client.util;

import java.util.HashSet;
import java.util.TreeSet;

public final class Sets {
   public static HashSet newHashSet() {
      return new HashSet();
   }

   public static TreeSet newTreeSet() {
      return new TreeSet();
   }

   private Sets() {
   }
}
