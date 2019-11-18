package com.google.api.client.auth.openidconnect;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;
import java.util.Collection;
import java.util.Collections;

@Beta
public class IdTokenVerifier$Builder {
   Clock clock;
   long acceptableTimeSkewSeconds;
   Collection issuers;
   Collection audience;

   public IdTokenVerifier$Builder() {
      this.clock = Clock.SYSTEM;
      this.acceptableTimeSkewSeconds = 300L;
   }

   public IdTokenVerifier build() {
      return new IdTokenVerifier(this);
   }

   public final Clock getClock() {
      return this.clock;
   }

   public IdTokenVerifier$Builder setClock(Clock clock) {
      this.clock = (Clock)Preconditions.checkNotNull(clock);
      return this;
   }

   public final String getIssuer() {
      return this.issuers == null ? null : (String)this.issuers.iterator().next();
   }

   public IdTokenVerifier$Builder setIssuer(String issuer) {
      return issuer == null ? this.setIssuers((Collection)null) : this.setIssuers(Collections.singleton(issuer));
   }

   public final Collection getIssuers() {
      return this.issuers;
   }

   public IdTokenVerifier$Builder setIssuers(Collection issuers) {
      Preconditions.checkArgument(issuers == null || !issuers.isEmpty(), "Issuers must not be empty");
      this.issuers = issuers;
      return this;
   }

   public final Collection getAudience() {
      return this.audience;
   }

   public IdTokenVerifier$Builder setAudience(Collection audience) {
      this.audience = audience;
      return this;
   }

   public final long getAcceptableTimeSkewSeconds() {
      return this.acceptableTimeSkewSeconds;
   }

   public IdTokenVerifier$Builder setAcceptableTimeSkewSeconds(long acceptableTimeSkewSeconds) {
      Preconditions.checkArgument(acceptableTimeSkewSeconds >= 0L);
      this.acceptableTimeSkewSeconds = acceptableTimeSkewSeconds;
      return this;
   }
}
