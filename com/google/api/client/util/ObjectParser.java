package com.google.api.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public interface ObjectParser {
   Object parseAndClose(InputStream var1, Charset var2, Class var3) throws IOException;

   Object parseAndClose(InputStream var1, Charset var2, Type var3) throws IOException;

   Object parseAndClose(Reader var1, Class var2) throws IOException;

   Object parseAndClose(Reader var1, Type var2) throws IOException;
}
