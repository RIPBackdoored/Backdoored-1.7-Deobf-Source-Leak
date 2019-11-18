package javassist.scopedpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javassist.ClassPath;
import javassist.ClassPool;
import javassist.LoaderClassPath;

public class ScopedClassPoolRepositoryImpl implements ScopedClassPoolRepository {
   private static final ScopedClassPoolRepositoryImpl instance = new ScopedClassPoolRepositoryImpl();
   private boolean prune = true;
   boolean pruneWhenCached;
   protected Map registeredCLs = Collections.synchronizedMap(new WeakHashMap());
   protected ClassPool classpool = ClassPool.getDefault();
   protected ScopedClassPoolFactory factory = new ScopedClassPoolFactoryImpl();

   public static ScopedClassPoolRepository getInstance() {
      return instance;
   }

   private ScopedClassPoolRepositoryImpl() {
      ClassLoader cl = Thread.currentThread().getContextClassLoader();
      this.classpool.insertClassPath((ClassPath)(new LoaderClassPath(cl)));
   }

   public boolean isPrune() {
      return this.prune;
   }

   public void setPrune(boolean prune) {
      this.prune = prune;
   }

   public ScopedClassPool createScopedClassPool(ClassLoader cl, ClassPool src) {
      return this.factory.create(cl, src, this);
   }

   public ClassPool findClassPool(ClassLoader cl) {
      return cl == null ? this.registerClassLoader(ClassLoader.getSystemClassLoader()) : this.registerClassLoader(cl);
   }

   public ClassPool registerClassLoader(ClassLoader ucl) {
      ScopedClassPool var10000;
      synchronized(this.registeredCLs) {
         if (this.registeredCLs.containsKey(ucl)) {
            ClassPool var6 = (ClassPool)this.registeredCLs.get(ucl);
            return var6;
         }

         ScopedClassPool pool = this.createScopedClassPool(ucl, this.classpool);
         this.registeredCLs.put(ucl, pool);
         var10000 = pool;
      }

      return var10000;
   }

   public Map getRegisteredCLs() {
      this.clearUnregisteredClassLoaders();
      return this.registeredCLs;
   }

   public void clearUnregisteredClassLoaders() {
      ArrayList toUnregister = null;
      synchronized(this.registeredCLs) {
         Iterator it = this.registeredCLs.values().iterator();

         while(it.hasNext()) {
            ScopedClassPool pool = (ScopedClassPool)it.next();
            if (pool.isUnloadedClassLoader()) {
               it.remove();
               ClassLoader cl = pool.getClassLoader();
               if (cl != null) {
                  if (toUnregister == null) {
                     toUnregister = new ArrayList();
                  }

                  toUnregister.add(cl);
               }
            }
         }

         if (toUnregister != null) {
            for(int i = 0; i < toUnregister.size(); ++i) {
               this.unregisterClassLoader((ClassLoader)toUnregister.get(i));
            }
         }
      }

   }

   public void unregisterClassLoader(ClassLoader cl) {
      synchronized(this.registeredCLs) {
         ScopedClassPool pool = (ScopedClassPool)this.registeredCLs.remove(cl);
         if (pool != null) {
            pool.close();
         }
      }

   }

   public void insertDelegate(ScopedClassPoolRepository delegate) {
   }

   public void setClassPoolFactory(ScopedClassPoolFactory factory) {
      this.factory = factory;
   }

   public ScopedClassPoolFactory getClassPoolFactory() {
      return this.factory;
   }
}
