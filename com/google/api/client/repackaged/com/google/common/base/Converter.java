package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Converter implements Function {
   private final boolean handleNullAutomatically;
   @LazyInit
   private transient Converter reverse;

   protected Converter() {
      this(true);
   }

   Converter(boolean handleNullAutomatically) {
      this.handleNullAutomatically = handleNullAutomatically;
   }

   protected abstract Object doForward(Object var1);

   protected abstract Object doBackward(Object var1);

   @Nullable
   @CanIgnoreReturnValue
   public final Object convert(@Nullable Object a) {
      return this.correctedDoForward(a);
   }

   @Nullable
   Object correctedDoForward(@Nullable Object a) {
      if (this.handleNullAutomatically) {
         return a == null ? null : Preconditions.checkNotNull(this.doForward(a));
      } else {
         return this.doForward(a);
      }
   }

   @Nullable
   Object correctedDoBackward(@Nullable Object b) {
      if (this.handleNullAutomatically) {
         return b == null ? null : Preconditions.checkNotNull(this.doBackward(b));
      } else {
         return this.doBackward(b);
      }
   }

   @CanIgnoreReturnValue
   public Iterable convertAll(Iterable fromIterable) {
      Preconditions.checkNotNull(fromIterable, "fromIterable");
      return new Converter$1(this, fromIterable);
   }

   @CanIgnoreReturnValue
   public Converter reverse() {
      Converter result = this.reverse;
      return result == null ? (this.reverse = new Converter$ReverseConverter(this)) : result;
   }

   public final Converter andThen(Converter secondConverter) {
      return this.doAndThen(secondConverter);
   }

   Converter doAndThen(Converter secondConverter) {
      return new Converter$ConverterComposition(this, (Converter)Preconditions.checkNotNull(secondConverter));
   }

   /** @deprecated */
   @Deprecated
   @Nullable
   @CanIgnoreReturnValue
   public final Object apply(@Nullable Object a) {
      return this.convert(a);
   }

   public boolean equals(@Nullable Object object) {
      return super.equals(object);
   }

   public static Converter from(Function forwardFunction, Function backwardFunction) {
      return new Converter$FunctionBasedConverter(forwardFunction, backwardFunction, (Converter$1)null);
   }

   public static Converter identity() {
      return Converter$IdentityConverter.INSTANCE;
   }
}
