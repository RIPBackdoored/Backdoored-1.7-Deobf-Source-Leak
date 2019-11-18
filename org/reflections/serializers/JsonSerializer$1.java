package org.reflections.serializers;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class JsonSerializer$1 implements JsonDeserializer {
   // $FF: synthetic field
   final JsonSerializer this$0;

   JsonSerializer$1(JsonSerializer this$0) {
      this.this$0 = this$0;
   }

   public Multimap deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
      SetMultimap map = Multimaps.newSetMultimap(new HashMap(), new JsonSerializer$1$1(this));
      Iterator var5 = ((JsonObject)jsonElement).entrySet().iterator();

      while(var5.hasNext()) {
         Entry entry = (Entry)var5.next();
         Iterator var7 = ((JsonArray)entry.getValue()).iterator();

         while(var7.hasNext()) {
            JsonElement element = (JsonElement)var7.next();
            map.get(entry.getKey()).add(element.getAsString());
         }
      }

      return map;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      return this.deserialize(var1, var2, var3);
   }
}
