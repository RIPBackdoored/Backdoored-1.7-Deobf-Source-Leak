package com.sun.jna;

final class Native$1 implements Callback$UncaughtExceptionHandler {
   public void uncaughtException(Callback c, Throwable e) {
      System.err.println("JNA: Callback " + c + " threw the following exception:");
      e.printStackTrace();
   }
}
