package com.google.cloud.storage.spi.v1;

import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.Storage.Builder;
import com.google.api.services.storage.Storage.Objects.Delete;
import com.google.api.services.storage.Storage.Objects.Get;
import com.google.api.services.storage.Storage.Objects.Insert;
import com.google.api.services.storage.Storage.Objects.Patch;
import com.google.api.services.storage.Storage.Objects.Rewrite;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.BucketAccessControls;
import com.google.api.services.storage.model.Buckets;
import com.google.api.services.storage.model.ComposeRequest;
import com.google.api.services.storage.model.HmacKey;
import com.google.api.services.storage.model.HmacKeyMetadata;
import com.google.api.services.storage.model.HmacKeysMetadata;
import com.google.api.services.storage.model.Notification;
import com.google.api.services.storage.model.Notifications;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.ObjectAccessControls;
import com.google.api.services.storage.model.Objects;
import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.ServiceAccount;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.TestIamPermissionsResponse;
import com.google.api.services.storage.model.ComposeRequest.SourceObjects;
import com.google.api.services.storage.model.ComposeRequest.SourceObjects.ObjectPreconditions;
import com.google.cloud.Tuple;
import com.google.cloud.http.CensusHttpModule;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import io.opencensus.common.Scope;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpStorageRpc implements StorageRpc {
   public static final String DEFAULT_PROJECTION = "full";
   public static final String NO_ACL_PROJECTION = "noAcl";
   private static final String ENCRYPTION_KEY_PREFIX = "x-goog-encryption-";
   private static final String SOURCE_ENCRYPTION_KEY_PREFIX = "x-goog-copy-source-encryption-";
   private static final int SC_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
   private final StorageOptions options;
   private final Storage storage;
   private final Tracer tracer = Tracing.getTracer();
   private final CensusHttpModule censusHttpModule;
   private final HttpRequestInitializer batchRequestInitializer;
   private static final long MEGABYTE = 1048576L;

   public HttpStorageRpc(StorageOptions options) {
      HttpTransportOptions transportOptions = (HttpTransportOptions)options.getTransportOptions();
      HttpTransport transport = transportOptions.getHttpTransportFactory().create();
      HttpRequestInitializer initializer = transportOptions.getHttpRequestInitializer(options);
      this.options = options;
      this.censusHttpModule = new CensusHttpModule(this.tracer, true);
      initializer = this.censusHttpModule.getHttpRequestInitializer(initializer);
      this.batchRequestInitializer = this.censusHttpModule.getHttpRequestInitializer((HttpRequestInitializer)null);
      HttpStorageRpcSpans.registerAllSpanNamesForCollection();
      this.storage = (new Builder(transport, new JacksonFactory(), initializer)).setRootUrl(options.getHost()).setApplicationName(options.getApplicationName()).build();
   }

   private static JsonBatchCallback toJsonCallback(RpcBatch$Callback callback) {
      return new HttpStorageRpc$1(callback);
   }

   private static StorageException translate(IOException exception) {
      return new StorageException(exception);
   }

   private static StorageException translate(GoogleJsonError exception) {
      return new StorageException(exception);
   }

   private static void setEncryptionHeaders(HttpHeaders headers, String headerPrefix, Map options) {
      String key = StorageRpc$Option.CUSTOMER_SUPPLIED_KEY.getString(options);
      if (key != null) {
         BaseEncoding base64 = BaseEncoding.base64();
         HashFunction hashFunction = Hashing.sha256();
         headers.set(headerPrefix + "algorithm", "AES256");
         headers.set(headerPrefix + "key", key);
         headers.set(headerPrefix + "key-sha256", base64.encode(hashFunction.hashBytes(base64.decode(key)).asBytes()));
      }

   }

   private Span startSpan(String spanName) {
      return this.tracer.spanBuilder(spanName).setRecordEvents(this.censusHttpModule.isRecordEvents()).startSpan();
   }

   public Bucket create(Bucket bucket, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_BUCKET);
      Scope scope = this.tracer.withSpan(span);

      Bucket var5;
      try {
         var5 = (Bucket)this.storage.buckets().insert(this.options.getProjectId(), bucket).setProjection("full").setPredefinedAcl(StorageRpc$Option.PREDEFINED_ACL.getString(options)).setPredefinedDefaultObjectAcl(StorageRpc$Option.PREDEFINED_DEFAULT_OBJECT_ACL.getString(options)).execute();
      } catch (IOException var9) {
         span.setStatus(Status.UNKNOWN.withDescription(var9.getMessage()));
         throw translate(var9);
      } finally {
         scope.close();
         span.end();
      }

      return var5;
   }

   public StorageObject create(StorageObject storageObject, InputStream content, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_OBJECT);
      Scope scope = this.tracer.withSpan(span);

      StorageObject var8;
      try {
         Insert insert = this.storage.objects().insert(storageObject.getBucket(), storageObject, new InputStreamContent(storageObject.getContentType(), content));
         insert.getMediaHttpUploader().setDirectUploadEnabled(true);
         Boolean disableGzipContent = StorageRpc$Option.IF_DISABLE_GZIP_CONTENT.getBoolean(options);
         if (disableGzipContent != null) {
            insert.setDisableGZipContent(disableGzipContent);
         }

         setEncryptionHeaders(insert.getRequestHeaders(), "x-goog-encryption-", options);
         var8 = (StorageObject)insert.setProjection("full").setPredefinedAcl(StorageRpc$Option.PREDEFINED_ACL.getString(options)).setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(options)).setIfMetagenerationNotMatch(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.getLong(options)).setIfGenerationMatch(StorageRpc$Option.IF_GENERATION_MATCH.getLong(options)).setIfGenerationNotMatch(StorageRpc$Option.IF_GENERATION_NOT_MATCH.getLong(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).setKmsKeyName(StorageRpc$Option.KMS_KEY_NAME.getString(options)).execute();
      } catch (IOException var12) {
         span.setStatus(Status.UNKNOWN.withDescription(var12.getMessage()));
         throw translate(var12);
      } finally {
         scope.close();
         span.end();
      }

      return var8;
   }

   public Tuple list(Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_BUCKETS);
      Scope scope = this.tracer.withSpan(span);

      Tuple var5;
      try {
         Buckets buckets = (Buckets)this.storage.buckets().list(this.options.getProjectId()).setProjection("full").setPrefix(StorageRpc$Option.PREFIX.getString(options)).setMaxResults(StorageRpc$Option.MAX_RESULTS.getLong(options)).setPageToken(StorageRpc$Option.PAGE_TOKEN.getString(options)).setFields(StorageRpc$Option.FIELDS.getString(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
         var5 = Tuple.of(buckets.getNextPageToken(), buckets.getItems());
      } catch (IOException var9) {
         span.setStatus(Status.UNKNOWN.withDescription(var9.getMessage()));
         throw translate(var9);
      } finally {
         scope.close();
         span.end();
      }

      return var5;
   }

   public Tuple list(String bucket, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_OBJECTS);
      Scope scope = this.tracer.withSpan(span);

      Tuple var7;
      try {
         Objects objects = (Objects)this.storage.objects().list(bucket).setProjection("full").setVersions(StorageRpc$Option.VERSIONS.getBoolean(options)).setDelimiter(StorageRpc$Option.DELIMITER.getString(options)).setPrefix(StorageRpc$Option.PREFIX.getString(options)).setMaxResults(StorageRpc$Option.MAX_RESULTS.getLong(options)).setPageToken(StorageRpc$Option.PAGE_TOKEN.getString(options)).setFields(StorageRpc$Option.FIELDS.getString(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
         Iterable storageObjects = Iterables.concat((Iterable)MoreObjects.firstNonNull(objects.getItems(), ImmutableList.of()), (Iterable)(objects.getPrefixes() != null ? Lists.transform(objects.getPrefixes(), objectFromPrefix(bucket)) : ImmutableList.of()));
         var7 = Tuple.of(objects.getNextPageToken(), storageObjects);
      } catch (IOException var11) {
         span.setStatus(Status.UNKNOWN.withDescription(var11.getMessage()));
         throw translate(var11);
      } finally {
         scope.close();
         span.end();
      }

      return var7;
   }

   private static Function objectFromPrefix(String bucket) {
      return new HttpStorageRpc$2(bucket);
   }

   public Bucket get(Bucket bucket, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_BUCKET);
      Scope scope = this.tracer.withSpan(span);

      Object var7;
      try {
         try {
            Bucket var5 = (Bucket)this.storage.buckets().get(bucket.getName()).setProjection("full").setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(options)).setIfMetagenerationNotMatch(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.getLong(options)).setFields(StorageRpc$Option.FIELDS.getString(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
            return var5;
         } catch (IOException var11) {
            span.setStatus(Status.UNKNOWN.withDescription(var11.getMessage()));
            StorageException serviceException = translate(var11);
            if (serviceException.getCode() != 404) {
               throw serviceException;
            }
         }

         var7 = null;
      } finally {
         scope.close();
         span.end();
      }

      return (Bucket)var7;
   }

   private Get getCall(StorageObject object, Map options) throws IOException {
      Get get = this.storage.objects().get(object.getBucket(), object.getName());
      setEncryptionHeaders(get.getRequestHeaders(), "x-goog-encryption-", options);
      return get.setGeneration(object.getGeneration()).setProjection("full").setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(options)).setIfMetagenerationNotMatch(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.getLong(options)).setIfGenerationMatch(StorageRpc$Option.IF_GENERATION_MATCH.getLong(options)).setIfGenerationNotMatch(StorageRpc$Option.IF_GENERATION_NOT_MATCH.getLong(options)).setFields(StorageRpc$Option.FIELDS.getString(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options));
   }

   public StorageObject get(StorageObject object, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_OBJECT);
      Scope scope = this.tracer.withSpan(span);

      Object var7;
      try {
         try {
            StorageObject var5 = (StorageObject)this.getCall(object, options).execute();
            return var5;
         } catch (IOException var11) {
            span.setStatus(Status.UNKNOWN.withDescription(var11.getMessage()));
            StorageException serviceException = translate(var11);
            if (serviceException.getCode() != 404) {
               throw serviceException;
            }
         }

         var7 = null;
      } finally {
         scope.close();
         span.end();
      }

      return (StorageObject)var7;
   }

   public Bucket patch(Bucket bucket, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_PATCH_BUCKET);
      Scope scope = this.tracer.withSpan(span);

      Bucket var6;
      try {
         String projection = StorageRpc$Option.PROJECTION.getString(options);
         if (bucket.getIamConfiguration() != null && bucket.getIamConfiguration().getBucketPolicyOnly() != null && bucket.getIamConfiguration().getBucketPolicyOnly().getEnabled() != null && bucket.getIamConfiguration().getBucketPolicyOnly().getEnabled()) {
            bucket.setDefaultObjectAcl((List)null);
            bucket.setAcl((List)null);
            if (projection == null) {
               projection = "noAcl";
            }
         }

         var6 = (Bucket)this.storage.buckets().patch(bucket.getName(), bucket).setProjection(projection == null ? "full" : projection).setPredefinedAcl(StorageRpc$Option.PREDEFINED_ACL.getString(options)).setPredefinedDefaultObjectAcl(StorageRpc$Option.PREDEFINED_DEFAULT_OBJECT_ACL.getString(options)).setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(options)).setIfMetagenerationNotMatch(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.getLong(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var10) {
         span.setStatus(Status.UNKNOWN.withDescription(var10.getMessage()));
         throw translate(var10);
      } finally {
         scope.close();
         span.end();
      }

      return var6;
   }

   private Patch patchCall(StorageObject storageObject, Map options) throws IOException {
      return this.storage.objects().patch(storageObject.getBucket(), storageObject.getName(), storageObject).setProjection("full").setPredefinedAcl(StorageRpc$Option.PREDEFINED_ACL.getString(options)).setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(options)).setIfMetagenerationNotMatch(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.getLong(options)).setIfGenerationMatch(StorageRpc$Option.IF_GENERATION_MATCH.getLong(options)).setIfGenerationNotMatch(StorageRpc$Option.IF_GENERATION_NOT_MATCH.getLong(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options));
   }

   public StorageObject patch(StorageObject storageObject, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_PATCH_OBJECT);
      Scope scope = this.tracer.withSpan(span);

      StorageObject var5;
      try {
         var5 = (StorageObject)this.patchCall(storageObject, options).execute();
      } catch (IOException var9) {
         span.setStatus(Status.UNKNOWN.withDescription(var9.getMessage()));
         throw translate(var9);
      } finally {
         scope.close();
         span.end();
      }

      return var5;
   }

   public boolean delete(Bucket bucket, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_BUCKET);
      Scope scope = this.tracer.withSpan(span);

      boolean var7;
      try {
         try {
            this.storage.buckets().delete(bucket.getName()).setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(options)).setIfMetagenerationNotMatch(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.getLong(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
            boolean var5 = true;
            return var5;
         } catch (IOException var11) {
            span.setStatus(Status.UNKNOWN.withDescription(var11.getMessage()));
            StorageException serviceException = translate(var11);
            if (serviceException.getCode() != 404) {
               throw serviceException;
            }
         }

         var7 = false;
      } finally {
         scope.close();
         span.end();
      }

      return var7;
   }

   private Delete deleteCall(StorageObject blob, Map options) throws IOException {
      return this.storage.objects().delete(blob.getBucket(), blob.getName()).setGeneration(blob.getGeneration()).setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(options)).setIfMetagenerationNotMatch(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.getLong(options)).setIfGenerationMatch(StorageRpc$Option.IF_GENERATION_MATCH.getLong(options)).setIfGenerationNotMatch(StorageRpc$Option.IF_GENERATION_NOT_MATCH.getLong(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options));
   }

   public boolean delete(StorageObject blob, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_OBJECT);
      Scope scope = this.tracer.withSpan(span);

      boolean var7;
      try {
         try {
            this.deleteCall(blob, options).execute();
            boolean var5 = true;
            return var5;
         } catch (IOException var11) {
            span.setStatus(Status.UNKNOWN.withDescription(var11.getMessage()));
            StorageException serviceException = translate(var11);
            if (serviceException.getCode() != 404) {
               throw serviceException;
            }
         }

         var7 = false;
      } finally {
         scope.close();
         span.end();
      }

      return var7;
   }

   public StorageObject compose(Iterable sources, StorageObject target, Map targetOptions) {
      ComposeRequest request = new ComposeRequest();
      request.setDestination(target);
      List sourceObjects = new ArrayList();

      SourceObjects sourceObject;
      for(Iterator var6 = sources.iterator(); var6.hasNext(); sourceObjects.add(sourceObject)) {
         StorageObject source = (StorageObject)var6.next();
         sourceObject = new SourceObjects();
         sourceObject.setName(source.getName());
         Long generation = source.getGeneration();
         if (generation != null) {
            sourceObject.setGeneration(generation);
            sourceObject.setObjectPreconditions((new ObjectPreconditions()).setIfGenerationMatch(generation));
         }
      }

      request.setSourceObjects(sourceObjects);
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_COMPOSE);
      Scope scope = this.tracer.withSpan(span);

      StorageObject var17;
      try {
         var17 = (StorageObject)this.storage.objects().compose(target.getBucket(), target.getName(), request).setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(targetOptions)).setIfGenerationMatch(StorageRpc$Option.IF_GENERATION_MATCH.getLong(targetOptions)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(targetOptions)).execute();
      } catch (IOException var13) {
         span.setStatus(Status.UNKNOWN.withDescription(var13.getMessage()));
         throw translate(var13);
      } finally {
         scope.close();
         span.end();
      }

      return var17;
   }

   public byte[] load(StorageObject from, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_LOAD);
      Scope scope = this.tracer.withSpan(span);

      byte[] var7;
      try {
         Get getRequest = this.storage.objects().get(from.getBucket(), from.getName()).setGeneration(from.getGeneration()).setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(options)).setIfMetagenerationNotMatch(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.getLong(options)).setIfGenerationMatch(StorageRpc$Option.IF_GENERATION_MATCH.getLong(options)).setIfGenerationNotMatch(StorageRpc$Option.IF_GENERATION_NOT_MATCH.getLong(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options));
         setEncryptionHeaders(getRequest.getRequestHeaders(), "x-goog-encryption-", options);
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         getRequest.executeMedia().download(out);
         var7 = out.toByteArray();
      } catch (IOException var11) {
         span.setStatus(Status.UNKNOWN.withDescription(var11.getMessage()));
         throw translate(var11);
      } finally {
         scope.close();
         span.end();
      }

      return var7;
   }

   public RpcBatch createBatch() {
      return new HttpStorageRpc$DefaultRpcBatch(this, this.storage, (HttpStorageRpc$1)null);
   }

   private Get createReadRequest(StorageObject from, Map options) throws IOException {
      Get req = this.storage.objects().get(from.getBucket(), from.getName()).setGeneration(from.getGeneration()).setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(options)).setIfMetagenerationNotMatch(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.getLong(options)).setIfGenerationMatch(StorageRpc$Option.IF_GENERATION_MATCH.getLong(options)).setIfGenerationNotMatch(StorageRpc$Option.IF_GENERATION_NOT_MATCH.getLong(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options));
      setEncryptionHeaders(req.getRequestHeaders(), "x-goog-encryption-", options);
      req.setReturnRawInputStream(true);
      return req;
   }

   public long read(StorageObject from, Map options, long position, OutputStream outputStream) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_READ);
      Scope scope = this.tracer.withSpan(span);

      long var10;
      try {
         Get req = this.createReadRequest(from, options);
         req.getMediaHttpDownloader().setBytesDownloaded(position);
         req.getMediaHttpDownloader().setDirectDownloadEnabled(true);
         req.executeMediaAndDownloadTo(outputStream);
         long var17 = req.getMediaHttpDownloader().getNumBytesDownloaded();
         return var17;
      } catch (IOException var15) {
         span.setStatus(Status.UNKNOWN.withDescription(var15.getMessage()));
         StorageException serviceException = translate(var15);
         if (serviceException.getCode() != 416) {
            throw serviceException;
         }

         var10 = 0L;
      } finally {
         scope.close();
         span.end();
      }

      return var10;
   }

   public Tuple read(StorageObject from, Map options, long position, int bytes) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_READ);
      Scope scope = this.tracer.withSpan(span);

      Tuple var10;
      try {
         Preconditions.checkArgument(position >= 0L, "Position should be non-negative, is %d", position);
         Get req = this.createReadRequest(from, options);
         StringBuilder range = new StringBuilder();
         range.append("bytes=").append(position).append("-").append(position + (long)bytes - 1L);
         HttpHeaders requestHeaders = req.getRequestHeaders();
         requestHeaders.setRange(range.toString());
         ByteArrayOutputStream output = new ByteArrayOutputStream(bytes);
         req.executeMedia().download(output);
         String etag = req.getLastResponseHeaders().getETag();
         Tuple var13 = Tuple.of(etag, output.toByteArray());
         return var13;
      } catch (IOException var17) {
         span.setStatus(Status.UNKNOWN.withDescription(var17.getMessage()));
         StorageException serviceException = translate(var17);
         if (serviceException.getCode() != 416) {
            throw serviceException;
         }

         var10 = Tuple.of((Object)null, new byte[0]);
      } finally {
         scope.close();
         span.end();
      }

      return var10;
   }

   public void write(String uploadId, byte[] toWrite, int toWriteOffset, long destOffset, int length, boolean last) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_WRITE);
      Scope scope = this.tracer.withSpan(span);

      try {
         if (length != 0 || last) {
            GenericUrl url = new GenericUrl(uploadId);
            HttpRequest httpRequest = this.storage.getRequestFactory().buildPutRequest(url, new ByteArrayContent((String)null, toWrite, toWriteOffset, length));
            long limit = destOffset + (long)length;
            StringBuilder range = new StringBuilder("bytes ");
            if (length == 0) {
               range.append('*');
            } else {
               range.append(destOffset).append('-').append(limit - 1L);
            }

            range.append('/');
            if (last) {
               range.append(limit);
            } else {
               range.append('*');
            }

            httpRequest.getHeaders().setContentRange(range.toString());
            IOException exception = null;
            HttpResponse response = null;

            int code;
            String message;
            try {
               response = httpRequest.execute();
               code = response.getStatusCode();
               message = response.getStatusMessage();
            } catch (HttpResponseException var30) {
               exception = var30;
               code = var30.getStatusCode();
               message = var30.getStatusMessage();
            } finally {
               if (response != null) {
                  response.disconnect();
               }

            }

            if ((last || code == 308) && (!last || code == 200 || code == 201)) {
               return;
            }

            if (exception != null) {
               throw exception;
            }

            GoogleJsonError error = new GoogleJsonError();
            error.setCode(code);
            error.setMessage(message);
            throw translate(error);
         }
      } catch (IOException var32) {
         span.setStatus(Status.UNKNOWN.withDescription(var32.getMessage()));
         throw translate(var32);
      } finally {
         scope.close();
         span.end();
      }

   }

   public String open(StorageObject object, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_OPEN);
      Scope scope = this.tracer.withSpan(span);

      String var27;
      try {
         Insert req = this.storage.objects().insert(object.getBucket(), object);
         GenericUrl url = req.buildHttpRequest().getUrl();
         String scheme = url.getScheme();
         String host = url.getHost();
         int port = url.getPort();
         port = port > 0 ? port : url.toURL().getDefaultPort();
         String path = "/upload" + url.getRawPath();
         url = new GenericUrl(scheme + "://" + host + ":" + port + path);
         url.set("uploadType", "resumable");
         url.set("name", object.getName());
         Iterator var11 = options.keySet().iterator();

         while(var11.hasNext()) {
            StorageRpc$Option option = (StorageRpc$Option)var11.next();
            Object content = option.get(options);
            if (content != null) {
               url.set(option.value(), content.toString());
            }
         }

         JsonFactory jsonFactory = this.storage.getJsonFactory();
         HttpRequestFactory requestFactory = this.storage.getRequestFactory();
         HttpRequest httpRequest = requestFactory.buildPostRequest(url, new JsonHttpContent(jsonFactory, object));
         HttpHeaders requestHeaders = httpRequest.getHeaders();
         requestHeaders.set("X-Upload-Content-Type", MoreObjects.firstNonNull(object.getContentType(), "application/octet-stream"));
         String key = StorageRpc$Option.CUSTOMER_SUPPLIED_KEY.getString(options);
         if (key != null) {
            BaseEncoding base64 = BaseEncoding.base64();
            HashFunction hashFunction = Hashing.sha256();
            requestHeaders.set("x-goog-encryption-algorithm", "AES256");
            requestHeaders.set("x-goog-encryption-key", key);
            requestHeaders.set("x-goog-encryption-key-sha256", base64.encode(hashFunction.hashBytes(base64.decode(key)).asBytes()));
         }

         HttpResponse response = httpRequest.execute();
         if (response.getStatusCode() != 200) {
            GoogleJsonError error = new GoogleJsonError();
            error.setCode(response.getStatusCode());
            error.setMessage(response.getStatusMessage());
            throw translate(error);
         }

         var27 = response.getHeaders().getLocation();
      } catch (IOException var21) {
         span.setStatus(Status.UNKNOWN.withDescription(var21.getMessage()));
         throw translate(var21);
      } finally {
         scope.close();
         span.end();
      }

      return var27;
   }

   public String open(String signedURL) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_OPEN);
      Scope scope = this.tracer.withSpan(span);

      String var11;
      try {
         GenericUrl url = new GenericUrl(signedURL);
         url.set("uploadType", "resumable");
         String bytesArrayParameters = "";
         byte[] bytesArray = new byte[bytesArrayParameters.length()];
         HttpRequestFactory requestFactory = this.storage.getRequestFactory();
         HttpRequest httpRequest = requestFactory.buildPostRequest(url, new ByteArrayContent("", bytesArray, 0, bytesArray.length));
         HttpHeaders requestHeaders = httpRequest.getHeaders();
         requestHeaders.set("X-Upload-Content-Type", "");
         requestHeaders.set("x-goog-resumable", "start");
         HttpResponse response = httpRequest.execute();
         if (response.getStatusCode() != 201) {
            GoogleJsonError error = new GoogleJsonError();
            error.setCode(response.getStatusCode());
            error.setMessage(response.getStatusMessage());
            throw translate(error);
         }

         var11 = response.getHeaders().getLocation();
      } catch (IOException var15) {
         span.setStatus(Status.UNKNOWN.withDescription(var15.getMessage()));
         throw translate(var15);
      } finally {
         scope.close();
         span.end();
      }

      return var11;
   }

   public StorageRpc$RewriteResponse openRewrite(StorageRpc$RewriteRequest rewriteRequest) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_OPEN_REWRITE);
      Scope scope = this.tracer.withSpan(span);

      StorageRpc$RewriteResponse var4;
      try {
         var4 = this.rewrite(rewriteRequest, (String)null);
      } finally {
         scope.close();
         span.end();
      }

      return var4;
   }

   public StorageRpc$RewriteResponse continueRewrite(StorageRpc$RewriteResponse previousResponse) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_CONTINUE_REWRITE);
      Scope scope = this.tracer.withSpan(span);

      StorageRpc$RewriteResponse var4;
      try {
         var4 = this.rewrite(previousResponse.rewriteRequest, previousResponse.rewriteToken);
      } finally {
         scope.close();
         span.end();
      }

      return var4;
   }

   private StorageRpc$RewriteResponse rewrite(StorageRpc$RewriteRequest req, String token) {
      StorageRpc$RewriteResponse var10000;
      try {
         String userProject = StorageRpc$Option.USER_PROJECT.getString(req.sourceOptions);
         if (userProject == null) {
            userProject = StorageRpc$Option.USER_PROJECT.getString(req.targetOptions);
         }

         Long maxBytesRewrittenPerCall = req.megabytesRewrittenPerCall != null ? req.megabytesRewrittenPerCall * 1048576L : null;
         Rewrite rewrite = this.storage.objects().rewrite(req.source.getBucket(), req.source.getName(), req.target.getBucket(), req.target.getName(), req.overrideInfo ? req.target : null).setSourceGeneration(req.source.getGeneration()).setRewriteToken(token).setMaxBytesRewrittenPerCall(maxBytesRewrittenPerCall).setProjection("full").setIfSourceMetagenerationMatch(StorageRpc$Option.IF_SOURCE_METAGENERATION_MATCH.getLong(req.sourceOptions)).setIfSourceMetagenerationNotMatch(StorageRpc$Option.IF_SOURCE_METAGENERATION_NOT_MATCH.getLong(req.sourceOptions)).setIfSourceGenerationMatch(StorageRpc$Option.IF_SOURCE_GENERATION_MATCH.getLong(req.sourceOptions)).setIfSourceGenerationNotMatch(StorageRpc$Option.IF_SOURCE_GENERATION_NOT_MATCH.getLong(req.sourceOptions)).setIfMetagenerationMatch(StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(req.targetOptions)).setIfMetagenerationNotMatch(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH.getLong(req.targetOptions)).setIfGenerationMatch(StorageRpc$Option.IF_GENERATION_MATCH.getLong(req.targetOptions)).setIfGenerationNotMatch(StorageRpc$Option.IF_GENERATION_NOT_MATCH.getLong(req.targetOptions)).setDestinationPredefinedAcl(StorageRpc$Option.PREDEFINED_ACL.getString(req.targetOptions)).setUserProject(userProject).setDestinationKmsKeyName(StorageRpc$Option.KMS_KEY_NAME.getString(req.targetOptions));
         HttpHeaders requestHeaders = rewrite.getRequestHeaders();
         setEncryptionHeaders(requestHeaders, "x-goog-copy-source-encryption-", req.sourceOptions);
         setEncryptionHeaders(requestHeaders, "x-goog-encryption-", req.targetOptions);
         com.google.api.services.storage.model.RewriteResponse rewriteResponse = (com.google.api.services.storage.model.RewriteResponse)rewrite.execute();
         var10000 = new StorageRpc$RewriteResponse(req, rewriteResponse.getResource(), rewriteResponse.getObjectSize(), rewriteResponse.getDone(), rewriteResponse.getRewriteToken(), rewriteResponse.getTotalBytesRewritten());
      } catch (IOException var8) {
         this.tracer.getCurrentSpan().setStatus(Status.UNKNOWN.withDescription(var8.getMessage()));
         throw translate(var8);
      }

      return var10000;
   }

   public BucketAccessControl getAcl(String bucket, String entity, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_BUCKET_ACL);
      Scope scope = this.tracer.withSpan(span);

      Object var8;
      try {
         try {
            BucketAccessControl var6 = (BucketAccessControl)this.storage.bucketAccessControls().get(bucket, entity).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
            return var6;
         } catch (IOException var12) {
            span.setStatus(Status.UNKNOWN.withDescription(var12.getMessage()));
            StorageException serviceException = translate(var12);
            if (serviceException.getCode() != 404) {
               throw serviceException;
            }
         }

         var8 = null;
      } finally {
         scope.close();
         span.end();
      }

      return (BucketAccessControl)var8;
   }

   public boolean deleteAcl(String bucket, String entity, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_BUCKET_ACL);
      Scope scope = this.tracer.withSpan(span);

      boolean var8;
      try {
         try {
            this.storage.bucketAccessControls().delete(bucket, entity).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
            boolean var6 = true;
            return var6;
         } catch (IOException var12) {
            span.setStatus(Status.UNKNOWN.withDescription(var12.getMessage()));
            StorageException serviceException = translate(var12);
            if (serviceException.getCode() != 404) {
               throw serviceException;
            }
         }

         var8 = false;
      } finally {
         scope.close();
         span.end();
      }

      return var8;
   }

   public BucketAccessControl createAcl(BucketAccessControl acl, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_BUCKET_ACL);
      Scope scope = this.tracer.withSpan(span);

      BucketAccessControl var5;
      try {
         var5 = (BucketAccessControl)this.storage.bucketAccessControls().insert(acl.getBucket(), acl).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var9) {
         span.setStatus(Status.UNKNOWN.withDescription(var9.getMessage()));
         throw translate(var9);
      } finally {
         scope.close();
         span.end();
      }

      return var5;
   }

   public BucketAccessControl patchAcl(BucketAccessControl acl, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_PATCH_BUCKET_ACL);
      Scope scope = this.tracer.withSpan(span);

      BucketAccessControl var5;
      try {
         var5 = (BucketAccessControl)this.storage.bucketAccessControls().patch(acl.getBucket(), acl.getEntity(), acl).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var9) {
         span.setStatus(Status.UNKNOWN.withDescription(var9.getMessage()));
         throw translate(var9);
      } finally {
         scope.close();
         span.end();
      }

      return var5;
   }

   public List listAcls(String bucket, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_BUCKET_ACLS);
      Scope scope = this.tracer.withSpan(span);

      List var5;
      try {
         var5 = ((BucketAccessControls)this.storage.bucketAccessControls().list(bucket).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute()).getItems();
      } catch (IOException var9) {
         span.setStatus(Status.UNKNOWN.withDescription(var9.getMessage()));
         throw translate(var9);
      } finally {
         scope.close();
         span.end();
      }

      return var5;
   }

   public ObjectAccessControl getDefaultAcl(String bucket, String entity) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_OBJECT_DEFAULT_ACL);
      Scope scope = this.tracer.withSpan(span);

      Object var7;
      try {
         ObjectAccessControl var5 = (ObjectAccessControl)this.storage.defaultObjectAccessControls().get(bucket, entity).execute();
         return var5;
      } catch (IOException var11) {
         span.setStatus(Status.UNKNOWN.withDescription(var11.getMessage()));
         StorageException serviceException = translate(var11);
         if (serviceException.getCode() != 404) {
            throw serviceException;
         }

         var7 = null;
      } finally {
         scope.close();
         span.end();
      }

      return (ObjectAccessControl)var7;
   }

   public boolean deleteDefaultAcl(String bucket, String entity) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_OBJECT_DEFAULT_ACL);
      Scope scope = this.tracer.withSpan(span);

      boolean var7;
      try {
         this.storage.defaultObjectAccessControls().delete(bucket, entity).execute();
         boolean var5 = true;
         return var5;
      } catch (IOException var11) {
         span.setStatus(Status.UNKNOWN.withDescription(var11.getMessage()));
         StorageException serviceException = translate(var11);
         if (serviceException.getCode() != 404) {
            throw serviceException;
         }

         var7 = false;
      } finally {
         scope.close();
         span.end();
      }

      return var7;
   }

   public ObjectAccessControl createDefaultAcl(ObjectAccessControl acl) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_OBJECT_DEFAULT_ACL);
      Scope scope = this.tracer.withSpan(span);

      ObjectAccessControl var4;
      try {
         var4 = (ObjectAccessControl)this.storage.defaultObjectAccessControls().insert(acl.getBucket(), acl).execute();
      } catch (IOException var8) {
         span.setStatus(Status.UNKNOWN.withDescription(var8.getMessage()));
         throw translate(var8);
      } finally {
         scope.close();
         span.end();
      }

      return var4;
   }

   public ObjectAccessControl patchDefaultAcl(ObjectAccessControl acl) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_PATCH_OBJECT_DEFAULT_ACL);
      Scope scope = this.tracer.withSpan(span);

      ObjectAccessControl var4;
      try {
         var4 = (ObjectAccessControl)this.storage.defaultObjectAccessControls().patch(acl.getBucket(), acl.getEntity(), acl).execute();
      } catch (IOException var8) {
         span.setStatus(Status.UNKNOWN.withDescription(var8.getMessage()));
         throw translate(var8);
      } finally {
         scope.close();
         span.end();
      }

      return var4;
   }

   public List listDefaultAcls(String bucket) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_OBJECT_DEFAULT_ACLS);
      Scope scope = this.tracer.withSpan(span);

      List var4;
      try {
         var4 = ((ObjectAccessControls)this.storage.defaultObjectAccessControls().list(bucket).execute()).getItems();
      } catch (IOException var8) {
         span.setStatus(Status.UNKNOWN.withDescription(var8.getMessage()));
         throw translate(var8);
      } finally {
         scope.close();
         span.end();
      }

      return var4;
   }

   public ObjectAccessControl getAcl(String bucket, String object, Long generation, String entity) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_OBJECT_ACL);
      Scope scope = this.tracer.withSpan(span);

      Object var9;
      try {
         ObjectAccessControl var7 = (ObjectAccessControl)this.storage.objectAccessControls().get(bucket, object, entity).setGeneration(generation).execute();
         return var7;
      } catch (IOException var13) {
         span.setStatus(Status.UNKNOWN.withDescription(var13.getMessage()));
         StorageException serviceException = translate(var13);
         if (serviceException.getCode() != 404) {
            throw serviceException;
         }

         var9 = null;
      } finally {
         scope.close();
         span.end();
      }

      return (ObjectAccessControl)var9;
   }

   public boolean deleteAcl(String bucket, String object, Long generation, String entity) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_OBJECT_ACL);
      Scope scope = this.tracer.withSpan(span);

      boolean var9;
      try {
         try {
            this.storage.objectAccessControls().delete(bucket, object, entity).setGeneration(generation).execute();
            boolean var7 = true;
            return var7;
         } catch (IOException var13) {
            span.setStatus(Status.UNKNOWN.withDescription(var13.getMessage()));
            StorageException serviceException = translate(var13);
            if (serviceException.getCode() != 404) {
               throw serviceException;
            }
         }

         var9 = false;
      } finally {
         scope.close();
         span.end();
      }

      return var9;
   }

   public ObjectAccessControl createAcl(ObjectAccessControl acl) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_OBJECT_ACL);
      Scope scope = this.tracer.withSpan(span);

      ObjectAccessControl var4;
      try {
         var4 = (ObjectAccessControl)this.storage.objectAccessControls().insert(acl.getBucket(), acl.getObject(), acl).setGeneration(acl.getGeneration()).execute();
      } catch (IOException var8) {
         span.setStatus(Status.UNKNOWN.withDescription(var8.getMessage()));
         throw translate(var8);
      } finally {
         scope.close();
         span.end();
      }

      return var4;
   }

   public ObjectAccessControl patchAcl(ObjectAccessControl acl) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_PATCH_OBJECT_ACL);
      Scope scope = this.tracer.withSpan(span);

      ObjectAccessControl var4;
      try {
         var4 = (ObjectAccessControl)this.storage.objectAccessControls().patch(acl.getBucket(), acl.getObject(), acl.getEntity(), acl).setGeneration(acl.getGeneration()).execute();
      } catch (IOException var8) {
         span.setStatus(Status.UNKNOWN.withDescription(var8.getMessage()));
         throw translate(var8);
      } finally {
         scope.close();
         span.end();
      }

      return var4;
   }

   public List listAcls(String bucket, String object, Long generation) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_OBJECT_ACLS);
      Scope scope = this.tracer.withSpan(span);

      List var6;
      try {
         var6 = ((ObjectAccessControls)this.storage.objectAccessControls().list(bucket, object).setGeneration(generation).execute()).getItems();
      } catch (IOException var10) {
         span.setStatus(Status.UNKNOWN.withDescription(var10.getMessage()));
         throw translate(var10);
      } finally {
         scope.close();
         span.end();
      }

      return var6;
   }

   public HmacKey createHmacKey(String serviceAccountEmail, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_HMAC_KEY);
      Scope scope = this.tracer.withSpan(span);
      String projectId = StorageRpc$Option.PROJECT_ID.getString(options);
      if (projectId == null) {
         projectId = this.options.getProjectId();
      }

      HmacKey var6;
      try {
         var6 = (HmacKey)this.storage.projects().hmacKeys().create(projectId, serviceAccountEmail).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var10) {
         span.setStatus(Status.UNKNOWN.withDescription(var10.getMessage()));
         throw translate(var10);
      } finally {
         scope.close();
         span.end();
      }

      return var6;
   }

   public Tuple listHmacKeys(Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_HMAC_KEYS);
      Scope scope = this.tracer.withSpan(span);
      String projectId = StorageRpc$Option.PROJECT_ID.getString(options);
      if (projectId == null) {
         projectId = this.options.getProjectId();
      }

      Tuple var6;
      try {
         HmacKeysMetadata hmacKeysMetadata = (HmacKeysMetadata)this.storage.projects().hmacKeys().list(projectId).setServiceAccountEmail(StorageRpc$Option.SERVICE_ACCOUNT_EMAIL.getString(options)).setPageToken(StorageRpc$Option.PAGE_TOKEN.getString(options)).setMaxResults(StorageRpc$Option.MAX_RESULTS.getLong(options)).setShowDeletedKeys(StorageRpc$Option.SHOW_DELETED_KEYS.getBoolean(options)).execute();
         var6 = Tuple.of(hmacKeysMetadata.getNextPageToken(), hmacKeysMetadata.getItems());
      } catch (IOException var10) {
         span.setStatus(Status.UNKNOWN.withDescription(var10.getMessage()));
         throw translate(var10);
      } finally {
         scope.close();
         span.end();
      }

      return var6;
   }

   public HmacKeyMetadata getHmacKey(String accessId, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_HMAC_KEY);
      Scope scope = this.tracer.withSpan(span);
      String projectId = StorageRpc$Option.PROJECT_ID.getString(options);
      if (projectId == null) {
         projectId = this.options.getProjectId();
      }

      HmacKeyMetadata var6;
      try {
         var6 = (HmacKeyMetadata)this.storage.projects().hmacKeys().get(projectId, accessId).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var10) {
         span.setStatus(Status.UNKNOWN.withDescription(var10.getMessage()));
         throw translate(var10);
      } finally {
         scope.close();
         span.end();
      }

      return var6;
   }

   public HmacKeyMetadata updateHmacKey(HmacKeyMetadata hmacKeyMetadata, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_UPDATE_HMAC_KEY);
      Scope scope = this.tracer.withSpan(span);
      String projectId = hmacKeyMetadata.getProjectId();
      if (projectId == null) {
         projectId = this.options.getProjectId();
      }

      HmacKeyMetadata var6;
      try {
         var6 = (HmacKeyMetadata)this.storage.projects().hmacKeys().update(projectId, hmacKeyMetadata.getAccessId(), hmacKeyMetadata).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var10) {
         span.setStatus(Status.UNKNOWN.withDescription(var10.getMessage()));
         throw translate(var10);
      } finally {
         scope.close();
         span.end();
      }

      return var6;
   }

   public void deleteHmacKey(HmacKeyMetadata hmacKeyMetadata, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_HMAC_KEY);
      Scope scope = this.tracer.withSpan(span);
      String projectId = hmacKeyMetadata.getProjectId();
      if (projectId == null) {
         projectId = this.options.getProjectId();
      }

      try {
         this.storage.projects().hmacKeys().delete(projectId, hmacKeyMetadata.getAccessId()).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var10) {
         span.setStatus(Status.UNKNOWN.withDescription(var10.getMessage()));
         throw translate(var10);
      } finally {
         scope.close();
         span.end();
      }

   }

   public Policy getIamPolicy(String bucket, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_BUCKET_IAM_POLICY);
      Scope scope = this.tracer.withSpan(span);

      Policy var5;
      try {
         var5 = (Policy)this.storage.buckets().getIamPolicy(bucket).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var9) {
         span.setStatus(Status.UNKNOWN.withDescription(var9.getMessage()));
         throw translate(var9);
      } finally {
         scope.close();
         span.end();
      }

      return var5;
   }

   public Policy setIamPolicy(String bucket, Policy policy, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_SET_BUCKET_IAM_POLICY);
      Scope scope = this.tracer.withSpan(span);

      Policy var6;
      try {
         var6 = (Policy)this.storage.buckets().setIamPolicy(bucket, policy).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var10) {
         span.setStatus(Status.UNKNOWN.withDescription(var10.getMessage()));
         throw translate(var10);
      } finally {
         scope.close();
         span.end();
      }

      return var6;
   }

   public TestIamPermissionsResponse testIamPermissions(String bucket, List permissions, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_TEST_BUCKET_IAM_PERMISSIONS);
      Scope scope = this.tracer.withSpan(span);

      TestIamPermissionsResponse var6;
      try {
         var6 = (TestIamPermissionsResponse)this.storage.buckets().testIamPermissions(bucket, permissions).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var10) {
         span.setStatus(Status.UNKNOWN.withDescription(var10.getMessage()));
         throw translate(var10);
      } finally {
         scope.close();
         span.end();
      }

      return var6;
   }

   public boolean deleteNotification(String bucket, String notification) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_DELETE_NOTIFICATION);
      Scope scope = this.tracer.withSpan(span);

      boolean var7;
      try {
         this.storage.notifications().delete(bucket, notification).execute();
         boolean var5 = true;
         return var5;
      } catch (IOException var11) {
         span.setStatus(Status.UNKNOWN.withDescription(var11.getMessage()));
         StorageException serviceException = translate(var11);
         if (serviceException.getCode() != 404) {
            throw serviceException;
         }

         var7 = false;
      } finally {
         scope.close();
         span.end();
      }

      return var7;
   }

   public List listNotifications(String bucket) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_LIST_NOTIFICATIONS);
      Scope scope = this.tracer.withSpan(span);

      List var4;
      try {
         var4 = ((Notifications)this.storage.notifications().list(bucket).execute()).getItems();
      } catch (IOException var8) {
         span.setStatus(Status.UNKNOWN.withDescription(var8.getMessage()));
         throw translate(var8);
      } finally {
         scope.close();
         span.end();
      }

      return var4;
   }

   public Notification createNotification(String bucket, Notification notification) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_CREATE_NOTIFICATION);
      Scope scope = this.tracer.withSpan(span);

      Notification var5;
      try {
         var5 = (Notification)this.storage.notifications().insert(bucket, notification).execute();
      } catch (IOException var9) {
         span.setStatus(Status.UNKNOWN.withDescription(var9.getMessage()));
         throw translate(var9);
      } finally {
         scope.close();
         span.end();
      }

      return var5;
   }

   public Bucket lockRetentionPolicy(Bucket bucket, Map options) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_LOCK_RETENTION_POLICY);
      Scope scope = this.tracer.withSpan(span);

      Bucket var5;
      try {
         var5 = (Bucket)this.storage.buckets().lockRetentionPolicy(bucket.getName(), StorageRpc$Option.IF_METAGENERATION_MATCH.getLong(options)).setUserProject(StorageRpc$Option.USER_PROJECT.getString(options)).execute();
      } catch (IOException var9) {
         span.setStatus(Status.UNKNOWN.withDescription(var9.getMessage()));
         throw translate(var9);
      } finally {
         scope.close();
         span.end();
      }

      return var5;
   }

   public ServiceAccount getServiceAccount(String projectId) {
      Span span = this.startSpan(HttpStorageRpcSpans.SPAN_NAME_GET_SERVICE_ACCOUNT);
      Scope scope = this.tracer.withSpan(span);

      ServiceAccount var4;
      try {
         var4 = (ServiceAccount)this.storage.projects().serviceAccount().get(projectId).execute();
      } catch (IOException var8) {
         span.setStatus(Status.UNKNOWN.withDescription(var8.getMessage()));
         throw translate(var8);
      } finally {
         scope.close();
         span.end();
      }

      return var4;
   }

   // $FF: synthetic method
   static HttpRequestInitializer access$000(HttpStorageRpc x0) {
      return x0.batchRequestInitializer;
   }

   // $FF: synthetic method
   static JsonBatchCallback access$100(RpcBatch$Callback x0) {
      return toJsonCallback(x0);
   }

   // $FF: synthetic method
   static Delete access$200(HttpStorageRpc x0, StorageObject x1, Map x2) throws IOException {
      return x0.deleteCall(x1, x2);
   }

   // $FF: synthetic method
   static StorageException access$300(IOException x0) {
      return translate(x0);
   }

   // $FF: synthetic method
   static Patch access$400(HttpStorageRpc x0, StorageObject x1, Map x2) throws IOException {
      return x0.patchCall(x1, x2);
   }

   // $FF: synthetic method
   static Get access$500(HttpStorageRpc x0, StorageObject x1, Map x2) throws IOException {
      return x0.getCall(x1, x2);
   }

   // $FF: synthetic method
   static Span access$600(HttpStorageRpc x0, String x1) {
      return x0.startSpan(x1);
   }

   // $FF: synthetic method
   static Tracer access$700(HttpStorageRpc x0) {
      return x0.tracer;
   }

   // $FF: synthetic method
   static StorageOptions access$800(HttpStorageRpc x0) {
      return x0.options;
   }
}
