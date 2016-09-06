package mike.java8;

/**
 * Created by Devin on 8/15/2016.
 */
public class ConstrutorMethodReference {

    public static void main(String[] args) {
        AnimalFactory dogFactory = new AnimalFactory() {
            @Override
            public Animal create(String name, int age) {
                return new Dog(name, age);
            }
        };
        Animal myDog = dogFactory.create("小花",2);
        myDog.behavior();

        AnimalFactory birdFactory = new AnimalFactory() {
            @Override
            public Animal create(String name, int age) {
                return new Bird(name, age);
            }
        };
        Animal myBird = birdFactory.create("小鸣",1);
        myBird.behavior();

        //方法引用之引用构造方法
        AnimalFactory<Animal> dogFacotry1 = Dog::new;
        Animal myDog1 = dogFacotry1.create("小花", 2);
        myDog1.behavior();

        AnimalFactory<Animal> birdFactory1 = Bird::new;
        Animal myBird1 = birdFactory1.create("小鸣",1);
        myBird1.behavior();
    }
}
