package com.sun.jna;

import java.nio.ByteBuffer;

class Pointer$Opaque extends Pointer {
   private final String MSG;

   private Pointer$Opaque(long peer) {
      super(peer);
      this.MSG = "This pointer is opaque: " + this;
   }

   public Pointer share(long offset, long size) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void clear(long size) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public long indexOf(long offset, byte value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void read(long bOff, byte[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void read(long bOff, char[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void read(long bOff, short[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void read(long bOff, int[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void read(long bOff, long[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void read(long bOff, float[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void read(long bOff, double[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void read(long bOff, Pointer[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void write(long bOff, byte[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void write(long bOff, char[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void write(long bOff, short[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void write(long bOff, int[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void write(long bOff, long[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void write(long bOff, float[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void write(long bOff, double[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void write(long bOff, Pointer[] buf, int index, int length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public ByteBuffer getByteBuffer(long offset, long length) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public byte getByte(long bOff) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public char getChar(long bOff) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public short getShort(long bOff) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public int getInt(long bOff) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public long getLong(long bOff) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public float getFloat(long bOff) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public double getDouble(long bOff) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public Pointer getPointer(long bOff) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public String getString(long bOff, String encoding) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public String getWideString(long bOff) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setByte(long bOff, byte value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setChar(long bOff, char value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setShort(long bOff, short value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setInt(long bOff, int value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setLong(long bOff, long value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setFloat(long bOff, float value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setDouble(long bOff, double value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setPointer(long offset, Pointer value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setString(long offset, String value, String encoding) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setWideString(long offset, String value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public void setMemory(long offset, long size, byte value) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public String dump(long offset, int size) {
      throw new UnsupportedOperationException(this.MSG);
   }

   public String toString() {
      return "const@0x" + Long.toHexString(this.peer);
   }

   // $FF: synthetic method
   Pointer$Opaque(long x0, Pointer$1 x1) {
      this(x0);
   }
}
