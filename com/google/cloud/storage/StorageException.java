package com.google.cloud.storage;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.core.InternalApi;
import com.google.cloud.BaseServiceException;
import com.google.cloud.BaseServiceException.Error;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.http.BaseHttpServiceException;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Set;

@InternalApi
public final class StorageException extends BaseHttpServiceException {
   private static final Set RETRYABLE_ERRORS = ImmutableSet.of(new Error(504, (String)null), new Error(503, (String)null), new Error(502, (String)null), new Error(500, (String)null), new Error(429, (String)null), new Error(408, (String)null), new Error[]{new Error((Integer)null, "internalError")});
   private static final long serialVersionUID = -4168430271327813063L;

   public StorageException(int code, String message) {
      this(code, message, (Throwable)null);
   }

   public StorageException(int code, String message, Throwable cause) {
      super(code, message, (String)null, true, RETRYABLE_ERRORS, cause);
   }

   public StorageException(IOException exception) {
      super(exception, true, RETRYABLE_ERRORS);
   }

   public StorageException(GoogleJsonError error) {
      super(error, true, RETRYABLE_ERRORS);
   }

   public static StorageException translateAndThrow(RetryHelperException ex) {
      BaseServiceException.translate(ex);
      throw new StorageException(0, ex.getMessage(), ex.getCause());
   }
}
