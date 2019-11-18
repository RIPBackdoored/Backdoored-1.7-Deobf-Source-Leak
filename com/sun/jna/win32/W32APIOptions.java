package com.sun.jna.win32;

import java.util.Collections;
import java.util.Map;

public interface W32APIOptions extends StdCallLibrary {
   Map UNICODE_OPTIONS = Collections.unmodifiableMap(new W32APIOptions$1());
   Map ASCII_OPTIONS = Collections.unmodifiableMap(new W32APIOptions$2());
   Map DEFAULT_OPTIONS = Boolean.getBoolean("w32.ascii") ? ASCII_OPTIONS : UNICODE_OPTIONS;
}
