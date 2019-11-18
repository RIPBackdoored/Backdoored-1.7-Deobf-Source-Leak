package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Objects;

public final class BlobId implements Serializable {
   private static final long serialVersionUID = -6156002883225601925L;
   private final String bucket;
   private final String name;
   private final Long generation;

   private BlobId(String bucket, String name, Long generation) {
      this.bucket = bucket;
      this.name = name;
      this.generation = generation;
   }

   public String getBucket() {
      return this.bucket;
   }

   public String getName() {
      return this.name;
   }

   public Long getGeneration() {
      return this.generation;
   }

   public String toString() {
      return MoreObjects.toStringHelper(this).add("bucket", this.getBucket()).add("name", this.getName()).add("generation", this.getGeneration()).toString();
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.bucket, this.name, this.generation});
   }

   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (obj != null && obj.getClass().equals(BlobId.class)) {
         BlobId other = (BlobId)obj;
         return Objects.equals(this.bucket, other.bucket) && Objects.equals(this.name, other.name) && Objects.equals(this.generation, other.generation);
      } else {
         return false;
      }
   }

   StorageObject toPb() {
      StorageObject storageObject = new StorageObject();
      storageObject.setBucket(this.bucket);
      storageObject.setName(this.name);
      storageObject.setGeneration(this.generation);
      return storageObject;
   }

   public static BlobId of(String bucket, String name) {
      return new BlobId((String)Preconditions.checkNotNull(bucket), (String)Preconditions.checkNotNull(name), (Long)null);
   }

   public static BlobId of(String bucket, String name, Long generation) {
      return new BlobId((String)Preconditions.checkNotNull(bucket), (String)Preconditions.checkNotNull(name), generation);
   }

   static BlobId fromPb(StorageObject storageObject) {
      return of(storageObject.getBucket(), storageObject.getName(), storageObject.getGeneration());
   }
}
