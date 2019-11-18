package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class PivotGroup extends GenericJson {
   @Key
   private PivotGroupRule groupRule;
   @Key
   private String label;
   @Key
   private Boolean repeatHeadings;
   @Key
   private Boolean showTotals;
   @Key
   private String sortOrder;
   @Key
   private Integer sourceColumnOffset;
   @Key
   private PivotGroupSortValueBucket valueBucket;
   @Key
   private List valueMetadata;

   public PivotGroupRule getGroupRule() {
      return this.groupRule;
   }

   public PivotGroup setGroupRule(PivotGroupRule var1) {
      this.groupRule = var1;
      return this;
   }

   public String getLabel() {
      return this.label;
   }

   public PivotGroup setLabel(String var1) {
      this.label = var1;
      return this;
   }

   public Boolean getRepeatHeadings() {
      return this.repeatHeadings;
   }

   public PivotGroup setRepeatHeadings(Boolean var1) {
      this.repeatHeadings = var1;
      return this;
   }

   public Boolean getShowTotals() {
      return this.showTotals;
   }

   public PivotGroup setShowTotals(Boolean var1) {
      this.showTotals = var1;
      return this;
   }

   public String getSortOrder() {
      return this.sortOrder;
   }

   public PivotGroup setSortOrder(String var1) {
      this.sortOrder = var1;
      return this;
   }

   public Integer getSourceColumnOffset() {
      return this.sourceColumnOffset;
   }

   public PivotGroup setSourceColumnOffset(Integer var1) {
      this.sourceColumnOffset = var1;
      return this;
   }

   public PivotGroupSortValueBucket getValueBucket() {
      return this.valueBucket;
   }

   public PivotGroup setValueBucket(PivotGroupSortValueBucket var1) {
      this.valueBucket = var1;
      return this;
   }

   public List getValueMetadata() {
      return this.valueMetadata;
   }

   public PivotGroup setValueMetadata(List var1) {
      this.valueMetadata = var1;
      return this;
   }

   public PivotGroup set(String var1, Object var2) {
      return (PivotGroup)super.set(var1, var2);
   }

   public PivotGroup clone() {
      return (PivotGroup)super.clone();
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
      Data.nullOf(PivotGroupValueMetadata.class);
   }
}
