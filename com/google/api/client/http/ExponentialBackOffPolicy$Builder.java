package com.google.api.client.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ExponentialBackOff$Builder;
import com.google.api.client.util.NanoClock;

/** @deprecated */
@Deprecated
@Beta
public class ExponentialBackOffPolicy$Builder {
   final ExponentialBackOff$Builder exponentialBackOffBuilder = new ExponentialBackOff$Builder();

   protected ExponentialBackOffPolicy$Builder() {
   }

   public ExponentialBackOffPolicy build() {
      return new ExponentialBackOffPolicy(this);
   }

   public final int getInitialIntervalMillis() {
      return this.exponentialBackOffBuilder.getInitialIntervalMillis();
   }

   public ExponentialBackOffPolicy$Builder setInitialIntervalMillis(int initialIntervalMillis) {
      this.exponentialBackOffBuilder.setInitialIntervalMillis(initialIntervalMillis);
      return this;
   }

   public final double getRandomizationFactor() {
      return this.exponentialBackOffBuilder.getRandomizationFactor();
   }

   public ExponentialBackOffPolicy$Builder setRandomizationFactor(double randomizationFactor) {
      this.exponentialBackOffBuilder.setRandomizationFactor(randomizationFactor);
      return this;
   }

   public final double getMultiplier() {
      return this.exponentialBackOffBuilder.getMultiplier();
   }

   public ExponentialBackOffPolicy$Builder setMultiplier(double multiplier) {
      this.exponentialBackOffBuilder.setMultiplier(multiplier);
      return this;
   }

   public final int getMaxIntervalMillis() {
      return this.exponentialBackOffBuilder.getMaxIntervalMillis();
   }

   public ExponentialBackOffPolicy$Builder setMaxIntervalMillis(int maxIntervalMillis) {
      this.exponentialBackOffBuilder.setMaxIntervalMillis(maxIntervalMillis);
      return this;
   }

   public final int getMaxElapsedTimeMillis() {
      return this.exponentialBackOffBuilder.getMaxElapsedTimeMillis();
   }

   public ExponentialBackOffPolicy$Builder setMaxElapsedTimeMillis(int maxElapsedTimeMillis) {
      this.exponentialBackOffBuilder.setMaxElapsedTimeMillis(maxElapsedTimeMillis);
      return this;
   }

   public final NanoClock getNanoClock() {
      return this.exponentialBackOffBuilder.getNanoClock();
   }

   public ExponentialBackOffPolicy$Builder setNanoClock(NanoClock nanoClock) {
      this.exponentialBackOffBuilder.setNanoClock(nanoClock);
      return this;
   }
}
