package org.reflections.util;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.reflections.ReflectionsException;

public class FilterBuilder implements Predicate {
   private final List chain;

   public FilterBuilder() {
      this.chain = Lists.newArrayList();
   }

   private FilterBuilder(Iterable filters) {
      this.chain = Lists.newArrayList(filters);
   }

   public FilterBuilder include(String regex) {
      return this.add(new FilterBuilder$Include(regex));
   }

   public FilterBuilder exclude(String regex) {
      this.add(new FilterBuilder$Exclude(regex));
      return this;
   }

   public FilterBuilder add(Predicate filter) {
      this.chain.add(filter);
      return this;
   }

   public FilterBuilder includePackage(Class aClass) {
      return this.add(new FilterBuilder$Include(packageNameRegex(aClass)));
   }

   public FilterBuilder excludePackage(Class aClass) {
      return this.add(new FilterBuilder$Exclude(packageNameRegex(aClass)));
   }

   public FilterBuilder includePackage(String... prefixes) {
      String[] var2 = prefixes;
      int var3 = prefixes.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String prefix = var2[var4];
         this.add(new FilterBuilder$Include(prefix(prefix)));
      }

      return this;
   }

   public FilterBuilder excludePackage(String prefix) {
      return this.add(new FilterBuilder$Exclude(prefix(prefix)));
   }

   private static String packageNameRegex(Class aClass) {
      return prefix(aClass.getPackage().getName() + ".");
   }

   public static String prefix(String qualifiedName) {
      return qualifiedName.replace(".", "\\.") + ".*";
   }

   public String toString() {
      return Joiner.on(", ").join(this.chain);
   }

   public boolean apply(String regex) {
      boolean accept = this.chain == null || this.chain.isEmpty() || this.chain.get(0) instanceof FilterBuilder$Exclude;
      if (this.chain != null) {
         Iterator var3 = this.chain.iterator();

         Predicate filter;
         do {
            do {
               do {
                  if (!var3.hasNext()) {
                     return accept;
                  }

                  filter = (Predicate)var3.next();
               } while(accept && filter instanceof FilterBuilder$Include);
            } while(!accept && filter instanceof FilterBuilder$Exclude);

            accept = filter.apply(regex);
         } while(accept || !(filter instanceof FilterBuilder$Exclude));
      }

      return accept;
   }

   public static FilterBuilder parse(String includeExcludeString) {
      List filters = new ArrayList();
      if (!Utils.isEmpty(includeExcludeString)) {
         String[] var2 = includeExcludeString.split(",");
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String string = var2[var4];
            String trimmed = string.trim();
            char prefix = trimmed.charAt(0);
            String pattern = trimmed.substring(1);
            Object filter;
            switch(prefix) {
            case '+':
               filter = new FilterBuilder$Include(pattern);
               break;
            case '-':
               filter = new FilterBuilder$Exclude(pattern);
               break;
            default:
               throw new ReflectionsException("includeExclude should start with either + or -");
            }

            filters.add(filter);
         }

         return new FilterBuilder(filters);
      } else {
         return new FilterBuilder();
      }
   }

   public static FilterBuilder parsePackages(String includeExcludeString) {
      List filters = new ArrayList();
      if (!Utils.isEmpty(includeExcludeString)) {
         String[] var2 = includeExcludeString.split(",");
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String string = var2[var4];
            String trimmed = string.trim();
            char prefix = trimmed.charAt(0);
            String pattern = trimmed.substring(1);
            if (!pattern.endsWith(".")) {
               pattern = pattern + ".";
            }

            pattern = prefix(pattern);
            Object filter;
            switch(prefix) {
            case '+':
               filter = new FilterBuilder$Include(pattern);
               break;
            case '-':
               filter = new FilterBuilder$Exclude(pattern);
               break;
            default:
               throw new ReflectionsException("includeExclude should start with either + or -");
            }

            filters.add(filter);
         }

         return new FilterBuilder(filters);
      } else {
         return new FilterBuilder();
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean apply(Object var1) {
      return this.apply((String)var1);
   }
}
