package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;
import java.util.Map;

public final class PivotTable extends GenericJson {
   @Key
   private List columns;
   @Key
   private Map criteria;
   @Key
   private List rows;
   @Key
   private GridRange source;
   @Key
   private String valueLayout;
   @Key
   private List values;

   public List getColumns() {
      return this.columns;
   }

   public PivotTable setColumns(List var1) {
      this.columns = var1;
      return this;
   }

   public Map getCriteria() {
      return this.criteria;
   }

   public PivotTable setCriteria(Map var1) {
      this.criteria = var1;
      return this;
   }

   public List getRows() {
      return this.rows;
   }

   public PivotTable setRows(List var1) {
      this.rows = var1;
      return this;
   }

   public GridRange getSource() {
      return this.source;
   }

   public PivotTable setSource(GridRange var1) {
      this.source = var1;
      return this;
   }

   public String getValueLayout() {
      return this.valueLayout;
   }

   public PivotTable setValueLayout(String var1) {
      this.valueLayout = var1;
      return this;
   }

   public List getValues() {
      return this.values;
   }

   public PivotTable setValues(List var1) {
      this.values = var1;
      return this;
   }

   public PivotTable set(String var1, Object var2) {
      return (PivotTable)super.set(var1, var2);
   }

   public PivotTable clone() {
      return (PivotTable)super.clone();
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
      Data.nullOf(PivotGroup.class);
      Data.nullOf(PivotFilterCriteria.class);
      Data.nullOf(PivotGroup.class);
      Data.nullOf(PivotValue.class);
   }
}
