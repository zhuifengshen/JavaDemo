package mike.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Devin on 2016/7/29.
 */
public class MyList {
    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();

        int[] array1 = new int[]{1,2,3,4,5};
        int[] array2 = array1;
        array1[0] = 0;
        for(int i : array1) {
            System.out.println(i);
        }
        for (int j : array2){
            System.out.println(j);
        }
        int size = 1;
        printNum(size++);
        System.out.println(size);

        LinkedList linkedList = new LinkedList();

    }
    public static void printNum(int num){
        System.out.println(num);


    }
}
