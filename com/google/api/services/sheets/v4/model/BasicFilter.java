package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

public final class BasicFilter extends GenericJson {
   @Key
   private Map criteria;
   @Key
   private GridRange range;
   @Key
   private List sortSpecs;

   public Map getCriteria() {
      return this.criteria;
   }

   public BasicFilter setCriteria(Map var1) {
      this.criteria = var1;
      return this;
   }

   public GridRange getRange() {
      return this.range;
   }

   public BasicFilter setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public List getSortSpecs() {
      return this.sortSpecs;
   }

   public BasicFilter setSortSpecs(List var1) {
      this.sortSpecs = var1;
      return this;
   }

   public BasicFilter set(String var1, Object var2) {
      return (BasicFilter)super.set(var1, var2);
   }

   public BasicFilter clone() {
      return (BasicFilter)super.clone();
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
