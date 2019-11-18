package com.google.cloud.storage;

public final class Acl$RawEntity extends Acl$Entity {
   private static final long serialVersionUID = 3966205614223053950L;

   Acl$RawEntity(String entity) {
      super(Acl$Entity$Type.UNKNOWN, entity);
   }

   String toPb() {
      return this.getValue();
   }
}
