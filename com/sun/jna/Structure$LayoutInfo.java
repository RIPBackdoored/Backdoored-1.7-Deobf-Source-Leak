package com.sun.jna;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

class Structure$LayoutInfo {
   private int size;
   private int alignment;
   private final Map fields;
   private int alignType;
   private TypeMapper typeMapper;
   private boolean variable;
   private Structure$StructField typeInfoField;

   private Structure$LayoutInfo() {
      this.size = -1;
      this.alignment = 1;
      this.fields = Collections.synchronizedMap(new LinkedHashMap());
      this.alignType = 0;
   }

   // $FF: synthetic method
   static boolean access$000(Structure$LayoutInfo x0) {
      return x0.variable;
   }

   // $FF: synthetic method
   static int access$100(Structure$LayoutInfo x0) {
      return x0.size;
   }

   // $FF: synthetic method
   static int access$200(Structure$LayoutInfo x0) {
      return x0.alignType;
   }

   // $FF: synthetic method
   static TypeMapper access$300(Structure$LayoutInfo x0) {
      return x0.typeMapper;
   }

   // $FF: synthetic method
   static int access$400(Structure$LayoutInfo x0) {
      return x0.alignment;
   }

   // $FF: synthetic method
   static Map access$500(Structure$LayoutInfo x0) {
      return x0.fields;
   }

   // $FF: synthetic method
   Structure$LayoutInfo(Structure$1 x0) {
      this();
   }

   // $FF: synthetic method
   static int access$202(Structure$LayoutInfo x0, int x1) {
      return x0.alignType = x1;
   }

   // $FF: synthetic method
   static TypeMapper access$302(Structure$LayoutInfo x0, TypeMapper x1) {
      return x0.typeMapper = x1;
   }

   // $FF: synthetic method
   static boolean access$002(Structure$LayoutInfo x0, boolean x1) {
      return x0.variable = x1;
   }

   // $FF: synthetic method
   static int access$402(Structure$LayoutInfo x0, int x1) {
      return x0.alignment = x1;
   }

   // $FF: synthetic method
   static Structure$StructField access$700(Structure$LayoutInfo x0) {
      return x0.typeInfoField;
   }

   // $FF: synthetic method
   static Structure$StructField access$702(Structure$LayoutInfo x0, Structure$StructField x1) {
      return x0.typeInfoField = x1;
   }

   // $FF: synthetic method
   static int access$102(Structure$LayoutInfo x0, int x1) {
      return x0.size = x1;
   }
}
