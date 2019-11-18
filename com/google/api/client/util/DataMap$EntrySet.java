package com.google.api.client.util;

import java.util.AbstractSet;
import java.util.Iterator;

final class DataMap$EntrySet extends AbstractSet {
   // $FF: synthetic field
   final DataMap this$0;

   DataMap$EntrySet(DataMap this$0) {
      this.this$0 = this$0;
   }

   public DataMap$EntryIterator iterator() {
      return new DataMap$EntryIterator(this.this$0);
   }

   public int size() {
      int result = 0;
      Iterator var2 = this.this$0.classInfo.names.iterator();

      while(var2.hasNext()) {
         String name = (String)var2.next();
         if (this.this$0.classInfo.getFieldInfo(name).getValue(this.this$0.object) != null) {
            ++result;
         }
      }

      return result;
   }

   public void clear() {
      Iterator var1 = this.this$0.classInfo.names.iterator();

      while(var1.hasNext()) {
         String name = (String)var1.next();
         this.this$0.classInfo.getFieldInfo(name).setValue(this.this$0.object, (Object)null);
      }

   }

   public boolean isEmpty() {
      Iterator var1 = this.this$0.classInfo.names.iterator();

      String name;
      do {
         if (!var1.hasNext()) {
            return true;
         }

         name = (String)var1.next();
      } while(this.this$0.classInfo.getFieldInfo(name).getValue(this.this$0.object) == null);

      return false;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Iterator iterator() {
      return this.iterator();
   }
}
