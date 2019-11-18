package javassist.util.proxy;

import java.lang.ref.WeakReference;

class ProxyFactory$ProxyDetails {
   byte[] signature;
   WeakReference proxyClass;
   boolean isUseWriteReplace;

   ProxyFactory$ProxyDetails(byte[] signature, Class proxyClass, boolean isUseWriteReplace) {
      this.signature = signature;
      this.proxyClass = new WeakReference(proxyClass);
      this.isUseWriteReplace = isUseWriteReplace;
   }
}
