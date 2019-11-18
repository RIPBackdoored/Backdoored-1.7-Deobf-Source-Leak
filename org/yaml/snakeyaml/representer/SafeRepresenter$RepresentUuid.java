package org.yaml.snakeyaml.representer;

import java.util.UUID;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentUuid implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentUuid(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      return this.this$0.representScalar(this.this$0.getTag(data.getClass(), new Tag(UUID.class)), data.toString());
   }
}
