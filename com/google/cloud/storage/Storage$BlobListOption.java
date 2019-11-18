package com.google.cloud.storage;

import com.google.cloud.FieldSelector.Helper;
import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Storage$BlobListOption extends Option {
   private static final String[] TOP_LEVEL_FIELDS = new String[]{"prefixes"};
   private static final long serialVersionUID = 9083383524788661294L;

   private Storage$BlobListOption(StorageRpc$Option option, Object value) {
      super(option, value);
   }

   public static Storage$BlobListOption pageSize(long pageSize) {
      return new Storage$BlobListOption(StorageRpc$Option.MAX_RESULTS, pageSize);
   }

   public static Storage$BlobListOption pageToken(String pageToken) {
      return new Storage$BlobListOption(StorageRpc$Option.PAGE_TOKEN, pageToken);
   }

   public static Storage$BlobListOption prefix(String prefix) {
      return new Storage$BlobListOption(StorageRpc$Option.PREFIX, prefix);
   }

   public static Storage$BlobListOption currentDirectory() {
      return new Storage$BlobListOption(StorageRpc$Option.DELIMITER, true);
   }

   public static Storage$BlobListOption userProject(String userProject) {
      return new Storage$BlobListOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   public static Storage$BlobListOption versions(boolean versions) {
      return new Storage$BlobListOption(StorageRpc$Option.VERSIONS, versions);
   }

   public static Storage$BlobListOption fields(Storage$BlobField... fields) {
      return new Storage$BlobListOption(StorageRpc$Option.FIELDS, Helper.listSelector(TOP_LEVEL_FIELDS, "items", Storage$BlobField.REQUIRED_FIELDS, fields, new String[0]));
   }
}
