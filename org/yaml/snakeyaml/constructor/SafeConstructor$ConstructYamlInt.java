package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;

public class SafeConstructor$ConstructYamlInt extends AbstractConstruct {
   // $FF: synthetic field
   final SafeConstructor this$0;

   public SafeConstructor$ConstructYamlInt(SafeConstructor this$0) {
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

      int base = true;
      if ("0".equals(value)) {
         return 0;
      } else {
         byte base;
         if (value.startsWith("0b")) {
            value = value.substring(2);
            base = 2;
         } else if (value.startsWith("0x")) {
            value = value.substring(2);
            base = 16;
         } else {
            if (!value.startsWith("0")) {
               if (value.indexOf(58) == -1) {
                  return SafeConstructor.access$100(this.this$0, sign, value, 10);
               }

               String[] digits = value.split(":");
               int bes = 1;
               int val = 0;
               int i = 0;

               for(int j = digits.length; i < j; ++i) {
                  val = (int)((long)val + Long.parseLong(digits[j - i - 1]) * (long)bes);
                  bes *= 60;
               }

               return SafeConstructor.access$100(this.this$0, sign, String.valueOf(val), 10);
            }

            value = value.substring(1);
            base = 8;
         }

         return SafeConstructor.access$100(this.this$0, sign, value, base);
      }
   }
}
