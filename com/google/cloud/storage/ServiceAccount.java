package com.google.cloud.storage;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

public final class ServiceAccount implements Serializable {
   static final Function FROM_PB_FUNCTION = new ServiceAccount$1();
   static final Function TO_PB_FUNCTION = new ServiceAccount$2();
   private static final long serialVersionUID = 4199610694227857331L;
   private final String email;

   private ServiceAccount(String email) {
      this.email = email;
   }

   public String getEmail() {
      return this.email;
   }

   public String toString() {
      return MoreObjects.toStringHelper(this).add("email", this.email).toString();
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.email});
   }

   public boolean equals(Object obj) {
      return obj == this || obj instanceof ServiceAccount && Objects.equals(this.toPb(), ((ServiceAccount)obj).toPb());
   }

   com.google.api.services.storage.model.ServiceAccount toPb() {
      com.google.api.services.storage.model.ServiceAccount serviceAccountPb = new com.google.api.services.storage.model.ServiceAccount();
      serviceAccountPb.setEmailAddress(this.email);
      return serviceAccountPb;
   }

   public static ServiceAccount of(String email) {
      return new ServiceAccount(email);
   }

   static ServiceAccount fromPb(com.google.api.services.storage.model.ServiceAccount accountPb) {
      return new ServiceAccount(accountPb.getEmailAddress());
   }
}
