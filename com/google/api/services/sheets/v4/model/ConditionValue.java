package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class ConditionValue extends GenericJson {
   @Key
   private String relativeDate;
   @Key
   private String userEnteredValue;

   public String getRelativeDate() {
      return this.relativeDate;
   }

   public ConditionValue setRelativeDate(String var1) {
      this.relativeDate = var1;
      return this;
   }

   public String getUserEnteredValue() {
      return this.userEnteredValue;
   }

   public ConditionValue setUserEnteredValue(String var1) {
      this.userEnteredValue = var1;
      return this;
   }

   public ConditionValue set(String var1, Object var2) {
      return (ConditionValue)super.set(var1, var2);
   }

   public ConditionValue clone() {
      return (ConditionValue)super.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object clone() throws CloneNotSupportedException {
      return this.clone();
   }
}
