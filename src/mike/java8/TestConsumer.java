package mike.java8;

import java.util.function.Consumer;

/**
 * Created by Devin on 2016/7/14.
 */
public class TestConsumer {
    public static TestConsumer INSTANCE = new TestConsumer();

    public void sayHello(String string){
        System.out.println("Hello:" + string);
    }

    public static void greeting(String string){
        System.out.println("Greeting:" + string);
    }

    public void tryConsumer(Consumer c, String t){
        c.accept(t);
    }

    public static void main(String[] args){
        TestConsumer test = new TestConsumer();
        test.tryConsumer(System.out::println, "hello");
    }
}
