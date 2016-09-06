package mike.java8;

/**
 * Created by Devin on 8/15/2016.
 */
public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void behavior(){}
}
