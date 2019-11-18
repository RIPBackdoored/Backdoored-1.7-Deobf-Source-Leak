package com.google.cloud.storage;

import com.google.api.gax.paging.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.PageImpl.NextPageFetcher;
import com.google.cloud.storage.spi.v1.StorageRpc$Option;
import java.util.Map;

class StorageImpl$BucketPageFetcher implements NextPageFetcher {
   private static final long serialVersionUID = 5850406828803613729L;
   private final Map requestOptions;
   private final StorageOptions serviceOptions;

   StorageImpl$BucketPageFetcher(StorageOptions serviceOptions, String cursor, Map optionMap) {
      this.requestOptions = PageImpl.nextRequestOptions(StorageRpc$Option.PAGE_TOKEN, cursor, optionMap);
      this.serviceOptions = serviceOptions;
   }

   public Page getNextPage() {
      return StorageImpl.access$100(this.serviceOptions, this.requestOptions);
   }
}
