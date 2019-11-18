package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import java.lang.ref.SoftReference;

public class BufferRecyclers {
   public static final String SYSTEM_PROPERTY_TRACK_REUSABLE_BUFFERS = "com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers";
   private static final ThreadLocalBufferManager _bufferRecyclerTracker = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers")) ? ThreadLocalBufferManager.instance() : null;
   protected static final ThreadLocal _recyclerRef = new ThreadLocal();
   protected static final ThreadLocal _encoderRef = new ThreadLocal();

   public static BufferRecycler getBufferRecycler() {
      SoftReference ref = (SoftReference)_recyclerRef.get();
      BufferRecycler br = ref == null ? null : (BufferRecycler)ref.get();
      if (br == null) {
         br = new BufferRecycler();
         if (_bufferRecyclerTracker != null) {
            ref = _bufferRecyclerTracker.wrapAndTrack(br);
         } else {
            ref = new SoftReference(br);
         }

         _recyclerRef.set(ref);
      }

      return br;
   }

   public static int releaseBuffers() {
      return _bufferRecyclerTracker != null ? _bufferRecyclerTracker.releaseBuffers() : -1;
   }

   public static JsonStringEncoder getJsonStringEncoder() {
      SoftReference ref = (SoftReference)_encoderRef.get();
      JsonStringEncoder enc = ref == null ? null : (JsonStringEncoder)ref.get();
      if (enc == null) {
         enc = new JsonStringEncoder();
         _encoderRef.set(new SoftReference(enc));
      }

      return enc;
   }

   public static byte[] encodeAsUTF8(String text) {
      return getJsonStringEncoder().encodeAsUTF8(text);
   }

   public static char[] quoteAsJsonText(String rawText) {
      return getJsonStringEncoder().quoteAsString(rawText);
   }

   public static void quoteAsJsonText(CharSequence input, StringBuilder output) {
      getJsonStringEncoder().quoteAsString(input, output);
   }

   public static byte[] quoteAsJsonUTF8(String rawText) {
      return getJsonStringEncoder().quoteAsUTF8(rawText);
   }
}
