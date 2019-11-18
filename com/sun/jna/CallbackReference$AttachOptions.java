package com.sun.jna;

import java.util.List;

class CallbackReference$AttachOptions extends Structure {
   public static final List FIELDS = createFieldsOrder(new String[]{"daemon", "detach", "name"});
   public boolean daemon;
   public boolean detach;
   public String name;

   CallbackReference$AttachOptions() {
      this.setStringEncoding("utf8");
   }

   protected List getFieldOrder() {
      return FIELDS;
   }
}
