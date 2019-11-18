package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Objects;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Beta
public final class StoredCredential implements Serializable {
   public static final String DEFAULT_DATA_STORE_ID = StoredCredential.class.getSimpleName();
   private static final long serialVersionUID = 1L;
   private final Lock lock = new ReentrantLock();
   private String accessToken;
   private Long expirationTimeMilliseconds;
   private String refreshToken;

   public StoredCredential() {
   }

   public StoredCredential(Credential credential) {
      this.setAccessToken(credential.getAccessToken());
      this.setRefreshToken(credential.getRefreshToken());
      this.setExpirationTimeMilliseconds(credential.getExpirationTimeMilliseconds());
   }

   public String getAccessToken() {
      this.lock.lock();

      String var1;
      try {
         var1 = this.accessToken;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public StoredCredential setAccessToken(String accessToken) {
      this.lock.lock();

      try {
         this.accessToken = accessToken;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public Long getExpirationTimeMilliseconds() {
      this.lock.lock();

      Long var1;
      try {
         var1 = this.expirationTimeMilliseconds;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public StoredCredential setExpirationTimeMilliseconds(Long expirationTimeMilliseconds) {
      this.lock.lock();

      try {
         this.expirationTimeMilliseconds = expirationTimeMilliseconds;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public String getRefreshToken() {
      this.lock.lock();

      String var1;
      try {
         var1 = this.refreshToken;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public StoredCredential setRefreshToken(String refreshToken) {
      this.lock.lock();

      try {
         this.refreshToken = refreshToken;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public String toString() {
      return Objects.toStringHelper(StoredCredential.class).add("accessToken", this.getAccessToken()).add("refreshToken", this.getRefreshToken()).add("expirationTimeMilliseconds", this.getExpirationTimeMilliseconds()).toString();
   }

   public boolean equals(Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof StoredCredential)) {
         return false;
      } else {
         StoredCredential o = (StoredCredential)other;
         return Objects.equal(this.getAccessToken(), o.getAccessToken()) && Objects.equal(this.getRefreshToken(), o.getRefreshToken()) && Objects.equal(this.getExpirationTimeMilliseconds(), o.getExpirationTimeMilliseconds());
      }
   }

   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.getAccessToken(), this.getRefreshToken(), this.getExpirationTimeMilliseconds()});
   }

   public static DataStore getDefaultDataStore(DataStoreFactory dataStoreFactory) throws IOException {
      return dataStoreFactory.getDataStore(DEFAULT_DATA_STORE_ID);
   }
}
