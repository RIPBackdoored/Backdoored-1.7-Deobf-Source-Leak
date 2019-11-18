package com.google.api.client.json;

import com.google.api.client.util.Beta;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Beta
public @interface JsonPolymorphicTypeMap {
   JsonPolymorphicTypeMap$TypeDef[] typeDefinitions();
}
