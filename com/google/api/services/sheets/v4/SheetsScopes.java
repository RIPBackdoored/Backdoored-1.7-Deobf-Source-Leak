package com.google.api.services.sheets.v4;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SheetsScopes {
   public static final String DRIVE = "https://www.googleapis.com/auth/drive";
   public static final String DRIVE_FILE = "https://www.googleapis.com/auth/drive.file";
   public static final String DRIVE_READONLY = "https://www.googleapis.com/auth/drive.readonly";
   public static final String SPREADSHEETS = "https://www.googleapis.com/auth/spreadsheets";
   public static final String SPREADSHEETS_READONLY = "https://www.googleapis.com/auth/spreadsheets.readonly";

   public static Set all() {
      HashSet var0 = new HashSet();
      var0.add("https://www.googleapis.com/auth/drive");
      var0.add("https://www.googleapis.com/auth/drive.file");
      var0.add("https://www.googleapis.com/auth/drive.readonly");
      var0.add("https://www.googleapis.com/auth/spreadsheets");
      var0.add("https://www.googleapis.com/auth/spreadsheets.readonly");
      return Collections.unmodifiableSet(var0);
   }

   private SheetsScopes() {
   }
}
