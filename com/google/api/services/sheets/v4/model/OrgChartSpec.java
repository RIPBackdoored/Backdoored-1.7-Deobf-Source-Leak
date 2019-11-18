package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class OrgChartSpec extends GenericJson {
   @Key
   private ChartData labels;
   @Key
   private Color nodeColor;
   @Key
   private String nodeSize;
   @Key
   private ChartData parentLabels;
   @Key
   private Color selectedNodeColor;
   @Key
   private ChartData tooltips;

   public ChartData getLabels() {
      return this.labels;
   }

   public OrgChartSpec setLabels(ChartData var1) {
      this.labels = var1;
      return this;
   }

   public Color getNodeColor() {
      return this.nodeColor;
   }

   public OrgChartSpec setNodeColor(Color var1) {
      this.nodeColor = var1;
      return this;
   }

   public String getNodeSize() {
      return this.nodeSize;
   }

   public OrgChartSpec setNodeSize(String var1) {
      this.nodeSize = var1;
      return this;
   }

   public ChartData getParentLabels() {
      return this.parentLabels;
   }

   public OrgChartSpec setParentLabels(ChartData var1) {
      this.parentLabels = var1;
      return this;
   }

   public Color getSelectedNodeColor() {
      return this.selectedNodeColor;
   }

   public OrgChartSpec setSelectedNodeColor(Color var1) {
      this.selectedNodeColor = var1;
      return this;
   }

   public ChartData getTooltips() {
      return this.tooltips;
   }

   public OrgChartSpec setTooltips(ChartData var1) {
      this.tooltips = var1;
      return this;
   }

   public OrgChartSpec set(String var1, Object var2) {
      return (OrgChartSpec)super.set(var1, var2);
   }

   public OrgChartSpec clone() {
      return (OrgChartSpec)super.clone();
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
