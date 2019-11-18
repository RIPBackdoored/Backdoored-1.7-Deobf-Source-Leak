package org.yaml.snakeyaml.constructor;

import java.util.Set;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;

public class SafeConstructor$ConstructYamlSet implements Construct {
   // $FF: synthetic field
   final SafeConstructor this$0;

   public SafeConstructor$ConstructYamlSet(SafeConstructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      if (node.isTwoStepsConstruction()) {
         return this.this$0.constructedObjects.containsKey(node) ? this.this$0.constructedObjects.get(node) : this.this$0.createDefaultSet();
      } else {
         return this.this$0.constructSet((MappingNode)node);
      }
   }

   public void construct2ndStep(Node node, Object object) {
      if (node.isTwoStepsConstruction()) {
         this.this$0.constructSet2ndStep((MappingNode)node, (Set)object);
      } else {
         throw new YAMLException("Unexpected recursive set structure. Node: " + node);
      }
   }
}
