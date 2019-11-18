package org.yaml.snakeyaml.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.Escaper;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.PercentEscaper;

public abstract class UriEncoder {
   private static final CharsetDecoder UTF8Decoder;
   private static final String SAFE_CHARS = "-_.!~*'()@:$&,;=[]/";
   private static final Escaper escaper;

   public static String encode(String uri) {
      return escaper.escape(uri);
   }

   public static String decode(ByteBuffer buff) throws CharacterCodingException {
      CharBuffer chars = UTF8Decoder.decode(buff);
      return chars.toString();
   }

   public static String decode(String buff) {
      String var10000;
      try {
         var10000 = URLDecoder.decode(buff, "UTF-8");
      } catch (UnsupportedEncodingException var2) {
         throw new YAMLException(var2);
      }

      return var10000;
   }

   static {
      UTF8Decoder = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPORT);
      escaper = new PercentEscaper("-_.!~*'()@:$&,;=[]/", false);
   }
}
