package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.GenericData;
import java.util.Collection;
import java.util.Collections;

public class BrowserClientRequestUrl extends AuthorizationRequestUrl {
   public BrowserClientRequestUrl(String encodedAuthorizationServerUrl, String clientId) {
      super(encodedAuthorizationServerUrl, clientId, Collections.singleton("token"));
   }

   public BrowserClientRequestUrl setResponseTypes(Collection responseTypes) {
      return (BrowserClientRequestUrl)super.setResponseTypes(responseTypes);
   }

   public BrowserClientRequestUrl setRedirectUri(String redirectUri) {
      return (BrowserClientRequestUrl)super.setRedirectUri(redirectUri);
   }

   public BrowserClientRequestUrl setScopes(Collection scopes) {
      return (BrowserClientRequestUrl)super.setScopes(scopes);
   }

   public BrowserClientRequestUrl setClientId(String clientId) {
      return (BrowserClientRequestUrl)super.setClientId(clientId);
   }

   public BrowserClientRequestUrl setState(String state) {
      return (BrowserClientRequestUrl)super.setState(state);
   }

   public BrowserClientRequestUrl set(String fieldName, Object value) {
      return (BrowserClientRequestUrl)super.set(fieldName, value);
   }

   public BrowserClientRequestUrl clone() {
      return (BrowserClientRequestUrl)super.clone();
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
