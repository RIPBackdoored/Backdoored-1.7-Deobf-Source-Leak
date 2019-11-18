package com.google.cloud.storage;

import com.google.cloud.FieldSelector;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class Storage$BucketField extends Enum implements FieldSelector {
   public static final Storage$BucketField ID = new Storage$BucketField("ID", 0, "id");
   public static final Storage$BucketField SELF_LINK = new Storage$BucketField("SELF_LINK", 1, "selfLink");
   public static final Storage$BucketField NAME = new Storage$BucketField("NAME", 2, "name");
   public static final Storage$BucketField TIME_CREATED = new Storage$BucketField("TIME_CREATED", 3, "timeCreated");
   public static final Storage$BucketField METAGENERATION = new Storage$BucketField("METAGENERATION", 4, "metageneration");
   public static final Storage$BucketField ACL = new Storage$BucketField("ACL", 5, "acl");
   public static final Storage$BucketField DEFAULT_OBJECT_ACL = new Storage$BucketField("DEFAULT_OBJECT_ACL", 6, "defaultObjectAcl");
   public static final Storage$BucketField OWNER = new Storage$BucketField("OWNER", 7, "owner");
   public static final Storage$BucketField LABELS = new Storage$BucketField("LABELS", 8, "labels");
   public static final Storage$BucketField LOCATION = new Storage$BucketField("LOCATION", 9, "location");
   public static final Storage$BucketField LOCATION_TYPE = new Storage$BucketField("LOCATION_TYPE", 10, "locationType");
   public static final Storage$BucketField WEBSITE = new Storage$BucketField("WEBSITE", 11, "website");
   public static final Storage$BucketField VERSIONING = new Storage$BucketField("VERSIONING", 12, "versioning");
   public static final Storage$BucketField CORS = new Storage$BucketField("CORS", 13, "cors");
   public static final Storage$BucketField LIFECYCLE = new Storage$BucketField("LIFECYCLE", 14, "lifecycle");
   public static final Storage$BucketField STORAGE_CLASS = new Storage$BucketField("STORAGE_CLASS", 15, "storageClass");
   public static final Storage$BucketField ETAG = new Storage$BucketField("ETAG", 16, "etag");
   public static final Storage$BucketField ENCRYPTION = new Storage$BucketField("ENCRYPTION", 17, "encryption");
   public static final Storage$BucketField BILLING = new Storage$BucketField("BILLING", 18, "billing");
   public static final Storage$BucketField DEFAULT_EVENT_BASED_HOLD = new Storage$BucketField("DEFAULT_EVENT_BASED_HOLD", 19, "defaultEventBasedHold");
   public static final Storage$BucketField RETENTION_POLICY = new Storage$BucketField("RETENTION_POLICY", 20, "retentionPolicy");
   public static final Storage$BucketField IAMCONFIGURATION = new Storage$BucketField("IAMCONFIGURATION", 21, "iamConfiguration");
   static final List REQUIRED_FIELDS = ImmutableList.of(NAME);
   private final String selector;
   // $FF: synthetic field
   private static final Storage$BucketField[] $VALUES = new Storage$BucketField[]{ID, SELF_LINK, NAME, TIME_CREATED, METAGENERATION, ACL, DEFAULT_OBJECT_ACL, OWNER, LABELS, LOCATION, LOCATION_TYPE, WEBSITE, VERSIONING, CORS, LIFECYCLE, STORAGE_CLASS, ETAG, ENCRYPTION, BILLING, DEFAULT_EVENT_BASED_HOLD, RETENTION_POLICY, IAMCONFIGURATION};

   public static Storage$BucketField[] values() {
      return (Storage$BucketField[])$VALUES.clone();
   }

   public static Storage$BucketField valueOf(String name) {
      return (Storage$BucketField)Enum.valueOf(Storage$BucketField.class, name);
   }

   private Storage$BucketField(String var1, int var2, String selector) {
      super(var1, var2);
      this.selector = selector;
   }

   public String getSelector() {
      return this.selector;
   }
}
