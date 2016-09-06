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
        if (x < 0){
            return false;
        }
        String string = String.valueOf(x);
        for (int i = 0; i <= string.length()/2; i++) {
            if (string.charAt(i) != string.charAt(string.length()-1-i)) return false;
        }
        return true;
    }

    private static boolean isPalindrome1(int x){
        if (x < 0){
            return false;
        }
        int temp = 0, x1 = x;
        while (x != 0){
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
