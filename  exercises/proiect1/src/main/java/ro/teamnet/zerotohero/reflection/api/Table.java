package ro.teamnet.zerotohero.reflection.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Miha on 10/28/2014.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
    public String tableName();  //o facem ca metoda, pt ca e interfata si nu am voie proprietati
}
