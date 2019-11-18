package l.c.v;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import l.c.x.d.a;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

public class b extends d {
   public static final boolean el;
   public static final int eh;
   public static final boolean ea;

   public b() {
      super("fakeplayer");
   }

   public boolean k(String[] var1) {
      try {
         boolean var10000;
         if (var1.length < 1) {
            var10000 = false;
            return var10000;
         } else {
            UUID var2 = UUID.fromString(l.c.n.h.p(var1[0]));
            System.out.print("UUID LOCATED: " + var2.toString());
            EntityOtherPlayerMP var3 = new EntityOtherPlayerMP(this.mc.world, new GameProfile(var2, var1[0]));
            var3.copyLocationAndAnglesFrom(this.mc.player);
            NBTTagCompound var4 = this.mc.player.writeToNBT(new NBTTagCompound());
            var3.readFromNBT(var4);
            int[] var5 = new int[]{-21, -69, -911, -420, -666, -2003};
            int var7 = var5.length;
            byte var8 = 0;
            if (var8 < var7) {
               int var9 = var5[var8];
               if (this.mc.world.getEntityByID(var9) == null) {
                  this.mc.world.addEntityToWorld(var9, var3);
                  var10000 = true;
                  return var10000;
               }

               int var15 = var8 + 1;
            }

            byte var6 = -1;
            if (var6 > -400) {
               if (this.mc.world.getEntityByID(var6) == null) {
                  this.mc.world.addEntityToWorld(var6, var3);
                  var10000 = true;
                  return var10000;
               }

               int var14 = var6 - 1;
            }

            a.m("No entity ids available", "gold");
            var10000 = false;
            return var10000;
         }
      } catch (Exception var13) {
         a.m(var13.getMessage(), "gold");
         var13.printStackTrace();
         return false;
      }
   }

   public String v() {
      return "-fakeplayer DanTDM";
   }
}
