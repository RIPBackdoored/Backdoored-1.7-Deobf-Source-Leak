package org.yaml.snakeyaml.constructor;

import java.util.List;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.SequenceNode;

public class SafeConstructor$ConstructYamlSeq implements Construct {
   // $FF: synthetic field
   final SafeConstructor this$0;

   public SafeConstructor$ConstructYamlSeq(SafeConstructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      SequenceNode seqNode = (SequenceNode)node;
      return node.isTwoStepsConstruction() ? this.this$0.newList(seqNode) : this.this$0.constructSequence(seqNode);
   }

   public void construct2ndStep(Node node, Object data) {
      if (node.isTwoStepsConstruction()) {
         this.this$0.constructSequenceStep2((SequenceNode)node, (List)data);
      } else {
         throw new YAMLException("Unexpected recursive sequence structure. Node: " + node);
      }
   }
}
