package com.google.cloud.storage;

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;

public final class Acl$Role extends StringEnumValue {
   private static final long serialVersionUID = 123037132067643600L;
   private static final ApiFunction CONSTRUCTOR = new Acl$Role$1();
   private static final StringEnumType type;
   public static final Acl$Role OWNER;
   public static final Acl$Role READER;
   public static final Acl$Role WRITER;

   private Acl$Role(String constant) {
      super(constant);
   }

   public static Acl$Role valueOfStrict(String constant) {
      return (Acl$Role)type.valueOfStrict(constant);
   }

   public static Acl$Role valueOf(String constant) {
      return (Acl$Role)type.valueOf(constant);
   }

   public static Acl$Role[] values() {
      return (Acl$Role[])type.values();
   }

   // $FF: synthetic method
   Acl$Role(String x0, Acl$1 x1) {
      this(x0);
   }

   static {
      type = new StringEnumType(Acl$Role.class, CONSTRUCTOR);
      OWNER = (Acl$Role)type.createAndRegister("OWNER");
      READER = (Acl$Role)type.createAndRegister("READER");
      WRITER = (Acl$Role)type.createAndRegister("WRITER");
   }
}
