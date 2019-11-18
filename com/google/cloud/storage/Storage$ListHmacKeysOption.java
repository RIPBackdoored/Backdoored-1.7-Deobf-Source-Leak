package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Storage$ListHmacKeysOption extends Option {
   private Storage$ListHmacKeysOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   public static Storage$ListHmacKeysOption serviceAccount(ServiceAccount serviceAccount) {
      return new Storage$ListHmacKeysOption(StorageRpc$Option.SERVICE_ACCOUNT_EMAIL, serviceAccount.getEmail());
   }

   public static Storage$ListHmacKeysOption maxResults(long pageSize) {
      return new Storage$ListHmacKeysOption(StorageRpc$Option.MAX_RESULTS, pageSize);
   }

   public static Storage$ListHmacKeysOption pageToken(String pageToken) {
      return new Storage$ListHmacKeysOption(StorageRpc$Option.PAGE_TOKEN, pageToken);
   }

   public static Storage$ListHmacKeysOption showDeletedKeys(boolean showDeletedKeys) {
      return new Storage$ListHmacKeysOption(StorageRpc$Option.SHOW_DELETED_KEYS, showDeletedKeys);
   }

   public static Storage$ListHmacKeysOption userProject(String userProject) {
      return new Storage$ListHmacKeysOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   public static Storage$ListHmacKeysOption projectId(String projectId) {
      return new Storage$ListHmacKeysOption(StorageRpc$Option.PROJECT_ID, projectId);
   }
}
