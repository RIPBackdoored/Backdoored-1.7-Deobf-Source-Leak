package com.google.api.client.auth.openidconnect;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import java.util.Collection;
import java.util.Collections;

@Beta
public class IdTokenVerifier {
   public static final long DEFAULT_TIME_SKEW_SECONDS = 300L;
   private final Clock clock;
   private final long acceptableTimeSkewSeconds;
   private final Collection issuers;
   private final Collection audience;

   public IdTokenVerifier() {
      this(new IdTokenVerifier$Builder());
   }

   protected IdTokenVerifier(IdTokenVerifier$Builder builder) {
      this.clock = builder.clock;
      this.acceptableTimeSkewSeconds = builder.acceptableTimeSkewSeconds;
      this.issuers = builder.issuers == null ? null : Collections.unmodifiableCollection(builder.issuers);
      this.audience = builder.audience == null ? null : Collections.unmodifiableCollection(builder.audience);
   }

   public final Clock getClock() {
      return this.clock;
   }

   public final long getAcceptableTimeSkewSeconds() {
      return this.acceptableTimeSkewSeconds;
   }

   public final String getIssuer() {
      return this.issuers == null ? null : (String)this.issuers.iterator().next();
   }

   public final Collection getIssuers() {
      return this.issuers;
   }

   public final Collection getAudience() {
      return this.audience;
   }

   public boolean verify(IdToken idToken) {
      return (this.issuers == null || idToken.verifyIssuer(this.issuers)) && (this.audience == null || idToken.verifyAudience(this.audience)) && idToken.verifyTime(this.clock.currentTimeMillis(), this.acceptableTimeSkewSeconds);
   }
}
