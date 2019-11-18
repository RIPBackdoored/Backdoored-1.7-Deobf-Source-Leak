package org.reflections.serializers;

import com.google.common.collect.Multimap;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;

class JsonSerializer$2 implements com.google.gson.JsonSerializer {
   // $FF: synthetic field
   final JsonSerializer this$0;

   JsonSerializer$2(JsonSerializer this$0) {
      this.this$0 = this$0;
   }

   public JsonElement serialize(Multimap multimap, Type type, JsonSerializationContext jsonSerializationContext) {
      return jsonSerializationContext.serialize(multimap.asMap());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
      return this.serialize((Multimap)var1, var2, var3);
   }
}
