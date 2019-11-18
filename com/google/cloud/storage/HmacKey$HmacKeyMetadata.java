package com.google.cloud.storage;

import com.google.api.client.util.DateTime;
import com.google.api.services.storage.model.HmacKeyMetadata;
import java.io.Serializable;
import java.util.Objects;

public class HmacKey$HmacKeyMetadata implements Serializable {
   private static final long serialVersionUID = 4571684785352640737L;
   private final String accessId;
   private final String etag;
   private final String id;
   private final String projectId;
   private final ServiceAccount serviceAccount;
   private final HmacKey$HmacKeyState state;
   private final Long createTime;
   private final Long updateTime;

   private HmacKey$HmacKeyMetadata(HmacKey$HmacKeyMetadata$Builder builder) {
      this.accessId = HmacKey$HmacKeyMetadata$Builder.access$400(builder);
      this.etag = HmacKey$HmacKeyMetadata$Builder.access$500(builder);
      this.id = HmacKey$HmacKeyMetadata$Builder.access$600(builder);
      this.projectId = HmacKey$HmacKeyMetadata$Builder.access$700(builder);
      this.serviceAccount = HmacKey$HmacKeyMetadata$Builder.access$800(builder);
      this.state = HmacKey$HmacKeyMetadata$Builder.access$900(builder);
      this.createTime = HmacKey$HmacKeyMetadata$Builder.access$1000(builder);
      this.updateTime = HmacKey$HmacKeyMetadata$Builder.access$1100(builder);
   }

   public static HmacKey$HmacKeyMetadata$Builder newBuilder(ServiceAccount serviceAccount) {
      return new HmacKey$HmacKeyMetadata$Builder(serviceAccount, (HmacKey$1)null);
   }

   public HmacKey$HmacKeyMetadata$Builder toBuilder() {
      return new HmacKey$HmacKeyMetadata$Builder(this, (HmacKey$1)null);
   }

   public static HmacKey$HmacKeyMetadata of(ServiceAccount serviceAccount, String accessId, String projectId) {
      return newBuilder(serviceAccount).setAccessId(accessId).setProjectId(projectId).build();
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.accessId, this.projectId});
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj != null && this.getClass() == obj.getClass()) {
         HmacKey$HmacKeyMetadata other = (HmacKey$HmacKeyMetadata)obj;
         return Objects.equals(this.accessId, other.accessId) && Objects.equals(this.etag, other.etag) && Objects.equals(this.id, other.id) && Objects.equals(this.projectId, other.projectId) && Objects.equals(this.serviceAccount, other.serviceAccount) && Objects.equals(this.state, other.state) && Objects.equals(this.createTime, other.createTime) && Objects.equals(this.updateTime, other.updateTime);
      } else {
         return false;
      }
   }

   public HmacKeyMetadata toPb() {
      HmacKeyMetadata metadata = new HmacKeyMetadata();
      metadata.setAccessId(this.accessId);
      metadata.setEtag(this.etag);
      metadata.setId(this.id);
      metadata.setProjectId(this.projectId);
      metadata.setServiceAccountEmail(this.serviceAccount == null ? null : this.serviceAccount.getEmail());
      metadata.setState(this.state == null ? null : this.state.toString());
      metadata.setTimeCreated(this.createTime == null ? null : new DateTime(this.createTime));
      metadata.setUpdated(this.updateTime == null ? null : new DateTime(this.updateTime));
      return metadata;
   }

   static HmacKey$HmacKeyMetadata fromPb(HmacKeyMetadata metadata) {
      return newBuilder(ServiceAccount.of(metadata.getServiceAccountEmail())).setAccessId(metadata.getAccessId()).setCreateTime(metadata.getTimeCreated().getValue()).setEtag(metadata.getEtag()).setId(metadata.getId()).setProjectId(metadata.getProjectId()).setState(HmacKey$HmacKeyState.valueOf(metadata.getState())).setUpdateTime(metadata.getUpdated().getValue()).build();
   }

   public String getAccessId() {
      return this.accessId;
   }

   public String getEtag() {
      return this.etag;
   }

   public String getId() {
      return this.id;
   }

   public String getProjectId() {
      return this.projectId;
   }

   public ServiceAccount getServiceAccount() {
      return this.serviceAccount;
   }

   public HmacKey$HmacKeyState getState() {
      return this.state;
   }

   public Long getCreateTime() {
      return this.createTime;
   }

   public Long getUpdateTime() {
      return this.updateTime;
   }

   // $FF: synthetic method
   static String access$1400(HmacKey$HmacKeyMetadata x0) {
      return x0.accessId;
   }

   // $FF: synthetic method
   static String access$1500(HmacKey$HmacKeyMetadata x0) {
      return x0.etag;
   }

   // $FF: synthetic method
   static String access$1600(HmacKey$HmacKeyMetadata x0) {
      return x0.id;
   }

   // $FF: synthetic method
   static String access$1700(HmacKey$HmacKeyMetadata x0) {
      return x0.projectId;
   }

   // $FF: synthetic method
   static ServiceAccount access$1800(HmacKey$HmacKeyMetadata x0) {
      return x0.serviceAccount;
   }

   // $FF: synthetic method
   static HmacKey$HmacKeyState access$1900(HmacKey$HmacKeyMetadata x0) {
      return x0.state;
   }

   // $FF: synthetic method
   static Long access$2000(HmacKey$HmacKeyMetadata x0) {
      return x0.createTime;
   }

   // $FF: synthetic method
   static Long access$2100(HmacKey$HmacKeyMetadata x0) {
      return x0.updateTime;
   }

   // $FF: synthetic method
   HmacKey$HmacKeyMetadata(HmacKey$HmacKeyMetadata$Builder x0, HmacKey$1 x1) {
      this(x0);
   }
}
