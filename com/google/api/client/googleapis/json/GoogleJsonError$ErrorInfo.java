package com.google.api.client.googleapis.json;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public class GoogleJsonError$ErrorInfo extends GenericJson {
   @Key
   private String domain;
   @Key
   private String reason;
   @Key
   private String message;
   @Key
   private String location;
   @Key
   private String locationType;

   public final String getDomain() {
      return this.domain;
   }

   public final void setDomain(String domain) {
      this.domain = domain;
   }

   public final String getReason() {
      return this.reason;
   }

   public final void setReason(String reason) {
      this.reason = reason;
   }

   public final String getMessage() {
      return this.message;
   }

   public final void setMessage(String message) {
      this.message = message;
   }

   public final String getLocation() {
      return this.location;
   }

   public final void setLocation(String location) {
      this.location = location;
   }

   public final String getLocationType() {
      return this.locationType;
   }

   public final void setLocationType(String locationType) {
      this.locationType = locationType;
   }

   public GoogleJsonError$ErrorInfo set(String fieldName, Object value) {
      return (GoogleJsonError$ErrorInfo)super.set(fieldName, value);
   }

   public GoogleJsonError$ErrorInfo clone() {
      return (GoogleJsonError$ErrorInfo)super.clone();
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
