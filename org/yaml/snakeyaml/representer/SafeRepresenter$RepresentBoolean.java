package org.yaml.snakeyaml.representer;

import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentBoolean implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentBoolean(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      String value;
      if (Boolean.TRUE.equals(data)) {
         value = "true";
      } else {
         value = "false";
      }

      return this.this$0.representScalar(Tag.BOOL, value);
   }
}
