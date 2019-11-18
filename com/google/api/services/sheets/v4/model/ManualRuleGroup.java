package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class ManualRuleGroup extends GenericJson {
   @Key
   private ExtendedValue groupName;
   @Key
   private List items;

   public ExtendedValue getGroupName() {
      return this.groupName;
   }

   public ManualRuleGroup setGroupName(ExtendedValue var1) {
      this.groupName = var1;
      return this;
   }

   public List getItems() {
      return this.items;
   }

   public ManualRuleGroup setItems(List var1) {
      this.items = var1;
      return this;
   }

   public ManualRuleGroup set(String var1, Object var2) {
      return (ManualRuleGroup)super.set(var1, var2);
   }

   public ManualRuleGroup clone() {
      return (ManualRuleGroup)super.clone();
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

   static {
      Data.nullOf(ExtendedValue.class);
   }
}
