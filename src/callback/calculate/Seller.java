package callback.calculate;

/**
 * Created by Devin on 2016/8/24.
 */
public class Seller implements CalculateService {
    private String name;

    public Seller(String name){
        this.name = name;
    }
    @Override
    public void accountantService(int a, int b, int result) {
        System.out.println(this.name + ",超级计算机真诚为您服务: " + a + " + " + b + " = " + result);
    }

    public void accountMoney(int a, int b){
        new SuperCalculator().addService(a, b, this);
    }
}
