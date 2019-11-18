package com.sun.jna;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class Structure {
   public static final int ALIGN_DEFAULT = 0;
   public static final int ALIGN_NONE = 1;
   public static final int ALIGN_GNUC = 2;
   public static final int ALIGN_MSVC = 3;
   protected static final int CALCULATE_SIZE = -1;
   static final Map layoutInfo = new WeakHashMap();
   static final Map fieldOrder = new WeakHashMap();
   private Pointer memory;
   private int size;
   private int alignType;
   private String encoding;
   private int actualAlignType;
   private int structAlignment;
   private Map structFields;
   private final Map nativeStrings;
   private TypeMapper typeMapper;
   private long typeInfo;
   private boolean autoRead;
   private boolean autoWrite;
   private Structure[] array;
   private boolean readCalled;
   private static final ThreadLocal reads = new Structure$1();
   private static final ThreadLocal busy = new Structure$2();
   private static final Pointer PLACEHOLDER_MEMORY = new Structure$3(0L);

   protected Structure() {
      this(0);
   }

   protected Structure(TypeMapper mapper) {
      this((Pointer)null, 0, mapper);
   }

   protected Structure(int alignType) {
      this((Pointer)null, alignType);
   }

   protected Structure(int alignType, TypeMapper mapper) {
      this((Pointer)null, alignType, mapper);
   }

   protected Structure(Pointer p) {
      this(p, 0);
   }

   protected Structure(Pointer p, int alignType) {
      this(p, alignType, (TypeMapper)null);
   }

   protected Structure(Pointer p, int alignType, TypeMapper mapper) {
      this.size = -1;
      this.nativeStrings = new HashMap();
      this.autoRead = true;
      this.autoWrite = true;
      this.setAlignType(alignType);
      this.setStringEncoding(Native.getStringEncoding(this.getClass()));
      this.initializeTypeMapper(mapper);
      this.validateFields();
      if (p != null) {
         this.useMemory(p, 0, true);
      } else {
         this.allocateMemory(-1);
      }

      this.initializeFields();
   }

   Map fields() {
      return this.structFields;
   }

   TypeMapper getTypeMapper() {
      return this.typeMapper;
   }

   private void initializeTypeMapper(TypeMapper mapper) {
      if (mapper == null) {
         mapper = Native.getTypeMapper(this.getClass());
      }

      this.typeMapper = mapper;
      this.layoutChanged();
   }

   private void layoutChanged() {
      if (this.size != -1) {
         this.size = -1;
         if (this.memory instanceof Structure$AutoAllocated) {
            this.memory = null;
         }

         this.ensureAllocated();
      }

   }

   protected void setStringEncoding(String encoding) {
      this.encoding = encoding;
   }

   protected String getStringEncoding() {
      return this.encoding;
   }

   protected void setAlignType(int alignType) {
      this.alignType = alignType;
      if (alignType == 0) {
         alignType = Native.getStructureAlignment(this.getClass());
         if (alignType == 0) {
            if (Platform.isWindows()) {
               alignType = 3;
            } else {
               alignType = 2;
            }
         }
      }

      this.actualAlignType = alignType;
      this.layoutChanged();
   }

   protected Memory autoAllocate(int size) {
      return new Structure$AutoAllocated(size);
   }

   protected void useMemory(Pointer m) {
      this.useMemory(m, 0);
   }

   protected void useMemory(Pointer m, int offset) {
      this.useMemory(m, offset, false);
   }

   void useMemory(Pointer m, int offset, boolean force) {
      try {
         this.nativeStrings.clear();
         if (this instanceof Structure$ByValue && !force) {
            byte[] buf = new byte[this.size()];
            m.read(0L, (byte[])buf, 0, buf.length);
            this.memory.write(0L, (byte[])buf, 0, buf.length);
         } else {
            this.memory = m.share((long)offset);
            if (this.size == -1) {
               this.size = this.calculateSize(false);
            }

            if (this.size != -1) {
               this.memory = m.share((long)offset, (long)this.size);
            }
         }

         this.array = null;
         this.readCalled = false;
      } catch (IndexOutOfBoundsException var5) {
         throw new IllegalArgumentException("Structure exceeds provided memory bounds", var5);
      }

   }

   protected void ensureAllocated() {
      this.ensureAllocated(false);
   }

   private void ensureAllocated(boolean avoidFFIType) {
      if (this.memory == null) {
         this.allocateMemory(avoidFFIType);
      } else if (this.size == -1) {
         this.size = this.calculateSize(true, avoidFFIType);
         if (!(this.memory instanceof Structure$AutoAllocated)) {
            try {
               this.memory = this.memory.share(0L, (long)this.size);
            } catch (IndexOutOfBoundsException var3) {
               throw new IllegalArgumentException("Structure exceeds provided memory bounds", var3);
            }
         }
      }

   }

   protected void allocateMemory() {
      this.allocateMemory(false);
   }

   private void allocateMemory(boolean avoidFFIType) {
      this.allocateMemory(this.calculateSize(true, avoidFFIType));
   }

   protected void allocateMemory(int size) {
      if (size == -1) {
         size = this.calculateSize(false);
      } else if (size <= 0) {
         throw new IllegalArgumentException("Structure size must be greater than zero: " + size);
      }

      if (size != -1) {
         if (this.memory == null || this.memory instanceof Structure$AutoAllocated) {
            this.memory = this.autoAllocate(size);
         }

         this.size = size;
      }

   }

   public int size() {
      this.ensureAllocated();
      return this.size;
   }

   public void clear() {
      this.ensureAllocated();
      this.memory.clear((long)this.size());
   }

   public Pointer getPointer() {
      this.ensureAllocated();
      return this.memory;
   }

   static Set busy() {
      return (Set)busy.get();
   }

   static Map reading() {
      return (Map)reads.get();
   }

   void conditionalAutoRead() {
      if (!this.readCalled) {
         this.autoRead();
      }

   }

   public void read() {
      if (this.memory != PLACEHOLDER_MEMORY) {
         this.readCalled = true;
         this.ensureAllocated();
         if (!busy().contains(this)) {
            busy().add(this);
            if (this instanceof Structure$ByReference) {
               reading().put(this.getPointer(), this);
            }

            try {
               Iterator var1 = this.fields().values().iterator();

               while(var1.hasNext()) {
                  Structure$StructField structField = (Structure$StructField)var1.next();
                  this.readField(structField);
               }
            } finally {
               busy().remove(this);
               if (reading().get(this.getPointer()) == this) {
                  reading().remove(this.getPointer());
               }

            }

         }
      }
   }

   protected int fieldOffset(String name) {
      this.ensureAllocated();
      Structure$StructField f = (Structure$StructField)this.fields().get(name);
      if (f == null) {
         throw new IllegalArgumentException("No such field: " + name);
      } else {
         return f.offset;
      }
   }

   public Object readField(String name) {
      this.ensureAllocated();
      Structure$StructField f = (Structure$StructField)this.fields().get(name);
      if (f == null) {
         throw new IllegalArgumentException("No such field: " + name);
      } else {
         return this.readField(f);
      }
   }

   Object getFieldValue(Field field) {
      Object var10000;
      try {
         var10000 = field.get(this);
      } catch (Exception var3) {
         throw new Error("Exception reading field '" + field.getName() + "' in " + this.getClass(), var3);
      }

      return var10000;
   }

   void setFieldValue(Field field, Object value) {
      this.setFieldValue(field, value, false);
   }

   private void setFieldValue(Field field, Object value, boolean overrideFinal) {
      try {
         field.set(this, value);
      } catch (IllegalAccessException var6) {
         int modifiers = field.getModifiers();
         if (Modifier.isFinal(modifiers)) {
            if (overrideFinal) {
               throw new UnsupportedOperationException("This VM does not support Structures with final fields (field '" + field.getName() + "' within " + this.getClass() + ")", var6);
            }

            throw new UnsupportedOperationException("Attempt to write to read-only field '" + field.getName() + "' within " + this.getClass(), var6);
         }

         throw new Error("Unexpectedly unable to write to field '" + field.getName() + "' within " + this.getClass(), var6);
      }

   }

   static Structure updateStructureByReference(Class type, Structure s, Pointer address) {
      if (address == null) {
         s = null;
      } else if (s != null && address.equals(s.getPointer())) {
         s.autoRead();
      } else {
         Structure s1 = (Structure)reading().get(address);
         if (s1 != null && type.equals(s1.getClass())) {
            s = s1;
            s1.autoRead();
         } else {
            s = newInstance(type, address);
            s.conditionalAutoRead();
         }
      }

      return s;
   }

   protected Object readField(Structure$StructField structField) {
      int offset = structField.offset;
      Class fieldType = structField.type;
      FromNativeConverter readConverter = structField.readConverter;
      if (readConverter != null) {
         fieldType = readConverter.nativeType();
      }

      Object currentValue = !Structure.class.isAssignableFrom(fieldType) && !Callback.class.isAssignableFrom(fieldType) && (!Platform.HAS_BUFFERS || !Buffer.class.isAssignableFrom(fieldType)) && !Pointer.class.isAssignableFrom(fieldType) && !NativeMapped.class.isAssignableFrom(fieldType) && !fieldType.isArray() ? null : this.getFieldValue(structField.field);
      Object result;
      if (fieldType == String.class) {
         Pointer p = this.memory.getPointer((long)offset);
         result = p == null ? null : p.getString(0L, this.encoding);
      } else {
         result = this.memory.getValue((long)offset, fieldType, currentValue);
      }

      if (readConverter != null) {
         result = readConverter.fromNative(result, structField.context);
         if (currentValue != null && currentValue.equals(result)) {
            result = currentValue;
         }
      }

      if (fieldType.equals(String.class) || fieldType.equals(WString.class)) {
         this.nativeStrings.put(structField.name + ".ptr", this.memory.getPointer((long)offset));
         this.nativeStrings.put(structField.name + ".val", result);
      }

      this.setFieldValue(structField.field, result, true);
      return result;
   }

   public void write() {
      if (this.memory != PLACEHOLDER_MEMORY) {
         this.ensureAllocated();
         if (this instanceof Structure$ByValue) {
            this.getTypeInfo();
         }

         if (!busy().contains(this)) {
            busy().add(this);

            try {
               Iterator var1 = this.fields().values().iterator();

               while(var1.hasNext()) {
                  Structure$StructField sf = (Structure$StructField)var1.next();
                  if (!sf.isVolatile) {
                     this.writeField(sf);
                  }
               }
            } finally {
               busy().remove(this);
            }

         }
      }
   }

   public void writeField(String name) {
      this.ensureAllocated();
      Structure$StructField f = (Structure$StructField)this.fields().get(name);
      if (f == null) {
         throw new IllegalArgumentException("No such field: " + name);
      } else {
         this.writeField(f);
      }
   }

   public void writeField(String name, Object value) {
      this.ensureAllocated();
      Structure$StructField structField = (Structure$StructField)this.fields().get(name);
      if (structField == null) {
         throw new IllegalArgumentException("No such field: " + name);
      } else {
         this.setFieldValue(structField.field, value);
         this.writeField(structField);
      }
   }

   protected void writeField(Structure$StructField structField) {
      if (!structField.isReadOnly) {
         int offset = structField.offset;
         Object value = this.getFieldValue(structField.field);
         Class fieldType = structField.type;
         ToNativeConverter converter = structField.writeConverter;
         if (converter != null) {
            value = converter.toNative(value, new StructureWriteContext(this, structField.field));
            fieldType = converter.nativeType();
         }

         if (String.class == fieldType || WString.class == fieldType) {
            boolean wide = fieldType == WString.class;
            if (value != null) {
               if (this.nativeStrings.containsKey(structField.name + ".ptr") && value.equals(this.nativeStrings.get(structField.name + ".val"))) {
                  return;
               }

               NativeString nativeString = wide ? new NativeString(value.toString(), true) : new NativeString(value.toString(), this.encoding);
               this.nativeStrings.put(structField.name, nativeString);
               value = nativeString.getPointer();
            } else {
               this.nativeStrings.remove(structField.name);
            }

            this.nativeStrings.remove(structField.name + ".ptr");
            this.nativeStrings.remove(structField.name + ".val");
         }

         try {
            this.memory.setValue((long)offset, value, fieldType);
         } catch (IllegalArgumentException var8) {
            String msg = "Structure field \"" + structField.name + "\" was declared as " + structField.type + (structField.type == fieldType ? "" : " (native type " + fieldType + ")") + ", which is not supported within a Structure";
            throw new IllegalArgumentException(msg, var8);
         }

      }
   }

   protected abstract List getFieldOrder();

   /** @deprecated */
   @Deprecated
   protected final void setFieldOrder(String[] fields) {
      throw new Error("This method is obsolete, use getFieldOrder() instead");
   }

   protected void sortFields(List fields, List names) {
      for(int i = 0; i < names.size(); ++i) {
         String name = (String)names.get(i);

         for(int f = 0; f < fields.size(); ++f) {
            Field field = (Field)fields.get(f);
            if (name.equals(field.getName())) {
               Collections.swap(fields, i, f);
               break;
            }
         }
      }

   }

   protected List getFieldList() {
      List flist = new ArrayList();

      for(Class cls = this.getClass(); !cls.equals(Structure.class); cls = cls.getSuperclass()) {
         List classFields = new ArrayList();
         Field[] fields = cls.getDeclaredFields();

         for(int i = 0; i < fields.length; ++i) {
            int modifiers = fields[i].getModifiers();
            if (!Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers)) {
               classFields.add(fields[i]);
            }
         }

         flist.addAll(0, classFields);
      }

      return flist;
   }

   private List fieldOrder() {
      Class clazz = this.getClass();
      List var10000;
      synchronized(fieldOrder) {
         List list = (List)fieldOrder.get(clazz);
         if (list == null) {
            list = this.getFieldOrder();
            fieldOrder.put(clazz, list);
         }

         var10000 = list;
      }

      return var10000;
   }

   public static List createFieldsOrder(List baseFields, String... extraFields) {
      return createFieldsOrder(baseFields, Arrays.asList(extraFields));
   }

   public static List createFieldsOrder(List baseFields, List extraFields) {
      List fields = new ArrayList(baseFields.size() + extraFields.size());
      fields.addAll(baseFields);
      fields.addAll(extraFields);
      return Collections.unmodifiableList(fields);
   }

   public static List createFieldsOrder(String field) {
      return Collections.unmodifiableList(Collections.singletonList(field));
   }

   public static List createFieldsOrder(String... fields) {
      return Collections.unmodifiableList(Arrays.asList(fields));
   }

   private static List sort(Collection c) {
      List list = new ArrayList(c);
      Collections.sort(list);
      return list;
   }

   protected List getFields(boolean force) {
      List flist = this.getFieldList();
      Set names = new HashSet();
      Iterator var4 = flist.iterator();

      while(var4.hasNext()) {
         Field f = (Field)var4.next();
         names.add(f.getName());
      }

      List fieldOrder = this.fieldOrder();
      if (fieldOrder.size() != flist.size() && flist.size() > 1) {
         if (force) {
            throw new Error("Structure.getFieldOrder() on " + this.getClass() + " does not provide enough names [" + fieldOrder.size() + "] (" + sort(fieldOrder) + ") to match declared fields [" + flist.size() + "] (" + sort(names) + ")");
         } else {
            return null;
         }
      } else {
         Set orderedNames = new HashSet(fieldOrder);
         if (!orderedNames.equals(names)) {
            throw new Error("Structure.getFieldOrder() on " + this.getClass() + " returns names (" + sort(fieldOrder) + ") which do not match declared field names (" + sort(names) + ")");
         } else {
            this.sortFields(flist, fieldOrder);
            return flist;
         }
      }
   }

   protected int calculateSize(boolean force) {
      return this.calculateSize(force, false);
   }

   static int size(Class type) {
      return size(type, (Structure)null);
   }

   static int size(Class type, Structure value) {
      Structure$LayoutInfo info;
      synchronized(layoutInfo) {
         info = (Structure$LayoutInfo)layoutInfo.get(type);
      }

      int sz = info != null && !Structure$LayoutInfo.access$000(info) ? Structure$LayoutInfo.access$100(info) : -1;
      if (sz == -1) {
         if (value == null) {
            value = newInstance(type, PLACEHOLDER_MEMORY);
         }

         sz = value.size();
      }

      return sz;
   }

   int calculateSize(boolean force, boolean avoidFFIType) {
      int size = -1;
      Class clazz = this.getClass();
      Structure$LayoutInfo info;
      synchronized(layoutInfo) {
         info = (Structure$LayoutInfo)layoutInfo.get(clazz);
      }

      if (info == null || this.alignType != Structure$LayoutInfo.access$200(info) || this.typeMapper != Structure$LayoutInfo.access$300(info)) {
         info = this.deriveLayout(force, avoidFFIType);
      }

      if (info != null) {
         this.structAlignment = Structure$LayoutInfo.access$400(info);
         this.structFields = Structure$LayoutInfo.access$500(info);
         if (!Structure$LayoutInfo.access$000(info)) {
            synchronized(layoutInfo) {
               if (!layoutInfo.containsKey(clazz) || this.alignType != 0 || this.typeMapper != null) {
                  layoutInfo.put(clazz, info);
               }
            }
         }

         size = Structure$LayoutInfo.access$100(info);
      }

      return size;
   }

   private void validateField(String name, Class type) {
      if (this.typeMapper != null) {
         ToNativeConverter toNative = this.typeMapper.getToNativeConverter(type);
         if (toNative != null) {
            this.validateField(name, toNative.nativeType());
            return;
         }
      }

      if (type.isArray()) {
         this.validateField(name, type.getComponentType());
      } else {
         try {
            this.getNativeSize(type);
         } catch (IllegalArgumentException var5) {
            String msg = "Invalid Structure field in " + this.getClass() + ", field name '" + name + "' (" + type + "): " + var5.getMessage();
            throw new IllegalArgumentException(msg, var5);
         }
      }

   }

   private void validateFields() {
      List fields = this.getFieldList();
      Iterator var2 = fields.iterator();

      while(var2.hasNext()) {
         Field f = (Field)var2.next();
         this.validateField(f.getName(), f.getType());
      }

   }

   private Structure$LayoutInfo deriveLayout(boolean force, boolean avoidFFIType) {
      int calculatedSize = 0;
      List fields = this.getFields(force);
      if (fields == null) {
         return null;
      } else {
         Structure$LayoutInfo info = new Structure$LayoutInfo((Structure$1)null);
         Structure$LayoutInfo.access$202(info, this.alignType);
         Structure$LayoutInfo.access$302(info, this.typeMapper);
         boolean firstField = true;

         for(Iterator i = fields.iterator(); i.hasNext(); firstField = false) {
            Field field = (Field)i.next();
            int modifiers = field.getModifiers();
            Class type = field.getType();
            if (type.isArray()) {
               Structure$LayoutInfo.access$002(info, true);
            }

            Structure$StructField structField = new Structure$StructField();
            structField.isVolatile = Modifier.isVolatile(modifiers);
            structField.isReadOnly = Modifier.isFinal(modifiers);
            if (structField.isReadOnly) {
               if (!Platform.RO_FIELDS) {
                  throw new IllegalArgumentException("This VM does not support read-only fields (field '" + field.getName() + "' within " + this.getClass() + ")");
               }

               field.setAccessible(true);
            }

            structField.field = field;
            structField.name = field.getName();
            structField.type = type;
            if (Callback.class.isAssignableFrom(type) && !type.isInterface()) {
               throw new IllegalArgumentException("Structure Callback field '" + field.getName() + "' must be an interface");
            }

            if (type.isArray() && Structure.class.equals(type.getComponentType())) {
               String msg = "Nested Structure arrays must use a derived Structure type so that the size of the elements can be determined";
               throw new IllegalArgumentException(msg);
            }

            int fieldAlignment = true;
            if (Modifier.isPublic(field.getModifiers())) {
               Object value = this.getFieldValue(structField.field);
               if (value == null && type.isArray()) {
                  if (force) {
                     throw new IllegalStateException("Array fields must be initialized");
                  }

                  return null;
               }

               Class nativeType = type;
               if (NativeMapped.class.isAssignableFrom(type)) {
                  NativeMappedConverter tc = NativeMappedConverter.getInstance(type);
                  nativeType = tc.nativeType();
                  structField.writeConverter = tc;
                  structField.readConverter = tc;
                  structField.context = new StructureReadContext(this, field);
               } else if (this.typeMapper != null) {
                  ToNativeConverter writeConverter = this.typeMapper.getToNativeConverter(type);
                  FromNativeConverter readConverter = this.typeMapper.getFromNativeConverter(type);
                  if (writeConverter != null && readConverter != null) {
                     value = writeConverter.toNative(value, new StructureWriteContext(this, structField.field));
                     nativeType = value != null ? value.getClass() : Pointer.class;
                     structField.writeConverter = writeConverter;
                     structField.readConverter = readConverter;
                     structField.context = new StructureReadContext(this, field);
                  } else if (writeConverter != null || readConverter != null) {
                     String msg = "Structures require bidirectional type conversion for " + type;
                     throw new IllegalArgumentException(msg);
                  }
               }

               if (value == null) {
                  value = this.initializeField(structField.field, type);
               }

               int fieldAlignment;
               try {
                  structField.size = this.getNativeSize(nativeType, value);
                  fieldAlignment = this.getNativeAlignment(nativeType, value, firstField);
               } catch (IllegalArgumentException var18) {
                  if (!force && this.typeMapper == null) {
                     return null;
                  }

                  String msg = "Invalid Structure field in " + this.getClass() + ", field name '" + structField.name + "' (" + structField.type + "): " + var18.getMessage();
                  throw new IllegalArgumentException(msg, var18);
               }

               if (fieldAlignment == 0) {
                  throw new Error("Field alignment is zero for field '" + structField.name + "' within " + this.getClass());
               }

               Structure$LayoutInfo.access$402(info, Math.max(Structure$LayoutInfo.access$400(info), fieldAlignment));
               if (calculatedSize % fieldAlignment != 0) {
                  calculatedSize += fieldAlignment - calculatedSize % fieldAlignment;
               }

               if (this instanceof Union) {
                  structField.offset = 0;
                  calculatedSize = Math.max(calculatedSize, structField.size);
               } else {
                  structField.offset = calculatedSize;
                  calculatedSize += structField.size;
               }

               Structure$LayoutInfo.access$500(info).put(structField.name, structField);
               if (Structure$LayoutInfo.access$700(info) == null || Structure$LayoutInfo.access$700(info).size < structField.size || Structure$LayoutInfo.access$700(info).size == structField.size && Structure.class.isAssignableFrom(structField.type)) {
                  Structure$LayoutInfo.access$702(info, structField);
               }
            }
         }

         if (calculatedSize > 0) {
            int size = this.addPadding(calculatedSize, Structure$LayoutInfo.access$400(info));
            if (this instanceof Structure$ByValue && !avoidFFIType) {
               this.getTypeInfo();
            }

            Structure$LayoutInfo.access$102(info, size);
            return info;
         } else {
            throw new IllegalArgumentException("Structure " + this.getClass() + " has unknown or zero size (ensure all fields are public)");
         }
      }
   }

   private void initializeFields() {
      List flist = this.getFieldList();
      Iterator var2 = flist.iterator();

      while(var2.hasNext()) {
         Field f = (Field)var2.next();

         try {
            Object o = f.get(this);
            if (o == null) {
               this.initializeField(f, f.getType());
            }
         } catch (Exception var5) {
            throw new Error("Exception reading field '" + f.getName() + "' in " + this.getClass(), var5);
         }
      }

   }

   private Object initializeField(Field field, Class type) {
      Object value = null;
      if (Structure.class.isAssignableFrom(type) && !Structure$ByReference.class.isAssignableFrom(type)) {
         try {
            value = newInstance(type, PLACEHOLDER_MEMORY);
            this.setFieldValue(field, value);
         } catch (IllegalArgumentException var6) {
            String msg = "Can't determine size of nested structure";
            throw new IllegalArgumentException(msg, var6);
         }
      } else if (NativeMapped.class.isAssignableFrom(type)) {
         NativeMappedConverter tc = NativeMappedConverter.getInstance(type);
         value = tc.defaultValue();
         this.setFieldValue(field, value);
      }

      return value;
   }

   private int addPadding(int calculatedSize) {
      return this.addPadding(calculatedSize, this.structAlignment);
   }

   private int addPadding(int calculatedSize, int alignment) {
      if (this.actualAlignType != 1 && calculatedSize % alignment != 0) {
         calculatedSize += alignment - calculatedSize % alignment;
      }

      return calculatedSize;
   }

   protected int getStructAlignment() {
      if (this.size == -1) {
         this.calculateSize(true);
      }

      return this.structAlignment;
   }

   protected int getNativeAlignment(Class type, Object value, boolean isFirstElement) {
      int alignment = true;
      if (NativeMapped.class.isAssignableFrom(type)) {
         NativeMappedConverter tc = NativeMappedConverter.getInstance(type);
         type = tc.nativeType();
         value = tc.toNative(value, new ToNativeContext());
      }

      int size = Native.getNativeSize(type, value);
      int alignment;
      if (!type.isPrimitive() && Long.class != type && Integer.class != type && Short.class != type && Character.class != type && Byte.class != type && Boolean.class != type && Float.class != type && Double.class != type) {
         if ((!Pointer.class.isAssignableFrom(type) || Function.class.isAssignableFrom(type)) && (!Platform.HAS_BUFFERS || !Buffer.class.isAssignableFrom(type)) && !Callback.class.isAssignableFrom(type) && WString.class != type && String.class != type) {
            if (Structure.class.isAssignableFrom(type)) {
               if (Structure$ByReference.class.isAssignableFrom(type)) {
                  alignment = Pointer.SIZE;
               } else {
                  if (value == null) {
                     value = newInstance(type, PLACEHOLDER_MEMORY);
                  }

                  alignment = ((Structure)value).getStructAlignment();
               }
            } else {
               if (!type.isArray()) {
                  throw new IllegalArgumentException("Type " + type + " has unknown native alignment");
               }

               alignment = this.getNativeAlignment(type.getComponentType(), (Object)null, isFirstElement);
            }
         } else {
            alignment = Pointer.SIZE;
         }
      } else {
         alignment = size;
      }

      if (this.actualAlignType == 1) {
         alignment = 1;
      } else if (this.actualAlignType == 3) {
         alignment = Math.min(8, alignment);
      } else if (this.actualAlignType == 2) {
         if (!isFirstElement || !Platform.isMac() || !Platform.isPPC()) {
            alignment = Math.min(Native.MAX_ALIGNMENT, alignment);
         }

         if (!isFirstElement && Platform.isAIX() && (type == Double.TYPE || type == Double.class)) {
            alignment = 4;
         }
      }

      return alignment;
   }

   public String toString() {
      return this.toString(Boolean.getBoolean("jna.dump_memory"));
   }

   public String toString(boolean debug) {
      return this.toString(0, true, debug);
   }

   private String format(Class type) {
      String s = type.getName();
      int dot = s.lastIndexOf(".");
      return s.substring(dot + 1);
   }

   private String toString(int indent, boolean showContents, boolean dumpMemory) {
      this.ensureAllocated();
      String LS = System.getProperty("line.separator");
      String name = this.format(this.getClass()) + "(" + this.getPointer() + ")";
      if (!(this.getPointer() instanceof Memory)) {
         name = name + " (" + this.size() + " bytes)";
      }

      String prefix = "";

      for(int idx = 0; idx < indent; ++idx) {
         prefix = prefix + "  ";
      }

      String contents = LS;
      if (!showContents) {
         contents = "...}";
      } else {
         Iterator i = this.fields().values().iterator();

         while(i.hasNext()) {
            Structure$StructField sf = (Structure$StructField)i.next();
            Object value = this.getFieldValue(sf.field);
            String type = this.format(sf.type);
            String index = "";
            contents = contents + prefix;
            if (sf.type.isArray() && value != null) {
               type = this.format(sf.type.getComponentType());
               index = "[" + Array.getLength(value) + "]";
            }

            contents = contents + "  " + type + " " + sf.name + index + "@" + Integer.toHexString(sf.offset);
            if (value instanceof Structure) {
               value = ((Structure)value).toString(indent + 1, !(value instanceof Structure$ByReference), dumpMemory);
            }

            contents = contents + "=";
            if (value instanceof Long) {
               contents = contents + Long.toHexString((Long)value);
            } else if (value instanceof Integer) {
               contents = contents + Integer.toHexString((Integer)value);
            } else if (value instanceof Short) {
               contents = contents + Integer.toHexString((Short)value);
            } else if (value instanceof Byte) {
               contents = contents + Integer.toHexString((Byte)value);
            } else {
               contents = contents + String.valueOf(value).trim();
            }

            contents = contents + LS;
            if (!i.hasNext()) {
               contents = contents + prefix + "}";
            }
         }
      }

      if (indent == 0 && dumpMemory) {
         int BYTES_PER_ROW = true;
         contents = contents + LS + "memory dump" + LS;
         byte[] buf = this.getPointer().getByteArray(0L, this.size());

         for(int i = 0; i < buf.length; ++i) {
            if (i % 4 == 0) {
               contents = contents + "[";
            }

            if (buf[i] >= 0 && buf[i] < 16) {
               contents = contents + "0";
            }

            contents = contents + Integer.toHexString(buf[i] & 255);
            if (i % 4 == 3 && i < buf.length - 1) {
               contents = contents + "]" + LS;
            }
         }

         contents = contents + "]";
      }

      return name + " {" + contents;
   }

   public Structure[] toArray(Structure[] array) {
      this.ensureAllocated();
      int i;
      if (this.memory instanceof Structure$AutoAllocated) {
         Memory m = (Memory)this.memory;
         i = array.length * this.size();
         if (m.size() < (long)i) {
            this.useMemory(this.autoAllocate(i));
         }
      }

      array[0] = this;
      int size = this.size();

      for(i = 1; i < array.length; ++i) {
         array[i] = newInstance(this.getClass(), this.memory.share((long)(i * size), (long)size));
         array[i].conditionalAutoRead();
      }

      if (!(this instanceof Structure$ByValue)) {
         this.array = array;
      }

      return array;
   }

   public Structure[] toArray(int size) {
      return this.toArray((Structure[])((Structure[])Array.newInstance(this.getClass(), size)));
   }

   private Class baseClass() {
      return (this instanceof Structure$ByReference || this instanceof Structure$ByValue) && Structure.class.isAssignableFrom(this.getClass().getSuperclass()) ? this.getClass().getSuperclass() : this.getClass();
   }

   public boolean dataEquals(Structure s) {
      return this.dataEquals(s, false);
   }

   public boolean dataEquals(Structure s, boolean clear) {
      if (clear) {
         s.getPointer().clear((long)s.size());
         s.write();
         this.getPointer().clear((long)this.size());
         this.write();
      }

      byte[] data = s.getPointer().getByteArray(0L, s.size());
      byte[] ref = this.getPointer().getByteArray(0L, this.size());
      if (data.length == ref.length) {
         for(int i = 0; i < data.length; ++i) {
            if (data[i] != ref[i]) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean equals(Object o) {
      return o instanceof Structure && o.getClass() == this.getClass() && ((Structure)o).getPointer().equals(this.getPointer());
   }

   public int hashCode() {
      Pointer p = this.getPointer();
      return p != null ? this.getPointer().hashCode() : this.getClass().hashCode();
   }

   protected void cacheTypeInfo(Pointer p) {
      this.typeInfo = p.peer;
   }

   Pointer getFieldTypeInfo(Structure$StructField f) {
      Class type = f.type;
      Object value = this.getFieldValue(f.field);
      if (this.typeMapper != null) {
         ToNativeConverter nc = this.typeMapper.getToNativeConverter(type);
         if (nc != null) {
            type = nc.nativeType();
            value = nc.toNative(value, new ToNativeContext());
         }
      }

      return Structure$FFIType.access$800(value, type);
   }

   Pointer getTypeInfo() {
      Pointer p = getTypeInfo(this);
      this.cacheTypeInfo(p);
      return p;
   }

   public void setAutoSynch(boolean auto) {
      this.setAutoRead(auto);
      this.setAutoWrite(auto);
   }

   public void setAutoRead(boolean auto) {
      this.autoRead = auto;
   }

   public boolean getAutoRead() {
      return this.autoRead;
   }

   public void setAutoWrite(boolean auto) {
      this.autoWrite = auto;
   }

   public boolean getAutoWrite() {
      return this.autoWrite;
   }

   static Pointer getTypeInfo(Object obj) {
      return Structure$FFIType.get(obj);
   }

   private static Structure newInstance(Class type, long init) {
      Structure var10000;
      try {
         Structure s = newInstance(type, init == 0L ? PLACEHOLDER_MEMORY : new Pointer(init));
         if (init != 0L) {
            s.conditionalAutoRead();
         }

         var10000 = s;
      } catch (Throwable var4) {
         System.err.println("JNA: Error creating structure: " + var4);
         return null;
      }

      return var10000;
   }

   public static Structure newInstance(Class type, Pointer init) throws IllegalArgumentException {
      String msg;
      try {
         Constructor ctor = type.getConstructor(Pointer.class);
         Structure var10000 = (Structure)ctor.newInstance(init);
         return var10000;
      } catch (NoSuchMethodException var4) {
      } catch (SecurityException var5) {
      } catch (InstantiationException var6) {
         msg = "Can't instantiate " + type;
         throw new IllegalArgumentException(msg, var6);
      } catch (IllegalAccessException var7) {
         msg = "Instantiation of " + type + " (Pointer) not allowed, is it public?";
         throw new IllegalArgumentException(msg, var7);
      } catch (InvocationTargetException var8) {
         msg = "Exception thrown while instantiating an instance of " + type;
         var8.printStackTrace();
         throw new IllegalArgumentException(msg, var8);
      }

      Structure s = newInstance(type);
      if (init != PLACEHOLDER_MEMORY) {
         s.useMemory(init);
      }

      return s;
   }

   public static Structure newInstance(Class type) throws IllegalArgumentException {
      Structure var10000;
      String msg;
      try {
         Structure s = (Structure)type.newInstance();
         if (s instanceof Structure$ByValue) {
            s.allocateMemory();
         }

         var10000 = s;
      } catch (InstantiationException var3) {
         msg = "Can't instantiate " + type;
         throw new IllegalArgumentException(msg, var3);
      } catch (IllegalAccessException var4) {
         msg = "Instantiation of " + type + " not allowed, is it public?";
         throw new IllegalArgumentException(msg, var4);
      }

      return var10000;
   }

   Structure$StructField typeInfoField() {
      Structure$LayoutInfo info;
      synchronized(layoutInfo) {
         info = (Structure$LayoutInfo)layoutInfo.get(this.getClass());
      }

      return info != null ? Structure$LayoutInfo.access$700(info) : null;
   }

   private static void structureArrayCheck(Structure[] ss) {
      if (!Structure$ByReference[].class.isAssignableFrom(ss.getClass())) {
         Pointer base = ss[0].getPointer();
         int size = ss[0].size();

         for(int si = 1; si < ss.length; ++si) {
            if (ss[si].getPointer().peer != base.peer + (long)(size * si)) {
               String msg = "Structure array elements must use contiguous memory (bad backing address at Structure array index " + si + ")";
               throw new IllegalArgumentException(msg);
            }
         }

      }
   }

   public static void autoRead(Structure[] ss) {
      structureArrayCheck(ss);
      if (ss[0].array == ss) {
         ss[0].autoRead();
      } else {
         for(int si = 0; si < ss.length; ++si) {
            if (ss[si] != null) {
               ss[si].autoRead();
            }
         }
      }

   }

   public void autoRead() {
      if (this.getAutoRead()) {
         this.read();
         if (this.array != null) {
            for(int i = 1; i < this.array.length; ++i) {
               this.array[i].autoRead();
            }
         }
      }

   }

   public static void autoWrite(Structure[] ss) {
      structureArrayCheck(ss);
      if (ss[0].array == ss) {
         ss[0].autoWrite();
      } else {
         for(int si = 0; si < ss.length; ++si) {
            if (ss[si] != null) {
               ss[si].autoWrite();
            }
         }
      }

   }

   public void autoWrite() {
      if (this.getAutoWrite()) {
         this.write();
         if (this.array != null) {
            for(int i = 1; i < this.array.length; ++i) {
               this.array[i].autoWrite();
            }
         }
      }

   }

   protected int getNativeSize(Class nativeType) {
      return this.getNativeSize(nativeType, (Object)null);
   }

   protected int getNativeSize(Class nativeType, Object value) {
      return Native.getNativeSize(nativeType, value);
   }

   static void validate(Class cls) {
      newInstance(cls, PLACEHOLDER_MEMORY);
   }

   // $FF: synthetic method
   static void access$1900(Structure x0, boolean x1) {
      x0.ensureAllocated(x1);
   }

   // $FF: synthetic method
   static Pointer access$2000() {
      return PLACEHOLDER_MEMORY;
   }
}
