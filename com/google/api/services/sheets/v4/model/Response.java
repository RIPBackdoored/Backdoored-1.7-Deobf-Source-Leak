package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class Response extends GenericJson {
   @Key
   private AddBandingResponse addBanding;
   @Key
   private AddChartResponse addChart;
   @Key
   private AddDimensionGroupResponse addDimensionGroup;
   @Key
   private AddFilterViewResponse addFilterView;
   @Key
   private AddNamedRangeResponse addNamedRange;
   @Key
   private AddProtectedRangeResponse addProtectedRange;
   @Key
   private AddSheetResponse addSheet;
   @Key
   private CreateDeveloperMetadataResponse createDeveloperMetadata;
   @Key
   private DeleteConditionalFormatRuleResponse deleteConditionalFormatRule;
   @Key
   private DeleteDeveloperMetadataResponse deleteDeveloperMetadata;
   @Key
   private DeleteDimensionGroupResponse deleteDimensionGroup;
   @Key
   private DuplicateFilterViewResponse duplicateFilterView;
   @Key
   private DuplicateSheetResponse duplicateSheet;
   @Key
   private FindReplaceResponse findReplace;
   @Key
   private UpdateConditionalFormatRuleResponse updateConditionalFormatRule;
   @Key
   private UpdateDeveloperMetadataResponse updateDeveloperMetadata;
   @Key
   private UpdateEmbeddedObjectPositionResponse updateEmbeddedObjectPosition;

   public AddBandingResponse getAddBanding() {
      return this.addBanding;
   }

   public Response setAddBanding(AddBandingResponse var1) {
      this.addBanding = var1;
      return this;
   }

   public AddChartResponse getAddChart() {
      return this.addChart;
   }

   public Response setAddChart(AddChartResponse var1) {
      this.addChart = var1;
      return this;
   }

   public AddDimensionGroupResponse getAddDimensionGroup() {
      return this.addDimensionGroup;
   }

   public Response setAddDimensionGroup(AddDimensionGroupResponse var1) {
      this.addDimensionGroup = var1;
      return this;
   }

   public AddFilterViewResponse getAddFilterView() {
      return this.addFilterView;
   }

   public Response setAddFilterView(AddFilterViewResponse var1) {
      this.addFilterView = var1;
      return this;
   }

   public AddNamedRangeResponse getAddNamedRange() {
      return this.addNamedRange;
   }

   public Response setAddNamedRange(AddNamedRangeResponse var1) {
      this.addNamedRange = var1;
      return this;
   }

   public AddProtectedRangeResponse getAddProtectedRange() {
      return this.addProtectedRange;
   }

   public Response setAddProtectedRange(AddProtectedRangeResponse var1) {
      this.addProtectedRange = var1;
      return this;
   }

   public AddSheetResponse getAddSheet() {
      return this.addSheet;
   }

   public Response setAddSheet(AddSheetResponse var1) {
      this.addSheet = var1;
      return this;
   }

   public CreateDeveloperMetadataResponse getCreateDeveloperMetadata() {
      return this.createDeveloperMetadata;
   }

   public Response setCreateDeveloperMetadata(CreateDeveloperMetadataResponse var1) {
      this.createDeveloperMetadata = var1;
      return this;
   }

   public DeleteConditionalFormatRuleResponse getDeleteConditionalFormatRule() {
      return this.deleteConditionalFormatRule;
   }

   public Response setDeleteConditionalFormatRule(DeleteConditionalFormatRuleResponse var1) {
      this.deleteConditionalFormatRule = var1;
      return this;
   }

   public DeleteDeveloperMetadataResponse getDeleteDeveloperMetadata() {
      return this.deleteDeveloperMetadata;
   }

   public Response setDeleteDeveloperMetadata(DeleteDeveloperMetadataResponse var1) {
      this.deleteDeveloperMetadata = var1;
      return this;
   }

   public DeleteDimensionGroupResponse getDeleteDimensionGroup() {
      return this.deleteDimensionGroup;
   }

   public Response setDeleteDimensionGroup(DeleteDimensionGroupResponse var1) {
      this.deleteDimensionGroup = var1;
      return this;
   }

   public DuplicateFilterViewResponse getDuplicateFilterView() {
      return this.duplicateFilterView;
   }

   public Response setDuplicateFilterView(DuplicateFilterViewResponse var1) {
      this.duplicateFilterView = var1;
      return this;
   }

   public DuplicateSheetResponse getDuplicateSheet() {
      return this.duplicateSheet;
   }

   public Response setDuplicateSheet(DuplicateSheetResponse var1) {
      this.duplicateSheet = var1;
      return this;
   }

   public FindReplaceResponse getFindReplace() {
      return this.findReplace;
   }

   public Response setFindReplace(FindReplaceResponse var1) {
      this.findReplace = var1;
      return this;
   }

   public UpdateConditionalFormatRuleResponse getUpdateConditionalFormatRule() {
      return this.updateConditionalFormatRule;
   }

   public Response setUpdateConditionalFormatRule(UpdateConditionalFormatRuleResponse var1) {
      this.updateConditionalFormatRule = var1;
      return this;
   }

   public UpdateDeveloperMetadataResponse getUpdateDeveloperMetadata() {
      return this.updateDeveloperMetadata;
   }

   public Response setUpdateDeveloperMetadata(UpdateDeveloperMetadataResponse var1) {
      this.updateDeveloperMetadata = var1;
      return this;
   }

   public UpdateEmbeddedObjectPositionResponse getUpdateEmbeddedObjectPosition() {
      return this.updateEmbeddedObjectPosition;
   }

   public Response setUpdateEmbeddedObjectPosition(UpdateEmbeddedObjectPositionResponse var1) {
      this.updateEmbeddedObjectPosition = var1;
      return this;
   }

   public Response set(String var1, Object var2) {
      return (Response)super.set(var1, var2);
   }

   public Response clone() {
      return (Response)super.clone();
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
