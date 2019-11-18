package org.spongepowered.tools.obfuscation.mirror;

import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeKind;

// $FF: synthetic class
class TypeUtils$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$javax$lang$model$type$TypeKind;
   // $FF: synthetic field
   static final int[] $SwitchMap$javax$lang$model$element$Modifier = new int[Modifier.values().length];

   static {
      try {
         $SwitchMap$javax$lang$model$element$Modifier[Modifier.PUBLIC.ordinal()] = 1;
      } catch (NoSuchFieldError var16) {
      }

      try {
         $SwitchMap$javax$lang$model$element$Modifier[Modifier.PROTECTED.ordinal()] = 2;
      } catch (NoSuchFieldError var15) {
      }

      try {
         $SwitchMap$javax$lang$model$element$Modifier[Modifier.PRIVATE.ordinal()] = 3;
      } catch (NoSuchFieldError var14) {
      }

      $SwitchMap$javax$lang$model$type$TypeKind = new int[TypeKind.values().length];

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.ARRAY.ordinal()] = 1;
      } catch (NoSuchFieldError var13) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.DECLARED.ordinal()] = 2;
      } catch (NoSuchFieldError var12) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.TYPEVAR.ordinal()] = 3;
      } catch (NoSuchFieldError var11) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.ERROR.ordinal()] = 4;
      } catch (NoSuchFieldError var10) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.BOOLEAN.ordinal()] = 5;
      } catch (NoSuchFieldError var9) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.BYTE.ordinal()] = 6;
      } catch (NoSuchFieldError var8) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.CHAR.ordinal()] = 7;
      } catch (NoSuchFieldError var7) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.DOUBLE.ordinal()] = 8;
      } catch (NoSuchFieldError var6) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.FLOAT.ordinal()] = 9;
      } catch (NoSuchFieldError var5) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.INT.ordinal()] = 10;
      } catch (NoSuchFieldError var4) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.LONG.ordinal()] = 11;
      } catch (NoSuchFieldError var3) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.SHORT.ordinal()] = 12;
      } catch (NoSuchFieldError var2) {
      }

      try {
         $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.VOID.ordinal()] = 13;
      } catch (NoSuchFieldError var1) {
      }

   }
}
