package com.google.api.client.testing.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import java.util.concurrent.atomic.AtomicLong;

@Beta
public class FixedClock implements Clock {
   private AtomicLong currentTime;

   public FixedClock() {
      this(0L);
   }

   public FixedClock(long startTime) {
      this.currentTime = new AtomicLong(startTime);
   }

   public FixedClock setTime(long newTime) {
      this.currentTime.set(newTime);
      return this;
   }

   public long currentTimeMillis() {
      return this.currentTime.get();
   }
}
