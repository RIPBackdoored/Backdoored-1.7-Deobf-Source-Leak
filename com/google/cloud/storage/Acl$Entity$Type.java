package com.google.cloud.storage;

public final class Acl$Entity$Type extends Enum {
   public static final Acl$Entity$Type DOMAIN = new Acl$Entity$Type("DOMAIN", 0);
   public static final Acl$Entity$Type GROUP = new Acl$Entity$Type("GROUP", 1);
   public static final Acl$Entity$Type USER = new Acl$Entity$Type("USER", 2);
   public static final Acl$Entity$Type PROJECT = new Acl$Entity$Type("PROJECT", 3);
   public static final Acl$Entity$Type UNKNOWN = new Acl$Entity$Type("UNKNOWN", 4);
   // $FF: synthetic field
   private static final Acl$Entity$Type[] $VALUES = new Acl$Entity$Type[]{DOMAIN, GROUP, USER, PROJECT, UNKNOWN};

   public static Acl$Entity$Type[] values() {
      return (Acl$Entity$Type[])$VALUES.clone();
   }

   public static Acl$Entity$Type valueOf(String name) {
      return (Acl$Entity$Type)Enum.valueOf(Acl$Entity$Type.class, name);
   }

   private Acl$Entity$Type(String var1, int var2) {
      super(var1, var2);
   }
}
