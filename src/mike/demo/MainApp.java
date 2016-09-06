package mike.demo;

/**
 * Created by Devin on 2016/6/30.
 */
public class MainApp {
    public static void main(String[] args){
        int[] array = new int[10];
        int index = 0;
        array[index++] = 1;
        System.out.println(array[0] + "&" + array[1]);

        int[] intArray = new int[]{1,2,3,4,5,6,7};
        int[] int1Array = new int[8];
        System.arraycopy(intArray,2,intArray,3,3);

        for (int i : intArray){
            System.out.println(i);
        }
    }
}
