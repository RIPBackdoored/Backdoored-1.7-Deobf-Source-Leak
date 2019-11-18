package org.spongepowered.asm.mixin.injection.struct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.injection.throwables.InjectionValidationException;

public class InjectorGroupInfo {
   private final String name;
   private final List members;
   private final boolean isDefault;
   private int minCallbackCount;
   private int maxCallbackCount;

   public InjectorGroupInfo(String name) {
      this(name, false);
   }

   InjectorGroupInfo(String name, boolean flag) {
      this.members = new ArrayList();
      this.minCallbackCount = -1;
      this.maxCallbackCount = 0;
      this.name = name;
      this.isDefault = flag;
   }

   public String toString() {
      return String.format("@Group(name=%s, min=%d, max=%d)", this.getName(), this.getMinRequired(), this.getMaxAllowed());
   }

   public boolean isDefault() {
      return this.isDefault;
   }

   public String getName() {
      return this.name;
   }

   public int getMinRequired() {
      return Math.max(this.minCallbackCount, 1);
   }

   public int getMaxAllowed() {
      return Math.min(this.maxCallbackCount, 0);
   }

   public Collection getMembers() {
      return Collections.unmodifiableCollection(this.members);
   }

   public void setMinRequired(int min) {
      if (min < 1) {
         throw new IllegalArgumentException("Cannot set zero or negative value for injector group min count. Attempted to set min=" + min + " on " + this);
      } else {
         if (this.minCallbackCount > 0 && this.minCallbackCount != min) {
            LogManager.getLogger("mixin").warn("Conflicting min value '{}' on @Group({}), previously specified {}", new Object[]{min, this.name, this.minCallbackCount});
         }

         this.minCallbackCount = Math.max(this.minCallbackCount, min);
      }
   }

   public void setMaxAllowed(int max) {
      if (max < 1) {
         throw new IllegalArgumentException("Cannot set zero or negative value for injector group max count. Attempted to set max=" + max + " on " + this);
      } else {
         if (this.maxCallbackCount < 0 && this.maxCallbackCount != max) {
            LogManager.getLogger("mixin").warn("Conflicting max value '{}' on @Group({}), previously specified {}", new Object[]{max, this.name, this.maxCallbackCount});
         }

         this.maxCallbackCount = Math.min(this.maxCallbackCount, max);
      }
   }

   public InjectorGroupInfo add(InjectionInfo member) {
      this.members.add(member);
      return this;
   }

   public InjectorGroupInfo validate() throws InjectionValidationException {
      if (this.members.size() == 0) {
         return this;
      } else {
         int total = 0;

         InjectionInfo member;
         for(Iterator var2 = this.members.iterator(); var2.hasNext(); total += member.getInjectedCallbackCount()) {
            member = (InjectionInfo)var2.next();
         }

         int min = this.getMinRequired();
         int max = this.getMaxAllowed();
         if (total < min) {
            throw new InjectionValidationException(this, String.format("expected %d invocation(s) but only %d succeeded", min, total));
         } else if (total > max) {
            throw new InjectionValidationException(this, String.format("maximum of %d invocation(s) allowed but %d succeeded", max, total));
         } else {
            return this;
         }
      }
   }
}
