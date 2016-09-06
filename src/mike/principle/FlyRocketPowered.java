package mike.principle;

/**
 * Created by Devin on 2016/7/22.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket");
    }
}
