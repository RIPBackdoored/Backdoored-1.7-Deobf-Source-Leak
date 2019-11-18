package com.google.api.services.sheets.v4.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import java.util.List;

public final class Editors extends GenericJson {
   @Key
   private Boolean domainUsersCanEdit;
   @Key
   private List groups;
   @Key
   private List users;

   public Boolean getDomainUsersCanEdit() {
      return this.domainUsersCanEdit;
   }

   public Editors setDomainUsersCanEdit(Boolean var1) {
      this.domainUsersCanEdit = var1;
      return this;
   }

   public List getGroups() {
      return this.groups;
   }

   public Editors setGroups(List var1) {
      this.groups = var1;
      return this;
   }

   public List getUsers() {
      return this.users;
   }

   public Editors setUsers(List var1) {
      this.users = var1;
      return this;
   }

   public Editors set(String var1, Object var2) {
      return (Editors)super.set(var1, var2);
   }

   public Editors clone() {
      return (Editors)super.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericJson clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object clone() throws CloneNotSupportedException {
      return this.clone();
   }
}
