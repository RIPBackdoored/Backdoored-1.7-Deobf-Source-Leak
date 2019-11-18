package org.yaml.snakeyaml.extensions.compactnotation;

import org.yaml.snakeyaml.constructor.Constructor$ConstructMapping;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;

public class CompactConstructor$ConstructCompactObject extends Constructor$ConstructMapping {
   // $FF: synthetic field
   final CompactConstructor this$0;

   public CompactConstructor$ConstructCompactObject(CompactConstructor this$0) {
      super(this$0);
      this.this$0 = this$0;
   }

   public void construct2ndStep(Node node, Object object) {
      MappingNode mnode = (MappingNode)node;
      NodeTuple nodeTuple = (NodeTuple)mnode.getValue().iterator().next();
      Node valueNode = nodeTuple.getValueNode();
      if (valueNode instanceof MappingNode) {
         valueNode.setType(object.getClass());
         this.constructJavaBean2ndStep((MappingNode)valueNode, object);
      } else {
         this.this$0.applySequence(object, CompactConstructor.access$000(this.this$0, (SequenceNode)valueNode));
      }

   }

   public Object construct(Node node) {
      ScalarNode tmpNode = null;
      if (node instanceof MappingNode) {
         MappingNode mnode = (MappingNode)node;
         NodeTuple nodeTuple = (NodeTuple)mnode.getValue().iterator().next();
         node.setTwoStepsConstruction(true);
         tmpNode = (ScalarNode)nodeTuple.getKeyNode();
      } else {
         tmpNode = (ScalarNode)node;
      }

      CompactData data = this.this$0.getCompactData(tmpNode.getValue());
      return data == null ? CompactConstructor.access$100(this.this$0, tmpNode) : this.this$0.constructCompactFormat(tmpNode, data);
   }
}
