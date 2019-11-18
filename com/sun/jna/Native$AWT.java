package com.sun.jna;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Window;

class Native$AWT {
   private Native$AWT() {
   }

   static long getWindowID(Window w) throws HeadlessException {
      return getComponentID(w);
   }

   static long getComponentID(Object o) throws HeadlessException {
      if (GraphicsEnvironment.isHeadless()) {
         throw new HeadlessException("No native windows when headless");
      } else {
         Component c = (Component)o;
         if (c.isLightweight()) {
            throw new IllegalArgumentException("Component must be heavyweight");
         } else if (!c.isDisplayable()) {
            throw new IllegalStateException("Component must be displayable");
         } else if (Platform.isX11() && System.getProperty("java.version").startsWith("1.4") && !c.isVisible()) {
            throw new IllegalStateException("Component must be visible");
         } else {
            return Native.getWindowHandle0(c);
         }
      }
   }
}
