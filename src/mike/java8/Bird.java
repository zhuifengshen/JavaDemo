package mike.java8;

/**
 * Created by Devin on 8/15/2016.
 */
public class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void behavior() {
        System.out.println("Fly");
    }
}
