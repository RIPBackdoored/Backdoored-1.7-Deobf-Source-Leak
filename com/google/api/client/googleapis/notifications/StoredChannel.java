package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Beta
public final class StoredChannel implements Serializable {
   public static final String DEFAULT_DATA_STORE_ID = StoredChannel.class.getSimpleName();
   private static final long serialVersionUID = 1L;
   private final Lock lock;
   private final UnparsedNotificationCallback notificationCallback;
   private String clientToken;
   private Long expiration;
   private final String id;
   private String topicId;

   public StoredChannel(UnparsedNotificationCallback notificationCallback) {
      this(notificationCallback, NotificationUtils.randomUuidString());
   }

   public StoredChannel(UnparsedNotificationCallback notificationCallback, String id) {
      this.lock = new ReentrantLock();
      this.notificationCallback = (UnparsedNotificationCallback)Preconditions.checkNotNull(notificationCallback);
      this.id = (String)Preconditions.checkNotNull(id);
   }

   public StoredChannel store(DataStoreFactory dataStoreFactory) throws IOException {
      return this.store(getDefaultDataStore(dataStoreFactory));
   }

   public StoredChannel store(DataStore dataStore) throws IOException {
      this.lock.lock();

      StoredChannel var2;
      try {
         dataStore.set(this.getId(), this);
         var2 = this;
      } finally {
         this.lock.unlock();
      }

      return var2;
   }

   public UnparsedNotificationCallback getNotificationCallback() {
      this.lock.lock();

      UnparsedNotificationCallback var1;
      try {
         var1 = this.notificationCallback;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public String getClientToken() {
      this.lock.lock();

      String var1;
      try {
         var1 = this.clientToken;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public StoredChannel setClientToken(String clientToken) {
      this.lock.lock();

      try {
         this.clientToken = clientToken;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public Long getExpiration() {
      this.lock.lock();

      Long var1;
      try {
         var1 = this.expiration;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public StoredChannel setExpiration(Long expiration) {
      this.lock.lock();

      try {
         this.expiration = expiration;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public String getId() {
      this.lock.lock();

      String var1;
      try {
         var1 = this.id;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public String getTopicId() {
      this.lock.lock();

      String var1;
      try {
         var1 = this.topicId;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public StoredChannel setTopicId(String topicId) {
      this.lock.lock();

      try {
         this.topicId = topicId;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public String toString() {
      return Objects.toStringHelper(StoredChannel.class).add("notificationCallback", this.getNotificationCallback()).add("clientToken", this.getClientToken()).add("expiration", this.getExpiration()).add("id", this.getId()).add("topicId", this.getTopicId()).toString();
   }

   public boolean equals(Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof StoredChannel)) {
         return false;
      } else {
         StoredChannel o = (StoredChannel)other;
         return this.getId().equals(o.getId());
      }
   }

   public int hashCode() {
      return this.getId().hashCode();
   }

   public static DataStore getDefaultDataStore(DataStoreFactory dataStoreFactory) throws IOException {
      return dataStoreFactory.getDataStore(DEFAULT_DATA_STORE_ID);
   }
}
