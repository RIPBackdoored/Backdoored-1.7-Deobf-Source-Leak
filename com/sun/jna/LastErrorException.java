package com.sun.jna;

public class LastErrorException extends RuntimeException {
   private static final long serialVersionUID = 1L;
   private int errorCode;

   private static String formatMessage(int code) {
      return Platform.isWindows() ? "GetLastError() returned " + code : "errno was " + code;
   }

   private static String parseMessage(String m) {
      String var10000;
      try {
         var10000 = formatMessage(Integer.parseInt(m));
      } catch (NumberFormatException var2) {
         return m;
      }

      return var10000;
   }

   public int getErrorCode() {
      return this.errorCode;
   }

   public LastErrorException(String msg) {
      super(parseMessage(msg.trim()));

      try {
         if (msg.startsWith("[")) {
            msg = msg.substring(1, msg.indexOf("]"));
         }

         this.errorCode = Integer.parseInt(msg);
      } catch (NumberFormatException var3) {
         this.errorCode = -1;
      }

   }

   public LastErrorException(int code) {
      this(code, formatMessage(code));
   }

   protected LastErrorException(int code, String msg) {
      super(msg);
      this.errorCode = code;
   }
}
