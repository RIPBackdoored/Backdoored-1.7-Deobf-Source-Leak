package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Storage$DeleteHmacKeyOption extends Option {
   private Storage$DeleteHmacKeyOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   public static Storage$DeleteHmacKeyOption userProject(String userProject) {
      return new Storage$DeleteHmacKeyOption(StorageRpc$Option.USER_PROJECT, userProject);
   }
}
