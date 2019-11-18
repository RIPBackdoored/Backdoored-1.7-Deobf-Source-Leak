package com.google.cloud.storage;

public final class Acl$Domain extends Acl$Entity {
   private static final long serialVersionUID = -3033025857280447253L;

   public Acl$Domain(String domain) {
      super(Acl$Entity$Type.DOMAIN, domain);
   }

   public String getDomain() {
      return this.getValue();
   }
}
