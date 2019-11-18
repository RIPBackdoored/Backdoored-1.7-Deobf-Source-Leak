package com.google.api.client.extensions.jetty.auth.oauth2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.handler.AbstractHandler;

class LocalServerReceiver$CallbackHandler extends AbstractHandler {
   // $FF: synthetic field
   final LocalServerReceiver this$0;

   LocalServerReceiver$CallbackHandler(LocalServerReceiver var1) {
      this.this$0 = var1;
   }

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException {
      if ("/Callback".equals(target)) {
         try {
            ((Request)request).setHandled(true);
            this.this$0.error = request.getParameter("error");
            this.this$0.code = request.getParameter("code");
            if (this.this$0.error == null && LocalServerReceiver.access$000(this.this$0) != null) {
               response.sendRedirect(LocalServerReceiver.access$000(this.this$0));
            } else if (this.this$0.error != null && LocalServerReceiver.access$100(this.this$0) != null) {
               response.sendRedirect(LocalServerReceiver.access$100(this.this$0));
            } else {
               this.writeLandingHtml(response);
            }

            response.flushBuffer();
         } finally {
            this.this$0.waitUnlessSignaled.release();
         }

      }
   }

   private void writeLandingHtml(HttpServletResponse response) throws IOException {
      response.setStatus(200);
      response.setContentType("text/html");
      PrintWriter doc = response.getWriter();
      doc.println("<html>");
      doc.println("<head><title>OAuth 2.0 Authentication Token Received</title></head>");
      doc.println("<body>");
      doc.println("Received verification code. You may now close this window.");
      doc.println("</body>");
      doc.println("</html>");
      doc.flush();
   }
}
