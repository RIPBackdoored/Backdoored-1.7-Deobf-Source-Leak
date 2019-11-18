package com.google.cloud.storage;

import com.google.api.gax.paging.Page;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.HmacKeyMetadata;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.TestIamPermissionsResponse;
import com.google.auth.ServiceAccountSigner;
import com.google.cloud.BaseService;
import com.google.cloud.PageImpl;
import com.google.cloud.Policy;
import com.google.cloud.ReadChannel;
import com.google.cloud.RetryHelper;
import com.google.cloud.Tuple;
import com.google.cloud.WriteChannel;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc$Option;
import com.google.cloud.storage.spi.v1.StorageRpc$RewriteResponse;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import com.google.common.net.UrlEscapers;
import com.google.common.primitives.Ints;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class StorageImpl extends BaseService implements Storage {
   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
   private static final String EMPTY_BYTE_ARRAY_MD5 = "1B2M2Y8AsgTpgAmY7PhCfg==";
   private static final String EMPTY_BYTE_ARRAY_CRC32C = "AAAAAA==";
   private static final String PATH_DELIMITER = "/";
   private static final String STORAGE_XML_HOST_NAME = "https://storage.googleapis.com";
   private static final Function DELETE_FUNCTION = new StorageImpl$1();
   private final StorageRpc storageRpc;

   StorageImpl(StorageOptions options) {
      super(options);
      this.storageRpc = options.getStorageRpcV1();
   }

   public Bucket create(BucketInfo bucketInfo, Storage$BucketTargetOption... options) {
      com.google.api.services.storage.model.Bucket bucketPb = bucketInfo.toPb();
      Map optionsMap = optionMap((BucketInfo)bucketInfo, options);

      Bucket var10000;
      try {
         var10000 = Bucket.fromPb(this, (com.google.api.services.storage.model.Bucket)RetryHelper.runWithRetries(new StorageImpl$2(this, bucketPb, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public Blob create(BlobInfo blobInfo, Storage$BlobTargetOption... options) {
      BlobInfo updatedInfo = blobInfo.toBuilder().setMd5("1B2M2Y8AsgTpgAmY7PhCfg==").setCrc32c("AAAAAA==").build();
      return this.internalCreate(updatedInfo, EMPTY_BYTE_ARRAY, options);
   }

   public Blob create(BlobInfo blobInfo, byte[] content, Storage$BlobTargetOption... options) {
      content = (byte[])MoreObjects.firstNonNull(content, EMPTY_BYTE_ARRAY);
      BlobInfo updatedInfo = blobInfo.toBuilder().setMd5(BaseEncoding.base64().encode(Hashing.md5().hashBytes(content).asBytes())).setCrc32c(BaseEncoding.base64().encode(Ints.toByteArray(Hashing.crc32c().hashBytes(content).asInt()))).build();
      return this.internalCreate(updatedInfo, content, options);
   }

   public Blob create(BlobInfo blobInfo, byte[] content, int offset, int length, Storage$BlobTargetOption... options) {
      content = (byte[])MoreObjects.firstNonNull(content, EMPTY_BYTE_ARRAY);
      byte[] subContent = Arrays.copyOfRange(content, offset, offset + length);
      BlobInfo updatedInfo = blobInfo.toBuilder().setMd5(BaseEncoding.base64().encode(Hashing.md5().hashBytes(subContent).asBytes())).setCrc32c(BaseEncoding.base64().encode(Ints.toByteArray(Hashing.crc32c().hashBytes(subContent).asInt()))).build();
      return this.internalCreate(updatedInfo, subContent, options);
   }

   /** @deprecated */
   @Deprecated
   public Blob create(BlobInfo blobInfo, InputStream content, Storage$BlobWriteOption... options) {
      Tuple targetOptions = Storage$BlobTargetOption.convert(blobInfo, options);
      StorageObject blobPb = ((BlobInfo)targetOptions.x()).toPb();
      Map optionsMap = optionMap((BlobInfo)targetOptions.x(), (Option[])targetOptions.y());
      InputStream inputStreamParam = (InputStream)MoreObjects.firstNonNull(content, new ByteArrayInputStream(EMPTY_BYTE_ARRAY));
      return Blob.fromPb(this, this.storageRpc.create(blobPb, inputStreamParam, optionsMap));
   }

   private Blob internalCreate(BlobInfo info, byte[] content, Storage$BlobTargetOption... options) {
      Preconditions.checkNotNull(content);
      StorageObject blobPb = info.toPb();
      Map optionsMap = optionMap((BlobInfo)info, options);

      Blob var10000;
      try {
         var10000 = Blob.fromPb(this, (StorageObject)RetryHelper.runWithRetries(new StorageImpl$3(this, blobPb, content, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var7) {
         throw StorageException.translateAndThrow(var7);
      }

      return var10000;
   }

   public Bucket get(String bucket, Storage$BucketGetOption... options) {
      com.google.api.services.storage.model.Bucket bucketPb = BucketInfo.of(bucket).toPb();
      Map optionsMap = optionMap(options);

      Bucket var10000;
      try {
         com.google.api.services.storage.model.Bucket answer = (com.google.api.services.storage.model.Bucket)RetryHelper.runWithRetries(new StorageImpl$4(this, bucketPb, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         var10000 = answer == null ? null : Bucket.fromPb(this, answer);
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public Blob get(String bucket, String blob, Storage$BlobGetOption... options) {
      return this.get(BlobId.of(bucket, blob), options);
   }

   public Blob get(BlobId blob, Storage$BlobGetOption... options) {
      StorageObject storedObject = blob.toPb();
      Map optionsMap = optionMap((BlobId)blob, options);

      Blob var10000;
      try {
         StorageObject storageObject = (StorageObject)RetryHelper.runWithRetries(new StorageImpl$5(this, storedObject, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         var10000 = storageObject == null ? null : Blob.fromPb(this, storageObject);
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public Blob get(BlobId blob) {
      return this.get(blob);
   }

   public Page list(Storage$BucketListOption... options) {
      return listBuckets((StorageOptions)this.getOptions(), optionMap(options));
   }

   public Page list(String bucket, Storage$BlobListOption... options) {
      return listBlobs(bucket, (StorageOptions)this.getOptions(), optionMap(options));
   }

   private static Page listBuckets(StorageOptions serviceOptions, Map optionsMap) {
      PageImpl var10000;
      try {
         Tuple result = (Tuple)RetryHelper.runWithRetries(new StorageImpl$6(serviceOptions, optionsMap), serviceOptions.getRetrySettings(), EXCEPTION_HANDLER, serviceOptions.getClock());
         String cursor = (String)result.x();
         Iterable buckets = result.y() == null ? ImmutableList.of() : Iterables.transform((Iterable)result.y(), new StorageImpl$7(serviceOptions));
         var10000 = new PageImpl(new StorageImpl$BucketPageFetcher(serviceOptions, cursor, optionsMap), cursor, (Iterable)buckets);
      } catch (RetryHelperException var5) {
         throw StorageException.translateAndThrow(var5);
      }

      return var10000;
   }

   private static Page listBlobs(String bucket, StorageOptions serviceOptions, Map optionsMap) {
      PageImpl var10000;
      try {
         Tuple result = (Tuple)RetryHelper.runWithRetries(new StorageImpl$8(serviceOptions, bucket, optionsMap), serviceOptions.getRetrySettings(), EXCEPTION_HANDLER, serviceOptions.getClock());
         String cursor = (String)result.x();
         Iterable blobs = result.y() == null ? ImmutableList.of() : Iterables.transform((Iterable)result.y(), new StorageImpl$9(serviceOptions));
         var10000 = new PageImpl(new StorageImpl$BlobPageFetcher(bucket, serviceOptions, cursor, optionsMap), cursor, (Iterable)blobs);
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public Bucket update(BucketInfo bucketInfo, Storage$BucketTargetOption... options) {
      com.google.api.services.storage.model.Bucket bucketPb = bucketInfo.toPb();
      Map optionsMap = optionMap((BucketInfo)bucketInfo, options);

      Bucket var10000;
      try {
         var10000 = Bucket.fromPb(this, (com.google.api.services.storage.model.Bucket)RetryHelper.runWithRetries(new StorageImpl$10(this, bucketPb, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public Blob update(BlobInfo blobInfo, Storage$BlobTargetOption... options) {
      StorageObject storageObject = blobInfo.toPb();
      Map optionsMap = optionMap((BlobInfo)blobInfo, options);

      Blob var10000;
      try {
         var10000 = Blob.fromPb(this, (StorageObject)RetryHelper.runWithRetries(new StorageImpl$11(this, storageObject, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public Blob update(BlobInfo blobInfo) {
      return this.update(blobInfo);
   }

   public boolean delete(String bucket, Storage$BucketSourceOption... options) {
      com.google.api.services.storage.model.Bucket bucketPb = BucketInfo.of(bucket).toPb();
      Map optionsMap = optionMap(options);

      boolean var10000;
      try {
         var10000 = (Boolean)RetryHelper.runWithRetries(new StorageImpl$12(this, bucketPb, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public boolean delete(String bucket, String blob, Storage$BlobSourceOption... options) {
      return this.delete(BlobId.of(bucket, blob), options);
   }

   public boolean delete(BlobId blob, Storage$BlobSourceOption... options) {
      StorageObject storageObject = blob.toPb();
      Map optionsMap = optionMap((BlobId)blob, options);

      boolean var10000;
      try {
         var10000 = (Boolean)RetryHelper.runWithRetries(new StorageImpl$13(this, storageObject, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public boolean delete(BlobId blob) {
      return this.delete(blob);
   }

   public Blob compose(Storage$ComposeRequest composeRequest) {
      List sources = Lists.newArrayListWithCapacity(composeRequest.getSourceBlobs().size());
      Iterator var3 = composeRequest.getSourceBlobs().iterator();

      while(var3.hasNext()) {
         Storage$ComposeRequest$SourceBlob sourceBlob = (Storage$ComposeRequest$SourceBlob)var3.next();
         sources.add(BlobInfo.newBuilder(BlobId.of(composeRequest.getTarget().getBucket(), sourceBlob.getName(), sourceBlob.getGeneration())).build().toPb());
      }

      StorageObject target = composeRequest.getTarget().toPb();
      Map targetOptions = optionMap(composeRequest.getTarget().getGeneration(), composeRequest.getTarget().getMetageneration(), (Iterable)composeRequest.getTargetOptions());

      Blob var10000;
      try {
         var10000 = Blob.fromPb(this, (StorageObject)RetryHelper.runWithRetries(new StorageImpl$14(this, sources, target, targetOptions), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public CopyWriter copy(Storage$CopyRequest copyRequest) {
      StorageObject source = copyRequest.getSource().toPb();
      Map sourceOptions = optionMap(copyRequest.getSource().getGeneration(), (Long)null, copyRequest.getSourceOptions(), true);
      StorageObject targetObject = copyRequest.getTarget().toPb();
      Map targetOptions = optionMap(copyRequest.getTarget().getGeneration(), copyRequest.getTarget().getMetageneration(), (Iterable)copyRequest.getTargetOptions());

      CopyWriter var10000;
      try {
         StorageRpc$RewriteResponse rewriteResponse = (StorageRpc$RewriteResponse)RetryHelper.runWithRetries(new StorageImpl$15(this, source, sourceOptions, copyRequest, targetObject, targetOptions), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         var10000 = new CopyWriter((StorageOptions)this.getOptions(), rewriteResponse);
      } catch (RetryHelperException var7) {
         throw StorageException.translateAndThrow(var7);
      }

      return var10000;
   }

   public byte[] readAllBytes(String bucket, String blob, Storage$BlobSourceOption... options) {
      return this.readAllBytes(BlobId.of(bucket, blob), options);
   }

   public byte[] readAllBytes(BlobId blob, Storage$BlobSourceOption... options) {
      StorageObject storageObject = blob.toPb();
      Map optionsMap = optionMap((BlobId)blob, options);

      byte[] var10000;
      try {
         var10000 = (byte[])RetryHelper.runWithRetries(new StorageImpl$16(this, storageObject, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public StorageBatch batch() {
      return new StorageBatch((StorageOptions)this.getOptions());
   }

   public ReadChannel reader(String bucket, String blob, Storage$BlobSourceOption... options) {
      Map optionsMap = optionMap(options);
      return new BlobReadChannel((StorageOptions)this.getOptions(), BlobId.of(bucket, blob), optionsMap);
   }

   public ReadChannel reader(BlobId blob, Storage$BlobSourceOption... options) {
      Map optionsMap = optionMap((BlobId)blob, options);
      return new BlobReadChannel((StorageOptions)this.getOptions(), blob, optionsMap);
   }

   public BlobWriteChannel writer(BlobInfo blobInfo, Storage$BlobWriteOption... options) {
      Tuple targetOptions = Storage$BlobTargetOption.convert(blobInfo, options);
      return this.writer((BlobInfo)targetOptions.x(), (Storage$BlobTargetOption[])targetOptions.y());
   }

   public BlobWriteChannel writer(URL signedURL) {
      return new BlobWriteChannel((StorageOptions)this.getOptions(), signedURL);
   }

   private BlobWriteChannel writer(BlobInfo blobInfo, Storage$BlobTargetOption... options) {
      Map optionsMap = optionMap((BlobInfo)blobInfo, options);
      return new BlobWriteChannel((StorageOptions)this.getOptions(), blobInfo, optionsMap);
   }

   public URL signUrl(BlobInfo blobInfo, long duration, TimeUnit unit, Storage$SignUrlOption... options) {
      EnumMap optionMap = Maps.newEnumMap(Storage$SignUrlOption$Option.class);
      Storage$SignUrlOption[] var7 = options;
      int var8 = options.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         Storage$SignUrlOption option = var7[var9];
         optionMap.put(option.getOption(), option.getValue());
      }

      boolean isV4 = Storage$SignUrlOption$SignatureVersion.V4.equals(optionMap.get(Storage$SignUrlOption$Option.SIGNATURE_VERSION));
      ServiceAccountSigner credentials = (ServiceAccountSigner)optionMap.get(Storage$SignUrlOption$Option.SERVICE_ACCOUNT_CRED);
      if (credentials == null) {
         Preconditions.checkState(((StorageOptions)this.getOptions()).getCredentials() instanceof ServiceAccountSigner, "Signing key was not provided and could not be derived");
         credentials = (ServiceAccountSigner)((StorageOptions)this.getOptions()).getCredentials();
      }

      long expiration = isV4 ? TimeUnit.SECONDS.convert(unit.toMillis(duration), TimeUnit.MILLISECONDS) : TimeUnit.SECONDS.convert(((StorageOptions)this.getOptions()).getClock().millisTime() + unit.toMillis(duration), TimeUnit.MILLISECONDS);
      String storageXmlHostName = optionMap.get(Storage$SignUrlOption$Option.HOST_NAME) != null ? (String)optionMap.get(Storage$SignUrlOption$Option.HOST_NAME) : "https://storage.googleapis.com";
      String bucketName = CharMatcher.anyOf("/").trimFrom(blobInfo.getBucket());
      String escapedBlobName = "";
      if (!Strings.isNullOrEmpty(blobInfo.getName())) {
         escapedBlobName = UrlEscapers.urlFragmentEscaper().escape(blobInfo.getName()).replace("?", "%3F").replace(";", "%3B");
      }

      String stPath = this.constructResourceUriPath(bucketName, escapedBlobName);
      URI path = URI.create(stPath);

      URL var10000;
      try {
         SignatureInfo signatureInfo = this.buildSignatureInfo(optionMap, blobInfo, expiration, path, credentials.getAccount());
         String unsignedPayload = signatureInfo.constructUnsignedPayload();
         byte[] signatureBytes = credentials.sign(unsignedPayload.getBytes(StandardCharsets.UTF_8));
         StringBuilder stBuilder = new StringBuilder();
         stBuilder.append(storageXmlHostName).append(path);
         BaseEncoding encoding;
         String signature;
         if (isV4) {
            encoding = BaseEncoding.base16().lowerCase();
            signature = URLEncoder.encode(encoding.encode(signatureBytes), StandardCharsets.UTF_8.name());
            stBuilder.append("?");
            stBuilder.append(signatureInfo.constructV4QueryString());
            stBuilder.append("&X-Goog-Signature=").append(signature);
         } else {
            encoding = BaseEncoding.base64();
            signature = URLEncoder.encode(encoding.encode(signatureBytes), StandardCharsets.UTF_8.name());
            stBuilder.append("?");
            stBuilder.append("GoogleAccessId=").append(credentials.getAccount());
            stBuilder.append("&Expires=").append(expiration);
            stBuilder.append("&Signature=").append(signature);
         }

         var10000 = new URL(stBuilder.toString());
      } catch (UnsupportedEncodingException | MalformedURLException var22) {
         throw new IllegalStateException(var22);
      }

      return var10000;
   }

   private String constructResourceUriPath(String slashlessBucketName, String escapedBlobName) {
      StringBuilder pathBuilder = new StringBuilder();
      pathBuilder.append("/").append(slashlessBucketName);
      if (Strings.isNullOrEmpty(escapedBlobName)) {
         return pathBuilder.toString();
      } else {
         if (!escapedBlobName.startsWith("/")) {
            pathBuilder.append("/");
         }

         pathBuilder.append(escapedBlobName);
         return pathBuilder.toString();
      }
   }

   private SignatureInfo buildSignatureInfo(Map optionMap, BlobInfo blobInfo, long expiration, URI path, String accountEmail) {
      HttpMethod httpVerb = optionMap.containsKey(Storage$SignUrlOption$Option.HTTP_METHOD) ? (HttpMethod)optionMap.get(Storage$SignUrlOption$Option.HTTP_METHOD) : HttpMethod.GET;
      SignatureInfo$Builder signatureInfoBuilder = new SignatureInfo$Builder(httpVerb, expiration, path);
      if ((Boolean)MoreObjects.firstNonNull((Boolean)optionMap.get(Storage$SignUrlOption$Option.MD5), false)) {
         Preconditions.checkArgument(blobInfo.getMd5() != null, "Blob is missing a value for md5");
         signatureInfoBuilder.setContentMd5(blobInfo.getMd5());
      }

      if ((Boolean)MoreObjects.firstNonNull((Boolean)optionMap.get(Storage$SignUrlOption$Option.CONTENT_TYPE), false)) {
         Preconditions.checkArgument(blobInfo.getContentType() != null, "Blob is missing a value for content-type");
         signatureInfoBuilder.setContentType(blobInfo.getContentType());
      }

      signatureInfoBuilder.setSignatureVersion((Storage$SignUrlOption$SignatureVersion)optionMap.get(Storage$SignUrlOption$Option.SIGNATURE_VERSION));
      signatureInfoBuilder.setAccountEmail(accountEmail);
      signatureInfoBuilder.setTimestamp(((StorageOptions)this.getOptions()).getClock().millisTime());
      Map extHeaders = optionMap.containsKey(Storage$SignUrlOption$Option.EXT_HEADERS) ? (Map)optionMap.get(Storage$SignUrlOption$Option.EXT_HEADERS) : Collections.emptyMap();
      return signatureInfoBuilder.setCanonicalizedExtensionHeaders(extHeaders).build();
   }

   public List get(BlobId... blobIds) {
      return this.get((Iterable)Arrays.asList(blobIds));
   }

   public List get(Iterable blobIds) {
      StorageBatch batch = this.batch();
      List results = Lists.newArrayList();
      Iterator var4 = blobIds.iterator();

      while(var4.hasNext()) {
         BlobId blob = (BlobId)var4.next();
         batch.get(blob).notify(new StorageImpl$17(this, results));
      }

      batch.submit();
      return Collections.unmodifiableList(results);
   }

   public List update(BlobInfo... blobInfos) {
      return this.update((Iterable)Arrays.asList(blobInfos));
   }

   public List update(Iterable blobInfos) {
      StorageBatch batch = this.batch();
      List results = Lists.newArrayList();
      Iterator var4 = blobInfos.iterator();

      while(var4.hasNext()) {
         BlobInfo blobInfo = (BlobInfo)var4.next();
         batch.update(blobInfo).notify(new StorageImpl$18(this, results));
      }

      batch.submit();
      return Collections.unmodifiableList(results);
   }

   public List delete(BlobId... blobIds) {
      return this.delete((Iterable)Arrays.asList(blobIds));
   }

   public List delete(Iterable blobIds) {
      StorageBatch batch = this.batch();
      List results = Lists.newArrayList();
      Iterator var4 = blobIds.iterator();

      while(var4.hasNext()) {
         BlobId blob = (BlobId)var4.next();
         batch.delete(blob).notify(new StorageImpl$19(this, results));
      }

      batch.submit();
      return Collections.unmodifiableList(results);
   }

   public Acl getAcl(String bucket, Acl$Entity entity, Storage$BucketSourceOption... options) {
      Acl var10000;
      try {
         Map optionsMap = optionMap(options);
         BucketAccessControl answer = (BucketAccessControl)RetryHelper.runWithRetries(new StorageImpl$20(this, bucket, entity, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         var10000 = answer == null ? null : Acl.fromPb(answer);
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public Acl getAcl(String bucket, Acl$Entity entity) {
      return this.getAcl(bucket, entity);
   }

   public boolean deleteAcl(String bucket, Acl$Entity entity, Storage$BucketSourceOption... options) {
      boolean var10000;
      try {
         Map optionsMap = optionMap(options);
         var10000 = (Boolean)RetryHelper.runWithRetries(new StorageImpl$21(this, bucket, entity, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
      } catch (RetryHelperException var5) {
         throw StorageException.translateAndThrow(var5);
      }

      return var10000;
   }

   public boolean deleteAcl(String bucket, Acl$Entity entity) {
      return this.deleteAcl(bucket, entity);
   }

   public Acl createAcl(String bucket, Acl acl, Storage$BucketSourceOption... options) {
      BucketAccessControl aclPb = acl.toBucketPb().setBucket(bucket);

      Acl var10000;
      try {
         Map optionsMap = optionMap(options);
         var10000 = Acl.fromPb((BucketAccessControl)RetryHelper.runWithRetries(new StorageImpl$22(this, aclPb, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public Acl createAcl(String bucket, Acl acl) {
      return this.createAcl(bucket, acl);
   }

   public Acl updateAcl(String bucket, Acl acl, Storage$BucketSourceOption... options) {
      BucketAccessControl aclPb = acl.toBucketPb().setBucket(bucket);

      Acl var10000;
      try {
         Map optionsMap = optionMap(options);
         var10000 = Acl.fromPb((BucketAccessControl)RetryHelper.runWithRetries(new StorageImpl$23(this, aclPb, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public Acl updateAcl(String bucket, Acl acl) {
      return this.updateAcl(bucket, acl);
   }

   public List listAcls(String bucket, Storage$BucketSourceOption... options) {
      List var10000;
      try {
         Map optionsMap = optionMap(options);
         List answer = (List)RetryHelper.runWithRetries(new StorageImpl$24(this, bucket, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         var10000 = Lists.transform(answer, Acl.FROM_BUCKET_PB_FUNCTION);
      } catch (RetryHelperException var5) {
         throw StorageException.translateAndThrow(var5);
      }

      return var10000;
   }

   public List listAcls(String bucket) {
      return this.listAcls(bucket);
   }

   public Acl getDefaultAcl(String bucket, Acl$Entity entity) {
      Acl var10000;
      try {
         ObjectAccessControl answer = (ObjectAccessControl)RetryHelper.runWithRetries(new StorageImpl$25(this, bucket, entity), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         var10000 = answer == null ? null : Acl.fromPb(answer);
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

      return var10000;
   }

   public boolean deleteDefaultAcl(String bucket, Acl$Entity entity) {
      boolean var10000;
      try {
         var10000 = (Boolean)RetryHelper.runWithRetries(new StorageImpl$26(this, bucket, entity), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

      return var10000;
   }

   public Acl createDefaultAcl(String bucket, Acl acl) {
      ObjectAccessControl aclPb = acl.toObjectPb().setBucket(bucket);

      Acl var10000;
      try {
         var10000 = Acl.fromPb((ObjectAccessControl)RetryHelper.runWithRetries(new StorageImpl$27(this, aclPb), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var5) {
         throw StorageException.translateAndThrow(var5);
      }

      return var10000;
   }

   public Acl updateDefaultAcl(String bucket, Acl acl) {
      ObjectAccessControl aclPb = acl.toObjectPb().setBucket(bucket);

      Acl var10000;
      try {
         var10000 = Acl.fromPb((ObjectAccessControl)RetryHelper.runWithRetries(new StorageImpl$28(this, aclPb), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var5) {
         throw StorageException.translateAndThrow(var5);
      }

      return var10000;
   }

   public List listDefaultAcls(String bucket) {
      List var10000;
      try {
         List answer = (List)RetryHelper.runWithRetries(new StorageImpl$29(this, bucket), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         var10000 = Lists.transform(answer, Acl.FROM_OBJECT_PB_FUNCTION);
      } catch (RetryHelperException var3) {
         throw StorageException.translateAndThrow(var3);
      }

      return var10000;
   }

   public Acl getAcl(BlobId blob, Acl$Entity entity) {
      Acl var10000;
      try {
         ObjectAccessControl answer = (ObjectAccessControl)RetryHelper.runWithRetries(new StorageImpl$30(this, blob, entity), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         var10000 = answer == null ? null : Acl.fromPb(answer);
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

      return var10000;
   }

   public boolean deleteAcl(BlobId blob, Acl$Entity entity) {
      boolean var10000;
      try {
         var10000 = (Boolean)RetryHelper.runWithRetries(new StorageImpl$31(this, blob, entity), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

      return var10000;
   }

   public Acl createAcl(BlobId blob, Acl acl) {
      ObjectAccessControl aclPb = acl.toObjectPb().setBucket(blob.getBucket()).setObject(blob.getName()).setGeneration(blob.getGeneration());

      Acl var10000;
      try {
         var10000 = Acl.fromPb((ObjectAccessControl)RetryHelper.runWithRetries(new StorageImpl$32(this, aclPb), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var5) {
         throw StorageException.translateAndThrow(var5);
      }

      return var10000;
   }

   public Acl updateAcl(BlobId blob, Acl acl) {
      ObjectAccessControl aclPb = acl.toObjectPb().setBucket(blob.getBucket()).setObject(blob.getName()).setGeneration(blob.getGeneration());

      Acl var10000;
      try {
         var10000 = Acl.fromPb((ObjectAccessControl)RetryHelper.runWithRetries(new StorageImpl$33(this, aclPb), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var5) {
         throw StorageException.translateAndThrow(var5);
      }

      return var10000;
   }

   public List listAcls(BlobId blob) {
      List var10000;
      try {
         List answer = (List)RetryHelper.runWithRetries(new StorageImpl$34(this, blob), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         var10000 = Lists.transform(answer, Acl.FROM_OBJECT_PB_FUNCTION);
      } catch (RetryHelperException var3) {
         throw StorageException.translateAndThrow(var3);
      }

      return var10000;
   }

   public HmacKey createHmacKey(ServiceAccount serviceAccount, Storage$CreateHmacKeyOption... options) {
      HmacKey var10000;
      try {
         var10000 = HmacKey.fromPb((com.google.api.services.storage.model.HmacKey)RetryHelper.runWithRetries(new StorageImpl$35(this, serviceAccount, options), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

      return var10000;
   }

   public Page listHmacKeys(Storage$ListHmacKeysOption... options) {
      return listHmacKeys((StorageOptions)this.getOptions(), optionMap(options));
   }

   public HmacKey$HmacKeyMetadata getHmacKey(String accessId, Storage$GetHmacKeyOption... options) {
      HmacKey$HmacKeyMetadata var10000;
      try {
         var10000 = HmacKey$HmacKeyMetadata.fromPb((HmacKeyMetadata)RetryHelper.runWithRetries(new StorageImpl$36(this, accessId, options), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

      return var10000;
   }

   private HmacKey$HmacKeyMetadata updateHmacKey(HmacKey$HmacKeyMetadata hmacKeyMetadata, Storage$UpdateHmacKeyOption... options) {
      HmacKey$HmacKeyMetadata var10000;
      try {
         var10000 = HmacKey$HmacKeyMetadata.fromPb((HmacKeyMetadata)RetryHelper.runWithRetries(new StorageImpl$37(this, hmacKeyMetadata, options), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

      return var10000;
   }

   public HmacKey$HmacKeyMetadata updateHmacKeyState(HmacKey$HmacKeyMetadata hmacKeyMetadata, HmacKey$HmacKeyState state, Storage$UpdateHmacKeyOption... options) {
      HmacKey$HmacKeyMetadata updatedMetadata = HmacKey$HmacKeyMetadata.newBuilder(hmacKeyMetadata.getServiceAccount()).setProjectId(hmacKeyMetadata.getProjectId()).setAccessId(hmacKeyMetadata.getAccessId()).setState(state).build();
      return this.updateHmacKey(updatedMetadata, options);
   }

   public void deleteHmacKey(HmacKey$HmacKeyMetadata metadata, Storage$DeleteHmacKeyOption... options) {
      try {
         RetryHelper.runWithRetries(new StorageImpl$38(this, metadata, options), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

   }

   private static Page listHmacKeys(StorageOptions serviceOptions, Map options) {
      PageImpl var10000;
      try {
         Tuple result = (Tuple)RetryHelper.runWithRetries(new StorageImpl$39(serviceOptions, options), serviceOptions.getRetrySettings(), EXCEPTION_HANDLER, serviceOptions.getClock());
         String cursor = (String)result.x();
         Iterable metadata = result.y() == null ? ImmutableList.of() : Iterables.transform((Iterable)result.y(), new StorageImpl$40());
         var10000 = new PageImpl(new StorageImpl$HmacKeyMetadataPageFetcher(serviceOptions, options), cursor, (Iterable)metadata);
      } catch (RetryHelperException var5) {
         throw StorageException.translateAndThrow(var5);
      }

      return var10000;
   }

   public Policy getIamPolicy(String bucket, Storage$BucketSourceOption... options) {
      Policy var10000;
      try {
         Map optionsMap = optionMap(options);
         var10000 = PolicyHelper.convertFromApiPolicy((com.google.api.services.storage.model.Policy)RetryHelper.runWithRetries(new StorageImpl$41(this, bucket, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var4) {
         throw StorageException.translateAndThrow(var4);
      }

      return var10000;
   }

   public Policy setIamPolicy(String bucket, Policy policy, Storage$BucketSourceOption... options) {
      Policy var10000;
      try {
         Map optionsMap = optionMap(options);
         var10000 = PolicyHelper.convertFromApiPolicy((com.google.api.services.storage.model.Policy)RetryHelper.runWithRetries(new StorageImpl$42(this, bucket, policy, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var5) {
         throw StorageException.translateAndThrow(var5);
      }

      return var10000;
   }

   public List testIamPermissions(String bucket, List permissions, Storage$BucketSourceOption... options) {
      List var10000;
      try {
         Map optionsMap = optionMap(options);
         TestIamPermissionsResponse response = (TestIamPermissionsResponse)RetryHelper.runWithRetries(new StorageImpl$43(this, bucket, permissions, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         Set heldPermissions = response.getPermissions() != null ? ImmutableSet.copyOf(response.getPermissions()) : ImmutableSet.of();
         var10000 = Lists.transform(permissions, new StorageImpl$44(this, heldPermissions));
      } catch (RetryHelperException var7) {
         throw StorageException.translateAndThrow(var7);
      }

      return var10000;
   }

   public Bucket lockRetentionPolicy(BucketInfo bucketInfo, Storage$BucketTargetOption... options) {
      com.google.api.services.storage.model.Bucket bucketPb = bucketInfo.toPb();
      Map optionsMap = optionMap((BucketInfo)bucketInfo, options);

      Bucket var10000;
      try {
         var10000 = Bucket.fromPb(this, (com.google.api.services.storage.model.Bucket)RetryHelper.runWithRetries(new StorageImpl$45(this, bucketPb, optionsMap), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock()));
      } catch (RetryHelperException var6) {
         throw StorageException.translateAndThrow(var6);
      }

      return var10000;
   }

   public ServiceAccount getServiceAccount(String projectId) {
      ServiceAccount var10000;
      try {
         com.google.api.services.storage.model.ServiceAccount answer = (com.google.api.services.storage.model.ServiceAccount)RetryHelper.runWithRetries(new StorageImpl$46(this, projectId), ((StorageOptions)this.getOptions()).getRetrySettings(), EXCEPTION_HANDLER, ((StorageOptions)this.getOptions()).getClock());
         var10000 = answer == null ? null : ServiceAccount.fromPb(answer);
      } catch (RetryHelperException var3) {
         throw StorageException.translateAndThrow(var3);
      }

      return var10000;
   }

   private static void addToOptionMap(StorageRpc$Option option, Object defaultValue, Map map) {
      addToOptionMap(option, option, defaultValue, map);
   }

   private static void addToOptionMap(StorageRpc$Option getOption, StorageRpc$Option putOption, Object defaultValue, Map map) {
      if (map.containsKey(getOption)) {
         Object value = map.remove(getOption);
         Preconditions.checkArgument(value != null || defaultValue != null, "Option " + getOption.value() + " is missing a value");
         value = MoreObjects.firstNonNull(value, defaultValue);
         map.put(putOption, value);
      }

   }

   private static Map optionMap(Long generation, Long metaGeneration, Iterable options) {
      return optionMap(generation, metaGeneration, options, false);
   }

   private static Map optionMap(Long generation, Long metaGeneration, Iterable options, boolean useAsSource) {
      Map temp = Maps.newEnumMap(StorageRpc$Option.class);
      Iterator var5 = options.iterator();

      while(var5.hasNext()) {
         Option option = (Option)var5.next();
         Object prev = temp.put(option.getRpcOption(), option.getValue());
         Preconditions.checkArgument(prev == null, "Duplicate option %s", option);
      }

      Boolean value = (Boolean)temp.remove(StorageRpc$Option.DELIMITER);
      if (Boolean.TRUE.equals(value)) {
         temp.put(StorageRpc$Option.DELIMITER, "/");
      }

      if (useAsSource) {
         addToOptionMap(StorageRpc$Option.IF_GENERATION_MATCH, StorageRpc$Option.IF_SOURCE_GENERATION_MATCH, generation, temp);
         addToOptionMap(StorageRpc$Option.IF_GENERATION_NOT_MATCH, StorageRpc$Option.IF_SOURCE_GENERATION_NOT_MATCH, generation, temp);
         addToOptionMap(StorageRpc$Option.IF_METAGENERATION_MATCH, StorageRpc$Option.IF_SOURCE_METAGENERATION_MATCH, metaGeneration, temp);
         addToOptionMap(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH, StorageRpc$Option.IF_SOURCE_METAGENERATION_NOT_MATCH, metaGeneration, temp);
      } else {
         addToOptionMap(StorageRpc$Option.IF_GENERATION_MATCH, generation, temp);
         addToOptionMap(StorageRpc$Option.IF_GENERATION_NOT_MATCH, generation, temp);
         addToOptionMap(StorageRpc$Option.IF_METAGENERATION_MATCH, metaGeneration, temp);
         addToOptionMap(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH, metaGeneration, temp);
      }

      return ImmutableMap.copyOf(temp);
   }

   private static Map optionMap(Option... options) {
      return optionMap((Long)null, (Long)null, (Iterable)Arrays.asList(options));
   }

   private static Map optionMap(Long generation, Long metaGeneration, Option... options) {
      return optionMap(generation, metaGeneration, (Iterable)Arrays.asList(options));
   }

   private static Map optionMap(BucketInfo bucketInfo, Option... options) {
      return optionMap((Long)null, bucketInfo.getMetageneration(), (Option[])options);
   }

   static Map optionMap(BlobInfo blobInfo, Option... options) {
      return optionMap(blobInfo.getGeneration(), blobInfo.getMetageneration(), options);
   }

   static Map optionMap(BlobId blobId, Option... options) {
      return optionMap(blobId.getGeneration(), (Long)null, (Option[])options);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public WriteChannel writer(URL var1) {
      return this.writer(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public WriteChannel writer(BlobInfo var1, Storage$BlobWriteOption[] var2) {
      return this.writer(var1, var2);
   }

   // $FF: synthetic method
   static StorageRpc access$000(StorageImpl x0) {
      return x0.storageRpc;
   }

   // $FF: synthetic method
   static Page access$100(StorageOptions x0, Map x1) {
      return listBuckets(x0, x1);
   }

   // $FF: synthetic method
   static Page access$200(String x0, StorageOptions x1, Map x2) {
      return listBlobs(x0, x1, x2);
   }

   // $FF: synthetic method
   static Page access$300(StorageOptions x0, Map x1) {
      return listHmacKeys(x0, x1);
   }

   // $FF: synthetic method
   static Map access$400(Option[] x0) {
      return optionMap(x0);
   }
}
