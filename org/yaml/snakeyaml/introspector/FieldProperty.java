package org.yaml.snakeyaml.introspector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.util.ArrayUtils;

public class FieldProperty extends GenericProperty {
   private final Field field;

   public FieldProperty(Field field) {
      super(field.getName(), field.getType(), field.getGenericType());
      this.field = field;
      field.setAccessible(true);
   }

   public void set(Object object, Object value) throws Exception {
      this.field.set(object, value);
   }

   public Object get(Object object) {
      Object var10000;
      try {
         var10000 = this.field.get(object);
      } catch (Exception var3) {
         throw new YAMLException("Unable to access field " + this.field.getName() + " on object " + object + " : " + var3);
      }

      return var10000;
   }

   public List getAnnotations() {
      return ArrayUtils.toUnmodifiableList(this.field.getAnnotations());
   }

   public Annotation getAnnotation(Class annotationType) {
      return this.field.getAnnotation(annotationType);
   }
}
