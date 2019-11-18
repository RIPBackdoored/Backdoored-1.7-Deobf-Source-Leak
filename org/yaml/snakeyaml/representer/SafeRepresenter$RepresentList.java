package org.yaml.snakeyaml.representer;

import java.util.List;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentList implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentList(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      return this.this$0.representSequence(this.this$0.getTag(data.getClass(), Tag.SEQ), (List)data, (Boolean)null);
   }
}
