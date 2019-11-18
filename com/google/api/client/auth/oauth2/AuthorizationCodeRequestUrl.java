package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.GenericData;
import java.util.Collection;
import java.util.Collections;

public class AuthorizationCodeRequestUrl extends AuthorizationRequestUrl {
   public AuthorizationCodeRequestUrl(String authorizationServerEncodedUrl, String clientId) {
      super(authorizationServerEncodedUrl, clientId, Collections.singleton("code"));
   }

   public AuthorizationCodeRequestUrl setResponseTypes(Collection responseTypes) {
      return (AuthorizationCodeRequestUrl)super.setResponseTypes(responseTypes);
   }

   public AuthorizationCodeRequestUrl setRedirectUri(String redirectUri) {
      return (AuthorizationCodeRequestUrl)super.setRedirectUri(redirectUri);
   }

   public AuthorizationCodeRequestUrl setScopes(Collection scopes) {
      return (AuthorizationCodeRequestUrl)super.setScopes(scopes);
   }

   public AuthorizationCodeRequestUrl setClientId(String clientId) {
      return (AuthorizationCodeRequestUrl)super.setClientId(clientId);
   }

   public AuthorizationCodeRequestUrl setState(String state) {
      return (AuthorizationCodeRequestUrl)super.setState(state);
   }

   public AuthorizationCodeRequestUrl set(String fieldName, Object value) {
      return (AuthorizationCodeRequestUrl)super.set(fieldName, value);
   }

   public AuthorizationCodeRequestUrl clone() {
      return (AuthorizationCodeRequestUrl)super.clone();
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
