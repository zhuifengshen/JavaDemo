package mike.principle;

/**
 * Created by Devin on 2016/7/22.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I'm quacking");
    }
}
