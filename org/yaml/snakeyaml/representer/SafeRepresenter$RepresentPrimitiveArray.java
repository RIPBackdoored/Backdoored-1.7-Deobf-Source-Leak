package org.yaml.snakeyaml.representer;

import java.util.ArrayList;
import java.util.List;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentPrimitiveArray implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentPrimitiveArray(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      Class type = data.getClass().getComponentType();
      if (Byte.TYPE == type) {
         return this.this$0.representSequence(Tag.SEQ, this.asByteList(data), (Boolean)null);
      } else if (Short.TYPE == type) {
         return this.this$0.representSequence(Tag.SEQ, this.asShortList(data), (Boolean)null);
      } else if (Integer.TYPE == type) {
         return this.this$0.representSequence(Tag.SEQ, this.asIntList(data), (Boolean)null);
      } else if (Long.TYPE == type) {
         return this.this$0.representSequence(Tag.SEQ, this.asLongList(data), (Boolean)null);
      } else if (Float.TYPE == type) {
         return this.this$0.representSequence(Tag.SEQ, this.asFloatList(data), (Boolean)null);
      } else if (Double.TYPE == type) {
         return this.this$0.representSequence(Tag.SEQ, this.asDoubleList(data), (Boolean)null);
      } else if (Character.TYPE == type) {
         return this.this$0.representSequence(Tag.SEQ, this.asCharList(data), (Boolean)null);
      } else if (Boolean.TYPE == type) {
         return this.this$0.representSequence(Tag.SEQ, this.asBooleanList(data), (Boolean)null);
      } else {
         throw new YAMLException("Unexpected primitive '" + type.getCanonicalName() + "'");
      }
   }

   private List asByteList(Object in) {
      byte[] array = (byte[])((byte[])in);
      List list = new ArrayList(array.length);

      for(int i = 0; i < array.length; ++i) {
         list.add(array[i]);
      }

      return list;
   }

   private List asShortList(Object in) {
      short[] array = (short[])((short[])in);
      List list = new ArrayList(array.length);

      for(int i = 0; i < array.length; ++i) {
         list.add(array[i]);
      }

      return list;
   }

   private List asIntList(Object in) {
      int[] array = (int[])((int[])in);
      List list = new ArrayList(array.length);

      for(int i = 0; i < array.length; ++i) {
         list.add(array[i]);
      }

      return list;
   }

   private List asLongList(Object in) {
      long[] array = (long[])((long[])in);
      List list = new ArrayList(array.length);

      for(int i = 0; i < array.length; ++i) {
         list.add(array[i]);
      }

      return list;
   }

   private List asFloatList(Object in) {
      float[] array = (float[])((float[])in);
      List list = new ArrayList(array.length);

      for(int i = 0; i < array.length; ++i) {
         list.add(array[i]);
      }

      return list;
   }

   private List asDoubleList(Object in) {
      double[] array = (double[])((double[])in);
      List list = new ArrayList(array.length);

      for(int i = 0; i < array.length; ++i) {
         list.add(array[i]);
      }

      return list;
   }

   private List asCharList(Object in) {
      char[] array = (char[])((char[])in);
      List list = new ArrayList(array.length);

      for(int i = 0; i < array.length; ++i) {
         list.add(array[i]);
      }

      return list;
   }

   private List asBooleanList(Object in) {
      boolean[] array = (boolean[])((boolean[])in);
      List list = new ArrayList(array.length);

      for(int i = 0; i < array.length; ++i) {
         list.add(array[i]);
      }

      return list;
   }
}
