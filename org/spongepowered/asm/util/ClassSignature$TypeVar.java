package org.spongepowered.asm.util;

class ClassSignature$TypeVar implements Comparable {
   private final String originalName;
   private String currentName;

   ClassSignature$TypeVar(String name) {
      this.currentName = this.originalName = name;
   }

   public int compareTo(ClassSignature$TypeVar other) {
      return this.currentName.compareTo(other.currentName);
   }

   public String toString() {
      return this.currentName;
   }

   String getOriginalName() {
      return this.originalName;
   }

   void rename(String name) {
      this.currentName = name;
   }

   public boolean matches(String originalName) {
      return this.originalName.equals(originalName);
   }

   public boolean equals(Object obj) {
      return this.currentName.equals(obj);
   }

   public int hashCode() {
      return this.currentName.hashCode();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compareTo(Object var1) {
      return this.compareTo((ClassSignature$TypeVar)var1);
   }
}
