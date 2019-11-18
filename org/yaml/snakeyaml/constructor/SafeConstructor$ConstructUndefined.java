package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.nodes.Node;

public final class SafeConstructor$ConstructUndefined extends AbstractConstruct {
   public Object construct(Node node) {
      throw new ConstructorException((String)null, (Mark)null, "could not determine a constructor for the tag " + node.getTag(), node.getStartMark());
   }
}
