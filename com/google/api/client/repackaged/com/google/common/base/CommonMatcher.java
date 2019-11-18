package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract class CommonMatcher {
   abstract boolean matches();

   abstract boolean find();

   abstract boolean find(int var1);

   abstract String replaceAll(String var1);

   abstract int end();

   abstract int start();
}
