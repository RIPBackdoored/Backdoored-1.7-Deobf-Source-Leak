package com.google.cloud.storage.spi.v1;

import com.google.api.services.storage.model.StorageObject;
import java.util.Map;
import java.util.Objects;

public class StorageRpc$RewriteRequest {
   public final StorageObject source;
   public final Map sourceOptions;
   public final boolean overrideInfo;
   public final StorageObject target;
   public final Map targetOptions;
   public final Long megabytesRewrittenPerCall;

   public StorageRpc$RewriteRequest(StorageObject source, Map sourceOptions, boolean overrideInfo, StorageObject target, Map targetOptions, Long megabytesRewrittenPerCall) {
      this.source = source;
      this.sourceOptions = sourceOptions;
      this.overrideInfo = overrideInfo;
      this.target = target;
      this.targetOptions = targetOptions;
      this.megabytesRewrittenPerCall = megabytesRewrittenPerCall;
   }

   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      } else if (!(obj instanceof StorageRpc$RewriteRequest)) {
         return false;
      } else {
         StorageRpc$RewriteRequest other = (StorageRpc$RewriteRequest)obj;
         return Objects.equals(this.source, other.source) && Objects.equals(this.sourceOptions, other.sourceOptions) && Objects.equals(this.overrideInfo, other.overrideInfo) && Objects.equals(this.target, other.target) && Objects.equals(this.targetOptions, other.targetOptions) && Objects.equals(this.megabytesRewrittenPerCall, other.megabytesRewrittenPerCall);
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.source, this.sourceOptions, this.overrideInfo, this.target, this.targetOptions, this.megabytesRewrittenPerCall});
   }
}
