package com.google.api.client.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class IOUtils {
   public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
      copy(inputStream, outputStream, true);
   }

   public static void copy(InputStream inputStream, OutputStream outputStream, boolean closeInputStream) throws IOException {
      try {
         ByteStreams.copy(inputStream, outputStream);
      } finally {
         if (closeInputStream) {
            inputStream.close();
         }

      }

   }

   public static long computeLength(StreamingContent content) throws IOException {
      ByteCountingOutputStream countingStream = new ByteCountingOutputStream();

      try {
         content.writeTo(countingStream);
      } finally {
         countingStream.close();
      }

      return countingStream.count;
   }

   public static byte[] serialize(Object value) throws IOException {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      serialize(value, out);
      return out.toByteArray();
   }

   public static void serialize(Object value, OutputStream outputStream) throws IOException {
      try {
         (new ObjectOutputStream(outputStream)).writeObject(value);
      } finally {
         outputStream.close();
      }

   }

   public static Serializable deserialize(byte[] bytes) throws IOException {
      return bytes == null ? null : deserialize((InputStream)(new ByteArrayInputStream(bytes)));
   }

   public static Serializable deserialize(InputStream inputStream) throws IOException {
      Serializable var1;
      try {
         var1 = (Serializable)(new ObjectInputStream(inputStream)).readObject();
      } catch (ClassNotFoundException var6) {
         IOException ioe = new IOException("Failed to deserialize object");
         ioe.initCause(var6);
         throw ioe;
      } finally {
         inputStream.close();
      }

      return var1;
   }

   public static boolean isSymbolicLink(File file) throws IOException {
      try {
         Class filesClass = Class.forName("java.nio.file.Files");
         Class pathClass = Class.forName("java.nio.file.Path");
         Object path = File.class.getMethod("toPath").invoke(file);
         boolean var10000 = (Boolean)filesClass.getMethod("isSymbolicLink", pathClass).invoke((Object)null, path);
         return var10000;
      } catch (InvocationTargetException var4) {
         Throwable cause = var4.getCause();
         Throwables.propagateIfPossible(cause, IOException.class);
         throw new RuntimeException(cause);
      } catch (ClassNotFoundException var5) {
      } catch (IllegalArgumentException var6) {
      } catch (SecurityException var7) {
      } catch (IllegalAccessException var8) {
      } catch (NoSuchMethodException var9) {
      }

      if (File.separatorChar == '\\') {
         return false;
      } else {
         File canonical = file;
         if (file.getParent() != null) {
            canonical = new File(file.getParentFile().getCanonicalFile(), file.getName());
         }

         return !canonical.getCanonicalFile().equals(canonical.getAbsoluteFile());
      }
   }
}
