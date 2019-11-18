package org.yaml.snakeyaml.constructor;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.SequenceNode;

public class SafeConstructor$ConstructYamlOmap extends AbstractConstruct {
   // $FF: synthetic field
   final SafeConstructor this$0;

   public SafeConstructor$ConstructYamlOmap(SafeConstructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      Map omap = new LinkedHashMap();
      if (!(node instanceof SequenceNode)) {
         throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a sequence, but found " + node.getNodeId(), node.getStartMark());
      } else {
         SequenceNode snode = (SequenceNode)node;
         Iterator var4 = snode.getValue().iterator();

         while(var4.hasNext()) {
            Node subnode = (Node)var4.next();
            if (!(subnode instanceof MappingNode)) {
               throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a mapping of length 1, but found " + subnode.getNodeId(), subnode.getStartMark());
            }

            MappingNode mnode = (MappingNode)subnode;
            if (mnode.getValue().size() != 1) {
               throw new ConstructorException("while constructing an ordered map", node.getStartMark(), "expected a single mapping item, but found " + mnode.getValue().size() + " items", mnode.getStartMark());
            }

            Node keyNode = ((NodeTuple)mnode.getValue().get(0)).getKeyNode();
            Node valueNode = ((NodeTuple)mnode.getValue().get(0)).getValueNode();
            Object key = this.this$0.constructObject(keyNode);
            Object value = this.this$0.constructObject(valueNode);
            omap.put(key, value);
         }

         return omap;
      }
   }
}
