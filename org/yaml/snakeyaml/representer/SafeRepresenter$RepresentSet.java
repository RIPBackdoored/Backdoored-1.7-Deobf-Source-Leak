package org.yaml.snakeyaml.representer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentSet implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentSet(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      Map value = new LinkedHashMap();
      Set set = (Set)data;
      Iterator var4 = set.iterator();

      while(var4.hasNext()) {
         Object key = var4.next();
         value.put(key, (Object)null);
      }

      return this.this$0.representMapping(this.this$0.getTag(data.getClass(), Tag.SET), value, (Boolean)null);
   }
}
