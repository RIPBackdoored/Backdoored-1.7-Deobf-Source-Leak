package com.google.cloud.storage;

public final class Storage$PredefinedAcl extends Enum {
   public static final Storage$PredefinedAcl AUTHENTICATED_READ = new Storage$PredefinedAcl("AUTHENTICATED_READ", 0, "authenticatedRead");
   public static final Storage$PredefinedAcl ALL_AUTHENTICATED_USERS = new Storage$PredefinedAcl("ALL_AUTHENTICATED_USERS", 1, "allAuthenticatedUsers");
   public static final Storage$PredefinedAcl PRIVATE = new Storage$PredefinedAcl("PRIVATE", 2, "private");
   public static final Storage$PredefinedAcl PROJECT_PRIVATE = new Storage$PredefinedAcl("PROJECT_PRIVATE", 3, "projectPrivate");
   public static final Storage$PredefinedAcl PUBLIC_READ = new Storage$PredefinedAcl("PUBLIC_READ", 4, "publicRead");
   public static final Storage$PredefinedAcl PUBLIC_READ_WRITE = new Storage$PredefinedAcl("PUBLIC_READ_WRITE", 5, "publicReadWrite");
   public static final Storage$PredefinedAcl BUCKET_OWNER_READ = new Storage$PredefinedAcl("BUCKET_OWNER_READ", 6, "bucketOwnerRead");
   public static final Storage$PredefinedAcl BUCKET_OWNER_FULL_CONTROL = new Storage$PredefinedAcl("BUCKET_OWNER_FULL_CONTROL", 7, "bucketOwnerFullControl");
   private final String entry;
   // $FF: synthetic field
   private static final Storage$PredefinedAcl[] $VALUES = new Storage$PredefinedAcl[]{AUTHENTICATED_READ, ALL_AUTHENTICATED_USERS, PRIVATE, PROJECT_PRIVATE, PUBLIC_READ, PUBLIC_READ_WRITE, BUCKET_OWNER_READ, BUCKET_OWNER_FULL_CONTROL};

   public static Storage$PredefinedAcl[] values() {
      return (Storage$PredefinedAcl[])$VALUES.clone();
   }

   public static Storage$PredefinedAcl valueOf(String name) {
      return (Storage$PredefinedAcl)Enum.valueOf(Storage$PredefinedAcl.class, name);
   }

   private Storage$PredefinedAcl(String var1, int var2, String entry) {
      super(var1, var2);
      this.entry = entry;
   }

   String getEntry() {
      return this.entry;
   }
}
