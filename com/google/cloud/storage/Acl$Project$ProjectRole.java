package com.google.cloud.storage;

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;

public final class Acl$Project$ProjectRole extends StringEnumValue {
   private static final long serialVersionUID = -8360324311187914382L;
   private static final ApiFunction CONSTRUCTOR = new Acl$Project$ProjectRole$1();
   private static final StringEnumType type;
   public static final Acl$Project$ProjectRole OWNERS;
   public static final Acl$Project$ProjectRole EDITORS;
   public static final Acl$Project$ProjectRole VIEWERS;

   private Acl$Project$ProjectRole(String constant) {
      super(constant);
   }

   public static Acl$Project$ProjectRole valueOfStrict(String constant) {
      return (Acl$Project$ProjectRole)type.valueOfStrict(constant);
   }

   public static Acl$Project$ProjectRole valueOf(String constant) {
      return (Acl$Project$ProjectRole)type.valueOf(constant);
   }

   public static Acl$Project$ProjectRole[] values() {
      return (Acl$Project$ProjectRole[])type.values();
   }

   // $FF: synthetic method
   Acl$Project$ProjectRole(String x0, Acl$1 x1) {
      this(x0);
   }

   static {
      type = new StringEnumType(Acl$Project$ProjectRole.class, CONSTRUCTOR);
      OWNERS = (Acl$Project$ProjectRole)type.createAndRegister("OWNERS");
      EDITORS = (Acl$Project$ProjectRole)type.createAndRegister("EDITORS");
      VIEWERS = (Acl$Project$ProjectRole)type.createAndRegister("VIEWERS");
   }
}
