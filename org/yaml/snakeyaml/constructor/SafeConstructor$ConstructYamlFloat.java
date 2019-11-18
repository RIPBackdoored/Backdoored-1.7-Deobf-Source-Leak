package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;

public class SafeConstructor$ConstructYamlFloat extends AbstractConstruct {
   // $FF: synthetic field
   final SafeConstructor this$0;

   public SafeConstructor$ConstructYamlFloat(SafeConstructor this$0) {
      this.this$0 = this$0;
   }

   public Object construct(Node node) {
      String value = this.this$0.constructScalar((ScalarNode)node).toString().replaceAll("_", "");
      int sign = 1;
      char first = value.charAt(0);
      if (first == '-') {
         sign = -1;
         value = value.substring(1);
      } else if (first == '+') {
         value = value.substring(1);
      }

      String valLower = value.toLowerCase();
      if (".inf".equals(valLower)) {
         return new Double(sign == -1 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
      } else if (".nan".equals(valLower)) {
         return new Double(Double.NaN);
      } else if (value.indexOf(58) == -1) {
         Double d = Double.valueOf(value);
         return new Double(d * (double)sign);
      } else {
         String[] digits = value.split(":");
         int bes = 1;
         double val = 0.0D;
         int i = 0;

         for(int j = digits.length; i < j; ++i) {
            val += Double.parseDouble(digits[j - i - 1]) * (double)bes;
            bes *= 60;
         }

         return new Double((double)sign * val);
      }
   }
}
