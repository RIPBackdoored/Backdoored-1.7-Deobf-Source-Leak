package org.yaml.snakeyaml.representer;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.Tag;

class SafeRepresenter extends BaseRepresenter {
   protected Map classTags;
   protected TimeZone timeZone = null;
   public static Pattern MULTILINE_PATTERN = Pattern.compile("\n|\u0085|\u2028|\u2029");

   public SafeRepresenter() {
      this.nullRepresenter = new SafeRepresenter$RepresentNull(this);
      this.representers.put(String.class, new SafeRepresenter$RepresentString(this));
      this.representers.put(Boolean.class, new SafeRepresenter$RepresentBoolean(this));
      this.representers.put(Character.class, new SafeRepresenter$RepresentString(this));
      this.representers.put(UUID.class, new SafeRepresenter$RepresentUuid(this));
      this.representers.put(byte[].class, new SafeRepresenter$RepresentByteArray(this));
      Represent primitiveArray = new SafeRepresenter$RepresentPrimitiveArray(this);
      this.representers.put(short[].class, primitiveArray);
      this.representers.put(int[].class, primitiveArray);
      this.representers.put(long[].class, primitiveArray);
      this.representers.put(float[].class, primitiveArray);
      this.representers.put(double[].class, primitiveArray);
      this.representers.put(char[].class, primitiveArray);
      this.representers.put(boolean[].class, primitiveArray);
      this.multiRepresenters.put(Number.class, new SafeRepresenter$RepresentNumber(this));
      this.multiRepresenters.put(List.class, new SafeRepresenter$RepresentList(this));
      this.multiRepresenters.put(Map.class, new SafeRepresenter$RepresentMap(this));
      this.multiRepresenters.put(Set.class, new SafeRepresenter$RepresentSet(this));
      this.multiRepresenters.put(Iterator.class, new SafeRepresenter$RepresentIterator(this));
      this.multiRepresenters.put((new Object[0]).getClass(), new SafeRepresenter$RepresentArray(this));
      this.multiRepresenters.put(Date.class, new SafeRepresenter$RepresentDate(this));
      this.multiRepresenters.put(Enum.class, new SafeRepresenter$RepresentEnum(this));
      this.multiRepresenters.put(Calendar.class, new SafeRepresenter$RepresentDate(this));
      this.classTags = new HashMap();
   }

   protected Tag getTag(Class clazz, Tag defaultTag) {
      return this.classTags.containsKey(clazz) ? (Tag)this.classTags.get(clazz) : defaultTag;
   }

   public Tag addClassTag(Class clazz, Tag tag) {
      if (tag == null) {
         throw new NullPointerException("Tag must be provided.");
      } else {
         return (Tag)this.classTags.put(clazz, tag);
      }
   }

   public TimeZone getTimeZone() {
      return this.timeZone;
   }

   public void setTimeZone(TimeZone timeZone) {
      this.timeZone = timeZone;
   }
}
