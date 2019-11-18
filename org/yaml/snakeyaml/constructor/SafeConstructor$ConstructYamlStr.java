package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;

public class SafeConstructor$ConstructYamlStr extends AbstractConstruct {
   // $FF: synthetic field
   final SafeConstructor this$0;

   public SafeConstructor$ConstructYamlStr(SafeConstructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      return this.this$0.constructScalar((ScalarNode)node);
   }
}
