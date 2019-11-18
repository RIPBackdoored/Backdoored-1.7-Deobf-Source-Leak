package com.google.cloud.storage;

import java.io.Serializable;
import java.util.Objects;

public abstract class Acl$Entity implements Serializable {
   private static final long serialVersionUID = -2707407252771255840L;
   private final Acl$Entity$Type type;
   private final String value;

   Acl$Entity(Acl$Entity$Type type, String value) {
      this.type = type;
      this.value = value;
   }

   public Acl$Entity$Type getType() {
      return this.type;
   }

   protected String getValue() {
      return this.value;
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj != null && this.getClass() == obj.getClass()) {
         Acl$Entity entity = (Acl$Entity)obj;
         return Objects.equals(this.type, entity.type) && Objects.equals(this.value, entity.value);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.type, this.value});
   }

   public String toString() {
      return this.toPb();
   }

   String toPb() {
      return this.type.name().toLowerCase() + "-" + this.getValue();
   }

   static Acl$Entity fromPb(String entity) {
      if (entity.startsWith("user-")) {
         return new Acl$User(entity.substring(5));
      } else if (entity.equals("allUsers")) {
         return Acl$User.ofAllUsers();
      } else if (entity.equals("allAuthenticatedUsers")) {
         return Acl$User.ofAllAuthenticatedUsers();
      } else if (entity.startsWith("group-")) {
         return new Acl$Group(entity.substring(6));
      } else if (entity.startsWith("domain-")) {
         return new Acl$Domain(entity.substring(7));
      } else if (entity.startsWith("project-")) {
         int idx = entity.indexOf(45, 8);
         String team = entity.substring(8, idx);
         String projectId = entity.substring(idx + 1);
         return new Acl$Project(Acl$Project$ProjectRole.valueOf(team.toUpperCase()), projectId);
      } else {
         return new Acl$RawEntity(entity);
      }
   }
}
