package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true
)
public abstract class Optional implements Serializable {
   private static final long serialVersionUID = 0L;

   public static Optional absent() {
      return Absent.withType();
   }

   public static Optional of(Object reference) {
      return new Present(Preconditions.checkNotNull(reference));
   }

   public static Optional fromNullable(@Nullable Object nullableReference) {
      return (Optional)(nullableReference == null ? absent() : new Present(nullableReference));
   }

   Optional() {
   }

   public abstract boolean isPresent();

   public abstract Object get();

   public abstract Object or(Object var1);

   public abstract Optional or(Optional var1);

   @Beta
   public abstract Object or(Supplier var1);

   @Nullable
   public abstract Object orNull();

   public abstract Set asSet();

   public abstract Optional transform(Function var1);

   public abstract boolean equals(@Nullable Object var1);

   public abstract int hashCode();

   public abstract String toString();

   @Beta
   public static Iterable presentInstances(Iterable optionals) {
      Preconditions.checkNotNull(optionals);
      return new Optional$1(optionals);
   }
}
