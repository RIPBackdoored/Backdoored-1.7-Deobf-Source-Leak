package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Storage$CreateHmacKeyOption extends Option {
   private Storage$CreateHmacKeyOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   public static Storage$CreateHmacKeyOption userProject(String userProject) {
      return new Storage$CreateHmacKeyOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   public static Storage$CreateHmacKeyOption projectId(String projectId) {
      return new Storage$CreateHmacKeyOption(StorageRpc$Option.PROJECT_ID, projectId);
   }
}
