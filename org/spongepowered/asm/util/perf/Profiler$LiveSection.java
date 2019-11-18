package org.spongepowered.asm.util.perf;

import java.util.Arrays;

class Profiler$LiveSection extends Profiler$Section {
   private int cursor;
   private long[] times;
   private long start;
   private long time;
   private long markedTime;
   private int count;
   private int markedCount;
   // $FF: synthetic field
   final Profiler this$0;

   Profiler$LiveSection(Profiler this$0, String name, int cursor) {
      super(this$0, name);
      this.this$0 = this$0;
      this.cursor = 0;
      this.times = new long[0];
      this.start = 0L;
      this.cursor = cursor;
   }

   Profiler$Section start() {
      this.start = System.currentTimeMillis();
      return this;
   }

   protected Profiler$Section stop() {
      if (this.start > 0L) {
         this.time += System.currentTimeMillis() - this.start;
      }

      this.start = 0L;
      ++this.count;
      return this;
   }

   public Profiler$Section end() {
      this.stop();
      if (!this.invalidated) {
         this.this$0.end(this);
      }

      return this;
   }

   void mark() {
      if (this.cursor >= this.times.length) {
         this.times = Arrays.copyOf(this.times, this.cursor + 4);
      }

      this.times[this.cursor] = this.time;
      this.markedTime += this.time;
      this.markedCount += this.count;
      this.time = 0L;
      this.count = 0;
      ++this.cursor;
   }

   public long getTime() {
      return this.time;
   }

   public long getTotalTime() {
      return this.time + this.markedTime;
   }

   public double getSeconds() {
      return (double)this.time * 0.001D;
   }

   public double getTotalSeconds() {
      return (double)(this.time + this.markedTime) * 0.001D;
   }

   public long[] getTimes() {
      long[] times = new long[this.cursor + 1];
      System.arraycopy(this.times, 0, times, 0, Math.min(this.times.length, this.cursor));
      times[this.cursor] = this.time;
      return times;
   }

   public int getCount() {
      return this.count;
   }

   public int getTotalCount() {
      return this.count + this.markedCount;
   }

   public double getAverageTime() {
      return this.count > 0 ? (double)this.time / (double)this.count : 0.0D;
   }

   public double getTotalAverageTime() {
      return this.count > 0 ? (double)(this.time + this.markedTime) / (double)(this.count + this.markedCount) : 0.0D;
   }
}
