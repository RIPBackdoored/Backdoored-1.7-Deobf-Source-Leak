package l.c.u;

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class d extends dw {
   public IBlockState iBlockState;
   public IBlockAccess iBlockAccess;
   public BlockPos blockPos;
   public CallbackInfoReturnable fl;
   public PropertyDirection propertyDirection;
   public static final int fa;

   public d(IBlockState var1, IBlockAccess var2, BlockPos var3, PropertyDirection var4, CallbackInfoReturnable var5) {
      this.iBlockState = var1;
      this.iBlockAccess = var2;
      this.blockPos = var3;
      this.propertyDirection = var4;
      this.fl = var5;
   }
}
