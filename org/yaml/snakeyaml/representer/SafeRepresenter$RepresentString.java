package org.yaml.snakeyaml.representer;

import java.io.UnsupportedEncodingException;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.reader.StreamReader;

public class SafeRepresenter$RepresentString implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentString(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      Tag tag = Tag.STR;
      Character style = null;
      String value = data.toString();
      if (!StreamReader.isPrintable(value)) {
         tag = Tag.BINARY;

         char[] binary;
         try {
            byte[] bytes = value.getBytes("UTF-8");
            String checkValue = new String(bytes, "UTF-8");
            if (!checkValue.equals(value)) {
               throw new YAMLException("invalid string value has occurred");
            }

            binary = Base64Coder.encode(bytes);
         } catch (UnsupportedEncodingException var8) {
            throw new YAMLException(var8);
         }

         value = String.valueOf(binary);
         style = '|';
      }

      if (this.this$0.defaultScalarStyle == null && SafeRepresenter.MULTILINE_PATTERN.matcher(value).find()) {
         style = '|';
      }

      return this.this$0.representScalar(tag, value, style);
   }
}
