package com.google.cloud.storage.spi.v1;

import com.google.api.core.InternalApi;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.HmacKey;
import com.google.api.services.storage.model.HmacKeyMetadata;
import com.google.api.services.storage.model.Notification;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.ServiceAccount;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.TestIamPermissionsResponse;
import com.google.cloud.ServiceRpc;
import com.google.cloud.Tuple;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@InternalApi
public interface StorageRpc extends ServiceRpc {
   Bucket create(Bucket var1, Map var2);

   StorageObject create(StorageObject var1, InputStream var2, Map var3);

   Tuple list(Map var1);

   Tuple list(String var1, Map var2);

   Bucket get(Bucket var1, Map var2);

   StorageObject get(StorageObject var1, Map var2);

   Bucket patch(Bucket var1, Map var2);

   StorageObject patch(StorageObject var1, Map var2);

   boolean delete(Bucket var1, Map var2);

   boolean delete(StorageObject var1, Map var2);

   RpcBatch createBatch();

   StorageObject compose(Iterable var1, StorageObject var2, Map var3);

   byte[] load(StorageObject var1, Map var2);

   Tuple read(StorageObject var1, Map var2, long var3, int var5);

   long read(StorageObject var1, Map var2, long var3, OutputStream var5);

   String open(StorageObject var1, Map var2);

   String open(String var1);

   void write(String var1, byte[] var2, int var3, long var4, int var6, boolean var7);

   StorageRpc$RewriteResponse openRewrite(StorageRpc$RewriteRequest var1);

   StorageRpc$RewriteResponse continueRewrite(StorageRpc$RewriteResponse var1);

   BucketAccessControl getAcl(String var1, String var2, Map var3);

   boolean deleteAcl(String var1, String var2, Map var3);

   BucketAccessControl createAcl(BucketAccessControl var1, Map var2);

   BucketAccessControl patchAcl(BucketAccessControl var1, Map var2);

   List listAcls(String var1, Map var2);

   ObjectAccessControl getDefaultAcl(String var1, String var2);

   boolean deleteDefaultAcl(String var1, String var2);

   ObjectAccessControl createDefaultAcl(ObjectAccessControl var1);

   ObjectAccessControl patchDefaultAcl(ObjectAccessControl var1);

   List listDefaultAcls(String var1);

   ObjectAccessControl getAcl(String var1, String var2, Long var3, String var4);

   boolean deleteAcl(String var1, String var2, Long var3, String var4);

   ObjectAccessControl createAcl(ObjectAccessControl var1);

   ObjectAccessControl patchAcl(ObjectAccessControl var1);

   List listAcls(String var1, String var2, Long var3);

   HmacKey createHmacKey(String var1, Map var2);

   Tuple listHmacKeys(Map var1);

   HmacKeyMetadata updateHmacKey(HmacKeyMetadata var1, Map var2);

   HmacKeyMetadata getHmacKey(String var1, Map var2);

   void deleteHmacKey(HmacKeyMetadata var1, Map var2);

   Policy getIamPolicy(String var1, Map var2);

   Policy setIamPolicy(String var1, Policy var2, Map var3);

   TestIamPermissionsResponse testIamPermissions(String var1, List var2, Map var3);

   boolean deleteNotification(String var1, String var2);

   List listNotifications(String var1);

   Notification createNotification(String var1, Notification var2);

   Bucket lockRetentionPolicy(Bucket var1, Map var2);

   ServiceAccount getServiceAccount(String var1);
}
