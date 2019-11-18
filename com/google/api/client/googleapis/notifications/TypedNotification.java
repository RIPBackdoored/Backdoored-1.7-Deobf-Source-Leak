package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;

@Beta
public class TypedNotification extends AbstractNotification {
   private Object content;

   public TypedNotification(long messageNumber, String resourceState, String resourceId, String resourceUri, String channelId) {
      super(messageNumber, resourceState, resourceId, resourceUri, channelId);
   }

   public TypedNotification(UnparsedNotification sourceNotification) {
      super(sourceNotification);
   }

   public final Object getContent() {
      return this.content;
   }

   public TypedNotification setContent(Object content) {
      this.content = content;
      return this;
   }

   public TypedNotification setMessageNumber(long messageNumber) {
      return (TypedNotification)super.setMessageNumber(messageNumber);
   }

   public TypedNotification setResourceState(String resourceState) {
      return (TypedNotification)super.setResourceState(resourceState);
   }

   public TypedNotification setResourceId(String resourceId) {
      return (TypedNotification)super.setResourceId(resourceId);
   }

   public TypedNotification setResourceUri(String resourceUri) {
      return (TypedNotification)super.setResourceUri(resourceUri);
   }

   public TypedNotification setChannelId(String channelId) {
      return (TypedNotification)super.setChannelId(channelId);
   }

   public TypedNotification setChannelExpiration(String channelExpiration) {
      return (TypedNotification)super.setChannelExpiration(channelExpiration);
   }

   public TypedNotification setChannelToken(String channelToken) {
      return (TypedNotification)super.setChannelToken(channelToken);
   }

   public TypedNotification setChanged(String changed) {
      return (TypedNotification)super.setChanged(changed);
   }

   public String toString() {
      return super.toStringHelper().add("content", this.content).toString();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractNotification setChanged(String var1) {
      return this.setChanged(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractNotification setChannelToken(String var1) {
      return this.setChannelToken(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractNotification setChannelExpiration(String var1) {
      return this.setChannelExpiration(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractNotification setChannelId(String var1) {
      return this.setChannelId(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractNotification setResourceUri(String var1) {
      return this.setResourceUri(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractNotification setResourceId(String var1) {
      return this.setResourceId(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractNotification setResourceState(String var1) {
      return this.setResourceState(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractNotification setMessageNumber(long var1) {
      return this.setMessageNumber(var1);
   }
}
