package arithmetic;

/**
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子， 小兔子长到第三个月后每个月又生一对兔子， 假如兔子都不死，问每个月的兔子对数为多少？
 * 程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
 * Created by Devin on 2016/8/24.
 */
public class Rabbit {
    public static void main(String[] args) {
        int num0 = 0;
        int num1 = 1;
        int temp;
        System.out.println("第十个月的总数: " + rabbit(10));
        System.out.println();
        System.out.println("第 1 个月的总数: " + num1);
        for (int i = 2; i < 46; i++) {
            System.out.println("第 " + i + " 个月的总数: " + (num0 + num1));
            temp =num1;
            num1 = num0 + num1;
            num0 = temp;
        }
    }

    public static int rabbit(int n){
        if (n == 1 || n == 2){
            return 1;
        }
        return rabbit(n - 1) + rabbit( n -2);
    }
}
