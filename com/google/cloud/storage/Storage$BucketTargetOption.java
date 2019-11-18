package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.StorageRpc$Option;

public class Storage$BucketTargetOption extends Option {
   private static final long serialVersionUID = -5880204616982900975L;

   private Storage$BucketTargetOption(StorageRpc$Option rpcOption, Object value) {
      super(rpcOption, value);
   }

   private Storage$BucketTargetOption(StorageRpc$Option rpcOption) {
      this(rpcOption, (Object)null);
   }

   public static Storage$BucketTargetOption predefinedAcl(Storage$PredefinedAcl acl) {
      return new Storage$BucketTargetOption(StorageRpc$Option.PREDEFINED_ACL, acl.getEntry());
   }

   public static Storage$BucketTargetOption predefinedDefaultObjectAcl(Storage$PredefinedAcl acl) {
      return new Storage$BucketTargetOption(StorageRpc$Option.PREDEFINED_DEFAULT_OBJECT_ACL, acl.getEntry());
   }

   public static Storage$BucketTargetOption metagenerationMatch() {
      return new Storage$BucketTargetOption(StorageRpc$Option.IF_METAGENERATION_MATCH);
   }

   public static Storage$BucketTargetOption metagenerationNotMatch() {
      return new Storage$BucketTargetOption(StorageRpc$Option.IF_METAGENERATION_NOT_MATCH);
   }

   public static Storage$BucketTargetOption userProject(String userProject) {
      return new Storage$BucketTargetOption(StorageRpc$Option.USER_PROJECT, userProject);
   }

   public static Storage$BucketTargetOption projection(String projection) {
      return new Storage$BucketTargetOption(StorageRpc$Option.PROJECTION, projection);
   }
}
