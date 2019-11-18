package com.google.api.client.repackaged.com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

/** @deprecated */
@Deprecated
public final class Objects$ToStringHelper {
   private final String className;
   private final Objects$ToStringHelper$ValueHolder holderHead;
   private Objects$ToStringHelper$ValueHolder holderTail;
   private boolean omitNullValues;

   private Objects$ToStringHelper(String className) {
      this.holderHead = new Objects$ToStringHelper$ValueHolder((Objects$1)null);
      this.holderTail = this.holderHead;
      this.omitNullValues = false;
      this.className = (String)Preconditions.checkNotNull(className);
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper omitNullValues() {
      this.omitNullValues = true;
      return this;
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper add(String name, @Nullable Object value) {
      return this.addHolder(name, value);
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper add(String name, boolean value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper add(String name, char value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper add(String name, double value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper add(String name, float value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper add(String name, int value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper add(String name, long value) {
      return this.addHolder(name, String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper addValue(@Nullable Object value) {
      return this.addHolder(value);
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper addValue(boolean value) {
      return this.addHolder(String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper addValue(char value) {
      return this.addHolder(String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper addValue(double value) {
      return this.addHolder(String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper addValue(float value) {
      return this.addHolder(String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper addValue(int value) {
      return this.addHolder(String.valueOf(value));
   }

   @CanIgnoreReturnValue
   public Objects$ToStringHelper addValue(long value) {
      return this.addHolder(String.valueOf(value));
   }

   public String toString() {
      boolean omitNullValuesSnapshot = this.omitNullValues;
      String nextSeparator = "";
      StringBuilder builder = (new StringBuilder(32)).append(this.className).append('{');

      for(Objects$ToStringHelper$ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
         if (!omitNullValuesSnapshot || valueHolder.value != null) {
            builder.append(nextSeparator);
            nextSeparator = ", ";
            if (valueHolder.name != null) {
               builder.append(valueHolder.name).append('=');
            }

            builder.append(valueHolder.value);
         }
      }

      return builder.append('}').toString();
   }

   private Objects$ToStringHelper$ValueHolder addHolder() {
      Objects$ToStringHelper$ValueHolder valueHolder = new Objects$ToStringHelper$ValueHolder((Objects$1)null);
      this.holderTail = this.holderTail.next = valueHolder;
      return valueHolder;
   }

   private Objects$ToStringHelper addHolder(@Nullable Object value) {
      Objects$ToStringHelper$ValueHolder valueHolder = this.addHolder();
      valueHolder.value = value;
      return this;
   }

   private Objects$ToStringHelper addHolder(String name, @Nullable Object value) {
      Objects$ToStringHelper$ValueHolder valueHolder = this.addHolder();
      valueHolder.value = value;
      valueHolder.name = (String)Preconditions.checkNotNull(name);
      return this;
   }

   // $FF: synthetic method
   Objects$ToStringHelper(String x0, Objects$1 x1) {
      this(x0);
   }
}
