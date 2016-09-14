package arithmetic;

/**
 * Created by Devin on 2016/9/13.
 * [-2147483648,-2147483648]
 */
public class RotateFunction396 {
    public static void main(String[] args) {
        int[] A = new int[]{4,3,2,6};
        System.out.println(maxRotateFunction1(A));
    }
    public static int maxRotateFunction(int[] A) {
        if (A.length==0 || A.length == 1) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int result = 0;
            int index = i;
            for (int j = 1; j < A.length; j++) {
                //因为j=0时结果为0,故这里直接从j=1开始,同时使用 ++index
                if (++index % A.length == i) break;
                result += j * A[index % A.length];
            }
            if (max < result) max = result;
        }
        return max;
    }

    public static int maxRotateFunction1(int[] A){
        int total = 0,sum = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];//total为数组各个数的和
            sum += i * A[i];//sum为首次按照公式计算的和
        }
        int max = sum;
        for (int i = A.length-1; i > 0; i--) {
            sum = sum + total - A.length * A[i];//根据题目循环的特点,下一次循环总是上一次循环的所有数自身增加一次,再减去最后一个数多加了A.length个,因为最后一个数循环后因数被置零.
            if (max < sum) max = sum;
        }
        return max;
    }
}
