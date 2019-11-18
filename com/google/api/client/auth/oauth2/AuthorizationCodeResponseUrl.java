package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;

public class AuthorizationCodeResponseUrl extends GenericUrl {
   @Key
   private String code;
   @Key
   private String state;
   @Key
   private String error;
   @Key("error_description")
   private String errorDescription;
   @Key("error_uri")
   private String errorUri;

   public AuthorizationCodeResponseUrl(String encodedResponseUrl) {
      super(encodedResponseUrl);
      Preconditions.checkArgument(this.code == null != (this.error == null));
   }

   public final String getCode() {
      return this.code;
   }

   public AuthorizationCodeResponseUrl setCode(String code) {
      this.code = code;
      return this;
   }

   public final String getState() {
      return this.state;
   }

   public AuthorizationCodeResponseUrl setState(String state) {
      this.state = state;
      return this;
   }

   public final String getError() {
      return this.error;
   }

   public AuthorizationCodeResponseUrl setError(String error) {
      this.error = error;
      return this;
   }

   public final String getErrorDescription() {
      return this.errorDescription;
   }

   public AuthorizationCodeResponseUrl setErrorDescription(String errorDescription) {
      this.errorDescription = errorDescription;
      return this;
   }

   public final String getErrorUri() {
      return this.errorUri;
   }

   public AuthorizationCodeResponseUrl setErrorUri(String errorUri) {
      this.errorUri = errorUri;
      return this;
   }

   public AuthorizationCodeResponseUrl set(String fieldName, Object value) {
      return (AuthorizationCodeResponseUrl)super.set(fieldName, value);
   }

   public AuthorizationCodeResponseUrl clone() {
      return (AuthorizationCodeResponseUrl)super.clone();
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
