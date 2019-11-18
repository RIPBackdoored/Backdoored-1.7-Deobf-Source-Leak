package com.fasterxml.jackson.core.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ThreadLocalBufferManager {
   private final Object RELEASE_LOCK = new Object();
   private final Map _trackedRecyclers = new ConcurrentHashMap();
   private final ReferenceQueue _refQueue = new ReferenceQueue();

   public static ThreadLocalBufferManager instance() {
      return ThreadLocalBufferManager$ThreadLocalBufferManagerHolder.manager;
   }

   public int releaseBuffers() {
      synchronized(this.RELEASE_LOCK) {
         int count = 0;
         this.removeSoftRefsClearedByGc();

         for(Iterator i$ = this._trackedRecyclers.keySet().iterator(); i$.hasNext(); ++count) {
            SoftReference ref = (SoftReference)i$.next();
            ref.clear();
         }

         this._trackedRecyclers.clear();
         int var10000 = count;
         return var10000;
      }
   }

   public SoftReference wrapAndTrack(BufferRecycler br) {
      SoftReference newRef = new SoftReference(br, this._refQueue);
      this._trackedRecyclers.put(newRef, true);
      this.removeSoftRefsClearedByGc();
      return newRef;
   }

   private void removeSoftRefsClearedByGc() {
      SoftReference clearedSoftRef;
      while((clearedSoftRef = (SoftReference)this._refQueue.poll()) != null) {
         this._trackedRecyclers.remove(clearedSoftRef);
      }

   }
}
