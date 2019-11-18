package javassist.bytecode;

public class StackMapTable$Walker {
   byte[] info;
   int numOfEntries;

   public StackMapTable$Walker(StackMapTable smt) {
      this(smt.get());
   }

   public StackMapTable$Walker(byte[] data) {
      this.info = data;
      this.numOfEntries = ByteArray.readU16bit(data, 0);
   }

   public final int size() {
      return this.numOfEntries;
   }

   public void parse() throws BadBytecode {
      int n = this.numOfEntries;
      int pos = 2;

      for(int i = 0; i < n; ++i) {
         pos = this.stackMapFrames(pos, i);
      }

   }

   int stackMapFrames(int pos, int nth) throws BadBytecode {
      int type = this.info[pos] & 255;
      if (type < 64) {
         this.sameFrame(pos, type);
         ++pos;
      } else if (type < 128) {
         pos = this.sameLocals(pos, type);
      } else {
         if (type < 247) {
            throw new BadBytecode("bad frame_type in StackMapTable");
         }

         if (type == 247) {
            pos = this.sameLocals(pos, type);
         } else {
            int offset;
            if (type < 251) {
               offset = ByteArray.readU16bit(this.info, pos + 1);
               this.chopFrame(pos, offset, 251 - type);
               pos += 3;
            } else if (type == 251) {
               offset = ByteArray.readU16bit(this.info, pos + 1);
               this.sameFrame(pos, offset);
               pos += 3;
            } else if (type < 255) {
               pos = this.appendFrame(pos, type);
            } else {
               pos = this.fullFrame(pos);
            }
         }
      }

      return pos;
   }

   public void sameFrame(int pos, int offsetDelta) throws BadBytecode {
   }

   private int sameLocals(int pos, int type) throws BadBytecode {
      int top = pos;
      int offset;
      if (type < 128) {
         offset = type - 64;
      } else {
         offset = ByteArray.readU16bit(this.info, pos + 1);
         pos += 2;
      }

      int tag = this.info[pos + 1] & 255;
      int data = 0;
      if (tag == 7 || tag == 8) {
         data = ByteArray.readU16bit(this.info, pos + 2);
         this.objectOrUninitialized(tag, data, pos + 2);
         pos += 2;
      }

      this.sameLocals(top, offset, tag, data);
      return pos + 2;
   }

   public void sameLocals(int pos, int offsetDelta, int stackTag, int stackData) throws BadBytecode {
   }

   public void chopFrame(int pos, int offsetDelta, int k) throws BadBytecode {
   }

   private int appendFrame(int pos, int type) throws BadBytecode {
      int k = type - 251;
      int offset = ByteArray.readU16bit(this.info, pos + 1);
      int[] tags = new int[k];
      int[] data = new int[k];
      int p = pos + 3;

      for(int i = 0; i < k; ++i) {
         int tag = this.info[p] & 255;
         tags[i] = tag;
         if (tag != 7 && tag != 8) {
            data[i] = 0;
            ++p;
         } else {
            data[i] = ByteArray.readU16bit(this.info, p + 1);
            this.objectOrUninitialized(tag, data[i], p + 1);
            p += 3;
         }
      }

      this.appendFrame(pos, offset, tags, data);
      return p;
   }

   public void appendFrame(int pos, int offsetDelta, int[] tags, int[] data) throws BadBytecode {
   }

   private int fullFrame(int pos) throws BadBytecode {
      int offset = ByteArray.readU16bit(this.info, pos + 1);
      int numOfLocals = ByteArray.readU16bit(this.info, pos + 3);
      int[] localsTags = new int[numOfLocals];
      int[] localsData = new int[numOfLocals];
      int p = this.verifyTypeInfo(pos + 5, numOfLocals, localsTags, localsData);
      int numOfItems = ByteArray.readU16bit(this.info, p);
      int[] itemsTags = new int[numOfItems];
      int[] itemsData = new int[numOfItems];
      p = this.verifyTypeInfo(p + 2, numOfItems, itemsTags, itemsData);
      this.fullFrame(pos, offset, localsTags, localsData, itemsTags, itemsData);
      return p;
   }

   public void fullFrame(int pos, int offsetDelta, int[] localTags, int[] localData, int[] stackTags, int[] stackData) throws BadBytecode {
   }

   private int verifyTypeInfo(int pos, int n, int[] tags, int[] data) {
      for(int i = 0; i < n; ++i) {
         int tag = this.info[pos++] & 255;
         tags[i] = tag;
         if (tag == 7 || tag == 8) {
            data[i] = ByteArray.readU16bit(this.info, pos);
            this.objectOrUninitialized(tag, data[i], pos);
            pos += 2;
         }
      }

      return pos;
   }

   public void objectOrUninitialized(int tag, int data, int pos) {
   }
}
