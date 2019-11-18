package org.yaml.snakeyaml.representer;

import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentByteArray implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentByteArray(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      char[] binary = Base64Coder.encode((byte[])((byte[])data));
      return this.this$0.representScalar(Tag.BINARY, String.valueOf(binary), '|');
   }
}
