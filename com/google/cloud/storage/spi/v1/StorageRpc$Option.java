package com.google.cloud.storage.spi.v1;

import java.util.Map;

public final class StorageRpc$Option extends Enum {
   public static final StorageRpc$Option PREDEFINED_ACL = new StorageRpc$Option("PREDEFINED_ACL", 0, "predefinedAcl");
   public static final StorageRpc$Option PREDEFINED_DEFAULT_OBJECT_ACL = new StorageRpc$Option("PREDEFINED_DEFAULT_OBJECT_ACL", 1, "predefinedDefaultObjectAcl");
   public static final StorageRpc$Option IF_METAGENERATION_MATCH = new StorageRpc$Option("IF_METAGENERATION_MATCH", 2, "ifMetagenerationMatch");
   public static final StorageRpc$Option IF_METAGENERATION_NOT_MATCH = new StorageRpc$Option("IF_METAGENERATION_NOT_MATCH", 3, "ifMetagenerationNotMatch");
   public static final StorageRpc$Option IF_GENERATION_MATCH = new StorageRpc$Option("IF_GENERATION_MATCH", 4, "ifGenerationMatch");
   public static final StorageRpc$Option IF_GENERATION_NOT_MATCH = new StorageRpc$Option("IF_GENERATION_NOT_MATCH", 5, "ifGenerationNotMatch");
   public static final StorageRpc$Option IF_SOURCE_METAGENERATION_MATCH = new StorageRpc$Option("IF_SOURCE_METAGENERATION_MATCH", 6, "ifSourceMetagenerationMatch");
   public static final StorageRpc$Option IF_SOURCE_METAGENERATION_NOT_MATCH = new StorageRpc$Option("IF_SOURCE_METAGENERATION_NOT_MATCH", 7, "ifSourceMetagenerationNotMatch");
   public static final StorageRpc$Option IF_SOURCE_GENERATION_MATCH = new StorageRpc$Option("IF_SOURCE_GENERATION_MATCH", 8, "ifSourceGenerationMatch");
   public static final StorageRpc$Option IF_SOURCE_GENERATION_NOT_MATCH = new StorageRpc$Option("IF_SOURCE_GENERATION_NOT_MATCH", 9, "ifSourceGenerationNotMatch");
   public static final StorageRpc$Option IF_DISABLE_GZIP_CONTENT = new StorageRpc$Option("IF_DISABLE_GZIP_CONTENT", 10, "disableGzipContent");
   public static final StorageRpc$Option PREFIX = new StorageRpc$Option("PREFIX", 11, "prefix");
   public static final StorageRpc$Option PROJECT_ID = new StorageRpc$Option("PROJECT_ID", 12, "projectId");
   public static final StorageRpc$Option PROJECTION = new StorageRpc$Option("PROJECTION", 13, "projection");
   public static final StorageRpc$Option MAX_RESULTS = new StorageRpc$Option("MAX_RESULTS", 14, "maxResults");
   public static final StorageRpc$Option PAGE_TOKEN = new StorageRpc$Option("PAGE_TOKEN", 15, "pageToken");
   public static final StorageRpc$Option DELIMITER = new StorageRpc$Option("DELIMITER", 16, "delimiter");
   public static final StorageRpc$Option VERSIONS = new StorageRpc$Option("VERSIONS", 17, "versions");
   public static final StorageRpc$Option FIELDS = new StorageRpc$Option("FIELDS", 18, "fields");
   public static final StorageRpc$Option CUSTOMER_SUPPLIED_KEY = new StorageRpc$Option("CUSTOMER_SUPPLIED_KEY", 19, "customerSuppliedKey");
   public static final StorageRpc$Option USER_PROJECT = new StorageRpc$Option("USER_PROJECT", 20, "userProject");
   public static final StorageRpc$Option KMS_KEY_NAME = new StorageRpc$Option("KMS_KEY_NAME", 21, "kmsKeyName");
   public static final StorageRpc$Option SERVICE_ACCOUNT_EMAIL = new StorageRpc$Option("SERVICE_ACCOUNT_EMAIL", 22, "serviceAccount");
   public static final StorageRpc$Option SHOW_DELETED_KEYS = new StorageRpc$Option("SHOW_DELETED_KEYS", 23, "showDeletedKeys");
   private final String value;
   // $FF: synthetic field
   private static final StorageRpc$Option[] $VALUES = new StorageRpc$Option[]{PREDEFINED_ACL, PREDEFINED_DEFAULT_OBJECT_ACL, IF_METAGENERATION_MATCH, IF_METAGENERATION_NOT_MATCH, IF_GENERATION_MATCH, IF_GENERATION_NOT_MATCH, IF_SOURCE_METAGENERATION_MATCH, IF_SOURCE_METAGENERATION_NOT_MATCH, IF_SOURCE_GENERATION_MATCH, IF_SOURCE_GENERATION_NOT_MATCH, IF_DISABLE_GZIP_CONTENT, PREFIX, PROJECT_ID, PROJECTION, MAX_RESULTS, PAGE_TOKEN, DELIMITER, VERSIONS, FIELDS, CUSTOMER_SUPPLIED_KEY, USER_PROJECT, KMS_KEY_NAME, SERVICE_ACCOUNT_EMAIL, SHOW_DELETED_KEYS};

   public static StorageRpc$Option[] values() {
      return (StorageRpc$Option[])$VALUES.clone();
   }

   public static StorageRpc$Option valueOf(String name) {
      return (StorageRpc$Option)Enum.valueOf(StorageRpc$Option.class, name);
   }

   private StorageRpc$Option(String var1, int var2, String value) {
      super(var1, var2);
      this.value = value;
   }

   public String value() {
      return this.value;
   }

   Object get(Map options) {
      return options.get(this);
   }

   String getString(Map options) {
      return (String)this.get(options);
   }

   Long getLong(Map options) {
      return (Long)this.get(options);
   }

   Boolean getBoolean(Map options) {
      return (Boolean)this.get(options);
   }
}
