package mike.java8;

import java.util.Optional;

/**
 * Created by Devin on 8/15/2016.
 */
public class TestOptional {
    public static void main(String[] args) {
        Optional<String> myValue = Optional.of("OptionalTest");
        //Optional<String> someNull = Optional.of(null);
        Optional empty = Optional.ofNullable(null);
        if (myValue.isPresent()){
            System.out.println(myValue.get());
        }
        //System.out.println(empty.get());
        myValue.ifPresent((value)->{
            System.out.println("the length of the value is:"+value.length());
        });
    }
}
