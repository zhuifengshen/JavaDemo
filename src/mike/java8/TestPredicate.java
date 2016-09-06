package mike.java8;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Devin on 8/15/2016.
 */
public class TestPredicate {
    public static void main(String[] args) {
        Predicate<String> predicate = (string) -> string.length() > 0;
        System.out.println("字符串长度大于0:" + predicate.test("lambda"));
        System.out.println("字符串长度大于0:" + predicate.test(""));
        System.out.println("字符串长度小于0:" + predicate.negate().test(""));

        Predicate<Object> predicate1 = Objects::nonNull;
        Object object = null;
        System.out.println("对象不为空:" + predicate1.test(object));
        object = new Object();
        System.out.println("对象不为空:" + predicate1.test(object));

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        String result = backToString.apply("1234");
        System.out.println(result);

        Function<Integer, Integer> add = (i) -> {
            System.out.println("first input:" + i);
            return i + i;
        };
        Function<Integer, Integer> zero = add.andThen((i) -> {
            System.out.println("second input:" + i);
            return i * 0;
        });
        Integer res = zero.apply(10);
        System.out.println(res);

        //Supplier接口
        Supplier<String> supplier = () -> "hello supplier";
        System.out.println(supplier.get());

        //Consumer接口
        Consumer<Integer> add5 = (p) ->{
            System.out.println("old value: " + p);
            p += 5;
            System.out.println("new value: " + p);
        };
        add5.accept(5);

    }
}
