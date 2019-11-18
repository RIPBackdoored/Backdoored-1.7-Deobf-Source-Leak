package org.yaml.snakeyaml;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertySubstitute;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class TypeDescription {
   private final Class type;
   private Class impl;
   private Tag tag;
   private transient Set dumpProperties;
   private transient PropertyUtils propertyUtils;
   private transient boolean delegatesChecked;
   private Map properties;
   protected Set excludes;
   protected String[] includes;
   protected BeanAccess beanAccess;

   public TypeDescription(Class clazz, Tag tag) {
      this(clazz, tag, (Class)null);
   }

   public TypeDescription(Class clazz, Tag tag, Class impl) {
      this.properties = Collections.emptyMap();
      this.excludes = Collections.emptySet();
      this.includes = null;
      this.type = clazz;
      this.tag = tag;
      this.impl = impl;
      this.beanAccess = null;
   }

   public TypeDescription(Class clazz, String tag) {
      this(clazz, new Tag(tag), (Class)null);
   }

   public TypeDescription(Class clazz) {
      this(clazz, (Tag)null, (Class)null);
   }

   public TypeDescription(Class clazz, Class impl) {
      this(clazz, (Tag)null, impl);
   }

   public Tag getTag() {
      return this.tag;
   }

   public void setTag(Tag tag) {
      this.tag = tag;
   }

   public void setTag(String tag) {
      this.setTag(new Tag(tag));
   }

   public Class getType() {
      return this.type;
   }

   /** @deprecated */
   @Deprecated
   public void putListPropertyType(String property, Class type) {
      this.addPropertyParameters(property, type);
   }

   /** @deprecated */
   @Deprecated
   public Class getListPropertyType(String property) {
      if (this.properties.containsKey(property)) {
         Class[] typeArguments = ((PropertySubstitute)this.properties.get(property)).getActualTypeArguments();
         if (typeArguments != null && typeArguments.length > 0) {
            return typeArguments[0];
         }
      }

      return null;
   }

   /** @deprecated */
   @Deprecated
   public void putMapPropertyType(String property, Class key, Class value) {
      this.addPropertyParameters(property, key, value);
   }

   /** @deprecated */
   @Deprecated
   public Class getMapKeyType(String property) {
      if (this.properties.containsKey(property)) {
         Class[] typeArguments = ((PropertySubstitute)this.properties.get(property)).getActualTypeArguments();
         if (typeArguments != null && typeArguments.length > 0) {
            return typeArguments[0];
         }
      }

      return null;
   }

   /** @deprecated */
   @Deprecated
   public Class getMapValueType(String property) {
      if (this.properties.containsKey(property)) {
         Class[] typeArguments = ((PropertySubstitute)this.properties.get(property)).getActualTypeArguments();
         if (typeArguments != null && typeArguments.length > 1) {
            return typeArguments[1];
         }
      }

      return null;
   }

   public void addPropertyParameters(String pName, Class... classes) {
      if (!this.properties.containsKey(pName)) {
         this.substituteProperty(pName, (Class)null, (String)null, (String)null, classes);
      } else {
         PropertySubstitute pr = (PropertySubstitute)this.properties.get(pName);
         pr.setActualTypeArguments(classes);
      }

   }

   public String toString() {
      return "TypeDescription for " + this.getType() + " (tag='" + this.getTag() + "')";
   }

   private void checkDelegates() {
      Collection values = this.properties.values();
      Iterator var2 = values.iterator();

      while(var2.hasNext()) {
         PropertySubstitute p = (PropertySubstitute)var2.next();

         try {
            p.setDelegate(this.discoverProperty(p.getName()));
         } catch (YAMLException var5) {
         }
      }

      this.delegatesChecked = true;
   }

   private Property discoverProperty(String name) {
      if (this.propertyUtils != null) {
         return this.beanAccess == null ? this.propertyUtils.getProperty(this.type, name) : this.propertyUtils.getProperty(this.type, name, this.beanAccess);
      } else {
         return null;
      }
   }

   public Property getProperty(String name) {
      if (!this.delegatesChecked) {
         this.checkDelegates();
      }

      return this.properties.containsKey(name) ? (Property)this.properties.get(name) : this.discoverProperty(name);
   }

   public void substituteProperty(String pName, Class pType, String getter, String setter, Class... argParams) {
      this.substituteProperty(new PropertySubstitute(pName, pType, getter, setter, argParams));
   }

   public void substituteProperty(PropertySubstitute substitute) {
      if (Collections.EMPTY_MAP == this.properties) {
         this.properties = new LinkedHashMap();
      }

      substitute.setTargetType(this.type);
      this.properties.put(substitute.getName(), substitute);
   }

   public void setPropertyUtils(PropertyUtils propertyUtils) {
      this.propertyUtils = propertyUtils;
   }

   public void setIncludes(String... propNames) {
      this.includes = propNames != null && propNames.length > 0 ? propNames : null;
   }

   public void setExcludes(String... propNames) {
      if (propNames != null && propNames.length > 0) {
         this.excludes = new HashSet();
         String[] var2 = propNames;
         int var3 = propNames.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String name = var2[var4];
            this.excludes.add(name);
         }
      } else {
         this.excludes = Collections.emptySet();
      }

   }

   public Set getProperties() {
      if (this.dumpProperties != null) {
         return this.dumpProperties;
      } else if (this.propertyUtils != null) {
         if (this.includes != null) {
            this.dumpProperties = new LinkedHashSet();
            String[] var5 = this.includes;
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
               String propertyName = var5[var7];
               if (!this.excludes.contains(propertyName)) {
                  this.dumpProperties.add(this.getProperty(propertyName));
               }
            }

            return this.dumpProperties;
         } else {
            Set readableProps = this.beanAccess == null ? this.propertyUtils.getProperties(this.type) : this.propertyUtils.getProperties(this.type, this.beanAccess);
            Iterator var2;
            Property property;
            if (this.properties.isEmpty()) {
               if (this.excludes.isEmpty()) {
                  return this.dumpProperties = readableProps;
               } else {
                  this.dumpProperties = new LinkedHashSet();
                  var2 = readableProps.iterator();

                  while(var2.hasNext()) {
                     property = (Property)var2.next();
                     if (!this.excludes.contains(property.getName())) {
                        this.dumpProperties.add(property);
                     }
                  }

                  return this.dumpProperties;
               }
            } else {
               if (!this.delegatesChecked) {
                  this.checkDelegates();
               }

               this.dumpProperties = new LinkedHashSet();
               var2 = this.properties.values().iterator();

               while(var2.hasNext()) {
                  property = (Property)var2.next();
                  if (!this.excludes.contains(property.getName()) && property.isReadable()) {
                     this.dumpProperties.add(property);
                  }
               }

               var2 = readableProps.iterator();

               while(var2.hasNext()) {
                  property = (Property)var2.next();
                  if (!this.excludes.contains(property.getName())) {
                     this.dumpProperties.add(property);
                  }
               }

               return this.dumpProperties;
            }
         }
      } else {
         return null;
      }
   }

   public boolean setupPropertyType(String key, Node valueNode) {
      return false;
   }

   public boolean setProperty(Object targetBean, String propertyName, Object value) throws Exception {
      return false;
   }

   public Object newInstance(Node node) {
      if (this.impl != null) {
         Object var10000;
         try {
            Constructor c = this.impl.getDeclaredConstructor();
            c.setAccessible(true);
            var10000 = c.newInstance();
         } catch (Exception var3) {
            var3.printStackTrace();
            this.impl = null;
            return null;
         }

         return var10000;
      } else {
         return null;
      }
   }

   public Object newInstance(String propertyName, Node node) {
      return null;
   }

   public Object finalizeConstruction(Object obj) {
      return obj;
   }
}
