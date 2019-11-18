package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;

public class SafeConstructor$ConstructYamlBinary extends AbstractConstruct {
   // $FF: synthetic field
   final SafeConstructor this$0;

   public SafeConstructor$ConstructYamlBinary(SafeConstructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      String noWhiteSpaces = this.this$0.constructScalar((ScalarNode)node).toString().replaceAll("\\s", "");
      byte[] decoded = Base64Coder.decode(noWhiteSpaces.toCharArray());
      return decoded;
   }
}
