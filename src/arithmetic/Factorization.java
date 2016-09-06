package arithmetic;

/**
 * Created by Devin on 2016/8/24.

 * 题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。

 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：

 (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。

 (2)如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数n,重复执行第一步。

 (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
 */
public class Factorization {
    public static void main(String[] args) {
        getFactor0(11);
        getFactor1(120);
        getFactor(49);
    }

    private static void getFactor0(int num) {
        for (int i = 2; i <= num; i++) {
            if (i == num){
                System.out.println(num);
                break;
            }
            if (num % i == 0){
                System.out.print(i + " * ");
                num = num / i;
                i--; // 由于每次获取到的肯定是当前最小的质数，所以只需要回滚1就可以了
            }
        }
    }

    private static void getFactor1(int num){
        for (int i = 2; i <= num; i++) {
            while (num % i == 0 && num != i){
                num /= i;
                System.out.print(i + " * ");
            }
            if (num == i){
                System.out.println(i);
                break;
            }
        }
    }

    public static void getFactor(int num){
        if (isPrime(num)){
            System.out.println(num);
            return;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0){
                System.out.print(i + " * ");
                getFactor(num/i);
                return;
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i<= Math.sqrt(num); i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}
