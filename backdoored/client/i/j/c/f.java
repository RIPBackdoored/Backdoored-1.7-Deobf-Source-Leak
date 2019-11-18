package l.c.i.j.c;

import l.c.i.d.a;
import l.c.x.b;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;

public class f extends a {
   public static final int ds;
   public static final boolean dm;

   public f() {
      super("BiomeElement");
   }

   public void k(int var1, int var2, float var3) {
      super.k(var1, var2, var3);
      if (this.ey()) {
         Chunk var4 = mc.world.getChunk(mc.player.getPosition());
         Biome var5 = var4.getBiome(mc.player.getPosition(), mc.world.getBiomeProvider());
         b.k(var5.getBiomeName(), this.a().fqs, this.a().fqm);
      }
   }
}
