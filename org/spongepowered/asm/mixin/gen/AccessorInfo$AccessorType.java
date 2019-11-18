package org.spongepowered.asm.mixin.gen;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

public abstract class AccessorInfo$AccessorType extends Enum {
   public static final AccessorInfo$AccessorType FIELD_GETTER = new AccessorInfo$AccessorType$1("FIELD_GETTER", 0, ImmutableSet.of("get", "is"));
   public static final AccessorInfo$AccessorType FIELD_SETTER = new AccessorInfo$AccessorType$2("FIELD_SETTER", 1, ImmutableSet.of("set"));
   public static final AccessorInfo$AccessorType METHOD_PROXY = new AccessorInfo$AccessorType$3("METHOD_PROXY", 2, ImmutableSet.of("call", "invoke"));
   private final Set expectedPrefixes;
   // $FF: synthetic field
   private static final AccessorInfo$AccessorType[] $VALUES = new AccessorInfo$AccessorType[]{FIELD_GETTER, FIELD_SETTER, METHOD_PROXY};

   public static AccessorInfo$AccessorType[] values() {
      return (AccessorInfo$AccessorType[])$VALUES.clone();
   }

   public static AccessorInfo$AccessorType valueOf(String name) {
      return (AccessorInfo$AccessorType)Enum.valueOf(AccessorInfo$AccessorType.class, name);
   }

   private AccessorInfo$AccessorType(String var1, int var2, Set expectedPrefixes) {
      super(var1, var2);
      this.expectedPrefixes = expectedPrefixes;
   }

   public boolean isExpectedPrefix(String prefix) {
      return this.expectedPrefixes.contains(prefix);
   }

   public String getExpectedPrefixes() {
      return this.expectedPrefixes.toString();
   }

   abstract AccessorGenerator getGenerator(AccessorInfo var1);

   // $FF: synthetic method
   AccessorInfo$AccessorType(String x0, int x1, Set x2, AccessorInfo$1 x3) {
      this(x0, x1, x2);
   }
}
