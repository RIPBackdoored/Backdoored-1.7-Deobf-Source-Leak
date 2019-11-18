package com.google.cloud.storage;

import com.google.api.gax.paging.Page;
import com.google.cloud.Tuple;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Bucket extends BucketInfo {
   private static final long serialVersionUID = 8574601739542252586L;
   private final StorageOptions options;
   private transient Storage storage;

   Bucket(Storage storage, BucketInfo$BuilderImpl infoBuilder) {
      super(infoBuilder);
      this.storage = (Storage)Preconditions.checkNotNull(storage);
      this.options = (StorageOptions)storage.getOptions();
   }

   public boolean exists(Bucket$BucketSourceOption... options) {
      int length = options.length;
      Storage$BucketGetOption[] getOptions = (Storage$BucketGetOption[])Arrays.copyOf(Bucket$BucketSourceOption.toGetOptions(this, options), length + 1);
      getOptions[length] = Storage$BucketGetOption.fields();
      return this.storage.get(this.getName(), getOptions) != null;
   }

   public Bucket reload(Bucket$BucketSourceOption... options) {
      return this.storage.get(this.getName(), Bucket$BucketSourceOption.toGetOptions(this, options));
   }

   public Bucket update(Storage$BucketTargetOption... options) {
      return this.storage.update((BucketInfo)this, (Storage$BucketTargetOption[])options);
   }

   public boolean delete(Bucket$BucketSourceOption... options) {
      return this.storage.delete(this.getName(), Bucket$BucketSourceOption.toSourceOptions(this, options));
   }

   public Page list(Storage$BlobListOption... options) {
      return this.storage.list(this.getName(), options);
   }

   public Blob get(String blob, Storage$BlobGetOption... options) {
      return this.storage.get(BlobId.of(this.getName(), blob), options);
   }

   public List get(String blobName1, String blobName2, String... blobNames) {
      List blobIds = Lists.newArrayListWithCapacity(blobNames.length + 2);
      blobIds.add(BlobId.of(this.getName(), blobName1));
      blobIds.add(BlobId.of(this.getName(), blobName2));
      String[] var5 = blobNames;
      int var6 = blobNames.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String blobName = var5[var7];
         blobIds.add(BlobId.of(this.getName(), blobName));
      }

      return this.storage.get((Iterable)blobIds);
   }

   public List get(Iterable blobNames) {
      com.google.common.collect.ImmutableList.Builder builder = ImmutableList.builder();
      Iterator var3 = blobNames.iterator();

      while(var3.hasNext()) {
         String blobName = (String)var3.next();
         builder.add(BlobId.of(this.getName(), blobName));
      }

      return this.storage.get((Iterable)builder.build());
   }

   public Blob create(String blob, byte[] content, String contentType, Bucket$BlobTargetOption... options) {
      BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(this.getName(), blob)).setContentType(contentType).build();
      Tuple target = Bucket$BlobTargetOption.toTargetOptions(blobInfo, options);
      return this.storage.create((BlobInfo)target.x(), content, (Storage$BlobTargetOption[])target.y());
   }

   public Blob create(String blob, InputStream content, String contentType, Bucket$BlobWriteOption... options) {
      BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(this.getName(), blob)).setContentType(contentType).build();
      Tuple write = Bucket$BlobWriteOption.toWriteOptions(blobInfo, options);
      return this.storage.create((BlobInfo)write.x(), content, (Storage$BlobWriteOption[])write.y());
   }

   public Blob create(String blob, byte[] content, Bucket$BlobTargetOption... options) {
      BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(this.getName(), blob)).build();
      Tuple target = Bucket$BlobTargetOption.toTargetOptions(blobInfo, options);
      return this.storage.create((BlobInfo)target.x(), content, (Storage$BlobTargetOption[])target.y());
   }

   public Blob create(String blob, InputStream content, Bucket$BlobWriteOption... options) {
      BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(this.getName(), blob)).build();
      Tuple write = Bucket$BlobWriteOption.toWriteOptions(blobInfo, options);
      return this.storage.create((BlobInfo)write.x(), content, (Storage$BlobWriteOption[])write.y());
   }

   public Acl getAcl(Acl$Entity entity) {
      return this.storage.getAcl(this.getName(), entity);
   }

   public boolean deleteAcl(Acl$Entity entity) {
      return this.storage.deleteAcl(this.getName(), entity);
   }

   public Acl createAcl(Acl acl) {
      return this.storage.createAcl(this.getName(), acl);
   }

   public Acl updateAcl(Acl acl) {
      return this.storage.updateAcl(this.getName(), acl);
   }

   public List listAcls() {
      return this.storage.listAcls(this.getName());
   }

   public Acl getDefaultAcl(Acl$Entity entity) {
      return this.storage.getDefaultAcl(this.getName(), entity);
   }

   public boolean deleteDefaultAcl(Acl$Entity entity) {
      return this.storage.deleteDefaultAcl(this.getName(), entity);
   }

   public Acl createDefaultAcl(Acl acl) {
      return this.storage.createDefaultAcl(this.getName(), acl);
   }

   public Acl updateDefaultAcl(Acl acl) {
      return this.storage.updateDefaultAcl(this.getName(), acl);
   }

   public List listDefaultAcls() {
      return this.storage.listDefaultAcls(this.getName());
   }

   public Bucket lockRetentionPolicy(Storage$BucketTargetOption... options) {
      return this.storage.lockRetentionPolicy(this, options);
   }

   public Storage getStorage() {
      return this.storage;
   }

   public Bucket$Builder toBuilder() {
      return new Bucket$Builder(this);
   }

   public final boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (obj != null && obj.getClass().equals(Bucket.class)) {
         Bucket other = (Bucket)obj;
         return Objects.equals(this.toPb(), other.toPb()) && Objects.equals(this.options, other.options);
      } else {
         return false;
      }
   }

   public final int hashCode() {
      return Objects.hash(new Object[]{super.hashCode(), this.options});
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.storage = (Storage)this.options.getService();
   }

   static Bucket fromPb(Storage storage, com.google.api.services.storage.model.Bucket bucketPb) {
      return new Bucket(storage, new BucketInfo$BuilderImpl(BucketInfo.fromPb(bucketPb)));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BucketInfo$Builder toBuilder() {
      return this.toBuilder();
   }

   // $FF: synthetic method
   static Storage access$100(Bucket x0) {
      return x0.storage;
   }
}
