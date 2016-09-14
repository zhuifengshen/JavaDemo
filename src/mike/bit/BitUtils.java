package mike.bit;

/**
 * Created by Devin on 2016/9/12.
 */
public class BitUtils {
    public static void main(String[] args) {
        System.out.println((byte)00001011);
        System.out.println(((byte)(00001011>>1)&1));
        System.out.println((1<<31)-1);
        System.out.println(1<<-1);
        System.out.println(-5>>1);
        System.out.println((-55^(-55>>31))-(-55>>31));
        System.out.println((-10^-10)>=0);

        System.out.println(min(12,12));
        System.out.println(max(11,11));
    }
    //小值
    public static int min(int a, int b){
        //(a-b)>>31得到的数32为都是符号位,比如当a-b大于零,则此时可知a大b小,因此与a将其置零(优先级:先取反,再移位)
        return a&((a-b)>>31) | b&(~(a-b)>>31);
    }
    //大值
    public static int max(int a,int b){
        //(a-b)>>31得到的数32为都是符号位,比如当a-b大于零,则此时可知a大b小,因此与b将其置零
        return b&((a-b)>>31) | a&(~(a-b)>>31);
    }
}
