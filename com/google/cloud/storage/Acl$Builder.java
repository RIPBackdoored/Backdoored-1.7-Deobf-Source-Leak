package com.google.cloud.storage;

public class Acl$Builder {
   private Acl$Entity entity;
   private Acl$Role role;
   private String id;
   private String etag;

   private Acl$Builder(Acl$Entity entity, Acl$Role role) {
      this.entity = entity;
      this.role = role;
   }

   private Acl$Builder(Acl acl) {
      this.entity = Acl.access$100(acl);
      this.role = Acl.access$200(acl);
      this.id = Acl.access$300(acl);
      this.etag = Acl.access$400(acl);
   }

   public Acl$Builder setEntity(Acl$Entity entity) {
      this.entity = entity;
      return this;
   }

   public Acl$Builder setRole(Acl$Role role) {
      this.role = role;
      return this;
   }

   Acl$Builder setId(String id) {
      this.id = id;
      return this;
   }

   Acl$Builder setEtag(String etag) {
      this.etag = etag;
      return this;
   }

   public Acl build() {
      return new Acl(this, (Acl$1)null);
   }

   // $FF: synthetic method
   static Acl$Entity access$700(Acl$Builder x0) {
      return x0.entity;
   }

   // $FF: synthetic method
   static Acl$Role access$800(Acl$Builder x0) {
      return x0.role;
   }

   // $FF: synthetic method
   static String access$900(Acl$Builder x0) {
      return x0.id;
   }

   // $FF: synthetic method
   static String access$1000(Acl$Builder x0) {
      return x0.etag;
   }

   // $FF: synthetic method
   Acl$Builder(Acl x0, Acl$1 x1) {
      this(x0);
   }

   // $FF: synthetic method
   Acl$Builder(Acl$Entity x0, Acl$Role x1, Acl$1 x2) {
      this(x0, x1);
   }
}
