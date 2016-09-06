package mike.java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Devin on 2016/7/14.
 */
public class Java8Test {
    public static void main(String[] args){
        List names = new ArrayList<String>();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
        //names.forEach(TestConsumer.INSTANCE ::sayHello);
        //names.forEach(TestConsumer::greeting);

        //函数式编程
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("输出所有数据：");
        eval(list, n->true);
        System.out.println("输出所有偶数：");
        eval(list, n-> n%2 == 0);
        System.out.println("输出所有大于五的数：");
        eval(list, n -> n > 5);

        //默认方法
        Vehicle vehicle = new Car();
        vehicle.print();

        //Stream
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);

        IntSummaryStatistics statistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("列表中最大的数：" + statistics.getMax());
        System.out.println("列表中最小的数：" + statistics.getMax());
        System.out.println("列表中的平均数：" + statistics.getAverage());
        System.out.println("列表中的总和：" + statistics.getSum());

        //Optional
        Java8Test java8Test = new Java8Test();
        Integer value1 = null;
        Integer value2 = new Integer(10);
        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);
        System.out.println(java8Test.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        System.out.println("第一个参数存在：" + a.isPresent());
        System.out.println("第二个参数存在：" + b.isPresent());
        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();
        return  value1 + value2;
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        for(Integer n: list){
            if(predicate.test(n)){
                System.out.print(n + "  ");
            }
        }
        System.out.println();
    }
}

interface Vehicle{
    default void print(){
        System.out.println("我是一辆车！");
    }
    static void blowHorn(){
        System.out.println("按喇叭...");
    }
}

interface FourWheeler{
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}

class Car implements Vehicle,FourWheeler{
    @Override
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车！");
    }
}