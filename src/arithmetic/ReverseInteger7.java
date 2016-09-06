package arithmetic;

/**
 * Created by Devin on 2016/9/2.
 */
public class ReverseInteger7 {
    public static void main(String[] args) {
        System.out.println(reverse(-10));
        System.out.println(reverse(-123));
        System.out.println(reverse(-1234));
        System.out.println(reverse(0));
        System.out.println(reverse(123450));
        System.out.println(reverse(2147483647));
        System.out.println(reverse(-2147483647));
        System.out.println(reverse(-2147483648));
    }
    /**
     * Reverse Integer Value
     * 注意点：
     * 1.处理负数情况;
     * 2.处理尾数为零的情况
     * 3.处理反转之后数值溢出的情况:是否抛出异常/执行前与最大值比较/与上一次结果比较
     * 4.(long)2147483647 * 10 = 21474836470
     * 5.(long)(2147483647 * 10) = -10
     * 6. -1234 % 10 = -4
     */
    // 5ms
    public static int reverse(int x){
        boolean isNegative = false;
        int result;
        if (x < 0){
            isNegative = true;
            x = -x;
        }
        String number = String.valueOf(x);
        char[] numbers = number.toCharArray();
        int i = 0, j = numbers.length -1;
        while (i < j){
            char temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            i++;
            j--;
        }
        //异常会抛出的异常,利用这个来判断是否溢出
        try{
            result = isNegative ? -Integer.valueOf(new String(numbers)) : Integer.valueOf(new String(numbers));
        }catch (NumberFormatException e){
            return 0;
        }
        return result;
    }
    //3ms
    public static int reverse1(int x){
        boolean flag = false;
        int result = 0;
        //转换为正数
        if (x < 0){
            x = -x;
            flag = true;
        }
        //循环倒置
        while (x > 0) {
            //判断是否溢出
            if (((long)result * 10) > Integer.MAX_VALUE || Integer.MAX_VALUE - x % 10 < result * 10) return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }
        return flag ? -result : result;
    }
    //2ms
    public static int reverse2(int x){
        int result = 0;
        //循环倒置
        while (x != 0) {
            //判断是否溢出
            if (Math.abs((long)result * 10) > Integer.MAX_VALUE || Integer.MAX_VALUE - Math.abs(x % 10) < Math.abs(result * 10)) return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
    //2ms
    public static int reverse3(int x){
        int result = 0;
        while (x != 0){
            //负数求余亦为负数,故不用另行区分
            int temp = result * 10 + x % 10;
            x /= 10;
            //判断是否溢出
            if (temp / 10 != result) return 0;
            result = temp;
        }
        return result;
    }
}
