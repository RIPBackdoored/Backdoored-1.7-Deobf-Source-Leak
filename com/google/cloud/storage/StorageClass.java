package com.google.cloud.storage;

import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;

public final class StorageClass extends StringEnumValue {
   private static final long serialVersionUID = -6938125060419556331L;
   private static final ApiFunction CONSTRUCTOR = new StorageClass$1();
   private static final StringEnumType type;
   public static final StorageClass REGIONAL;
   public static final StorageClass MULTI_REGIONAL;
   public static final StorageClass NEARLINE;
   public static final StorageClass COLDLINE;
   public static final StorageClass STANDARD;
   public static final StorageClass DURABLE_REDUCED_AVAILABILITY;

   private StorageClass(String constant) {
      super(constant);
   }

   public static StorageClass valueOfStrict(String constant) {
      return (StorageClass)type.valueOfStrict(constant);
   }

   public static StorageClass valueOf(String constant) {
      return (StorageClass)type.valueOf(constant);
   }

   public static StorageClass[] values() {
      return (StorageClass[])type.values();
   }

   // $FF: synthetic method
   StorageClass(String x0, StorageClass$1 x1) {
      this(x0);
   }

   static {
      type = new StringEnumType(StorageClass.class, CONSTRUCTOR);
      REGIONAL = (StorageClass)type.createAndRegister("REGIONAL");
      MULTI_REGIONAL = (StorageClass)type.createAndRegister("MULTI_REGIONAL");
      NEARLINE = (StorageClass)type.createAndRegister("NEARLINE");
      COLDLINE = (StorageClass)type.createAndRegister("COLDLINE");
      STANDARD = (StorageClass)type.createAndRegister("STANDARD");
      DURABLE_REDUCED_AVAILABILITY = (StorageClass)type.createAndRegister("DURABLE_REDUCED_AVAILABILITY");
   }
}
