package reflection.api.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by andrei.dobre on 28.10.2014.
 */


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Column {
    public String name() default "test";
}
