package com.google.cloud.storage;

import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.ReadChannel;
import com.google.cloud.RetryHelper;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.io.CountingOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Blob extends BlobInfo {
   private static final long serialVersionUID = -6806832496717441434L;
   private final StorageOptions options;
   private transient Storage storage;
   static final Function BLOB_FROM_PB_FUNCTION = new Blob$1();
   private static final int DEFAULT_CHUNK_SIZE = 2097152;

   public void downloadTo(Path path, Blob$BlobSourceOption... options) {
      try {
         OutputStream outputStream = Files.newOutputStream(path);
         Throwable var4 = null;

         try {
            this.downloadTo(outputStream, options);
         } catch (Throwable var14) {
            var4 = var14;
            throw var14;
         } finally {
            if (outputStream != null) {
               if (var4 != null) {
                  try {
                     outputStream.close();
                  } catch (Throwable var13) {
                     var4.addSuppressed(var13);
                  }
               } else {
                  outputStream.close();
               }
            }

         }
      } catch (IOException var16) {
         throw new StorageException(var16);
      }

   }

   public void downloadTo(OutputStream outputStream, Blob$BlobSourceOption... options) {
      CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
      StorageRpc storageRpc = this.options.getStorageRpcV1();
      Map requestOptions = StorageImpl.optionMap((BlobId)this.getBlobId(), options);
      RetryHelper.runWithRetries(Executors.callable(new Blob$2(this, storageRpc, requestOptions, countingOutputStream)), this.options.getRetrySettings(), StorageImpl.EXCEPTION_HANDLER, this.options.getClock());
   }

   public void downloadTo(Path path) {
      this.downloadTo(path);
   }

   Blob(Storage storage, BlobInfo$BuilderImpl infoBuilder) {
      super(infoBuilder);
      this.storage = (Storage)Preconditions.checkNotNull(storage);
      this.options = (StorageOptions)storage.getOptions();
   }

   public boolean exists(Blob$BlobSourceOption... options) {
      int length = options.length;
      Storage$BlobGetOption[] getOptions = (Storage$BlobGetOption[])Arrays.copyOf(Blob$BlobSourceOption.toGetOptions(this, options), length + 1);
      getOptions[length] = Storage$BlobGetOption.fields();
      return this.storage.get(this.getBlobId(), getOptions) != null;
   }

   public byte[] getContent(Blob$BlobSourceOption... options) {
      return this.storage.readAllBytes(this.getBlobId(), Blob$BlobSourceOption.toSourceOptions(this, options));
   }

   public Blob reload(Blob$BlobSourceOption... options) {
      return this.storage.get(this.getBlobId(), Blob$BlobSourceOption.toGetOptions(this, options));
   }

   public Blob update(Storage$BlobTargetOption... options) {
      return this.storage.update((BlobInfo)this, (Storage$BlobTargetOption[])options);
   }

   public boolean delete(Blob$BlobSourceOption... options) {
      return this.storage.delete(this.getBlobId(), Blob$BlobSourceOption.toSourceOptions(this, options));
   }

   public CopyWriter copyTo(BlobId targetBlob, Blob$BlobSourceOption... options) {
      Storage$CopyRequest copyRequest = Storage$CopyRequest.newBuilder().setSource(this.getBucket(), this.getName()).setSourceOptions(Blob$BlobSourceOption.toSourceOptions(this, options)).setTarget(targetBlob).build();
      return this.storage.copy(copyRequest);
   }

   public CopyWriter copyTo(String targetBucket, Blob$BlobSourceOption... options) {
      return this.copyTo(targetBucket, this.getName(), options);
   }

   public CopyWriter copyTo(String targetBucket, String targetBlob, Blob$BlobSourceOption... options) {
      return this.copyTo(BlobId.of(targetBucket, targetBlob), options);
   }

   public ReadChannel reader(Blob$BlobSourceOption... options) {
      return this.storage.reader(this.getBlobId(), Blob$BlobSourceOption.toSourceOptions(this, options));
   }

   public WriteChannel writer(Storage$BlobWriteOption... options) {
      return this.storage.writer(this, options);
   }

   public URL signUrl(long duration, TimeUnit unit, Storage$SignUrlOption... options) {
      return this.storage.signUrl(this, duration, unit, options);
   }

   public Acl getAcl(Acl$Entity entity) {
      return this.storage.getAcl(this.getBlobId(), entity);
   }

   public boolean deleteAcl(Acl$Entity entity) {
      return this.storage.deleteAcl(this.getBlobId(), entity);
   }

   public Acl createAcl(Acl acl) {
      return this.storage.createAcl(this.getBlobId(), acl);
   }

   public Acl updateAcl(Acl acl) {
      return this.storage.updateAcl(this.getBlobId(), acl);
   }

   public List listAcls() {
      return this.storage.listAcls(this.getBlobId());
   }

   public Storage getStorage() {
      return this.storage;
   }

   public Blob$Builder toBuilder() {
      return new Blob$Builder(this);
   }

   public final boolean equals(Object obj) {
      if (obj == this) {
         return true;
      } else if (obj != null && obj.getClass().equals(Blob.class)) {
         Blob other = (Blob)obj;
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

   static Blob fromPb(Storage storage, StorageObject storageObject) {
      BlobInfo info = BlobInfo.fromPb(storageObject);
      return new Blob(storage, new BlobInfo$BuilderImpl(info));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public BlobInfo$Builder toBuilder() {
      return this.toBuilder();
   }
}
