package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;

public class SafeConstructor$ConstructYamlBool extends AbstractConstruct {
   // $FF: synthetic field
   final SafeConstructor this$0;

   public SafeConstructor$ConstructYamlBool(SafeConstructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      String val = (String)this.this$0.constructScalar((ScalarNode)node);
      return SafeConstructor.access$000().get(val.toLowerCase());
   }
}
