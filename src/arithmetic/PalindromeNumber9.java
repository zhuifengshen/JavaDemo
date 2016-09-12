package arithmetic;

/**
 * Created by Devin on 2016/9/5.
 */
public class PalindromeNumber9 {
    public static void main(String[] args) {
        int x = -2147483648;
        System.out.println(isPalindrome1(x));
    }
    //方式一:转化为字符串处理
    private static boolean isPalindrome(int x) {
        //负数为非回文串
        if (x < 0){
            return false;
        }
        //数值转换为字符串
        String string = String.valueOf(x);
        for (int i = 0; i <= string.length()/2; i++) {
            if (string.charAt(i) != string.charAt(string.length()-1-i)) return false;
        }
        return true;
    }

    private static boolean isPalindrome1(int x){
        //负数为非回文串
        if (x < 0){
            return false;
        }
        int temp = 0, x1 = x;
        while (x != 0){
            //回文串倒置后相等,如果倒置出现溢出,说明为非回文串
            if (Integer.MAX_VALUE / 10 < temp || (Integer.MAX_VALUE / 10 == temp && Integer.MAX_VALUE % 10 < x % 10)){
                return false;
            }
            temp = temp * 10 + x % 10;
            x /=10;
        }
        if (temp == x1){
            return true;
        }else {
            return false;
        }
    }
}
