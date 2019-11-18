package org.yaml.snakeyaml.representer;

import java.util.Arrays;
import java.util.List;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentArray implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentArray(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      Object[] array = (Object[])((Object[])data);
      List list = Arrays.asList(array);
      return this.this$0.representSequence(Tag.SEQ, list, (Boolean)null);
   }
}
