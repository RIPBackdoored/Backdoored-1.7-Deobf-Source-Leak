package javassist.bytecode;

import java.io.ByteArrayOutputStream;

public class StackMapTable$Writer {
   ByteArrayOutputStream output;
   int numOfEntries;

   public StackMapTable$Writer(int size) {
      this.output = new ByteArrayOutputStream(size);
      this.numOfEntries = 0;
      this.output.write(0);
      this.output.write(0);
   }

   public byte[] toByteArray() {
      byte[] b = this.output.toByteArray();
      ByteArray.write16bit(this.numOfEntries, b, 0);
      return b;
   }

   public StackMapTable toStackMapTable(ConstPool cp) {
      return new StackMapTable(cp, this.toByteArray());
   }

   public void sameFrame(int offsetDelta) {
      ++this.numOfEntries;
      if (offsetDelta < 64) {
         this.output.write(offsetDelta);
      } else {
         this.output.write(251);
         this.write16(offsetDelta);
      }

   }

   public void sameLocals(int offsetDelta, int tag, int data) {
      ++this.numOfEntries;
      if (offsetDelta < 64) {
         this.output.write(offsetDelta + 64);
      } else {
         this.output.write(247);
         this.write16(offsetDelta);
      }

      this.writeTypeInfo(tag, data);
   }

   public void chopFrame(int offsetDelta, int k) {
      ++this.numOfEntries;
      this.output.write(251 - k);
      this.write16(offsetDelta);
   }

   public void appendFrame(int offsetDelta, int[] tags, int[] data) {
      ++this.numOfEntries;
      int k = tags.length;
      this.output.write(k + 251);
      this.write16(offsetDelta);

      for(int i = 0; i < k; ++i) {
         this.writeTypeInfo(tags[i], data[i]);
      }

   }

   public void fullFrame(int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) {
      ++this.numOfEntries;
      this.output.write(255);
      this.write16(offsetDelta);
      int n = localTags.length;
      this.write16(n);

      int i;
      for(i = 0; i < n; ++i) {
         this.writeTypeInfo(localTags[i], localData[i]);
      }

      n = stackTags.length;
      this.write16(n);

      for(i = 0; i < n; ++i) {
         this.writeTypeInfo(stackTags[i], stackData[i]);
      }

   }

   private void writeTypeInfo(int tag, int data) {
      this.output.write(tag);
      if (tag == 7 || tag == 8) {
         this.write16(data);
      }

   }

   private void write16(int value) {
      this.output.write(value >>> 8 & 255);
      this.output.write(value & 255);
   }
}
