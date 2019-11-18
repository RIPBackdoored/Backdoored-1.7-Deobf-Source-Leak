package com.google.cloud.storage;

public final class Acl$Project extends Acl$Entity {
   private static final long serialVersionUID = 7933776866530023027L;
   private final Acl$Project$ProjectRole projectRole;
   private final String projectId;

   public Acl$Project(Acl$Project$ProjectRole projectRole, String projectId) {
      super(Acl$Entity$Type.PROJECT, projectRole.name().toLowerCase() + "-" + projectId);
      this.projectRole = projectRole;
      this.projectId = projectId;
   }

   public Acl$Project$ProjectRole getProjectRole() {
      return this.projectRole;
   }

   public String getProjectId() {
      return this.projectId;
   }
}
