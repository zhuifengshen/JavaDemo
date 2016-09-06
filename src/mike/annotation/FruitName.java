package mike.annotation;

import java.lang.annotation.*;

/**
 * Created by Devin on 2016/7/19.
 * 水果名称注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default " ";
}
