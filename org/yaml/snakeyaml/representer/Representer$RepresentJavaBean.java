package org.yaml.snakeyaml.representer;

import org.yaml.snakeyaml.nodes.Node;

public class Representer$RepresentJavaBean implements Represent {
   // $FF: synthetic field
   final Representer this$0;

   protected Representer$RepresentJavaBean(Representer this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      return this.this$0.representJavaBean(this.this$0.getProperties(data.getClass()), data);
   }
}
