package callback.calculate;

/**
 * Created by Devin on 2016/8/24.
 */
public class SuperCalculator {
    public void addService(int a, int b, CalculateService consumer){
        int result = a + b;
        consumer.accountantService(a, b, result);
    }
}
