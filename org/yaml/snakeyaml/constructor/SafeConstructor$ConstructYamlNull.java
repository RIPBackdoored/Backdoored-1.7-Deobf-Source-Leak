package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;

public class SafeConstructor$ConstructYamlNull extends AbstractConstruct {
   // $FF: synthetic field
   final SafeConstructor this$0;

   public SafeConstructor$ConstructYamlNull(SafeConstructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      this.this$0.constructScalar((ScalarNode)node);
      return null;
   }
}
