package org.spongepowered.asm.util.perf;

class Profiler$SubSection extends Profiler$LiveSection {
   private final String baseName;
   private final Profiler$Section root;
   // $FF: synthetic field
   final Profiler this$0;

   Profiler$SubSection(Profiler this$0, String name, int cursor, String baseName, Profiler$Section root) {
      super(this$0, name, cursor);
      this.this$0 = this$0;
      this.baseName = baseName;
      this.root = root;
   }

   Profiler$Section invalidate() {
      this.root.invalidate();
      return super.invalidate();
   }

   public String getBaseName() {
      return this.baseName;
   }

   public void setInfo(String info) {
      this.root.setInfo(info);
      super.setInfo(info);
   }

   Profiler$Section getDelegate() {
      return this.root;
   }

   Profiler$Section start() {
      this.root.start();
      return super.start();
   }

   public Profiler$Section end() {
      this.root.stop();
      return super.end();
   }

   public Profiler$Section next(String name) {
      super.stop();
      return this.root.next(name);
   }
}
