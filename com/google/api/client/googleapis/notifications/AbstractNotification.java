package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Objects$ToStringHelper;
import com.google.api.client.util.Preconditions;

@Beta
public abstract class AbstractNotification {
   private long messageNumber;
   private String resourceState;
   private String resourceId;
   private String resourceUri;
   private String channelId;
   private String channelExpiration;
   private String channelToken;
   private String changed;

   protected AbstractNotification(long messageNumber, String resourceState, String resourceId, String resourceUri, String channelId) {
      this.setMessageNumber(messageNumber);
      this.setResourceState(resourceState);
      this.setResourceId(resourceId);
      this.setResourceUri(resourceUri);
      this.setChannelId(channelId);
   }

   protected AbstractNotification(AbstractNotification source) {
      this(source.getMessageNumber(), source.getResourceState(), source.getResourceId(), source.getResourceUri(), source.getChannelId());
      this.setChannelExpiration(source.getChannelExpiration());
      this.setChannelToken(source.getChannelToken());
      this.setChanged(source.getChanged());
   }

   public String toString() {
      return this.toStringHelper().toString();
   }

   protected Objects$ToStringHelper toStringHelper() {
      return Objects.toStringHelper(this).add("messageNumber", this.messageNumber).add("resourceState", this.resourceState).add("resourceId", this.resourceId).add("resourceUri", this.resourceUri).add("channelId", this.channelId).add("channelExpiration", this.channelExpiration).add("channelToken", this.channelToken).add("changed", this.changed);
   }

   public final long getMessageNumber() {
      return this.messageNumber;
   }

   public AbstractNotification setMessageNumber(long messageNumber) {
      Preconditions.checkArgument(messageNumber >= 1L);
      this.messageNumber = messageNumber;
      return this;
   }

   public final String getResourceState() {
      return this.resourceState;
   }

   public AbstractNotification setResourceState(String resourceState) {
      this.resourceState = (String)Preconditions.checkNotNull(resourceState);
      return this;
   }

   public final String getResourceId() {
      return this.resourceId;
   }

   public AbstractNotification setResourceId(String resourceId) {
      this.resourceId = (String)Preconditions.checkNotNull(resourceId);
      return this;
   }

   public final String getResourceUri() {
      return this.resourceUri;
   }

   public AbstractNotification setResourceUri(String resourceUri) {
      this.resourceUri = (String)Preconditions.checkNotNull(resourceUri);
      return this;
   }

   public final String getChannelId() {
      return this.channelId;
   }

   public AbstractNotification setChannelId(String channelId) {
      this.channelId = (String)Preconditions.checkNotNull(channelId);
      return this;
   }

   public final String getChannelExpiration() {
      return this.channelExpiration;
   }

   public AbstractNotification setChannelExpiration(String channelExpiration) {
      this.channelExpiration = channelExpiration;
      return this;
   }

   public final String getChannelToken() {
      return this.channelToken;
   }

   public AbstractNotification setChannelToken(String channelToken) {
      this.channelToken = channelToken;
      return this;
   }

   public final String getChanged() {
      return this.changed;
   }

   public AbstractNotification setChanged(String changed) {
      this.changed = changed;
      return this;
   }
}
