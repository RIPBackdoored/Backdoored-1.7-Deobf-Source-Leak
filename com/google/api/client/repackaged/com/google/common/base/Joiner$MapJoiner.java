package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class Joiner$MapJoiner {
   private final Joiner joiner;
   private final String keyValueSeparator;

   private Joiner$MapJoiner(Joiner joiner, String keyValueSeparator) {
      this.joiner = joiner;
      this.keyValueSeparator = (String)Preconditions.checkNotNull(keyValueSeparator);
   }

   @CanIgnoreReturnValue
   public Appendable appendTo(Appendable appendable, Map map) throws IOException {
      return this.appendTo((Appendable)appendable, (Iterable)map.entrySet());
   }

   @CanIgnoreReturnValue
   public StringBuilder appendTo(StringBuilder builder, Map map) {
      return this.appendTo((StringBuilder)builder, (Iterable)map.entrySet());
   }

   public String join(Map map) {
      return this.join((Iterable)map.entrySet());
   }

   @Beta
   @CanIgnoreReturnValue
   public Appendable appendTo(Appendable appendable, Iterable entries) throws IOException {
      return this.appendTo(appendable, entries.iterator());
   }

   @Beta
   @CanIgnoreReturnValue
   public Appendable appendTo(Appendable appendable, Iterator parts) throws IOException {
      Preconditions.checkNotNull(appendable);
      if (parts.hasNext()) {
         Entry entry = (Entry)parts.next();
         appendable.append(this.joiner.toString(entry.getKey()));
         appendable.append(this.keyValueSeparator);
         appendable.append(this.joiner.toString(entry.getValue()));

         while(parts.hasNext()) {
            appendable.append(Joiner.access$100(this.joiner));
            Entry e = (Entry)parts.next();
            appendable.append(this.joiner.toString(e.getKey()));
            appendable.append(this.keyValueSeparator);
            appendable.append(this.joiner.toString(e.getValue()));
         }
      }

      return appendable;
   }

   @Beta
   @CanIgnoreReturnValue
   public StringBuilder appendTo(StringBuilder builder, Iterable entries) {
      return this.appendTo(builder, entries.iterator());
   }

   @Beta
   @CanIgnoreReturnValue
   public StringBuilder appendTo(StringBuilder builder, Iterator entries) {
      try {
         this.appendTo((Appendable)builder, (Iterator)entries);
      } catch (IOException var4) {
         throw new AssertionError(var4);
      }

      return builder;
   }

   @Beta
   public String join(Iterable entries) {
      return this.join(entries.iterator());
   }

   @Beta
   public String join(Iterator entries) {
      return this.appendTo(new StringBuilder(), entries).toString();
   }

   public Joiner$MapJoiner useForNull(String nullText) {
      return new Joiner$MapJoiner(this.joiner.useForNull(nullText), this.keyValueSeparator);
   }

   // $FF: synthetic method
   Joiner$MapJoiner(Joiner x0, String x1, Joiner$1 x2) {
      this(x0, x1);
   }
}
