package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public final class FindReplaceResponse extends GenericJson {
   @Key
   private Integer formulasChanged;
   @Key
   private Integer occurrencesChanged;
   @Key
   private Integer rowsChanged;
   @Key
   private Integer sheetsChanged;
   @Key
   private Integer valuesChanged;

   public Integer getFormulasChanged() {
      return this.formulasChanged;
   }

   public FindReplaceResponse setFormulasChanged(Integer var1) {
      this.formulasChanged = var1;
      return this;
   }

   public Integer getOccurrencesChanged() {
      return this.occurrencesChanged;
   }

   public FindReplaceResponse setOccurrencesChanged(Integer var1) {
      this.occurrencesChanged = var1;
      return this;
   }

   public Integer getRowsChanged() {
      return this.rowsChanged;
   }

   public FindReplaceResponse setRowsChanged(Integer var1) {
      this.rowsChanged = var1;
      return this;
   }

   public Integer getSheetsChanged() {
      return this.sheetsChanged;
   }

   public FindReplaceResponse setSheetsChanged(Integer var1) {
      this.sheetsChanged = var1;
      return this;
   }

   public Integer getValuesChanged() {
      return this.valuesChanged;
   }

   public FindReplaceResponse setValuesChanged(Integer var1) {
      this.valuesChanged = var1;
      return this;
   }

   public FindReplaceResponse set(String var1, Object var2) {
      return (FindReplaceResponse)super.set(var1, var2);
   }

   public FindReplaceResponse clone() {
      return (FindReplaceResponse)super.clone();
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
