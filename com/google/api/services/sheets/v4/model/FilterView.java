package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

public final class FilterView extends GenericJson {
   @Key
   private Map criteria;
   @Key
   private Integer filterViewId;
   @Key
   private String namedRangeId;
   @Key
   private GridRange range;
   @Key
   private List sortSpecs;
   @Key
   private String title;

   public Map getCriteria() {
      return this.criteria;
   }

   public FilterView setCriteria(Map var1) {
      this.criteria = var1;
      return this;
   }

   public Integer getFilterViewId() {
      return this.filterViewId;
   }

   public FilterView setFilterViewId(Integer var1) {
      this.filterViewId = var1;
      return this;
   }

   public String getNamedRangeId() {
      return this.namedRangeId;
   }

   public FilterView setNamedRangeId(String var1) {
      this.namedRangeId = var1;
      return this;
   }

   public GridRange getRange() {
      return this.range;
   }

   public FilterView setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public List getSortSpecs() {
      return this.sortSpecs;
   }

   public FilterView setSortSpecs(List var1) {
      this.sortSpecs = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public FilterView setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public FilterView set(String var1, Object var2) {
      return (FilterView)super.set(var1, var2);
   }

   public FilterView clone() {
      return (FilterView)super.clone();
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
      Data.nullOf(FilterCriteria.class);
      Data.nullOf(SortSpec.class);
   }
}
