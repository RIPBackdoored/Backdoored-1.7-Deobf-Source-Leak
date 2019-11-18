package org.yaml.snakeyaml.representer;

import java.util.Map;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentMap implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentMap(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      return this.this$0.representMapping(this.this$0.getTag(data.getClass(), Tag.MAP), (Map)data, (Boolean)null);
   }
}
