package org.spongepowered.asm.launch;

import java.util.ServiceLoader;
import org.spongepowered.asm.service.IGlobalPropertyService;

public final class GlobalProperties {
   private static IGlobalPropertyService service;

   private GlobalProperties() {
   }

   private static IGlobalPropertyService getService() {
      if (service == null) {
         ServiceLoader serviceLoader = ServiceLoader.load(IGlobalPropertyService.class, GlobalProperties.class.getClassLoader());
         service = (IGlobalPropertyService)serviceLoader.iterator().next();
      }

      return service;
   }

   public static Object get(String key) {
      return getService().getProperty(key);
   }

   public static void put(String key, Object value) {
      getService().setProperty(key, value);
   }

   public static Object get(String key, Object defaultValue) {
      return getService().getProperty(key, defaultValue);
   }

   public static String getString(String key, String defaultValue) {
      return getService().getPropertyString(key, defaultValue);
   }
}
