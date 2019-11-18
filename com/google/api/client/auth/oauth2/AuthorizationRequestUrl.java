package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import java.util.Collection;

public class AuthorizationRequestUrl extends GenericUrl {
   @Key("response_type")
   private String responseTypes;
   @Key("redirect_uri")
   private String redirectUri;
   @Key("scope")
   private String scopes;
   @Key("client_id")
   private String clientId;
   @Key
   private String state;

   public AuthorizationRequestUrl(String authorizationServerEncodedUrl, String clientId, Collection responseTypes) {
      super(authorizationServerEncodedUrl);
      Preconditions.checkArgument(this.getFragment() == null);
      this.setClientId(clientId);
      this.setResponseTypes(responseTypes);
   }

   public final String getResponseTypes() {
      return this.responseTypes;
   }

   public AuthorizationRequestUrl setResponseTypes(Collection responseTypes) {
      this.responseTypes = Joiner.on(' ').join(responseTypes);
      return this;
   }

   public final String getRedirectUri() {
      return this.redirectUri;
   }

   public AuthorizationRequestUrl setRedirectUri(String redirectUri) {
      this.redirectUri = redirectUri;
      return this;
   }

   public final String getScopes() {
      return this.scopes;
   }

   public AuthorizationRequestUrl setScopes(Collection scopes) {
      this.scopes = scopes != null && scopes.iterator().hasNext() ? Joiner.on(' ').join(scopes) : null;
      return this;
   }

   public final String getClientId() {
      return this.clientId;
   }

   public AuthorizationRequestUrl setClientId(String clientId) {
      this.clientId = (String)Preconditions.checkNotNull(clientId);
      return this;
   }

   public final String getState() {
      return this.state;
   }

   public AuthorizationRequestUrl setState(String state) {
      this.state = state;
      return this;
   }

   public AuthorizationRequestUrl set(String fieldName, Object value) {
      return (AuthorizationRequestUrl)super.set(fieldName, value);
   }

   public AuthorizationRequestUrl clone() {
      return (AuthorizationRequestUrl)super.clone();
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
