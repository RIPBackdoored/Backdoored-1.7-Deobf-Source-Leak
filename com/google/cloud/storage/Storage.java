package com.google.cloud.storage;

import com.google.api.gax.paging.Page;
import com.google.cloud.Policy;
import com.google.cloud.ReadChannel;
import com.google.cloud.Service;
import com.google.cloud.WriteChannel;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface Storage extends Service {
   Bucket create(BucketInfo var1, Storage$BucketTargetOption... var2);

   Blob create(BlobInfo var1, Storage$BlobTargetOption... var2);

   Blob create(BlobInfo var1, byte[] var2, Storage$BlobTargetOption... var3);

   Blob create(BlobInfo var1, byte[] var2, int var3, int var4, Storage$BlobTargetOption... var5);

   /** @deprecated */
   @Deprecated
   Blob create(BlobInfo var1, InputStream var2, Storage$BlobWriteOption... var3);

   Bucket get(String var1, Storage$BucketGetOption... var2);

   Bucket lockRetentionPolicy(BucketInfo var1, Storage$BucketTargetOption... var2);

   Blob get(String var1, String var2, Storage$BlobGetOption... var3);

   Blob get(BlobId var1, Storage$BlobGetOption... var2);

   Blob get(BlobId var1);

   Page list(Storage$BucketListOption... var1);

   Page list(String var1, Storage$BlobListOption... var2);

   Bucket update(BucketInfo var1, Storage$BucketTargetOption... var2);

   Blob update(BlobInfo var1, Storage$BlobTargetOption... var2);

   Blob update(BlobInfo var1);

   boolean delete(String var1, Storage$BucketSourceOption... var2);

   boolean delete(String var1, String var2, Storage$BlobSourceOption... var3);

   boolean delete(BlobId var1, Storage$BlobSourceOption... var2);

   boolean delete(BlobId var1);

   Blob compose(Storage$ComposeRequest var1);

   CopyWriter copy(Storage$CopyRequest var1);

   byte[] readAllBytes(String var1, String var2, Storage$BlobSourceOption... var3);

   byte[] readAllBytes(BlobId var1, Storage$BlobSourceOption... var2);

   StorageBatch batch();

   ReadChannel reader(String var1, String var2, Storage$BlobSourceOption... var3);

   ReadChannel reader(BlobId var1, Storage$BlobSourceOption... var2);

   WriteChannel writer(BlobInfo var1, Storage$BlobWriteOption... var2);

   WriteChannel writer(URL var1);

   URL signUrl(BlobInfo var1, long var2, TimeUnit var4, Storage$SignUrlOption... var5);

   List get(BlobId... var1);

   List get(Iterable var1);

   List update(BlobInfo... var1);

   List update(Iterable var1);

   List delete(BlobId... var1);

   List delete(Iterable var1);

   Acl getAcl(String var1, Acl$Entity var2, Storage$BucketSourceOption... var3);

   Acl getAcl(String var1, Acl$Entity var2);

   boolean deleteAcl(String var1, Acl$Entity var2, Storage$BucketSourceOption... var3);

   boolean deleteAcl(String var1, Acl$Entity var2);

   Acl createAcl(String var1, Acl var2, Storage$BucketSourceOption... var3);

   Acl createAcl(String var1, Acl var2);

   Acl updateAcl(String var1, Acl var2, Storage$BucketSourceOption... var3);

   Acl updateAcl(String var1, Acl var2);

   List listAcls(String var1, Storage$BucketSourceOption... var2);

   List listAcls(String var1);

   Acl getDefaultAcl(String var1, Acl$Entity var2);

   boolean deleteDefaultAcl(String var1, Acl$Entity var2);

   Acl createDefaultAcl(String var1, Acl var2);

   Acl updateDefaultAcl(String var1, Acl var2);

   List listDefaultAcls(String var1);

   Acl getAcl(BlobId var1, Acl$Entity var2);

   boolean deleteAcl(BlobId var1, Acl$Entity var2);

   Acl createAcl(BlobId var1, Acl var2);

   Acl updateAcl(BlobId var1, Acl var2);

   List listAcls(BlobId var1);

   HmacKey createHmacKey(ServiceAccount var1, Storage$CreateHmacKeyOption... var2);

   Page listHmacKeys(Storage$ListHmacKeysOption... var1);

   HmacKey$HmacKeyMetadata getHmacKey(String var1, Storage$GetHmacKeyOption... var2);

   void deleteHmacKey(HmacKey$HmacKeyMetadata var1, Storage$DeleteHmacKeyOption... var2);

   HmacKey$HmacKeyMetadata updateHmacKeyState(HmacKey$HmacKeyMetadata var1, HmacKey$HmacKeyState var2, Storage$UpdateHmacKeyOption... var3);

   Policy getIamPolicy(String var1, Storage$BucketSourceOption... var2);

   Policy setIamPolicy(String var1, Policy var2, Storage$BucketSourceOption... var3);

   List testIamPermissions(String var1, List var2, Storage$BucketSourceOption... var3);

   ServiceAccount getServiceAccount(String var1);
}
