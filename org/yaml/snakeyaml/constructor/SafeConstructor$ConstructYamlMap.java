package org.yaml.snakeyaml.constructor;

import java.util.Map;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;

public class SafeConstructor$ConstructYamlMap implements Construct {
   // $FF: synthetic field
   final SafeConstructor this$0;

   public SafeConstructor$ConstructYamlMap(SafeConstructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      return node.isTwoStepsConstruction() ? this.this$0.createDefaultMap() : this.this$0.constructMapping((MappingNode)node);
   }

   public void construct2ndStep(Node node, Object object) {
      if (node.isTwoStepsConstruction()) {
         this.this$0.constructMapping2ndStep((MappingNode)node, (Map)object);
      } else {
         throw new YAMLException("Unexpected recursive mapping structure. Node: " + node);
      }
   }
}
