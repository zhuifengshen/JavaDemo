package arithmetic;

/**
 * Created by Devin on 2016/9/14.
 */
public class IntegerReplacement397 {
    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println(integerReplacement1(n));
    }
    // 4ms
    private static int integerReplacement1(int n) {
        int num = 0;
        if (n == Integer.MAX_VALUE){
            return 32;//因为最大值加1会溢出,故直接返回结果;
        }
        while (n != 1){
            if((n & 1) == 0){
                n >>= 1;
            }else if (n == 3 || ((n >> 1) & 1) == 0){
                n--;
            }else {
                n++;
            }
            num++;
        }
        return num;
    }
//这道题的难点在于什么时候该加1,什么时候该减1,以便我们减少迭代次数,那就是尽可能地成为二的倍数,于是我们从位运算的角度分析,末两位的组合有四种情况:00,10,01,11,前两种为偶数直接可以除以2,而后01应该减一,11应该加一,由此解题思路就很清晰了,代码实现如下:
//另外需要注意的是考虑n为3和Integer.MAX_VALUE时的两种特殊情况.
    private static int integerReplacement(int n){
        if (n == 1) return 0;
        else if (n == 3) return 2;
        else if (n == Integer.MAX_VALUE) return 32;
        else if ((n & 1) == 0) return integerReplacement(n/2) + 1;
        else return integerReplacement(((n >> 1) & 1) == 0 ? n-1 : n+1) + 1;
    }
}