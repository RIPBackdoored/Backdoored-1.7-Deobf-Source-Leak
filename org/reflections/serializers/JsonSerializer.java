package org.reflections.serializers;

import com.google.common.collect.Multimap;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.reflections.Reflections;
import org.reflections.util.Utils;

public class JsonSerializer implements Serializer {
   private Gson gson;

   public Reflections read(InputStream inputStream) {
      return (Reflections)this.getGson().fromJson(new InputStreamReader(inputStream), Reflections.class);
   }

   public File save(Reflections reflections, String filename) {
      File var10000;
      try {
         File file = Utils.prepareFile(filename);
         Files.write(this.toString(reflections), file, Charset.defaultCharset());
         var10000 = file;
      } catch (IOException var4) {
         throw new RuntimeException(var4);
      }

      return var10000;
   }

   public String toString(Reflections reflections) {
      return this.getGson().toJson(reflections);
   }

   private Gson getGson() {
      if (this.gson == null) {
         this.gson = (new GsonBuilder()).registerTypeAdapter(Multimap.class, new JsonSerializer$2(this)).registerTypeAdapter(Multimap.class, new JsonSerializer$1(this)).setPrettyPrinting().create();
      }

      return this.gson;
   }
}
