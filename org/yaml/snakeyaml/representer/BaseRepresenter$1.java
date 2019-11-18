package org.yaml.snakeyaml.representer;

import java.util.IdentityHashMap;
import org.yaml.snakeyaml.nodes.AnchorNode;
import org.yaml.snakeyaml.nodes.Node;

class BaseRepresenter$1 extends IdentityHashMap {
   private static final long serialVersionUID = -5576159264232131854L;
   // $FF: synthetic field
   final BaseRepresenter this$0;

   BaseRepresenter$1(BaseRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node put(Object key, Node value) {
      return (Node)super.put(key, new AnchorNode(value));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object put(Object var1, Object var2) {
      return this.put(var1, (Node)var2);
   }
}
