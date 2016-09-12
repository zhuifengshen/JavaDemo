package arithmetic;

/**
 * Created by Devin on 2016/9/8.
 */
public class GuessNumber374 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(guessNumber(num));
    }

    //考虑猜的数不存在时结束循环
    private static int guessNumber(int n) {
        int m = 1;
        int mid = (int)(m/2.0 + n/2.0);
        while (m<=n){
            int flag = guess(mid);
            if (flag == 1) m = mid + 1;
            else if(flag == -1) n = mid - 1;
            else return mid;
            mid = (int)(m/2.0 + n/2.0);
        }
        return 0;
    }

    private static int guess(int n){
        if (n > 1) return -1;
        else if (n < 1) return 1;
        else return 0;
    }

    //无法处理溢出
    private static int guessNumber1(int n) {
        int m = 1;
        int mid = (m + n)/2;
        int flag = guess(mid);
        while (flag != 0){
            if (flag == 1) m = mid + 1;
            else n = mid - 1;
            mid = (m + n)/2;
            flag = guess(mid);
        }
        return mid;
    }
    //无法处理为1的时候
    private static int guessNumber2(int n) {
        int m = 1;
        int mid = m/2 + n/2;
        int flag = guess(mid);
        while (flag != 0){
            if (flag == 1) m = mid + 1;
            else n = mid - 1;
            mid = m/2 + n/2;
            flag = guess(mid);
        }
        return mid;
    }
    //猜的数不存在时无限循环
    private static int guessNumber3(int n) {
        int m = 1;
        int mid = (int)(m/2.0 + n/2.0);
        int flag = guess(mid);
        while (flag != 0){
            if (flag == 1) m = mid + 1;
            else n = mid - 1;
            mid = (int)(m/2.0 + n/2.0);
            flag = guess(mid);
        }
        return mid;
    }
}
