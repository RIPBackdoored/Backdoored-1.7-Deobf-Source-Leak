package com.sun.jna.win32;

import java.util.HashMap;

final class W32APIOptions$1 extends HashMap {
   private static final long serialVersionUID = 1L;

   W32APIOptions$1() {
      this.put("type-mapper", W32APITypeMapper.UNICODE);
      this.put("function-mapper", W32APIFunctionMapper.UNICODE);
   }
}
