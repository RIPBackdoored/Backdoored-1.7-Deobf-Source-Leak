package com.google.cloud.storage;

import com.google.api.gax.paging.Page;
import com.google.cloud.PageImpl.NextPageFetcher;
import java.util.Map;

class StorageImpl$HmacKeyMetadataPageFetcher implements NextPageFetcher {
   private static final long serialVersionUID = 308012320541700881L;
   private final StorageOptions serviceOptions;
   private final Map options;

   StorageImpl$HmacKeyMetadataPageFetcher(StorageOptions serviceOptions, Map options) {
      this.serviceOptions = serviceOptions;
      this.options = options;
   }

   public Page getNextPage() {
      return StorageImpl.access$300(this.serviceOptions, this.options);
   }
}
