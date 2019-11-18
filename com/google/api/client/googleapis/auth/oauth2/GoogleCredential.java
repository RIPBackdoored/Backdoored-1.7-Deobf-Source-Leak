package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.Credential$Builder;
import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebSignature$Header;
import com.google.api.client.json.webtoken.JsonWebToken$Payload;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.PemReader;
import com.google.api.client.util.PemReader$Section;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collection;
import java.util.Collections;

public class GoogleCredential extends Credential {
   static final String USER_FILE_TYPE = "authorized_user";
   static final String SERVICE_ACCOUNT_FILE_TYPE = "service_account";
   @Beta
   private static DefaultCredentialProvider defaultCredentialProvider = new DefaultCredentialProvider();
   private String serviceAccountId;
   private String serviceAccountProjectId;
   private Collection serviceAccountScopes;
   private PrivateKey serviceAccountPrivateKey;
   private String serviceAccountPrivateKeyId;
   private String serviceAccountUser;

   @Beta
   @Beta
   public static GoogleCredential getApplicationDefault() throws IOException {
      return getApplicationDefault(Utils.getDefaultTransport(), Utils.getDefaultJsonFactory());
   }

   @Beta
   @Beta
   public static GoogleCredential getApplicationDefault(HttpTransport transport, JsonFactory jsonFactory) throws IOException {
      Preconditions.checkNotNull(transport);
      Preconditions.checkNotNull(jsonFactory);
      return defaultCredentialProvider.getDefaultCredential(transport, jsonFactory);
   }

   @Beta
   @Beta
   public static GoogleCredential fromStream(InputStream credentialStream) throws IOException {
      return fromStream(credentialStream, Utils.getDefaultTransport(), Utils.getDefaultJsonFactory());
   }

   @Beta
   @Beta
   public static GoogleCredential fromStream(InputStream credentialStream, HttpTransport transport, JsonFactory jsonFactory) throws IOException {
      Preconditions.checkNotNull(credentialStream);
      Preconditions.checkNotNull(transport);
      Preconditions.checkNotNull(jsonFactory);
      JsonObjectParser parser = new JsonObjectParser(jsonFactory);
      GenericJson fileContents = (GenericJson)parser.parseAndClose(credentialStream, OAuth2Utils.UTF_8, GenericJson.class);
      String fileType = (String)fileContents.get("type");
      if (fileType == null) {
         throw new IOException("Error reading credentials from stream, 'type' field not specified.");
      } else if ("authorized_user".equals(fileType)) {
         return fromStreamUser(fileContents, transport, jsonFactory);
      } else if ("service_account".equals(fileType)) {
         return fromStreamServiceAccount(fileContents, transport, jsonFactory);
      } else {
         throw new IOException(String.format("Error reading credentials from stream, 'type' value '%s' not recognized. Expecting '%s' or '%s'.", fileType, "authorized_user", "service_account"));
      }
   }

   public GoogleCredential() {
      this(new GoogleCredential$Builder());
   }

   protected GoogleCredential(GoogleCredential$Builder builder) {
      super((Credential$Builder)builder);
      if (builder.serviceAccountPrivateKey == null) {
         Preconditions.checkArgument(builder.serviceAccountId == null && builder.serviceAccountScopes == null && builder.serviceAccountUser == null);
      } else {
         this.serviceAccountId = (String)Preconditions.checkNotNull(builder.serviceAccountId);
         this.serviceAccountProjectId = builder.serviceAccountProjectId;
         this.serviceAccountScopes = (Collection)(builder.serviceAccountScopes == null ? Collections.emptyList() : Collections.unmodifiableCollection(builder.serviceAccountScopes));
         this.serviceAccountPrivateKey = builder.serviceAccountPrivateKey;
         this.serviceAccountPrivateKeyId = builder.serviceAccountPrivateKeyId;
         this.serviceAccountUser = builder.serviceAccountUser;
      }

   }

   public GoogleCredential setAccessToken(String accessToken) {
      return (GoogleCredential)super.setAccessToken(accessToken);
   }

   public GoogleCredential setRefreshToken(String refreshToken) {
      if (refreshToken != null) {
         Preconditions.checkArgument(this.getJsonFactory() != null && this.getTransport() != null && this.getClientAuthentication() != null, "Please use the Builder and call setJsonFactory, setTransport and setClientSecrets");
      }

      return (GoogleCredential)super.setRefreshToken(refreshToken);
   }

   public GoogleCredential setExpirationTimeMilliseconds(Long expirationTimeMilliseconds) {
      return (GoogleCredential)super.setExpirationTimeMilliseconds(expirationTimeMilliseconds);
   }

   public GoogleCredential setExpiresInSeconds(Long expiresIn) {
      return (GoogleCredential)super.setExpiresInSeconds(expiresIn);
   }

   public GoogleCredential setFromTokenResponse(TokenResponse tokenResponse) {
      return (GoogleCredential)super.setFromTokenResponse(tokenResponse);
   }

   @Beta
   @Beta
   protected TokenResponse executeRefreshToken() throws IOException {
      if (this.serviceAccountPrivateKey == null) {
         return super.executeRefreshToken();
      } else {
         JsonWebSignature$Header header = new JsonWebSignature$Header();
         header.setAlgorithm("RS256");
         header.setType("JWT");
         header.setKeyId(this.serviceAccountPrivateKeyId);
         JsonWebToken$Payload payload = new JsonWebToken$Payload();
         long currentTime = this.getClock().currentTimeMillis();
         payload.setIssuer(this.serviceAccountId);
         payload.setAudience(this.getTokenServerEncodedUrl());
         payload.setIssuedAtTimeSeconds(currentTime / 1000L);
         payload.setExpirationTimeSeconds(currentTime / 1000L + 3600L);
         payload.setSubject(this.serviceAccountUser);
         payload.put("scope", Joiner.on(' ').join(this.serviceAccountScopes));

         TokenResponse var10000;
         try {
            String assertion = JsonWebSignature.signUsingRsaSha256(this.serviceAccountPrivateKey, this.getJsonFactory(), header, payload);
            TokenRequest request = new TokenRequest(this.getTransport(), this.getJsonFactory(), new GenericUrl(this.getTokenServerEncodedUrl()), "urn:ietf:params:oauth:grant-type:jwt-bearer");
            request.put("assertion", assertion);
            var10000 = request.execute();
         } catch (GeneralSecurityException var7) {
            IOException e = new IOException();
            e.initCause(var7);
            throw e;
         }

         return var10000;
      }
   }

   public final String getServiceAccountId() {
      return this.serviceAccountId;
   }

   public final String getServiceAccountProjectId() {
      return this.serviceAccountProjectId;
   }

   public final Collection getServiceAccountScopes() {
      return this.serviceAccountScopes;
   }

   public final String getServiceAccountScopesAsString() {
      return this.serviceAccountScopes == null ? null : Joiner.on(' ').join(this.serviceAccountScopes);
   }

   public final PrivateKey getServiceAccountPrivateKey() {
      return this.serviceAccountPrivateKey;
   }

   @Beta
   @Beta
   public final String getServiceAccountPrivateKeyId() {
      return this.serviceAccountPrivateKeyId;
   }

   public final String getServiceAccountUser() {
      return this.serviceAccountUser;
   }

   @Beta
   @Beta
   public boolean createScopedRequired() {
      if (this.serviceAccountPrivateKey == null) {
         return false;
      } else {
         return this.serviceAccountScopes == null || this.serviceAccountScopes.isEmpty();
      }
   }

   @Beta
   @Beta
   public GoogleCredential createScoped(Collection scopes) {
      return this.serviceAccountPrivateKey == null ? this : (new GoogleCredential$Builder()).setServiceAccountPrivateKey(this.serviceAccountPrivateKey).setServiceAccountPrivateKeyId(this.serviceAccountPrivateKeyId).setServiceAccountId(this.serviceAccountId).setServiceAccountProjectId(this.serviceAccountProjectId).setServiceAccountUser(this.serviceAccountUser).setServiceAccountScopes(scopes).setTokenServerEncodedUrl(this.getTokenServerEncodedUrl()).setTransport(this.getTransport()).setJsonFactory(this.getJsonFactory()).setClock(this.getClock()).build();
   }

   @Beta
   @Beta
   private static GoogleCredential fromStreamUser(GenericJson fileContents, HttpTransport transport, JsonFactory jsonFactory) throws IOException {
      String clientId = (String)fileContents.get("client_id");
      String clientSecret = (String)fileContents.get("client_secret");
      String refreshToken = (String)fileContents.get("refresh_token");
      if (clientId != null && clientSecret != null && refreshToken != null) {
         GoogleCredential credential = (new GoogleCredential$Builder()).setClientSecrets(clientId, clientSecret).setTransport(transport).setJsonFactory(jsonFactory).build();
         credential.setRefreshToken(refreshToken);
         credential.refreshToken();
         return credential;
      } else {
         throw new IOException("Error reading user credential from stream,  expecting 'client_id', 'client_secret' and 'refresh_token'.");
      }
   }

   @Beta
   @Beta
   private static GoogleCredential fromStreamServiceAccount(GenericJson fileContents, HttpTransport transport, JsonFactory jsonFactory) throws IOException {
      String clientId = (String)fileContents.get("client_id");
      String clientEmail = (String)fileContents.get("client_email");
      String privateKeyPem = (String)fileContents.get("private_key");
      String privateKeyId = (String)fileContents.get("private_key_id");
      if (clientId != null && clientEmail != null && privateKeyPem != null && privateKeyId != null) {
         PrivateKey privateKey = privateKeyFromPkcs8(privateKeyPem);
         Collection emptyScopes = Collections.emptyList();
         GoogleCredential$Builder credentialBuilder = (new GoogleCredential$Builder()).setTransport(transport).setJsonFactory(jsonFactory).setServiceAccountId(clientEmail).setServiceAccountScopes(emptyScopes).setServiceAccountPrivateKey(privateKey).setServiceAccountPrivateKeyId(privateKeyId);
         String tokenUri = (String)fileContents.get("token_uri");
         if (tokenUri != null) {
            credentialBuilder.setTokenServerEncodedUrl(tokenUri);
         }

         String projectId = (String)fileContents.get("project_id");
         if (projectId != null) {
            credentialBuilder.setServiceAccountProjectId(projectId);
         }

         return credentialBuilder.build();
      } else {
         throw new IOException("Error reading service account credential from stream, expecting  'client_id', 'client_email', 'private_key' and 'private_key_id'.");
      }
   }

   @Beta
   @Beta
   private static PrivateKey privateKeyFromPkcs8(String privateKeyPem) throws IOException {
      Reader reader = new StringReader(privateKeyPem);
      PemReader$Section section = PemReader.readFirstSectionAndClose(reader, "PRIVATE KEY");
      if (section == null) {
         throw new IOException("Invalid PKCS8 data.");
      } else {
         byte[] bytes = section.getBase64DecodedBytes();
         PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
         Object unexpectedException = null;

         try {
            KeyFactory keyFactory = SecurityUtils.getRsaKeyFactory();
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            PrivateKey var10000 = privateKey;
            return var10000;
         } catch (NoSuchAlgorithmException var8) {
            unexpectedException = var8;
         } catch (InvalidKeySpecException var9) {
            unexpectedException = var9;
         }

         throw (IOException)OAuth2Utils.exceptionWithCause(new IOException("Unexpected exception reading PKCS data"), (Throwable)unexpectedException);
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential setFromTokenResponse(TokenResponse var1) {
      return this.setFromTokenResponse(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential setExpiresInSeconds(Long var1) {
      return this.setExpiresInSeconds(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential setExpirationTimeMilliseconds(Long var1) {
      return this.setExpirationTimeMilliseconds(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential setRefreshToken(String var1) {
      return this.setRefreshToken(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Credential setAccessToken(String var1) {
      return this.setAccessToken(var1);
   }
}
