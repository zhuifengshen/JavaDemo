package mike.array;

/**
 * Created by Devin on 2016/7/19.
 */
public class ArrayTest {
    public static void main(String[] args){
        int[] array = new int[10];
        int[][] array0 = new int[10][10];
        String[] array1 = new String[10];
        System.out.println("array的父类是：" + array1.getClass().getSuperclass());
        System.out.println("array的父类是：" + array1.getClass().getName());
        System.out.println("array的父类是：" + array.getClass().getName());
        System.out.println("array的父类是：" + array0.getClass().getName());
    }

}
