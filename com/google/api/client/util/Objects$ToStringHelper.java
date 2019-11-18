package com.google.api.client.util;

public final class Objects$ToStringHelper {
   private final String className;
   private Objects$ToStringHelper$ValueHolder holderHead = new Objects$ToStringHelper$ValueHolder((Objects$1)null);
   private Objects$ToStringHelper$ValueHolder holderTail;
   private boolean omitNullValues;

   Objects$ToStringHelper(String className) {
      this.holderTail = this.holderHead;
      this.className = className;
   }

   public Objects$ToStringHelper omitNullValues() {
      this.omitNullValues = true;
      return this;
   }

   public Objects$ToStringHelper add(String name, Object value) {
      return this.addHolder(name, value);
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

   private Objects$ToStringHelper addHolder(String name, Object value) {
      Objects$ToStringHelper$ValueHolder valueHolder = this.addHolder();
      valueHolder.value = value;
      valueHolder.name = (String)Preconditions.checkNotNull(name);
      return this;
   }
}
