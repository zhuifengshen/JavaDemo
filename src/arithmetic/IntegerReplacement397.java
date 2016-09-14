package arithmetic;

/**
 * Created by Devin on 2016/9/14.
 */
public class IntegerReplacement397 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(integerReplacement(n));
    }

    private static int integerReplacement(int n) {
        int num = 1;
        while (n > 2<<1) num++;
        return num;
    }
}
