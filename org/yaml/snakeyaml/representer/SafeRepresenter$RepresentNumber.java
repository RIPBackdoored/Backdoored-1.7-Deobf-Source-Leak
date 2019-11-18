package org.yaml.snakeyaml.representer;

import java.math.BigInteger;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentNumber implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentNumber(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      Tag tag;
      String value;
      if (!(data instanceof Byte) && !(data instanceof Short) && !(data instanceof Integer) && !(data instanceof Long) && !(data instanceof BigInteger)) {
         Number number = (Number)data;
         tag = Tag.FLOAT;
         if (number.equals(Double.NaN)) {
            value = ".NaN";
         } else if (number.equals(Double.POSITIVE_INFINITY)) {
            value = ".inf";
         } else if (number.equals(Double.NEGATIVE_INFINITY)) {
            value = "-.inf";
         } else {
            value = number.toString();
         }
      } else {
         tag = Tag.INT;
         value = data.toString();
      }

      return this.this$0.representScalar(this.this$0.getTag(data.getClass(), tag), value);
   }
}
