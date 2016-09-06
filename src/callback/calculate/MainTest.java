package callback.calculate;

/**
 * Created by Devin on 2016/8/24.
 */
public class MainTest {
    public static void main(String[] args) {
        Student xiaoming = new Student("小明");
        xiaoming.homework(123, 434);
        Seller oldWoman = new Seller("老婆婆");
        oldWoman.accountMoney(24356, 2345);
    }
}
