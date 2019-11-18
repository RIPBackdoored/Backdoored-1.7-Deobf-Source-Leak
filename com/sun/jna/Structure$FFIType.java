package com.sun.jna;

import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

class Structure$FFIType extends Structure {
   private static final Map typeInfoMap = new WeakHashMap();
   private static final int FFI_TYPE_STRUCT = 13;
   public Structure$FFIType$size_t size;
   public short alignment;
   public short type = 13;
   public Pointer elements;

   private Structure$FFIType(Structure ref) {
      Structure.access$1900(ref, true);
      Pointer[] els;
      if (ref instanceof Union) {
         Structure$StructField sf = ((Union)ref).typeInfoField();
         els = new Pointer[]{get(ref.getFieldValue(sf.field), sf.type), null};
      } else {
         els = new Pointer[ref.fields().size() + 1];
         int idx = 0;

         Structure$StructField sf;
         for(Iterator var4 = ref.fields().values().iterator(); var4.hasNext(); els[idx++] = ref.getFieldTypeInfo(sf)) {
            sf = (Structure$StructField)var4.next();
         }
      }

      this.init(els);
   }

   private Structure$FFIType(Object array, Class type) {
      int length = Array.getLength(array);
      Pointer[] els = new Pointer[length + 1];
      Pointer p = get((Object)null, type.getComponentType());

      for(int i = 0; i < length; ++i) {
         els[i] = p;
      }

      this.init(els);
   }

   protected List getFieldOrder() {
      return Arrays.asList("size", "alignment", "type", "elements");
   }

   private void init(Pointer[] els) {
      this.elements = new Memory((long)(Pointer.SIZE * els.length));
      this.elements.write(0L, (Pointer[])els, 0, els.length);
      this.write();
   }

   static Pointer get(Object obj) {
      if (obj == null) {
         return Structure$FFIType$FFITypes.access$1800();
      } else {
         return obj instanceof Class ? get((Object)null, (Class)obj) : get(obj, obj.getClass());
      }
   }

   private static Pointer get(Object obj, Class cls) {
      TypeMapper mapper = Native.getTypeMapper(cls);
      if (mapper != null) {
         ToNativeConverter nc = mapper.getToNativeConverter(cls);
         if (nc != null) {
            cls = nc.nativeType();
         }
      }

      Pointer var10000;
      synchronized(typeInfoMap) {
         Object o = typeInfoMap.get(cls);
         if (o instanceof Pointer) {
            var10000 = (Pointer)o;
            return var10000;
         }

         if (o instanceof Structure$FFIType) {
            var10000 = ((Structure$FFIType)o).getPointer();
            return var10000;
         }

         if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls) || Callback.class.isAssignableFrom(cls)) {
            typeInfoMap.put(cls, Structure$FFIType$FFITypes.access$1800());
            var10000 = Structure$FFIType$FFITypes.access$1800();
            return var10000;
         }

         Structure$FFIType type;
         if (Structure.class.isAssignableFrom(cls)) {
            if (obj == null) {
               obj = newInstance(cls, Structure.access$2000());
            }

            if (Structure$ByReference.class.isAssignableFrom(cls)) {
               typeInfoMap.put(cls, Structure$FFIType$FFITypes.access$1800());
               var10000 = Structure$FFIType$FFITypes.access$1800();
               return var10000;
            }

            type = new Structure$FFIType((Structure)obj);
            typeInfoMap.put(cls, type);
            var10000 = type.getPointer();
            return var10000;
         }

         if (NativeMapped.class.isAssignableFrom(cls)) {
            NativeMappedConverter c = NativeMappedConverter.getInstance(cls);
            var10000 = get(c.toNative(obj, new ToNativeContext()), c.nativeType());
            return var10000;
         }

         if (!cls.isArray()) {
            throw new IllegalArgumentException("Unsupported type " + cls);
         }

         type = new Structure$FFIType(obj, cls);
         typeInfoMap.put(obj, type);
         var10000 = type.getPointer();
      }

      return var10000;
   }

   // $FF: synthetic method
   static Pointer access$800(Object x0, Class x1) {
      return get(x0, x1);
   }

   static {
      if (Native.POINTER_SIZE == 0) {
         throw new Error("Native library not initialized");
      } else if (Structure$FFIType$FFITypes.access$900() == null) {
         throw new Error("FFI types not initialized");
      } else {
         typeInfoMap.put(Void.TYPE, Structure$FFIType$FFITypes.access$900());
         typeInfoMap.put(Void.class, Structure$FFIType$FFITypes.access$900());
         typeInfoMap.put(Float.TYPE, Structure$FFIType$FFITypes.access$1000());
         typeInfoMap.put(Float.class, Structure$FFIType$FFITypes.access$1000());
         typeInfoMap.put(Double.TYPE, Structure$FFIType$FFITypes.access$1100());
         typeInfoMap.put(Double.class, Structure$FFIType$FFITypes.access$1100());
         typeInfoMap.put(Long.TYPE, Structure$FFIType$FFITypes.access$1200());
         typeInfoMap.put(Long.class, Structure$FFIType$FFITypes.access$1200());
         typeInfoMap.put(Integer.TYPE, Structure$FFIType$FFITypes.access$1300());
         typeInfoMap.put(Integer.class, Structure$FFIType$FFITypes.access$1300());
         typeInfoMap.put(Short.TYPE, Structure$FFIType$FFITypes.access$1400());
         typeInfoMap.put(Short.class, Structure$FFIType$FFITypes.access$1400());
         Pointer ctype = Native.WCHAR_SIZE == 2 ? Structure$FFIType$FFITypes.access$1500() : Structure$FFIType$FFITypes.access$1600();
         typeInfoMap.put(Character.TYPE, ctype);
         typeInfoMap.put(Character.class, ctype);
         typeInfoMap.put(Byte.TYPE, Structure$FFIType$FFITypes.access$1700());
         typeInfoMap.put(Byte.class, Structure$FFIType$FFITypes.access$1700());
         typeInfoMap.put(Pointer.class, Structure$FFIType$FFITypes.access$1800());
         typeInfoMap.put(String.class, Structure$FFIType$FFITypes.access$1800());
         typeInfoMap.put(WString.class, Structure$FFIType$FFITypes.access$1800());
         typeInfoMap.put(Boolean.TYPE, Structure$FFIType$FFITypes.access$1600());
         typeInfoMap.put(Boolean.class, Structure$FFIType$FFITypes.access$1600());
      }
   }
}
