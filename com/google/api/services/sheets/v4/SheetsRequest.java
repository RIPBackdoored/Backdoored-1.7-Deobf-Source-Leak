package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public abstract class SheetsRequest extends AbstractGoogleJsonClientRequest {
   @Key("$.xgafv")
   private String $Xgafv;
   @Key("access_token")
   private String accessToken;
   @Key
   private String alt;
   @Key
   private String callback;
   @Key
   private String fields;
   @Key
   private String key;
   @Key("oauth_token")
   private String oauthToken;
   @Key
   private Boolean prettyPrint;
   @Key
   private String quotaUser;
   @Key
   private String uploadType;
   @Key("upload_protocol")
   private String uploadProtocol;

   public SheetsRequest(Sheets var1, String var2, String var3, Object var4, Class var5) {
      super(var1, var2, var3, var4, var5);
   }

   public String get$Xgafv() {
      return this.$Xgafv;
   }

   public SheetsRequest set$Xgafv(String var1) {
      this.$Xgafv = var1;
      return this;
   }

   public String getAccessToken() {
      return this.accessToken;
   }

   public SheetsRequest setAccessToken(String var1) {
      this.accessToken = var1;
      return this;
   }

   public String getAlt() {
      return this.alt;
   }

   public SheetsRequest setAlt(String var1) {
      this.alt = var1;
      return this;
   }

   public String getCallback() {
      return this.callback;
   }

   public SheetsRequest setCallback(String var1) {
      this.callback = var1;
      return this;
   }

   public String getFields() {
      return this.fields;
   }

   public SheetsRequest setFields(String var1) {
      this.fields = var1;
      return this;
   }

   public String getKey() {
      return this.key;
   }

   public SheetsRequest setKey(String var1) {
      this.key = var1;
      return this;
   }

   public String getOauthToken() {
      return this.oauthToken;
   }

   public SheetsRequest setOauthToken(String var1) {
      this.oauthToken = var1;
      return this;
   }

   public Boolean getPrettyPrint() {
      return this.prettyPrint;
   }

   public SheetsRequest setPrettyPrint(Boolean var1) {
      this.prettyPrint = var1;
      return this;
   }

   public String getQuotaUser() {
      return this.quotaUser;
   }

   public SheetsRequest setQuotaUser(String var1) {
      this.quotaUser = var1;
      return this;
   }

   public String getUploadType() {
      return this.uploadType;
   }

   public SheetsRequest setUploadType(String var1) {
      this.uploadType = var1;
      return this;
   }

   public String getUploadProtocol() {
      return this.uploadProtocol;
   }

   public SheetsRequest setUploadProtocol(String var1) {
      this.uploadProtocol = var1;
      return this;
   }

   public final Sheets getAbstractGoogleClient() {
      return (Sheets)super.getAbstractGoogleClient();
   }

   public SheetsRequest setDisableGZipContent(boolean var1) {
      return (SheetsRequest)super.setDisableGZipContent(var1);
   }

   public SheetsRequest setRequestHeaders(HttpHeaders var1) {
      return (SheetsRequest)super.setRequestHeaders(var1);
   }

   public SheetsRequest set(String var1, Object var2) {
      return (SheetsRequest)super.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClientRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClientRequest setRequestHeaders(HttpHeaders var1) {
      return this.setRequestHeaders(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClientRequest setDisableGZipContent(boolean var1) {
      return this.setDisableGZipContent(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleJsonClient getAbstractGoogleClient() {
      return this.getAbstractGoogleClient();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest setRequestHeaders(HttpHeaders var1) {
      return this.setRequestHeaders(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClient getAbstractGoogleClient() {
      return this.getAbstractGoogleClient();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractGoogleClientRequest setDisableGZipContent(boolean var1) {
      return this.setDisableGZipContent(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }
}
