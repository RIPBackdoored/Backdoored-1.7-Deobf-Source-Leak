package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import java.io.IOException;
import java.io.Serializable;

@Beta
public interface UnparsedNotificationCallback extends Serializable {
   void onNotification(StoredChannel var1, UnparsedNotification var2) throws IOException;
}
