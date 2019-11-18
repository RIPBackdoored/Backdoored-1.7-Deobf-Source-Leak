package com.google.api.client.googleapis.testing.json;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.testing.http.HttpTesting;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockHttpTransport$Builder;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
public final class GoogleJsonResponseExceptionFactoryTesting {
   public static GoogleJsonResponseException newMock(JsonFactory jsonFactory, int httpCode, String reasonPhrase) throws IOException {
      MockLowLevelHttpResponse otherServiceUnavaiableLowLevelResponse = (new MockLowLevelHttpResponse()).setStatusCode(httpCode).setReasonPhrase(reasonPhrase);
      MockHttpTransport otherTransport = (new MockHttpTransport$Builder()).setLowLevelHttpResponse(otherServiceUnavaiableLowLevelResponse).build();
      HttpRequest otherRequest = otherTransport.createRequestFactory().buildGetRequest(HttpTesting.SIMPLE_GENERIC_URL);
      otherRequest.setThrowExceptionOnExecuteError(false);
      HttpResponse otherServiceUnavailableResponse = otherRequest.execute();
      return GoogleJsonResponseException.from(jsonFactory, otherServiceUnavailableResponse);
   }
}
