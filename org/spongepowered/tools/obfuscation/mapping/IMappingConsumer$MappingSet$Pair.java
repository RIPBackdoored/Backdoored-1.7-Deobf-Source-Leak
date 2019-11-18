package org.spongepowered.tools.obfuscation.mapping;

import com.google.common.base.Objects;
import org.spongepowered.asm.obfuscation.mapping.IMapping;

public class IMappingConsumer$MappingSet$Pair {
   public final IMapping from;
   public final IMapping to;

   public IMappingConsumer$MappingSet$Pair(IMapping from, IMapping to) {
      this.from = from;
      this.to = to;
   }

   public boolean equals(Object obj) {
      if (!(obj instanceof IMappingConsumer$MappingSet$Pair)) {
         return false;
      } else {
         IMappingConsumer$MappingSet$Pair other = (IMappingConsumer$MappingSet$Pair)obj;
         return Objects.equal(this.from, other.from) && Objects.equal(this.to, other.to);
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.from, this.to});
   }

   public String toString() {
      return String.format("%s -> %s", this.from, this.to);
   }
}
