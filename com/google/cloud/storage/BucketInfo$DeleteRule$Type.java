package com.google.cloud.storage;

public final class BucketInfo$DeleteRule$Type extends Enum {
   public static final BucketInfo$DeleteRule$Type AGE = new BucketInfo$DeleteRule$Type("AGE", 0);
   public static final BucketInfo$DeleteRule$Type CREATE_BEFORE = new BucketInfo$DeleteRule$Type("CREATE_BEFORE", 1);
   public static final BucketInfo$DeleteRule$Type NUM_NEWER_VERSIONS = new BucketInfo$DeleteRule$Type("NUM_NEWER_VERSIONS", 2);
   public static final BucketInfo$DeleteRule$Type IS_LIVE = new BucketInfo$DeleteRule$Type("IS_LIVE", 3);
   public static final BucketInfo$DeleteRule$Type UNKNOWN = new BucketInfo$DeleteRule$Type("UNKNOWN", 4);
   // $FF: synthetic field
   private static final BucketInfo$DeleteRule$Type[] $VALUES = new BucketInfo$DeleteRule$Type[]{AGE, CREATE_BEFORE, NUM_NEWER_VERSIONS, IS_LIVE, UNKNOWN};

   public static BucketInfo$DeleteRule$Type[] values() {
      return (BucketInfo$DeleteRule$Type[])$VALUES.clone();
   }

   public static BucketInfo$DeleteRule$Type valueOf(String name) {
      return (BucketInfo$DeleteRule$Type)Enum.valueOf(BucketInfo$DeleteRule$Type.class, name);
   }

   private BucketInfo$DeleteRule$Type(String var1, int var2) {
      super(var1, var2);
   }
}
