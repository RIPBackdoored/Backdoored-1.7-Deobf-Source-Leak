package com.google.cloud.storage;

public final class Acl$Group extends Acl$Entity {
   private static final long serialVersionUID = -1660987136294408826L;

   public Acl$Group(String email) {
      super(Acl$Entity$Type.GROUP, email);
   }

   public String getEmail() {
      return this.getValue();
   }
}
