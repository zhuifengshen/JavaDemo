package mike.annotation;

import java.lang.annotation.*;

/**
 * Created by Devin on 2016/7/19.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    public int id() default -1;
    public String name() default " ";
    public String address() default " ";
}
