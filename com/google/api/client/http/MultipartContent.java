package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Logger;

public class MultipartContent extends AbstractHttpContent {
   static final String NEWLINE = "\r\n";
   private static final String TWO_DASHES = "--";
   private ArrayList parts = new ArrayList();

   public MultipartContent() {
      super((new HttpMediaType("multipart/related")).setParameter("boundary", "__END_OF_PART__"));
   }

   public void writeTo(OutputStream out) throws IOException {
      Writer writer = new OutputStreamWriter(out, this.getCharset());
      String boundary = this.getBoundary();

      for(Iterator var4 = this.parts.iterator(); var4.hasNext(); writer.write("\r\n")) {
         MultipartContent$Part part = (MultipartContent$Part)var4.next();
         HttpHeaders headers = (new HttpHeaders()).setAcceptEncoding((String)null);
         if (part.headers != null) {
            headers.fromHttpHeaders(part.headers);
         }

         headers.setContentEncoding((String)null).setUserAgent((String)null).setContentType((String)null).setContentLength((Long)null).set("Content-Transfer-Encoding", (Object)null);
         HttpContent content = part.content;
         StreamingContent streamingContent = null;
         if (content != null) {
            headers.set("Content-Transfer-Encoding", Arrays.asList("binary"));
            headers.setContentType(content.getType());
            HttpEncoding encoding = part.encoding;
            long contentLength;
            if (encoding == null) {
               contentLength = content.getLength();
               streamingContent = content;
            } else {
               headers.setContentEncoding(encoding.getName());
               streamingContent = new HttpEncodingStreamingContent(content, encoding);
               contentLength = AbstractHttpContent.computeLength(content);
            }

            if (contentLength != -1L) {
               headers.setContentLength(contentLength);
            }
         }

         writer.write("--");
         writer.write(boundary);
         writer.write("\r\n");
         HttpHeaders.serializeHeadersForMultipartRequests(headers, (StringBuilder)null, (Logger)null, writer);
         if (streamingContent != null) {
            writer.write("\r\n");
            writer.flush();
            ((StreamingContent)streamingContent).writeTo(out);
         }
      }

      writer.write("--");
      writer.write(boundary);
      writer.write("--");
      writer.write("\r\n");
      writer.flush();
   }

   public boolean retrySupported() {
      Iterator var1 = this.parts.iterator();

      MultipartContent$Part part;
      do {
         if (!var1.hasNext()) {
            return true;
         }

         part = (MultipartContent$Part)var1.next();
      } while(part.content.retrySupported());

      return false;
   }

   public MultipartContent setMediaType(HttpMediaType mediaType) {
      super.setMediaType(mediaType);
      return this;
   }

   public final Collection getParts() {
      return Collections.unmodifiableCollection(this.parts);
   }

   public MultipartContent addPart(MultipartContent$Part part) {
      this.parts.add(Preconditions.checkNotNull(part));
      return this;
   }

   public MultipartContent setParts(Collection parts) {
      this.parts = new ArrayList(parts);
      return this;
   }

   public MultipartContent setContentParts(Collection contentParts) {
      this.parts = new ArrayList(contentParts.size());
      Iterator var2 = contentParts.iterator();

      while(var2.hasNext()) {
         HttpContent contentPart = (HttpContent)var2.next();
         this.addPart(new MultipartContent$Part(contentPart));
      }

      return this;
   }

   public final String getBoundary() {
      return this.getMediaType().getParameter("boundary");
   }

   public MultipartContent setBoundary(String boundary) {
      this.getMediaType().setParameter("boundary", (String)Preconditions.checkNotNull(boundary));
      return this;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public AbstractHttpContent setMediaType(HttpMediaType var1) {
      return this.setMediaType(var1);
   }
}
