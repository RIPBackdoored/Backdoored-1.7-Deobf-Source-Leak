package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class Sheet extends GenericJson {
   @Key
   private List bandedRanges;
   @Key
   private BasicFilter basicFilter;
   @Key
   private List charts;
   @Key
   private List columnGroups;
   @Key
   private List conditionalFormats;
   @Key
   private List data;
   @Key
   private List developerMetadata;
   @Key
   private List filterViews;
   @Key
   private List merges;
   @Key
   private SheetProperties properties;
   @Key
   private List protectedRanges;
   @Key
   private List rowGroups;

   public List getBandedRanges() {
      return this.bandedRanges;
   }

   public Sheet setBandedRanges(List var1) {
      this.bandedRanges = var1;
      return this;
   }

   public BasicFilter getBasicFilter() {
      return this.basicFilter;
   }

   public Sheet setBasicFilter(BasicFilter var1) {
      this.basicFilter = var1;
      return this;
   }

   public List getCharts() {
      return this.charts;
   }

   public Sheet setCharts(List var1) {
      this.charts = var1;
      return this;
   }

   public List getColumnGroups() {
      return this.columnGroups;
   }

   public Sheet setColumnGroups(List var1) {
      this.columnGroups = var1;
      return this;
   }

   public List getConditionalFormats() {
      return this.conditionalFormats;
   }

   public Sheet setConditionalFormats(List var1) {
      this.conditionalFormats = var1;
      return this;
   }

   public List getData() {
      return this.data;
   }

   public Sheet setData(List var1) {
      this.data = var1;
      return this;
   }

   public List getDeveloperMetadata() {
      return this.developerMetadata;
   }

   public Sheet setDeveloperMetadata(List var1) {
      this.developerMetadata = var1;
      return this;
   }

   public List getFilterViews() {
      return this.filterViews;
   }

   public Sheet setFilterViews(List var1) {
      this.filterViews = var1;
      return this;
   }

   public List getMerges() {
      return this.merges;
   }

   public Sheet setMerges(List var1) {
      this.merges = var1;
      return this;
   }

   public SheetProperties getProperties() {
      return this.properties;
   }

   public Sheet setProperties(SheetProperties var1) {
      this.properties = var1;
      return this;
   }

   public List getProtectedRanges() {
      return this.protectedRanges;
   }

   public Sheet setProtectedRanges(List var1) {
      this.protectedRanges = var1;
      return this;
   }

   public List getRowGroups() {
      return this.rowGroups;
   }

   public Sheet setRowGroups(List var1) {
      this.rowGroups = var1;
      return this;
   }

   public Sheet set(String var1, Object var2) {
      return (Sheet)super.set(var1, var2);
   }

   public Sheet clone() {
      return (Sheet)super.clone();
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
      Data.nullOf(EmbeddedChart.class);
      Data.nullOf(GridData.class);
   }
}
