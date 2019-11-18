package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

@Beta
public class LogRecordingHandler extends Handler {
   private final List records = Lists.newArrayList();

   public void publish(LogRecord record) {
      this.records.add(record);
   }

   public void flush() {
   }

   public void close() throws SecurityException {
   }

   public List messages() {
      List result = Lists.newArrayList();
      Iterator var2 = this.records.iterator();

      while(var2.hasNext()) {
         LogRecord record = (LogRecord)var2.next();
         result.add(record.getMessage());
      }

      return result;
   }
}
