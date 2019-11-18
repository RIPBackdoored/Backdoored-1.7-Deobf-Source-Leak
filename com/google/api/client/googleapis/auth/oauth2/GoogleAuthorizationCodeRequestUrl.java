package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.AuthorizationRequestUrl;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.util.Collection;

public class GoogleAuthorizationCodeRequestUrl extends AuthorizationCodeRequestUrl {
   @Key("approval_prompt")
   private String approvalPrompt;
   @Key("access_type")
   private String accessType;

   public GoogleAuthorizationCodeRequestUrl(String clientId, String redirectUri, Collection scopes) {
      this("https://accounts.google.com/o/oauth2/auth", clientId, redirectUri, scopes);
   }

   public GoogleAuthorizationCodeRequestUrl(String authorizationServerEncodedUrl, String clientId, String redirectUri, Collection scopes) {
      super(authorizationServerEncodedUrl, clientId);
      this.setRedirectUri(redirectUri);
      this.setScopes(scopes);
   }

   public GoogleAuthorizationCodeRequestUrl(GoogleClientSecrets clientSecrets, String redirectUri, Collection scopes) {
      this(clientSecrets.getDetails().getClientId(), redirectUri, scopes);
   }

   public final String getApprovalPrompt() {
      return this.approvalPrompt;
   }

   public GoogleAuthorizationCodeRequestUrl setApprovalPrompt(String approvalPrompt) {
      this.approvalPrompt = approvalPrompt;
      return this;
   }

   public final String getAccessType() {
      return this.accessType;
   }

   public GoogleAuthorizationCodeRequestUrl setAccessType(String accessType) {
      this.accessType = accessType;
      return this;
   }

   public GoogleAuthorizationCodeRequestUrl setResponseTypes(Collection responseTypes) {
      return (GoogleAuthorizationCodeRequestUrl)super.setResponseTypes(responseTypes);
   }

   public GoogleAuthorizationCodeRequestUrl setRedirectUri(String redirectUri) {
      Preconditions.checkNotNull(redirectUri);
      return (GoogleAuthorizationCodeRequestUrl)super.setRedirectUri(redirectUri);
   }

   public GoogleAuthorizationCodeRequestUrl setScopes(Collection scopes) {
      Preconditions.checkArgument(scopes.iterator().hasNext());
      return (GoogleAuthorizationCodeRequestUrl)super.setScopes(scopes);
   }

   public GoogleAuthorizationCodeRequestUrl setClientId(String clientId) {
      return (GoogleAuthorizationCodeRequestUrl)super.setClientId(clientId);
   }

   public GoogleAuthorizationCodeRequestUrl setState(String state) {
      return (GoogleAuthorizationCodeRequestUrl)super.setState(state);
   }

   public GoogleAuthorizationCodeRequestUrl set(String fieldName, Object value) {
      return (GoogleAuthorizationCodeRequestUrl)super.set(fieldName, value);
   }

   public GoogleAuthorizationCodeRequestUrl clone() {
      return (GoogleAuthorizationCodeRequestUrl)super.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeRequestUrl clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeRequestUrl set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeRequestUrl setState(String var1) {
      return this.setState(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeRequestUrl setClientId(String var1) {
      return this.setClientId(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeRequestUrl setScopes(Collection var1) {
      return this.setScopes(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeRequestUrl setRedirectUri(String var1) {
      return this.setRedirectUri(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AuthorizationCodeRequestUrl setResponseTypes(Collection var1) {
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
