package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Storage$GetHmacKeyOption extends Option {
   private Storage$GetHmacKeyOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   public static Storage$GetHmacKeyOption userProject(String userProject) {
      return new Storage$GetHmacKeyOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   public static Storage$GetHmacKeyOption projectId(String projectId) {
      return new Storage$GetHmacKeyOption(StorageRpc$Option.PROJECT_ID, projectId);
   }
}
