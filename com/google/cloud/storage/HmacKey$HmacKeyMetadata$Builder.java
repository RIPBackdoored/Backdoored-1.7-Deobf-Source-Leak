package com.google.cloud.storage;

public class HmacKey$HmacKeyMetadata$Builder {
   private String accessId;
   private String etag;
   private String id;
   private String projectId;
   private ServiceAccount serviceAccount;
   private HmacKey$HmacKeyState state;
   private Long createTime;
   private Long updateTime;

   private HmacKey$HmacKeyMetadata$Builder(ServiceAccount serviceAccount) {
      this.serviceAccount = serviceAccount;
   }

   private HmacKey$HmacKeyMetadata$Builder(HmacKey$HmacKeyMetadata metadata) {
      this.accessId = HmacKey$HmacKeyMetadata.access$1400(metadata);
      this.etag = HmacKey$HmacKeyMetadata.access$1500(metadata);
      this.id = HmacKey$HmacKeyMetadata.access$1600(metadata);
      this.projectId = HmacKey$HmacKeyMetadata.access$1700(metadata);
      this.serviceAccount = HmacKey$HmacKeyMetadata.access$1800(metadata);
      this.state = HmacKey$HmacKeyMetadata.access$1900(metadata);
      this.createTime = HmacKey$HmacKeyMetadata.access$2000(metadata);
      this.updateTime = HmacKey$HmacKeyMetadata.access$2100(metadata);
   }

   public HmacKey$HmacKeyMetadata$Builder setAccessId(String accessId) {
      this.accessId = accessId;
      return this;
   }

   public HmacKey$HmacKeyMetadata$Builder setEtag(String etag) {
      this.etag = etag;
      return this;
   }

   public HmacKey$HmacKeyMetadata$Builder setId(String id) {
      this.id = id;
      return this;
   }

   public HmacKey$HmacKeyMetadata$Builder setServiceAccount(ServiceAccount serviceAccount) {
      this.serviceAccount = serviceAccount;
      return this;
   }

   public HmacKey$HmacKeyMetadata$Builder setState(HmacKey$HmacKeyState state) {
      this.state = state;
      return this;
   }

   public HmacKey$HmacKeyMetadata$Builder setCreateTime(long createTime) {
      this.createTime = createTime;
      return this;
   }

   public HmacKey$HmacKeyMetadata$Builder setProjectId(String projectId) {
      this.projectId = projectId;
      return this;
   }

   public HmacKey$HmacKeyMetadata build() {
      return new HmacKey$HmacKeyMetadata(this, (HmacKey$1)null);
   }

   public HmacKey$HmacKeyMetadata$Builder setUpdateTime(long updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   // $FF: synthetic method
   static String access$400(HmacKey$HmacKeyMetadata$Builder x0) {
      return x0.accessId;
   }

   // $FF: synthetic method
   static String access$500(HmacKey$HmacKeyMetadata$Builder x0) {
      return x0.etag;
   }

   // $FF: synthetic method
   static String access$600(HmacKey$HmacKeyMetadata$Builder x0) {
      return x0.id;
   }

   // $FF: synthetic method
   static String access$700(HmacKey$HmacKeyMetadata$Builder x0) {
      return x0.projectId;
   }

   // $FF: synthetic method
   static ServiceAccount access$800(HmacKey$HmacKeyMetadata$Builder x0) {
      return x0.serviceAccount;
   }

   // $FF: synthetic method
   static HmacKey$HmacKeyState access$900(HmacKey$HmacKeyMetadata$Builder x0) {
      return x0.state;
   }

   // $FF: synthetic method
   static Long access$1000(HmacKey$HmacKeyMetadata$Builder x0) {
      return x0.createTime;
   }

   // $FF: synthetic method
   static Long access$1100(HmacKey$HmacKeyMetadata$Builder x0) {
      return x0.updateTime;
   }

   // $FF: synthetic method
   HmacKey$HmacKeyMetadata$Builder(ServiceAccount x0, HmacKey$1 x1) {
      this(x0);
   }

   // $FF: synthetic method
   HmacKey$HmacKeyMetadata$Builder(HmacKey$HmacKeyMetadata x0, HmacKey$1 x1) {
      this(x0);
   }
}
