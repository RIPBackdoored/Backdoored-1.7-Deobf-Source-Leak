package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class ProtectedRange extends GenericJson {
   @Key
   private String description;
   @Key
   private Editors editors;
   @Key
   private String namedRangeId;
   @Key
   private Integer protectedRangeId;
   @Key
   private GridRange range;
   @Key
   private Boolean requestingUserCanEdit;
   @Key
   private List unprotectedRanges;
   @Key
   private Boolean warningOnly;

   public String getDescription() {
      return this.description;
   }

   public ProtectedRange setDescription(String var1) {
      this.description = var1;
      return this;
   }

   public Editors getEditors() {
      return this.editors;
   }

   public ProtectedRange setEditors(Editors var1) {
      this.editors = var1;
      return this;
   }

   public String getNamedRangeId() {
      return this.namedRangeId;
   }

   public ProtectedRange setNamedRangeId(String var1) {
      this.namedRangeId = var1;
      return this;
   }

   public Integer getProtectedRangeId() {
      return this.protectedRangeId;
   }

   public ProtectedRange setProtectedRangeId(Integer var1) {
      this.protectedRangeId = var1;
      return this;
   }

   public GridRange getRange() {
      return this.range;
   }

   public ProtectedRange setRange(GridRange var1) {
      this.range = var1;
      return this;
   }

   public Boolean getRequestingUserCanEdit() {
      return this.requestingUserCanEdit;
   }

   public ProtectedRange setRequestingUserCanEdit(Boolean var1) {
      this.requestingUserCanEdit = var1;
      return this;
   }

   public List getUnprotectedRanges() {
      return this.unprotectedRanges;
   }

   public ProtectedRange setUnprotectedRanges(List var1) {
      this.unprotectedRanges = var1;
      return this;
   }

   public Boolean getWarningOnly() {
      return this.warningOnly;
   }

   public ProtectedRange setWarningOnly(Boolean var1) {
      this.warningOnly = var1;
      return this;
   }

   public ProtectedRange set(String var1, Object var2) {
      return (ProtectedRange)super.set(var1, var2);
   }

   public ProtectedRange clone() {
      return (ProtectedRange)super.clone();
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
      Data.nullOf(GridRange.class);
   }
}
