package com.google.api.client.repackaged.com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import javax.annotation.Nullable;

public final class MoreObjects$ToStringHelper {
   private final String className;
   private final MoreObjects$ToStringHelper$ValueHolder holderHead;
   private MoreObjects$ToStringHelper$ValueHolder holderTail;
   private boolean omitNullValues;

   private MoreObjects$ToStringHelper(String className) {
      this.holderHead = new MoreObjects$ToStringHelper$ValueHolder((MoreObjects$1)null);
      this.holderTail = this.holderHead;
      this.omitNullValues = false;
      this.className = (String)Preconditions.checkNotNull(className);
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper omitNullValues() {
      this.omitNullValues = true;
      return this;
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper add(String name, @Nullable Object value) {
      return this.addHolder(name, value);
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper add(String name, boolean value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper add(String name, char value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper add(String name, double value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper add(String name, float value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper add(String name, int value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper add(String name, long value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper addValue(@Nullable Object value) {
      return this.addHolder(value);
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper addValue(boolean value) {
      return this.addHolder(String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper addValue(char value) {
      return this.addHolder(String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper addValue(double value) {
      return this.addHolder(String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper addValue(float value) {
      return this.addHolder(String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper addValue(int value) {
      return this.addHolder(String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public MoreObjects$ToStringHelper addValue(long value) {
      return this.addHolder(String.valueOf(value));
   }

   public String toString() {
      boolean omitNullValuesSnapshot = this.omitNullValues;
      String nextSeparator = "";
      StringBuilder builder = (new StringBuilder(32)).append(this.className).append('{');

      for(MoreObjects$ToStringHelper$ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
         Object value = valueHolder.value;
         if (!omitNullValuesSnapshot || value != null) {
            builder.append(nextSeparator);
            nextSeparator = ", ";
            if (valueHolder.name != null) {
               builder.append(valueHolder.name).append('=');
            }

            if (value != null && value.getClass().isArray()) {
               Object[] objectArray = new Object[]{value};
               String arrayString = Arrays.deepToString(objectArray);
               builder.append(arrayString, 1, arrayString.length() - 1);
            } else {
               builder.append(value);
            }
         }
      }

      return builder.append('}').toString();
   }

   private MoreObjects$ToStringHelper$ValueHolder addHolder() {
      MoreObjects$ToStringHelper$ValueHolder valueHolder = new MoreObjects$ToStringHelper$ValueHolder((MoreObjects$1)null);
      this.holderTail = this.holderTail.next = valueHolder;
      return valueHolder;
   }

   private MoreObjects$ToStringHelper addHolder(@Nullable Object value) {
      MoreObjects$ToStringHelper$ValueHolder valueHolder = this.addHolder();
      valueHolder.value = value;
      return this;
   }

   private MoreObjects$ToStringHelper addHolder(String name, @Nullable Object value) {
      MoreObjects$ToStringHelper$ValueHolder valueHolder = this.addHolder();
      valueHolder.value = value;
      valueHolder.name = (String)Preconditions.checkNotNull(name);
      return this;
   }

   // $FF: synthetic method
   MoreObjects$ToStringHelper(String x0, MoreObjects$1 x1) {
      this(x0);
   }
}
