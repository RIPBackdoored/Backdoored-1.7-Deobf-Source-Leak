package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.json.JsonFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CloudShellCredential extends GoogleCredential {
   private static final int ACCESS_TOKEN_INDEX = 2;
   private static final int READ_TIMEOUT_MS = 5000;
   protected static final String GET_AUTH_TOKEN_REQUEST = "2\n[]";
   private final int authPort;
   private final JsonFactory jsonFactory;

   public CloudShellCredential(int authPort, JsonFactory jsonFactory) {
      this.authPort = authPort;
      this.jsonFactory = jsonFactory;
   }

   protected int getAuthPort() {
      return this.authPort;
   }

   protected TokenResponse executeRefreshToken() throws IOException {
      Socket socket = new Socket("localhost", this.getAuthPort());
      socket.setSoTimeout(5000);
      TokenResponse token = new TokenResponse();

      try {
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         out.println("2\n[]");
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         input.readLine();
         Collection messageArray = this.jsonFactory.createJsonParser((Reader)input).parseArray(LinkedList.class, Object.class);
         String accessToken = ((List)messageArray).get(2).toString();
         token.setAccessToken(accessToken);
      } finally {
         socket.close();
      }

      return token;
   }
}
