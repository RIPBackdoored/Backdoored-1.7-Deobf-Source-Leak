package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@GwtCompatible(
   emulated = true
)
public final class Splitter {
   private final CharMatcher trimmer;
   private final boolean omitEmptyStrings;
   private final Splitter$Strategy strategy;
   private final int limit;

   private Splitter(Splitter$Strategy strategy) {
      this(strategy, false, CharMatcher.none(), 0);
   }

   private Splitter(Splitter$Strategy strategy, boolean omitEmptyStrings, CharMatcher trimmer, int limit) {
      this.strategy = strategy;
      this.omitEmptyStrings = omitEmptyStrings;
      this.trimmer = trimmer;
      this.limit = limit;
   }

   public static Splitter on(char separator) {
      return on(CharMatcher.is(separator));
   }

   public static Splitter on(CharMatcher separatorMatcher) {
      Preconditions.checkNotNull(separatorMatcher);
      return new Splitter(new Splitter$1(separatorMatcher));
   }

   public static Splitter on(String separator) {
      Preconditions.checkArgument(separator.length() != 0, "The separator may not be the empty string.");
      return separator.length() == 1 ? on(separator.charAt(0)) : new Splitter(new Splitter$2(separator));
   }

   @GwtIncompatible
   public static Splitter on(Pattern separatorPattern) {
      return on((CommonPattern)(new JdkPattern(separatorPattern)));
   }

   private static Splitter on(CommonPattern separatorPattern) {
      Preconditions.checkArgument(!separatorPattern.matcher("").matches(), "The pattern may not match the empty string: %s", (Object)separatorPattern);
      return new Splitter(new Splitter$3(separatorPattern));
   }

   @GwtIncompatible
   public static Splitter onPattern(String separatorPattern) {
      return on(Platform.compilePattern(separatorPattern));
   }

   public static Splitter fixedLength(int length) {
      Preconditions.checkArgument(length > 0, "The length may not be less than 1");
      return new Splitter(new Splitter$4(length));
   }

   public Splitter omitEmptyStrings() {
      return new Splitter(this.strategy, true, this.trimmer, this.limit);
   }

   public Splitter limit(int limit) {
      Preconditions.checkArgument(limit > 0, "must be greater than zero: %s", limit);
      return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, limit);
   }

   public Splitter trimResults() {
      return this.trimResults(CharMatcher.whitespace());
   }

   public Splitter trimResults(CharMatcher trimmer) {
      Preconditions.checkNotNull(trimmer);
      return new Splitter(this.strategy, this.omitEmptyStrings, trimmer, this.limit);
   }

   public Iterable split(CharSequence sequence) {
      Preconditions.checkNotNull(sequence);
      return new Splitter$5(this, sequence);
   }

   private Iterator splittingIterator(CharSequence sequence) {
      return this.strategy.iterator(this, sequence);
   }

   @Beta
   public List splitToList(CharSequence sequence) {
      Preconditions.checkNotNull(sequence);
      Iterator iterator = this.splittingIterator(sequence);
      ArrayList result = new ArrayList();

      while(iterator.hasNext()) {
         result.add(iterator.next());
      }

      return Collections.unmodifiableList(result);
   }

   @Beta
   public Splitter$MapSplitter withKeyValueSeparator(String separator) {
      return this.withKeyValueSeparator(on(separator));
   }

   @Beta
   public Splitter$MapSplitter withKeyValueSeparator(char separator) {
      return this.withKeyValueSeparator(on(separator));
   }

   @Beta
   public Splitter$MapSplitter withKeyValueSeparator(Splitter keyValueSplitter) {
      return new Splitter$MapSplitter(this, keyValueSplitter, (Splitter$1)null);
   }

   // $FF: synthetic method
   static Iterator access$000(Splitter x0, CharSequence x1) {
      return x0.splittingIterator(x1);
   }

   // $FF: synthetic method
   static CharMatcher access$200(Splitter x0) {
      return x0.trimmer;
   }

   // $FF: synthetic method
   static boolean access$300(Splitter x0) {
      return x0.omitEmptyStrings;
   }

   // $FF: synthetic method
   static int access$400(Splitter x0) {
      return x0.limit;
   }
}
