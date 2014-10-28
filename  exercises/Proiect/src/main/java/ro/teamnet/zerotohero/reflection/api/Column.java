package ro.teamnet.zerotohero.reflection.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ovy on 10/28/2014.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public  @interface Column{
    String nume() default "";
    String job() default "";
}
