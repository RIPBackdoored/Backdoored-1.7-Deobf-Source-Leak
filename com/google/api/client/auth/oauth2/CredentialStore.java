package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import java.io.IOException;

/** @deprecated */
@Deprecated
@Beta
public interface CredentialStore {
   boolean load(String var1, Credential var2) throws IOException;

   void store(String var1, Credential var2) throws IOException;

   void delete(String var1, Credential var2) throws IOException;
}
