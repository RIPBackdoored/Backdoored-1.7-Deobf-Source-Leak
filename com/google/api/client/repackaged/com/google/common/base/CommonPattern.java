package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract class CommonPattern {
   abstract CommonMatcher matcher(CharSequence var1);

   abstract String pattern();

   abstract int flags();

   public abstract String toString();

   public abstract int hashCode();

   public abstract boolean equals(Object var1);
}
