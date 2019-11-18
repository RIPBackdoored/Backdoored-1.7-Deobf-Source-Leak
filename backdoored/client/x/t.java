package l.c.x;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public final class t {
   public static final boolean pf;
   public static final int pq;
   public static final boolean pt;

   public static boolean f(ItemStack var0) {
      return var0.hasTagCompound();
   }

   public static void q(ItemStack var0) {
      if (!f(var0)) {
         k(var0, new NBTTagCompound());
      }

   }

   public static void k(ItemStack var0, NBTTagCompound var1) {
      var0.setTagCompound(var1);
   }

   public static NBTTagCompound t(ItemStack var0) {
      q(var0);
      return var0.getTagCompound();
   }

   public static void k(ItemStack var0, String var1, boolean var2) {
      t(var0).setBoolean(var1, var2);
   }

   public static void k(ItemStack var0, String var1, byte var2) {
      t(var0).setByte(var1, var2);
   }

   public static void k(ItemStack var0, String var1, short var2) {
      t(var0).setShort(var1, var2);
   }

   public static void k(ItemStack var0, String var1, int var2) {
      t(var0).setInteger(var1, var2);
   }

   public static void k(ItemStack var0, String var1, long var2) {
      t(var0).setLong(var1, var2);
   }

   public static void k(ItemStack var0, String var1, float var2) {
      t(var0).setFloat(var1, var2);
   }

   public static void k(ItemStack var0, String var1, double var2) {
      t(var0).setDouble(var1, var2);
   }

   public static void k(ItemStack var0, String var1, NBTTagCompound var2) {
      if (!var1.equalsIgnoreCase("ench")) {
         t(var0).setTag(var1, var2);
      }

   }

   public static void k(ItemStack var0, String var1, String var2) {
      t(var0).setString(var1, var2);
   }

   public static void k(ItemStack var0, String var1, NBTTagList var2) {
      t(var0).setTag(var1, var2);
   }

   public static boolean k(ItemStack var0, String var1) {
      if (t(var0).hasKey(var1)) {
         boolean var10000 = true;
      }

      return false;
   }

   /** @deprecated */
   @Deprecated
   public static boolean f(ItemStack var0, String var1) {
      return k(var0, var1);
   }

   public static boolean f(ItemStack var0, String var1, boolean var2) {
      if (k(var0, var1)) {
         t(var0).getBoolean(var1);
      }

      return var2;
   }

   public static byte f(ItemStack var0, String var1, byte var2) {
      if (k(var0, var1)) {
         t(var0).getByte(var1);
      }

      return var2;
   }

   public static short f(ItemStack var0, String var1, short var2) {
      if (k(var0, var1)) {
         t(var0).getShort(var1);
      }

      return var2;
   }

   public static int f(ItemStack var0, String var1, int var2) {
      if (k(var0, var1)) {
         t(var0).getInteger(var1);
      }

      return var2;
   }

   public static long f(ItemStack var0, String var1, long var2) {
      if (k(var0, var1)) {
         t(var0).getLong(var1);
      }

      return var2;
   }

   public static float f(ItemStack var0, String var1, float var2) {
      if (k(var0, var1)) {
         t(var0).getFloat(var1);
      }

      return var2;
   }

   public static double f(ItemStack var0, String var1, double var2) {
      if (k(var0, var1)) {
         t(var0).getDouble(var1);
      }

      return var2;
   }

   public static NBTTagCompound q(ItemStack var0, String var1, boolean var2) {
      if (k(var0, var1)) {
         t(var0).getCompoundTag(var1);
      }

      if (var2) {
         Object var10000 = null;
      }

      return new NBTTagCompound();
   }

   public static String f(ItemStack var0, String var1, String var2) {
      if (k(var0, var1)) {
         t(var0).getString(var1);
      }

      return var2;
   }

   public static NBTTagList k(ItemStack var0, String var1, int var2, boolean var3) {
      if (k(var0, var1)) {
         t(var0).getTagList(var1, var2);
      }

      if (var3) {
         Object var10000 = null;
      }

      return new NBTTagList();
   }
}
