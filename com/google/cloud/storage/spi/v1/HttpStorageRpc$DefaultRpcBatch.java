package com.google.cloud.storage.spi.v1;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.model.StorageObject;
import io.opencensus.common.Scope;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class HttpStorageRpc$DefaultRpcBatch implements RpcBatch {
   private static final int MAX_BATCH_SIZE = 100;
   private final Storage storage;
   private final LinkedList batches;
   private int currentBatchSize;
   // $FF: synthetic field
   final HttpStorageRpc this$0;

   private HttpStorageRpc$DefaultRpcBatch(HttpStorageRpc var1, Storage storage) {
      this.this$0 = var1;
      this.storage = storage;
      this.batches = new LinkedList();
      this.batches.add(storage.batch(HttpStorageRpc.access$000(var1)));
   }

   public void addDelete(StorageObject storageObject, RpcBatch$Callback callback, Map options) {
      try {
         if (this.currentBatchSize == 100) {
            this.batches.add(this.storage.batch());
            this.currentBatchSize = 0;
         }

         HttpStorageRpc.access$200(this.this$0, storageObject, options).queue((BatchRequest)this.batches.getLast(), HttpStorageRpc.access$100(callback));
         ++this.currentBatchSize;
      } catch (IOException var5) {
         throw HttpStorageRpc.access$300(var5);
      }

   }

   public void addPatch(StorageObject storageObject, RpcBatch$Callback callback, Map options) {
      try {
         if (this.currentBatchSize == 100) {
            this.batches.add(this.storage.batch());
            this.currentBatchSize = 0;
         }

         HttpStorageRpc.access$400(this.this$0, storageObject, options).queue((BatchRequest)this.batches.getLast(), HttpStorageRpc.access$100(callback));
         ++this.currentBatchSize;
      } catch (IOException var5) {
         throw HttpStorageRpc.access$300(var5);
      }

   }

   public void addGet(StorageObject storageObject, RpcBatch$Callback callback, Map options) {
      try {
         if (this.currentBatchSize == 100) {
            this.batches.add(this.storage.batch());
            this.currentBatchSize = 0;
         }

         HttpStorageRpc.access$500(this.this$0, storageObject, options).queue((BatchRequest)this.batches.getLast(), HttpStorageRpc.access$100(callback));
         ++this.currentBatchSize;
      } catch (IOException var5) {
         throw HttpStorageRpc.access$300(var5);
      }

   }

   public void submit() {
      Span span = HttpStorageRpc.access$600(this.this$0, HttpStorageRpcSpans.SPAN_NAME_BATCH_SUBMIT);
      Scope scope = HttpStorageRpc.access$700(this.this$0).withSpan(span);

      try {
         span.putAttribute("batch size", AttributeValue.longAttributeValue((long)this.batches.size()));
         Iterator var3 = this.batches.iterator();

         while(var3.hasNext()) {
            BatchRequest batch = (BatchRequest)var3.next();
            span.addAnnotation("Execute batch request");
            batch.setBatchUrl(new GenericUrl(String.format("%s/batch/storage/v1", HttpStorageRpc.access$800(this.this$0).getHost())));
            batch.execute();
         }
      } catch (IOException var8) {
         span.setStatus(Status.UNKNOWN.withDescription(var8.getMessage()));
         throw HttpStorageRpc.access$300(var8);
      } finally {
         scope.close();
         span.end();
      }

   }

   // $FF: synthetic method
   HttpStorageRpc$DefaultRpcBatch(HttpStorageRpc x0, Storage x1, HttpStorageRpc$1 x2) {
      this(x0, x1);
   }
}
