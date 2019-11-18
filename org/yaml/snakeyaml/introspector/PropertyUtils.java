package org.yaml.snakeyaml.introspector;

import java.beans.FeatureDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.util.PlatformFeatureDetector;

public class PropertyUtils {
   private static final Logger log = Logger.getLogger(PropertyUtils.class.getPackage().getName());
   private final Map propertiesCache;
   private final Map readableProperties;
   private BeanAccess beanAccess;
   private boolean allowReadOnlyProperties;
   private boolean skipMissingProperties;
   private PlatformFeatureDetector platformFeatureDetector;
   private boolean transientMethodChecked;
   private Method isTransientMethod;

   public PropertyUtils() {
      this(new PlatformFeatureDetector());
   }

   PropertyUtils(PlatformFeatureDetector platformFeatureDetector) {
      this.propertiesCache = new HashMap();
      this.readableProperties = new HashMap();
      this.beanAccess = BeanAccess.DEFAULT;
      this.allowReadOnlyProperties = false;
      this.skipMissingProperties = false;
      this.platformFeatureDetector = platformFeatureDetector;
      if (platformFeatureDetector.isRunningOnAndroid()) {
         this.beanAccess = BeanAccess.FIELD;
      }

   }

   protected Map getPropertiesMap(Class type, BeanAccess bAccess) {
      // $FF: Couldn't be decompiled
   }

   private boolean isTransient(FeatureDescriptor fd) {
      if (!this.transientMethodChecked) {
         this.transientMethodChecked = true;

         try {
            this.isTransientMethod = FeatureDescriptor.class.getDeclaredMethod("isTransient");
            this.isTransientMethod.setAccessible(true);
         } catch (NoSuchMethodException var3) {
            log.fine("NoSuchMethod: FeatureDescriptor.isTransient(). Don't check it anymore.");
         } catch (SecurityException var4) {
            var4.printStackTrace();
            this.isTransientMethod = null;
         }
      }

      if (this.isTransientMethod != null) {
         label30: {
            boolean var10000;
            try {
               var10000 = Boolean.TRUE.equals(this.isTransientMethod.invoke(fd));
            } catch (IllegalAccessException var5) {
               var5.printStackTrace();
               break label30;
            } catch (IllegalArgumentException var6) {
               var6.printStackTrace();
               break label30;
            } catch (InvocationTargetException var7) {
               var7.printStackTrace();
               break label30;
            }

            return var10000;
         }

         this.isTransientMethod = null;
      }

      return false;
   }

   public Set getProperties(Class type) {
      return this.getProperties(type, this.beanAccess);
   }

   public Set getProperties(Class type, BeanAccess bAccess) {
      if (this.readableProperties.containsKey(type)) {
         return (Set)this.readableProperties.get(type);
      } else {
         Set properties = this.createPropertySet(type, bAccess);
         this.readableProperties.put(type, properties);
         return properties;
      }
   }

   protected Set createPropertySet(Class type, BeanAccess bAccess) {
      Set properties = new TreeSet();
      Collection props = this.getPropertiesMap(type, bAccess).values();
      Iterator var5 = props.iterator();

      while(true) {
         Property property;
         do {
            do {
               if (!var5.hasNext()) {
                  return properties;
               }

               property = (Property)var5.next();
            } while(!property.isReadable());
         } while(!this.allowReadOnlyProperties && !property.isWritable());

         properties.add(property);
      }
   }

   public Property getProperty(Class type, String name) {
      return this.getProperty(type, name, this.beanAccess);
   }

   public Property getProperty(Class type, String name, BeanAccess bAccess) {
      Map properties = this.getPropertiesMap(type, bAccess);
      Property property = (Property)properties.get(name);
      if (property == null && this.skipMissingProperties) {
         property = new MissingProperty(name);
      }

      if (property == null) {
         throw new YAMLException("Unable to find property '" + name + "' on class: " + type.getName());
      } else {
         return (Property)property;
      }
   }

   public void setBeanAccess(BeanAccess beanAccess) {
      if (this.platformFeatureDetector.isRunningOnAndroid() && beanAccess != BeanAccess.FIELD) {
         throw new IllegalArgumentException("JVM is Android - only BeanAccess.FIELD is available");
      } else {
         if (this.beanAccess != beanAccess) {
            this.beanAccess = beanAccess;
            this.propertiesCache.clear();
            this.readableProperties.clear();
         }

      }
   }

   public void setAllowReadOnlyProperties(boolean allowReadOnlyProperties) {
      if (this.allowReadOnlyProperties != allowReadOnlyProperties) {
         this.allowReadOnlyProperties = allowReadOnlyProperties;
         this.readableProperties.clear();
      }

   }

   public boolean isAllowReadOnlyProperties() {
      return this.allowReadOnlyProperties;
   }

   public void setSkipMissingProperties(boolean skipMissingProperties) {
      if (this.skipMissingProperties != skipMissingProperties) {
         this.skipMissingProperties = skipMissingProperties;
         this.readableProperties.clear();
      }

   }

   public boolean isSkipMissingProperties() {
      return this.skipMissingProperties;
   }
}
