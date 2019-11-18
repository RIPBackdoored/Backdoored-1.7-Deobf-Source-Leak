package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Beta;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlException;
import java.util.Locale;

@Beta
class DefaultCredentialProvider extends SystemEnvironmentProvider {
   static final String CREDENTIAL_ENV_VAR = "GOOGLE_APPLICATION_CREDENTIALS";
   static final String WELL_KNOWN_CREDENTIALS_FILE = "application_default_credentials.json";
   static final String CLOUDSDK_CONFIG_DIRECTORY = "gcloud";
   static final String HELP_PERMALINK = "https://developers.google.com/accounts/docs/application-default-credentials";
   static final String APP_ENGINE_CREDENTIAL_CLASS = "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper";
   static final String CLOUD_SHELL_ENV_VAR = "DEVSHELL_CLIENT_PORT";
   private GoogleCredential cachedCredential = null;
   private DefaultCredentialProvider$Environment detectedEnvironment = null;

   final GoogleCredential getDefaultCredential(HttpTransport transport, JsonFactory jsonFactory) throws IOException {
      synchronized(this) {
         if (this.cachedCredential == null) {
            this.cachedCredential = this.getDefaultCredentialUnsynchronized(transport, jsonFactory);
         }

         if (this.cachedCredential != null) {
            GoogleCredential var10000 = this.cachedCredential;
            return var10000;
         }
      }

      throw new IOException(String.format("The Application Default Credentials are not available. They are available if running on Google App Engine, Google Compute Engine, or Google Cloud Shell. Otherwise, the environment variable %s must be defined pointing to a file defining the credentials. See %s for more information.", "GOOGLE_APPLICATION_CREDENTIALS", "https://developers.google.com/accounts/docs/application-default-credentials"));
   }

   private final GoogleCredential getDefaultCredentialUnsynchronized(HttpTransport transport, JsonFactory jsonFactory) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private final File getWellKnownCredentialsFile() {
      File cloudConfigPath = null;
      String os = this.getProperty("os.name", "").toLowerCase(Locale.US);
      File credentialFilePath;
      if (os.indexOf("windows") >= 0) {
         credentialFilePath = new File(this.getEnv("APPDATA"));
         cloudConfigPath = new File(credentialFilePath, "gcloud");
      } else {
         credentialFilePath = new File(this.getProperty("user.home", ""), ".config");
         cloudConfigPath = new File(credentialFilePath, "gcloud");
      }

      credentialFilePath = new File(cloudConfigPath, "application_default_credentials.json");
      return credentialFilePath;
   }

   boolean fileExists(File file) {
      return file.exists() && !file.isDirectory();
   }

   String getProperty(String property, String def) {
      return System.getProperty(property, def);
   }

   Class forName(String className) throws ClassNotFoundException {
      return Class.forName(className);
   }

   private final DefaultCredentialProvider$Environment detectEnvironment(HttpTransport transport) throws IOException {
      if (this.runningUsingEnvironmentVariable()) {
         return DefaultCredentialProvider$Environment.ENVIRONMENT_VARIABLE;
      } else if (this.runningUsingWellKnownFile()) {
         return DefaultCredentialProvider$Environment.WELL_KNOWN_FILE;
      } else if (this.runningOnAppEngine()) {
         return DefaultCredentialProvider$Environment.APP_ENGINE;
      } else if (this.runningOnCloudShell()) {
         return DefaultCredentialProvider$Environment.CLOUD_SHELL;
      } else {
         return OAuth2Utils.runningOnComputeEngine(transport, this) ? DefaultCredentialProvider$Environment.COMPUTE_ENGINE : DefaultCredentialProvider$Environment.UNKNOWN;
      }
   }

   private boolean runningUsingEnvironmentVariable() throws IOException {
      String credentialsPath = this.getEnv("GOOGLE_APPLICATION_CREDENTIALS");
      if (credentialsPath != null && credentialsPath.length() != 0) {
         boolean var10000;
         try {
            File credentialsFile = new File(credentialsPath);
            if (!credentialsFile.exists() || credentialsFile.isDirectory()) {
               throw new IOException(String.format("Error reading credential file from environment variable %s, value '%s': File does not exist.", "GOOGLE_APPLICATION_CREDENTIALS", credentialsPath));
            }

            var10000 = true;
         } catch (AccessControlException var3) {
            return false;
         }

         return var10000;
      } else {
         return false;
      }
   }

   private GoogleCredential getCredentialUsingEnvironmentVariable(HttpTransport transport, JsonFactory jsonFactory) throws IOException {
      String credentialsPath = this.getEnv("GOOGLE_APPLICATION_CREDENTIALS");
      FileInputStream credentialsStream = null;

      GoogleCredential var5;
      try {
         credentialsStream = new FileInputStream(credentialsPath);
         var5 = GoogleCredential.fromStream(credentialsStream, transport, jsonFactory);
      } catch (IOException var9) {
         throw (IOException)OAuth2Utils.exceptionWithCause(new IOException(String.format("Error reading credential file from environment variable %s, value '%s': %s", "GOOGLE_APPLICATION_CREDENTIALS", credentialsPath, var9.getMessage())), var9);
      } finally {
         if (credentialsStream != null) {
            credentialsStream.close();
         }

      }

      return var5;
   }

   private boolean runningUsingWellKnownFile() {
      File wellKnownFileLocation = this.getWellKnownCredentialsFile();

      boolean var10000;
      try {
         var10000 = this.fileExists(wellKnownFileLocation);
      } catch (AccessControlException var3) {
         return false;
      }

      return var10000;
   }

   private GoogleCredential getCredentialUsingWellKnownFile(HttpTransport transport, JsonFactory jsonFactory) throws IOException {
      File wellKnownFileLocation = this.getWellKnownCredentialsFile();
      FileInputStream credentialsStream = null;

      GoogleCredential var5;
      try {
         credentialsStream = new FileInputStream(wellKnownFileLocation);
         var5 = GoogleCredential.fromStream(credentialsStream, transport, jsonFactory);
      } catch (IOException var9) {
         throw new IOException(String.format("Error reading credential file from location %s: %s", wellKnownFileLocation, var9.getMessage()));
      } finally {
         if (credentialsStream != null) {
            credentialsStream.close();
         }

      }

      return var5;
   }

   private boolean runningOnAppEngine() {
      Class systemPropertyClass = null;

      try {
         systemPropertyClass = this.forName("com.google.appengine.api.utils.SystemProperty");
      } catch (ClassNotFoundException var8) {
         return false;
      }

      Object cause = null;

      try {
         Field environmentField = systemPropertyClass.getField("environment");
         Object environmentValue = environmentField.get((Object)null);
         Class environmentType = environmentField.getType();
         Method valueMethod = environmentType.getMethod("value");
         Object environmentValueValue = valueMethod.invoke(environmentValue);
         boolean var10000 = environmentValueValue != null;
         return var10000;
      } catch (NoSuchFieldException var9) {
         cause = var9;
      } catch (SecurityException var10) {
         cause = var10;
      } catch (IllegalArgumentException var11) {
         cause = var11;
      } catch (IllegalAccessException var12) {
         cause = var12;
      } catch (NoSuchMethodException var13) {
         cause = var13;
      } catch (InvocationTargetException var14) {
         cause = var14;
      }

      throw (RuntimeException)OAuth2Utils.exceptionWithCause(new RuntimeException(String.format("Unexpcted error trying to determine if runnning on Google App Engine: %s", ((Exception)cause).getMessage())), (Throwable)cause);
   }

   private final GoogleCredential getAppEngineCredential(HttpTransport transport, JsonFactory jsonFactory) throws IOException {
      Object innerException = null;

      try {
         Class credentialClass = this.forName("com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper");
         Constructor constructor = credentialClass.getConstructor(HttpTransport.class, JsonFactory.class);
         GoogleCredential var10000 = (GoogleCredential)constructor.newInstance(transport, jsonFactory);
         return var10000;
      } catch (ClassNotFoundException var6) {
         innerException = var6;
      } catch (NoSuchMethodException var7) {
         innerException = var7;
      } catch (InstantiationException var8) {
         innerException = var8;
      } catch (IllegalAccessException var9) {
         innerException = var9;
      } catch (InvocationTargetException var10) {
         innerException = var10;
      }

      throw (IOException)OAuth2Utils.exceptionWithCause(new IOException(String.format("Application Default Credentials failed to create the Google App Engine service account credentials class %s. Check that the component 'google-api-client-appengine' is deployed.", "com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential$AppEngineCredentialWrapper")), (Throwable)innerException);
   }

   private boolean runningOnCloudShell() {
      return this.getEnv("DEVSHELL_CLIENT_PORT") != null;
   }

   private GoogleCredential getCloudShellCredential(JsonFactory jsonFactory) {
      String port = this.getEnv("DEVSHELL_CLIENT_PORT");
      return new CloudShellCredential(Integer.parseInt(port), jsonFactory);
   }

   private final GoogleCredential getComputeCredential(HttpTransport transport, JsonFactory jsonFactory) {
      return new DefaultCredentialProvider$ComputeGoogleCredential(transport, jsonFactory);
   }
}
