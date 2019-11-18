package l.c.x.j;

public class c extends RuntimeException {
   public static final int h;
   public static final boolean a;

   public c() {
      this("");
   }

   public c(String var1) {
      this.setStackTrace(new StackTraceElement[0]);
   }

   public String toString() {
      return "Go away john";
   }

   public synchronized Throwable fillInStackTrace() {
      return this;
   }
}
