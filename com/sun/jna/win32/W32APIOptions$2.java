package com.sun.jna.win32;

import java.util.HashMap;

final class W32APIOptions$2 extends HashMap {
   private static final long serialVersionUID = 1L;

   W32APIOptions$2() {
      this.put("type-mapper", W32APITypeMapper.ASCII);
      this.put("function-mapper", W32APIFunctionMapper.ASCII);
   }
}
