package com.google.cloud.storage;

import com.google.api.gax.paging.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.storage.spi.v1.StorageRpc$Option;
import java.util.Map;

class StorageImpl$BlobPageFetcher implements NextPageFetcher {
   private static final long serialVersionUID = 81807334445874098L;
   private final Map requestOptions;
   private final StorageOptions serviceOptions;
   private final String bucket;

   StorageImpl$BlobPageFetcher(String bucket, StorageOptions serviceOptions, String cursor, Map optionMap) {
      this.requestOptions = PageImpl.nextRequestOptions(StorageRpc$Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
      this.bucket = bucket;
   }

   public Page getNextPage() {
      return StorageImpl.access$200(this.bucket, this.serviceOptions, this.requestOptions);
   }
}
