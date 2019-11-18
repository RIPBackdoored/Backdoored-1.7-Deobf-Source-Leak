package com.google.cloud.storage;

import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Objects;

public final class Acl implements Serializable {
   private static final long serialVersionUID = 7516713233557576082L;
   static final Function FROM_OBJECT_PB_FUNCTION = new Acl$1();
   static final Function FROM_BUCKET_PB_FUNCTION = new Acl$2();
   private final Acl$Entity entity;
   private final Acl$Role role;
   private final String id;
   private final String etag;

   private Acl(Acl$Builder builder) {
      this.entity = (Acl$Entity)Preconditions.checkNotNull(Acl$Builder.access$700(builder));
      this.role = (Acl$Role)Preconditions.checkNotNull(Acl$Builder.access$800(builder));
      this.id = Acl$Builder.access$900(builder);
      this.etag = Acl$Builder.access$1000(builder);
   }

   public Acl$Entity getEntity() {
      return this.entity;
   }

   public Acl$Role getRole() {
      return this.role;
   }

   public String getId() {
      return this.id;
   }

   public String getEtag() {
      return this.etag;
   }

   public Acl$Builder toBuilder() {
      return new Acl$Builder(this, (Acl$1)null);
   }

   public static Acl of(Acl$Entity entity, Acl$Role role) {
      return newBuilder(entity, role).build();
   }

   public static Acl$Builder newBuilder(Acl$Entity entity, Acl$Role role) {
      return new Acl$Builder(entity, role, (Acl$1)null);
   }

   public String toString() {
      return MoreObjects.toStringHelper(this).add("entity", this.entity).add("role", this.role).add("etag", this.etag).add("id", this.id).toString();
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.entity, this.role});
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj != null && this.getClass() == obj.getClass()) {
         Acl other = (Acl)obj;
         return Objects.equals(this.entity, other.entity) && Objects.equals(this.role, other.role) && Objects.equals(this.etag, other.etag) && Objects.equals(this.id, other.id);
      } else {
         return false;
      }
   }

   BucketAccessControl toBucketPb() {
      BucketAccessControl bucketPb = new BucketAccessControl();
      bucketPb.setEntity(this.getEntity().toString());
      bucketPb.setRole(this.getRole().toString());
      bucketPb.setId(this.getId());
      bucketPb.setEtag(this.getEtag());
      return bucketPb;
   }

   ObjectAccessControl toObjectPb() {
      ObjectAccessControl objectPb = new ObjectAccessControl();
      objectPb.setEntity(this.getEntity().toPb());
      objectPb.setRole(this.getRole().name());
      objectPb.setId(this.getId());
      objectPb.setEtag(this.getEtag());
      return objectPb;
   }

   static Acl fromPb(ObjectAccessControl objectAccessControl) {
      Acl$Role role = Acl$Role.valueOf(objectAccessControl.getRole());
      Acl$Entity entity = Acl$Entity.fromPb(objectAccessControl.getEntity());
      return newBuilder(entity, role).setEtag(objectAccessControl.getEtag()).setId(objectAccessControl.getId()).build();
   }

   static Acl fromPb(BucketAccessControl bucketAccessControl) {
      Acl$Role role = Acl$Role.valueOf(bucketAccessControl.getRole());
      Acl$Entity entity = Acl$Entity.fromPb(bucketAccessControl.getEntity());
      return newBuilder(entity, role).setEtag(bucketAccessControl.getEtag()).setId(bucketAccessControl.getId()).build();
   }

   // $FF: synthetic method
   static Acl$Entity access$100(Acl x0) {
      return x0.entity;
   }

   // $FF: synthetic method
   static Acl$Role access$200(Acl x0) {
      return x0.role;
   }

   // $FF: synthetic method
   static String access$300(Acl x0) {
      return x0.id;
   }

   // $FF: synthetic method
   static String access$400(Acl x0) {
      return x0.etag;
   }

   // $FF: synthetic method
   Acl(Acl$Builder x0, Acl$1 x1) {
      this(x0);
   }
}
