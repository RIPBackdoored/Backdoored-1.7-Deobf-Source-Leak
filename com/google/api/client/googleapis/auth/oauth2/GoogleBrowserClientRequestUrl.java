package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.AuthorizationRequestUrl;
import com.google.api.client.auth.oauth2.BrowserClientRequestUrl;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.util.Collection;

public class GoogleBrowserClientRequestUrl extends BrowserClientRequestUrl {
   @Key("approval_prompt")
   private String approvalPrompt;

   public GoogleBrowserClientRequestUrl(String clientId, String redirectUri, Collection scopes) {
      super("https://accounts.google.com/o/oauth2/auth", clientId);
      this.setRedirectUri(redirectUri);
      this.setScopes(scopes);
   }

   public GoogleBrowserClientRequestUrl(GoogleClientSecrets clientSecrets, String redirectUri, Collection scopes) {
      this(clientSecrets.getDetails().getClientId(), redirectUri, scopes);
   }

   public final String getApprovalPrompt() {
      return this.approvalPrompt;
   }

   public GoogleBrowserClientRequestUrl setApprovalPrompt(String approvalPrompt) {
      this.approvalPrompt = approvalPrompt;
      return this;
   }

   public GoogleBrowserClientRequestUrl setResponseTypes(Collection responseTypes) {
      return (GoogleBrowserClientRequestUrl)super.setResponseTypes(responseTypes);
   }

   public GoogleBrowserClientRequestUrl setRedirectUri(String redirectUri) {
      return (GoogleBrowserClientRequestUrl)super.setRedirectUri(redirectUri);
   }

   public GoogleBrowserClientRequestUrl setScopes(Collection scopes) {
      Preconditions.checkArgument(scopes.iterator().hasNext());
      return (GoogleBrowserClientRequestUrl)super.setScopes(scopes);
   }

   public GoogleBrowserClientRequestUrl setClientId(String clientId) {
      return (GoogleBrowserClientRequestUrl)super.setClientId(clientId);
   }

   public GoogleBrowserClientRequestUrl setState(String state) {
      return (GoogleBrowserClientRequestUrl)super.setState(state);
   }

   public GoogleBrowserClientRequestUrl set(String fieldName, Object value) {
      return (GoogleBrowserClientRequestUrl)super.set(fieldName, value);
   }

   public GoogleBrowserClientRequestUrl clone() {
      return (GoogleBrowserClientRequestUrl)super.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BrowserClientRequestUrl clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BrowserClientRequestUrl set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BrowserClientRequestUrl setState(String var1) {
      return this.setState(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BrowserClientRequestUrl setClientId(String var1) {
      return this.setClientId(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BrowserClientRequestUrl setScopes(Collection var1) {
      return this.setScopes(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BrowserClientRequestUrl setRedirectUri(String var1) {
      return this.setRedirectUri(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BrowserClientRequestUrl setResponseTypes(Collection var1) {
      return this.setResponseTypes(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationRequestUrl clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationRequestUrl set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationRequestUrl setState(String var1) {
      return this.setState(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationRequestUrl setClientId(String var1) {
      return this.setClientId(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationRequestUrl setScopes(Collection var1) {
      return this.setScopes(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationRequestUrl setRedirectUri(String var1) {
      return this.setRedirectUri(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationRequestUrl setResponseTypes(Collection var1) {
      return this.setResponseTypes(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericUrl set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericUrl clone() {
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
