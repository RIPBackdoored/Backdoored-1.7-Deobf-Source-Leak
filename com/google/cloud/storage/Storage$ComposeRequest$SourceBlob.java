package com.google.cloud.storage;

import java.io.Serializable;

public class Storage$ComposeRequest$SourceBlob implements Serializable {
   private static final long serialVersionUID = 4094962795951990439L;
   final String name;
   final Long generation;

   Storage$ComposeRequest$SourceBlob(String name) {
      this(name, (Long)null);
   }

   Storage$ComposeRequest$SourceBlob(String name, Long generation) {
      this.name = name;
      this.generation = generation;
   }

   public String getName() {
      return this.name;
   }

   public Long getGeneration() {
      return this.generation;
   }
}
