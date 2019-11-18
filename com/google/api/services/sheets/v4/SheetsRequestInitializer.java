package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;
import java.io.IOException;

public class SheetsRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
   public SheetsRequestInitializer() {
   }

   public SheetsRequestInitializer(String var1) {
      super(var1);
   }

   public SheetsRequestInitializer(String var1, String var2) {
      super(var1, var2);
   }

   public final void initializeJsonRequest(AbstractGoogleJsonClientRequest var1) throws IOException {
      super.initializeJsonRequest(var1);
      this.initializeSheetsRequest((SheetsRequest)var1);
   }

   protected void initializeSheetsRequest(SheetsRequest var1) throws IOException {
   }
}
