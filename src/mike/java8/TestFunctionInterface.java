package mike.java8;

/**
 * Created by Devin on 8/12/2016.
 */
public class TestFunctionInterface {
    public static void main(String[] args) {
        Calculate calculate = new Calculate() {
            @Override
            public void play(int i) {
                System.out.println(i);
            }
        };
        calculate.play(88);

        //lambda表达式
        Calculate calculate1 = nums -> System.out.println(nums);
        calculate1.play(888);

        //Runnable
        new Thread(() -> System.out.println("Hello lambda")).start();

    }
    @FunctionalInterface
    interface Calculate{
        void play(int i);
    }
}
