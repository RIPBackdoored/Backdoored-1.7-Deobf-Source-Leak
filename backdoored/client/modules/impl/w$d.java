package l.c.h.j;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nonnull;
import l.c.h.d.c;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface w$d {
   @Nonnull
   String name();

   @Nonnull
   String description();

   @Nonnull
   c category();

   boolean defaultOn() default false;

   boolean defaultIsVisible() default true;

   String defaultBind() default "NONE";
}
