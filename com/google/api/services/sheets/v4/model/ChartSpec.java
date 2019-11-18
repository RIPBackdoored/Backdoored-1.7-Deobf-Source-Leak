package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class ChartSpec extends GenericJson {
   @Key
   private String altText;
   @Key
   private Color backgroundColor;
   @Key
   private BasicChartSpec basicChart;
   @Key
   private BubbleChartSpec bubbleChart;
   @Key
   private CandlestickChartSpec candlestickChart;
   @Key
   private String fontName;
   @Key
   private String hiddenDimensionStrategy;
   @Key
   private HistogramChartSpec histogramChart;
   @Key
   private Boolean maximized;
   @Key
   private OrgChartSpec orgChart;
   @Key
   private PieChartSpec pieChart;
   @Key
   private String subtitle;
   @Key
   private TextFormat subtitleTextFormat;
   @Key
   private TextPosition subtitleTextPosition;
   @Key
   private String title;
   @Key
   private TextFormat titleTextFormat;
   @Key
   private TextPosition titleTextPosition;
   @Key
   private TreemapChartSpec treemapChart;
   @Key
   private WaterfallChartSpec waterfallChart;

   public String getAltText() {
      return this.altText;
   }

   public ChartSpec setAltText(String var1) {
      this.altText = var1;
      return this;
   }

   public Color getBackgroundColor() {
      return this.backgroundColor;
   }

   public ChartSpec setBackgroundColor(Color var1) {
      this.backgroundColor = var1;
      return this;
   }

   public BasicChartSpec getBasicChart() {
      return this.basicChart;
   }

   public ChartSpec setBasicChart(BasicChartSpec var1) {
      this.basicChart = var1;
      return this;
   }

   public BubbleChartSpec getBubbleChart() {
      return this.bubbleChart;
   }

   public ChartSpec setBubbleChart(BubbleChartSpec var1) {
      this.bubbleChart = var1;
      return this;
   }

   public CandlestickChartSpec getCandlestickChart() {
      return this.candlestickChart;
   }

   public ChartSpec setCandlestickChart(CandlestickChartSpec var1) {
      this.candlestickChart = var1;
      return this;
   }

   public String getFontName() {
      return this.fontName;
   }

   public ChartSpec setFontName(String var1) {
      this.fontName = var1;
      return this;
   }

   public String getHiddenDimensionStrategy() {
      return this.hiddenDimensionStrategy;
   }

   public ChartSpec setHiddenDimensionStrategy(String var1) {
      this.hiddenDimensionStrategy = var1;
      return this;
   }

   public HistogramChartSpec getHistogramChart() {
      return this.histogramChart;
   }

   public ChartSpec setHistogramChart(HistogramChartSpec var1) {
      this.histogramChart = var1;
      return this;
   }

   public Boolean getMaximized() {
      return this.maximized;
   }

   public ChartSpec setMaximized(Boolean var1) {
      this.maximized = var1;
      return this;
   }

   public OrgChartSpec getOrgChart() {
      return this.orgChart;
   }

   public ChartSpec setOrgChart(OrgChartSpec var1) {
      this.orgChart = var1;
      return this;
   }

   public PieChartSpec getPieChart() {
      return this.pieChart;
   }

   public ChartSpec setPieChart(PieChartSpec var1) {
      this.pieChart = var1;
      return this;
   }

   public String getSubtitle() {
      return this.subtitle;
   }

   public ChartSpec setSubtitle(String var1) {
      this.subtitle = var1;
      return this;
   }

   public TextFormat getSubtitleTextFormat() {
      return this.subtitleTextFormat;
   }

   public ChartSpec setSubtitleTextFormat(TextFormat var1) {
      this.subtitleTextFormat = var1;
      return this;
   }

   public TextPosition getSubtitleTextPosition() {
      return this.subtitleTextPosition;
   }

   public ChartSpec setSubtitleTextPosition(TextPosition var1) {
      this.subtitleTextPosition = var1;
      return this;
   }

   public String getTitle() {
      return this.title;
   }

   public ChartSpec setTitle(String var1) {
      this.title = var1;
      return this;
   }

   public TextFormat getTitleTextFormat() {
      return this.titleTextFormat;
   }

   public ChartSpec setTitleTextFormat(TextFormat var1) {
      this.titleTextFormat = var1;
      return this;
   }

   public TextPosition getTitleTextPosition() {
      return this.titleTextPosition;
   }

   public ChartSpec setTitleTextPosition(TextPosition var1) {
      this.titleTextPosition = var1;
      return this;
   }

   public TreemapChartSpec getTreemapChart() {
      return this.treemapChart;
   }

   public ChartSpec setTreemapChart(TreemapChartSpec var1) {
      this.treemapChart = var1;
      return this;
   }

   public WaterfallChartSpec getWaterfallChart() {
      return this.waterfallChart;
   }

   public ChartSpec setWaterfallChart(WaterfallChartSpec var1) {
      this.waterfallChart = var1;
      return this;
   }

   public ChartSpec set(String var1, Object var2) {
      return (ChartSpec)super.set(var1, var2);
   }

   public ChartSpec clone() {
      return (ChartSpec)super.clone();
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
