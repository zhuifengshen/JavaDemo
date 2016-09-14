package json;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Devin on 2016/9/12.
 */
public class JSONArrayTest {
    public static void main(String[] args) {
        //constructroTest();
        putMethodTest();
    }
    public static void constructroTest(){
        //String
        String jsonStr = "[{'name':'devin','age':22},{'name':'kevin','age':33}]";
        JSONArray strJson = new JSONArray(jsonStr);
        System.out.println("构造参数为String:" + strJson);

        //Collection
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Map<String, Object> bookMap = new HashMap<>();
            bookMap.put("title", "Java程序设计" + i);
            bookMap.put("price", i * 10 + "$");
            list.add(bookMap);
        }
        JSONArray listJson = new JSONArray(list);
        System.out.println(listJson);

        //Array
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        JSONArray arrayJson = new JSONArray(nums);
        System.out.println(arrayJson);

        //bean
        Student[] students = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].setName("Devin" + i);
            students[i].setSex("male");
            students[i].setAge(i+20);
        }
        JSONArray beanJson = new JSONArray(students);
        System.out.println(beanJson);
    }

    public static void putMethodTest(){
        //添加基本类型
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("Devin");
        jsonArray.put(22);
        jsonArray.put("male");
        System.out.println(jsonArray);

        //Map类型
        JSONArray jsonArray1 = new JSONArray();
        Map<String, Object> bookMap = new HashMap<>();
        bookMap.put("title", "Java程序设计1");
        bookMap.put("price",22);
        jsonArray1.put(bookMap);
        System.out.println(jsonArray1);

        bookMap.clear();
        //System.out.println("-");
        //System.out.println(jsonArray1);
        //System.out.println("-");

        bookMap.put("title", "Java程序设计2");
        bookMap.put("price",23);
        jsonArray1.put(bookMap);
        System.out.println(jsonArray1);

        bookMap.put("title", "Java程序设计3");
        bookMap.put("price",24);
        jsonArray1.put(0,bookMap);//指定嵌入位置,如果该位置存在，则覆盖
        System.out.println(jsonArray1);

        // Bean类型，嵌套数组
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].setName("Devin"+i);
            students[i].setAge(2+i);
            students[i].setSex("male");
        }
        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.put(students);

        Student[] students1 = new Student[3];
        for (int i = 0; i < students1.length; i++) {
            students1[i] = new Student();
            students1[i].setName("Devin"+i);
            students1[i].setAge(2+i);
            students1[i].setSex("male");
        }
        jsonArray2.put(students1);

        System.out.println(jsonArray2);
    }
}
