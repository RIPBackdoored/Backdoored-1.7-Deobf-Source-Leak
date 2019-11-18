package com.google.api.client.googleapis.notifications;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.nio.charset.Charset;

@Beta
public abstract class TypedNotificationCallback implements UnparsedNotificationCallback {
   private static final long serialVersionUID = 1L;

   protected abstract void onNotification(StoredChannel var1, TypedNotification var2) throws IOException;

   protected abstract ObjectParser getObjectParser() throws IOException;

   protected abstract Class getDataClass() throws IOException;

   public final void onNotification(StoredChannel storedChannel, UnparsedNotification notification) throws IOException {
      TypedNotification typedNotification = new TypedNotification(notification);
      String contentType = notification.getContentType();
      if (contentType != null) {
         Charset charset = (new HttpMediaType(contentType)).getCharsetParameter();
         Class dataClass = (Class)Preconditions.checkNotNull(this.getDataClass());
         typedNotification.setContent(this.getObjectParser().parseAndClose(notification.getContentStream(), charset, dataClass));
      }

      this.onNotification(storedChannel, typedNotification);
   }
}
