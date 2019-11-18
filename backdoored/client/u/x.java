package l.c.u;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class x extends dw {
   public final IBlockState iBlockState;
   public final IBlockAccess iBlockAccess;
   public final BlockPos blockPos;
   public final EnumFacing enumFacing;
   public static final int pc;
   public static final boolean po;

   public x(IBlockState var1, IBlockAccess var2, BlockPos var3, EnumFacing var4) {
      this.iBlockState = var1;
      this.iBlockAccess = var2;
      this.blockPos = var3;
      this.enumFacing = var4;
   }

   public boolean isCancelable() {
      return true;
   }
}
