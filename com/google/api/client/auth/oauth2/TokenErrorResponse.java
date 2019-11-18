package com.google.api.client.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;

public class TokenErrorResponse extends GenericJson {
   @Key
   private String error;
   @Key("error_description")
   private String errorDescription;
   @Key("error_uri")
   private String errorUri;

   public final String getError() {
      return this.error;
   }

   public TokenErrorResponse setError(String error) {
      this.error = (String)Preconditions.checkNotNull(error);
      return this;
   }

   public final String getErrorDescription() {
      return this.errorDescription;
   }

   public TokenErrorResponse setErrorDescription(String errorDescription) {
      this.errorDescription = errorDescription;
      return this;
   }

   public final String getErrorUri() {
      return this.errorUri;
   }

   public TokenErrorResponse setErrorUri(String errorUri) {
      this.errorUri = errorUri;
      return this;
   }

   public TokenErrorResponse set(String fieldName, Object value) {
      return (TokenErrorResponse)super.set(fieldName, value);
   }

   public TokenErrorResponse clone() {
      return (TokenErrorResponse)super.clone();
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
