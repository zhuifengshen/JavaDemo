package mike.annotation;

import java.lang.annotation.*;

/**
 * Created by Devin on 2016/7/19.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    public String tableName() default "className";
    public String setTableName() default "myTable";
    public enum FontColor{BULE, RED, GREEN};
    FontColor fontColor() default FontColor.GREEN;
}

//@Target(ElementType.FIELD)
//public @interface NoDBColumn{
//
//}
