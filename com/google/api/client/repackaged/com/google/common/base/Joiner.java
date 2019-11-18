package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
public class Joiner {
   private final String separator;

   public static Joiner on(String separator) {
      return new Joiner(separator);
   }

   public static Joiner on(char separator) {
      return new Joiner(String.valueOf(separator));
   }

   private Joiner(String separator) {
      this.separator = (String)Preconditions.checkNotNull(separator);
   }

   private Joiner(Joiner prototype) {
      this.separator = prototype.separator;
   }

   @CanIgnoreReturnValue
   public Appendable appendTo(Appendable appendable, Iterable parts) throws IOException {
      return this.appendTo(appendable, parts.iterator());
   }

   @CanIgnoreReturnValue
   public Appendable appendTo(Appendable appendable, Iterator parts) throws IOException {
      Preconditions.checkNotNull(appendable);
      if (parts.hasNext()) {
         appendable.append(this.toString(parts.next()));

         while(parts.hasNext()) {
            appendable.append(this.separator);
            appendable.append(this.toString(parts.next()));
         }
      }

      return appendable;
   }

   @CanIgnoreReturnValue
   public final Appendable appendTo(Appendable appendable, Object[] parts) throws IOException {
      return this.appendTo((Appendable)appendable, (Iterable)Arrays.asList(parts));
   }

   @CanIgnoreReturnValue
   public final Appendable appendTo(Appendable appendable, @Nullable Object first, @Nullable Object second, Object... rest) throws IOException {
      return this.appendTo(appendable, iterable(first, second, rest));
   }

   @CanIgnoreReturnValue
   public final StringBuilder appendTo(StringBuilder builder, Iterable parts) {
      return this.appendTo(builder, parts.iterator());
   }

   @CanIgnoreReturnValue
   public final StringBuilder appendTo(StringBuilder builder, Iterator parts) {
      try {
         this.appendTo((Appendable)builder, (Iterator)parts);
      } catch (IOException var4) {
         throw new AssertionError(var4);
      }

      return builder;
   }

   @CanIgnoreReturnValue
   public final StringBuilder appendTo(StringBuilder builder, Object[] parts) {
      return this.appendTo((StringBuilder)builder, (Iterable)Arrays.asList(parts));
   }

   @CanIgnoreReturnValue
   public final StringBuilder appendTo(StringBuilder builder, @Nullable Object first, @Nullable Object second, Object... rest) {
      return this.appendTo(builder, iterable(first, second, rest));
   }

   public final String join(Iterable parts) {
      return this.join(parts.iterator());
   }

   public final String join(Iterator parts) {
      return this.appendTo(new StringBuilder(), parts).toString();
   }

   public final String join(Object[] parts) {
      return this.join((Iterable)Arrays.asList(parts));
   }

   public final String join(@Nullable Object first, @Nullable Object second, Object... rest) {
      return this.join(iterable(first, second, rest));
   }

   public Joiner useForNull(String nullText) {
      Preconditions.checkNotNull(nullText);
      return new Joiner$1(this, this, nullText);
   }

   public Joiner skipNulls() {
      return new Joiner$2(this, this);
   }

   public Joiner$MapJoiner withKeyValueSeparator(char keyValueSeparator) {
      return this.withKeyValueSeparator(String.valueOf(keyValueSeparator));
   }

   public Joiner$MapJoiner withKeyValueSeparator(String keyValueSeparator) {
      return new Joiner$MapJoiner(this, keyValueSeparator, (Joiner$1)null);
   }

   CharSequence toString(Object part) {
      Preconditions.checkNotNull(part);
      return (CharSequence)(part instanceof CharSequence ? (CharSequence)part : part.toString());
   }

   private static Iterable iterable(Object first, Object second, Object[] rest) {
      Preconditions.checkNotNull(rest);
      return new Joiner$3(rest, first, second);
   }

   // $FF: synthetic method
   Joiner(Joiner x0, Joiner$1 x1) {
      this(x0);
   }

   // $FF: synthetic method
   static String access$100(Joiner x0) {
      return x0.separator;
   }
}
