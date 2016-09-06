package mike.java8;

/**
 * Created by Devin on 8/15/2016.
 */
public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void behavior() {
        System.out.println("Run");
    }
}
