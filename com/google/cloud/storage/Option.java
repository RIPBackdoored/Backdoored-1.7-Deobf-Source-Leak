package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Objects;

public abstract class Option implements Serializable {
   private static final long serialVersionUID = -73199088766477208L;
   private final StorageRpc$Option rpcOption;
   private final Object value;

   Option(StorageRpc$Option rpcOption, Object value) {
      this.rpcOption = (StorageRpc$Option)Preconditions.checkNotNull(rpcOption);
      this.value = value;
   }

   StorageRpc$Option getRpcOption() {
      return this.rpcOption;
   }

   Object getValue() {
      return this.value;
   }

   public boolean equals(Object obj) {
      if (!(obj instanceof Option)) {
         return false;
      } else {
         Option other = (Option)obj;
         return Objects.equals(this.rpcOption, other.rpcOption) && Objects.equals(this.value, other.value);
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.rpcOption, this.value});
   }

   public String toString() {
      return MoreObjects.toStringHelper(this).add("name", this.rpcOption.value()).add("value", this.value).toString();
   }
}
