package arithmetic;

/**
 * Created by Devin on 2016/8/24.
 * 题目：判断100-200之间有多少个素数，并输出所有素数。
 */
public class PrimeNumber {
    public static void main(String[] args) {
        getPrime(100, 200);

        //int count = 0;
        //boolean isPrime = true;
        //for (int i = 100; i <= 200; i++) {
        //    for (int j = 2; j <= Math.sqrt(i); j++) {
        //        if (i % j == 0){
        //            isPrime = false;
        //            break;
        //        }
        //    }
        //    if (isPrime){
        //        System.out.println(i);
        //        count++;
        //    }
        //    isPrime = true;
        //}
        //System.out.println("100到200之间素数的个数是:" + count);
    }

    public static void getPrime(int m, int n){
        int count = 0;
        for (int i = m; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                count++;
                System.out.println("第 " + count + "个素数是:" + i);
            }
        }
    }
}
