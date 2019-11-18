package com.google.api.client.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingByteArrayOutputStream extends ByteArrayOutputStream {
   private int bytesWritten;
   private final int maximumBytesToLog;
   private boolean closed;
   private final Level loggingLevel;
   private final Logger logger;

   public LoggingByteArrayOutputStream(Logger logger, Level loggingLevel, int maximumBytesToLog) {
      this.logger = (Logger)Preconditions.checkNotNull(logger);
      this.loggingLevel = (Level)Preconditions.checkNotNull(loggingLevel);
      Preconditions.checkArgument(maximumBytesToLog >= 0);
      this.maximumBytesToLog = maximumBytesToLog;
   }

   public synchronized void write(int b) {
      Preconditions.checkArgument(!this.closed);
      ++this.bytesWritten;
      if (this.count < this.maximumBytesToLog) {
         super.write(b);
      }

   }

   public synchronized void write(byte[] b, int off, int len) {
      Preconditions.checkArgument(!this.closed);
      this.bytesWritten += len;
      if (this.count < this.maximumBytesToLog) {
         int end = this.count + len;
         if (end > this.maximumBytesToLog) {
            len += this.maximumBytesToLog - end;
         }

         super.write(b, off, len);
      }

   }

   public synchronized void close() throws IOException {
      if (!this.closed) {
         if (this.bytesWritten != 0) {
            StringBuilder buf = (new StringBuilder()).append("Total: ");
            appendBytes(buf, this.bytesWritten);
            if (this.count != 0 && this.count < this.bytesWritten) {
               buf.append(" (logging first ");
               appendBytes(buf, this.count);
               buf.append(")");
            }

            this.logger.config(buf.toString());
            if (this.count != 0) {
               this.logger.log(this.loggingLevel, this.toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
            }
         }

         this.closed = true;
      }

   }

   public final int getMaximumBytesToLog() {
      return this.maximumBytesToLog;
   }

   public final synchronized int getBytesWritten() {
      return this.bytesWritten;
   }

   private static void appendBytes(StringBuilder buf, int x) {
      if (x == 1) {
         buf.append("1 byte");
      } else {
         buf.append(NumberFormat.getInstance().format((long)x)).append(" bytes");
      }

   }
}
