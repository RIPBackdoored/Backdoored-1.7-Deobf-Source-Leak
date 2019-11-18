package com.google.api.services.sheets.v4;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

public class Sheets extends AbstractGoogleJsonClient {
   public static final String DEFAULT_ROOT_URL = "https://sheets.googleapis.com/";
   public static final String DEFAULT_SERVICE_PATH = "";
   public static final String DEFAULT_BATCH_PATH = "batch";
   public static final String DEFAULT_BASE_URL = "https://sheets.googleapis.com/";

   public Sheets(HttpTransport var1, JsonFactory var2, HttpRequestInitializer var3) {
      this(new Sheets$Builder(var1, var2, var3));
   }

   Sheets(Sheets$Builder var1) {
      super(var1);
   }

   protected void initialize(AbstractGoogleClientRequest var1) throws IOException {
      super.initialize(var1);
   }

   public Sheets$Spreadsheets spreadsheets() {
      return new Sheets$Spreadsheets(this);
   }

   static {
      Preconditions.checkState(GoogleUtils.MAJOR_VERSION == 1 && GoogleUtils.MINOR_VERSION >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.25.0 of the Google Sheets API library.", GoogleUtils.VERSION);
   }
}
