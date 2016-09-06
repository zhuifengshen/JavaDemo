package mike.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Devin on 8/15/2016.
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<String>();
        lists.add("a1");
        lists.add("a2");
        lists.add("b1");
        lists.add("b2");
        lists.add("b3");
        lists.add("o1");
        //中间方法
        lists.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
        lists.stream().sorted((p1,p2)-> p1.compareTo(p2)).filter(s -> s.startsWith("b")).forEach(System.out::println);
        lists.stream().map(String::toUpperCase).sorted((a,b)->b.compareTo(a)).forEach(System.out::println);
        Function<String,String> function = (p) -> {
            return p + ".txt";
        };
        lists.stream().map(String::toUpperCase).map(function).sorted((a,b)->b.compareTo(a)).forEach(System.out::println);
        //完结方法
        boolean anyStartWithA = lists.stream().anyMatch(s -> s.startsWith("a"));
        boolean allStartWithA = lists.stream().allMatch(s -> s.startsWith("a"));
        List<String> list = lists.stream().filter(p -> p.startsWith("a")).sorted().collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list.stream().filter(s -> s.startsWith("a")).count());
        Optional<String> optional = lists.stream().sorted().reduce((s1, s2)->{
            System.out.println(s1 + "|" + s2);
            return s1 + "|" + s2;
        });

        Stream stream = Stream.generate(new NatureSeq());
        System.out.println("元素个数:"+ stream.map(param ->{return param;}).limit(1000).count());
    }

}
class NatureSeq implements Supplier<Long>{
    long value = 0;

    @Override
    public Long get() {
        value++;
        return value;
    }
}