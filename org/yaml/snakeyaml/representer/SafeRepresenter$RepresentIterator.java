package org.yaml.snakeyaml.representer;

import java.util.Iterator;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentIterator implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentIterator(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      Iterator iter = (Iterator)data;
      return this.this$0.representSequence(this.this$0.getTag(data.getClass(), Tag.SEQ), new SafeRepresenter$IteratorWrapper(iter), (Boolean)null);
   }
}
