package arithmetic;

/**
 * Created by Devin on 2016/9/9.
 */
public class SumOfTwoIntegers371 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(getSum2(a,b));
    }
    //解题思路:根据计算机内部加班运算原理:两个数^异或运算 = 每一位相加后需要进位的和; 两个数&与运算 = 每一位相加后需要进位的和的一半;
    public static int getSum(int a, int b){
        if(b == 0) return a;
        int nonCarry = a ^ b;
        int carry = (a & b) << 1;
        return getSum(nonCarry, carry);
    }
    //解题思路:根据计算机内部加班运算原理:两个数^异或运算 = 每一位相加后需要进位的和; 两个数&与运算 = 每一位相加后需要进位的和的一半;
    public static int getSum1(int a, int b){
        return b == 0 ? a : getSum(a ^ b,(a & b)<<1);
    }
    //解题思路:根据计算机内部加班运算原理:两个数^异或运算 = 每一位相加后需要进位的和; 两个数&与运算 = 每一位相加后需要进位的和的一半;
    public static int getSum2(int a, int b){
        if (b == 0) return a;
        while (b != 0){
            int carray = (a & b)<<1;
            a = a ^ b;
            b = carray;
        }
        return a;
    }
}
