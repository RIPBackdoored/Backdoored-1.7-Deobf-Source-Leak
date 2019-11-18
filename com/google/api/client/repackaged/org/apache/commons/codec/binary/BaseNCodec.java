package com.google.api.client.repackaged.org.apache.commons.codec.binary;

import com.google.api.client.repackaged.org.apache.commons.codec.BinaryDecoder;
import com.google.api.client.repackaged.org.apache.commons.codec.BinaryEncoder;
import com.google.api.client.repackaged.org.apache.commons.codec.DecoderException;
import com.google.api.client.repackaged.org.apache.commons.codec.EncoderException;

public abstract class BaseNCodec implements BinaryEncoder, BinaryDecoder {
   public static final int MIME_CHUNK_SIZE = 76;
   public static final int PEM_CHUNK_SIZE = 64;
   private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
   private static final int DEFAULT_BUFFER_SIZE = 8192;
   protected static final int MASK_8BITS = 255;
   protected static final byte PAD_DEFAULT = 61;
   protected final byte PAD = 61;
   private final int unencodedBlockSize;
   private final int encodedBlockSize;
   protected final int lineLength;
   private final int chunkSeparatorLength;
   protected byte[] buffer;
   protected int pos;
   private int readPos;
   protected boolean eof;
   protected int currentLinePos;
   protected int modulus;

   protected BaseNCodec(int unencodedBlockSize, int encodedBlockSize, int lineLength, int chunkSeparatorLength) {
      this.unencodedBlockSize = unencodedBlockSize;
      this.encodedBlockSize = encodedBlockSize;
      this.lineLength = lineLength > 0 && chunkSeparatorLength > 0 ? lineLength / encodedBlockSize * encodedBlockSize : 0;
      this.chunkSeparatorLength = chunkSeparatorLength;
   }

   boolean hasData() {
      return this.buffer != null;
   }

   int available() {
      return this.buffer != null ? this.pos - this.readPos : 0;
   }

   protected int getDefaultBufferSize() {
      return 8192;
   }

   private void resizeBuffer() {
      if (this.buffer == null) {
         this.buffer = new byte[this.getDefaultBufferSize()];
         this.pos = 0;
         this.readPos = 0;
      } else {
         byte[] b = new byte[this.buffer.length * 2];
         System.arraycopy(this.buffer, 0, b, 0, this.buffer.length);
         this.buffer = b;
      }

   }

   protected void ensureBufferSize(int size) {
      if (this.buffer == null || this.buffer.length < this.pos + size) {
         this.resizeBuffer();
      }

   }

   int readResults(byte[] b, int bPos, int bAvail) {
      if (this.buffer != null) {
         int len = Math.min(this.available(), bAvail);
         System.arraycopy(this.buffer, this.readPos, b, bPos, len);
         this.readPos += len;
         if (this.readPos >= this.pos) {
            this.buffer = null;
         }

         return len;
      } else {
         return this.eof ? -1 : 0;
      }
   }

   protected static boolean isWhiteSpace(byte byteToCheck) {
      switch(byteToCheck) {
      case 9:
      case 10:
      case 13:
      case 32:
         return true;
      default:
         return false;
      }
   }

   private void reset() {
      this.buffer = null;
      this.pos = 0;
      this.readPos = 0;
      this.currentLinePos = 0;
      this.modulus = 0;
      this.eof = false;
   }

   public Object encode(Object pObject) throws EncoderException {
      if (!(pObject instanceof byte[])) {
         throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
      } else {
         return this.encode((byte[])((byte[])pObject));
      }
   }

   public String encodeToString(byte[] pArray) {
      return StringUtils.newStringUtf8(this.encode(pArray));
   }

   public Object decode(Object pObject) throws DecoderException {
      if (pObject instanceof byte[]) {
         return this.decode((byte[])((byte[])pObject));
      } else if (pObject instanceof String) {
         return this.decode((String)pObject);
      } else {
         throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
      }
   }

   public byte[] decode(String pArray) {
      return this.decode(StringUtils.getBytesUtf8(pArray));
   }

   public byte[] decode(byte[] pArray) {
      this.reset();
      if (pArray != null && pArray.length != 0) {
         this.decode(pArray, 0, pArray.length);
         this.decode(pArray, 0, -1);
         byte[] result = new byte[this.pos];
         this.readResults(result, 0, result.length);
         return result;
      } else {
         return pArray;
      }
   }

   public byte[] encode(byte[] pArray) {
      this.reset();
      if (pArray != null && pArray.length != 0) {
         this.encode(pArray, 0, pArray.length);
         this.encode(pArray, 0, -1);
         byte[] buf = new byte[this.pos - this.readPos];
         this.readResults(buf, 0, buf.length);
         return buf;
      } else {
         return pArray;
      }
   }

   public String encodeAsString(byte[] pArray) {
      return StringUtils.newStringUtf8(this.encode(pArray));
   }

   abstract void encode(byte[] var1, int var2, int var3);

   abstract void decode(byte[] var1, int var2, int var3);

   protected abstract boolean isInAlphabet(byte var1);

   public boolean isInAlphabet(byte[] arrayOctet, boolean allowWSPad) {
      for(int i = 0; i < arrayOctet.length; ++i) {
         if (!this.isInAlphabet(arrayOctet[i]) && (!allowWSPad || arrayOctet[i] != 61 && !isWhiteSpace(arrayOctet[i]))) {
            return false;
         }
      }

      return true;
   }

   public boolean isInAlphabet(String basen) {
      return this.isInAlphabet(StringUtils.getBytesUtf8(basen), true);
   }

   protected boolean containsAlphabetOrPad(byte[] arrayOctet) {
      if (arrayOctet == null) {
         return false;
      } else {
         byte[] arr$ = arrayOctet;
         int len$ = arrayOctet.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            byte element = arr$[i$];
            if (61 == element || this.isInAlphabet(element)) {
               return true;
            }
         }

         return false;
      }
   }

   public long getEncodedLength(byte[] pArray) {
      long len = (long)((pArray.length + this.unencodedBlockSize - 1) / this.unencodedBlockSize) * (long)this.encodedBlockSize;
      if (this.lineLength > 0) {
         len += (len + (long)this.lineLength - 1L) / (long)this.lineLength * (long)this.chunkSeparatorLength;
      }

      return len;
   }
}
