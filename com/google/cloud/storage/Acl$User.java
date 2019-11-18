package com.google.cloud.storage;

public final class Acl$User extends Acl$Entity {
   private static final long serialVersionUID = 3076518036392737008L;
   private static final String ALL_USERS = "allUsers";
   private static final String ALL_AUTHENTICATED_USERS = "allAuthenticatedUsers";

   public Acl$User(String email) {
      super(Acl$Entity$Type.USER, email);
   }

   public String getEmail() {
      return this.getValue();
   }

   String toPb() {
      String var1 = this.getValue();
      byte var2 = -1;
      switch(var1.hashCode()) {
      case 769236634:
         if (var1.equals("allAuthenticatedUsers")) {
            var2 = 0;
         }
         break;
      case 1789001959:
         if (var1.equals("allUsers")) {
            var2 = 1;
         }
      }

      switch(var2) {
      case 0:
         return "allAuthenticatedUsers";
      case 1:
         return "allUsers";
      default:
         return super.toPb();
      }
   }

   public static Acl$User ofAllUsers() {
      return new Acl$User("allUsers");
   }

   public static Acl$User ofAllAuthenticatedUsers() {
      return new Acl$User("allAuthenticatedUsers");
   }
}
