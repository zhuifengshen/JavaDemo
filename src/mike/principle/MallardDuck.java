package mike.principle;

/**
 * Created by Devin on 2016/7/22.
 */
public class MallardDuck extends Duck {
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    @Override
    public void display() {
        System.out.println(("I'm a real Mallard duck"));
    }
}
