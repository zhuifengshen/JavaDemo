package mike.skill;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Devin on 2016/8/5.
 */
public class SystemArrayCopy {
    public static void main(String[] args){
        int[] ids = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(ids));
        System.arraycopy(ids, 0, ids, 3, 2);
        System.out.println(Arrays.toString(ids));

        int[] ids2 = new int[6];
        System.arraycopy(ids, 1, ids2, 0, 3);
        System.out.println(Arrays.toString(ids2));

        try{
            System.arraycopy(ids, 0, ids2, 0, ids.length+1);
        }catch (IndexOutOfBoundsException ex){
            System.out.println("拷贝发生异常");
        }
        System.out.println(Arrays.toString(ids2));

        Object[] objects1 = {1, 2, 3, 4.4, 5.5};
        Integer[] objects2 = new Integer[5];
        System.out.println(Arrays.toString(objects2));
        try{
            System.arraycopy(objects1, 0, objects2, 0, objects1.length);
        }catch (ArrayStoreException ex){
            System.out.println("拷贝异常：数据转换出错，部分存储");
        }
        System.out.println(Arrays.toString(ids2));

        String[] strArray = new String[]{"abc", "bcd", "cde"};
        String[] copyArray = new String[4];
        System.arraycopy(strArray, 0, copyArray, 0, strArray.length);
        strArray[0] = "xyz";
        System.out.println(Arrays.toString(copyArray));
        System.out.println(strArray[0] == copyArray[0]);

        String[] copyArray2 = new String[2];
        System.out.println(copyArray2.length);
        //改变了copyArray2的引用
        copyArray2= Arrays.copyOf(strArray, 2);
        System.out.println(copyArray2.length);
        strArray[1] = "opq";
        System.out.println(Arrays.toString(copyArray2));
        System.out.println(strArray[0] == copyArray2[0]);

        List<String> list1 = Arrays.asList("abc", "bcd", "cde");
        String[] arary1 = {"a","b","c"};
        List<String> list2 = Arrays.asList(arary1);
        String[] array2 = (String[])list2.toArray();

    }
}
