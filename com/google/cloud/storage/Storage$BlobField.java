package com.google.cloud.storage;

import com.google.cloud.FieldSelector;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class Storage$BlobField extends Enum implements FieldSelector {
   public static final Storage$BlobField ACL = new Storage$BlobField("ACL", 0, "acl");
   public static final Storage$BlobField BUCKET = new Storage$BlobField("BUCKET", 1, "bucket");
   public static final Storage$BlobField CACHE_CONTROL = new Storage$BlobField("CACHE_CONTROL", 2, "cacheControl");
   public static final Storage$BlobField COMPONENT_COUNT = new Storage$BlobField("COMPONENT_COUNT", 3, "componentCount");
   public static final Storage$BlobField CONTENT_DISPOSITION = new Storage$BlobField("CONTENT_DISPOSITION", 4, "contentDisposition");
   public static final Storage$BlobField CONTENT_ENCODING = new Storage$BlobField("CONTENT_ENCODING", 5, "contentEncoding");
   public static final Storage$BlobField CONTENT_LANGUAGE = new Storage$BlobField("CONTENT_LANGUAGE", 6, "contentLanguage");
   public static final Storage$BlobField CONTENT_TYPE = new Storage$BlobField("CONTENT_TYPE", 7, "contentType");
   public static final Storage$BlobField CRC32C = new Storage$BlobField("CRC32C", 8, "crc32c");
   public static final Storage$BlobField ETAG = new Storage$BlobField("ETAG", 9, "etag");
   public static final Storage$BlobField GENERATION = new Storage$BlobField("GENERATION", 10, "generation");
   public static final Storage$BlobField ID = new Storage$BlobField("ID", 11, "id");
   public static final Storage$BlobField KIND = new Storage$BlobField("KIND", 12, "kind");
   public static final Storage$BlobField MD5HASH = new Storage$BlobField("MD5HASH", 13, "md5Hash");
   public static final Storage$BlobField MEDIA_LINK = new Storage$BlobField("MEDIA_LINK", 14, "mediaLink");
   public static final Storage$BlobField METADATA = new Storage$BlobField("METADATA", 15, "metadata");
   public static final Storage$BlobField METAGENERATION = new Storage$BlobField("METAGENERATION", 16, "metageneration");
   public static final Storage$BlobField NAME = new Storage$BlobField("NAME", 17, "name");
   public static final Storage$BlobField OWNER = new Storage$BlobField("OWNER", 18, "owner");
   public static final Storage$BlobField SELF_LINK = new Storage$BlobField("SELF_LINK", 19, "selfLink");
   public static final Storage$BlobField SIZE = new Storage$BlobField("SIZE", 20, "size");
   public static final Storage$BlobField STORAGE_CLASS = new Storage$BlobField("STORAGE_CLASS", 21, "storageClass");
   public static final Storage$BlobField TIME_DELETED = new Storage$BlobField("TIME_DELETED", 22, "timeDeleted");
   public static final Storage$BlobField TIME_CREATED = new Storage$BlobField("TIME_CREATED", 23, "timeCreated");
   public static final Storage$BlobField KMS_KEY_NAME = new Storage$BlobField("KMS_KEY_NAME", 24, "kmsKeyName");
   public static final Storage$BlobField EVENT_BASED_HOLD = new Storage$BlobField("EVENT_BASED_HOLD", 25, "eventBasedHold");
   public static final Storage$BlobField TEMPORARY_HOLD = new Storage$BlobField("TEMPORARY_HOLD", 26, "temporaryHold");
   public static final Storage$BlobField RETENTION_EXPIRATION_TIME = new Storage$BlobField("RETENTION_EXPIRATION_TIME", 27, "retentionExpirationTime");
   public static final Storage$BlobField UPDATED = new Storage$BlobField("UPDATED", 28, "updated");
   static final List REQUIRED_FIELDS = ImmutableList.of(BUCKET, NAME);
   private final String selector;
   // $FF: synthetic field
   private static final Storage$BlobField[] $VALUES = new Storage$BlobField[]{ACL, BUCKET, CACHE_CONTROL, COMPONENT_COUNT, CONTENT_DISPOSITION, CONTENT_ENCODING, CONTENT_LANGUAGE, CONTENT_TYPE, CRC32C, ETAG, GENERATION, ID, KIND, MD5HASH, MEDIA_LINK, METADATA, METAGENERATION, NAME, OWNER, SELF_LINK, SIZE, STORAGE_CLASS, TIME_DELETED, TIME_CREATED, KMS_KEY_NAME, EVENT_BASED_HOLD, TEMPORARY_HOLD, RETENTION_EXPIRATION_TIME, UPDATED};

   public static Storage$BlobField[] values() {
      return (Storage$BlobField[])$VALUES.clone();
   }

   public static Storage$BlobField valueOf(String name) {
      return (Storage$BlobField)Enum.valueOf(Storage$BlobField.class, name);
   }

   private Storage$BlobField(String var1, int var2, String selector) {
      super(var1, var2);
      this.selector = selector;
   }

   public String getSelector() {
      return this.selector;
   }
}
