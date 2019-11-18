package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Storage$UpdateHmacKeyOption extends Option {
   private Storage$UpdateHmacKeyOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   public static Storage$UpdateHmacKeyOption userProject(String userProject) {
      return new Storage$UpdateHmacKeyOption(StorageRpc$Option.USER_PROJECT, userProject);
   }
}
