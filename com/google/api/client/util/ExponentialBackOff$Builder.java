package com.google.api.client.util;

public class ExponentialBackOff$Builder {
   int initialIntervalMillis = 500;
   double randomizationFactor = 0.5D;
   double multiplier = 1.5D;
   int maxIntervalMillis = 60000;
   int maxElapsedTimeMillis = 900000;
   NanoClock nanoClock;

   public ExponentialBackOff$Builder() {
      this.nanoClock = NanoClock.SYSTEM;
   }

   public ExponentialBackOff build() {
      return new ExponentialBackOff(this);
   }

   public final int getInitialIntervalMillis() {
      return this.initialIntervalMillis;
   }

   public ExponentialBackOff$Builder setInitialIntervalMillis(int initialIntervalMillis) {
      this.initialIntervalMillis = initialIntervalMillis;
      return this;
   }

   public final double getRandomizationFactor() {
      return this.randomizationFactor;
   }

   public ExponentialBackOff$Builder setRandomizationFactor(double randomizationFactor) {
      this.randomizationFactor = randomizationFactor;
      return this;
   }

   public final double getMultiplier() {
      return this.multiplier;
   }

   public ExponentialBackOff$Builder setMultiplier(double multiplier) {
      this.multiplier = multiplier;
      return this;
   }

   public final int getMaxIntervalMillis() {
      return this.maxIntervalMillis;
   }

   public ExponentialBackOff$Builder setMaxIntervalMillis(int maxIntervalMillis) {
      this.maxIntervalMillis = maxIntervalMillis;
      return this;
   }

   public final int getMaxElapsedTimeMillis() {
      return this.maxElapsedTimeMillis;
   }

   public ExponentialBackOff$Builder setMaxElapsedTimeMillis(int maxElapsedTimeMillis) {
      this.maxElapsedTimeMillis = maxElapsedTimeMillis;
      return this;
   }

   public final NanoClock getNanoClock() {
      return this.nanoClock;
   }

   public ExponentialBackOff$Builder setNanoClock(NanoClock nanoClock) {
      this.nanoClock = (NanoClock)Preconditions.checkNotNull(nanoClock);
      return this;
   }
}
