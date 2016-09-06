package mike.skill;

/**
 * Created by Devin on 2016/7/18.
 * NaN是Not a Number的缩写，即不是一个数字。它不等于任何浮点数，包括自己。
 */
public class LittleSkill {
    Float f1 = 0.01f;
    Float f2 = 0.02f;
    float f3 = f1.floatToIntBits(1);

    public static void main(String[] args){
        double i = 1.0/0;
        double j = 1.0/0.0;
        System.out.println(i);// Infinity
        System.out.println(-j);// -Infinity
        System.out.println(i == j);//ture

        double a = 0.0/0.0;
        float b = 0.0f/0.0f;
        System.out.println(a);//NaN
        System.out.println(b);//NaN
        System.out.println(a == b);//false

        Float f11 = new Float(-1.0 / 0.0);
        Float f22 = new Float(0.0 / 0.0);
        Double f33 = Math.sqrt(-1);
        System.out.println(f11 + " = " + f11.isNaN());
        System.out.println(f22 + " = " + f22.isNaN());
        System.out.println(f33 + " = " + f33.isNaN());
        System.out.println(Double.isNaN(Double.longBitsToDouble(0x7ff0000000000011L)));

        System.out.println(f11.getClass());
    }
}
