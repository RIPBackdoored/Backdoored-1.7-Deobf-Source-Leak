package com.google.api.client.http;

import com.google.api.client.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

public interface HttpEncoding {
   String getName();

   void encode(StreamingContent var1, OutputStream var2) throws IOException;
}
