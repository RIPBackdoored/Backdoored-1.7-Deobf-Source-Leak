package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public interface Function {
   @Nullable
   @CanIgnoreReturnValue
   Object apply(@Nullable Object var1);

   boolean equals(@Nullable Object var1);
}
