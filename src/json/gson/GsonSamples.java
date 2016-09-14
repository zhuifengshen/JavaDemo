package json.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import json.jsonlib.Student;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Devin on 2016/9/14.
 */
public class GsonSamples {
    public static void main(String[] args) {
        Gson gson = new Gson();
        //基本数据类型转换为json
        String intGson = gson.toJson(110);
        System.out.println(intGson);
        String strGson = gson.toJson("devin");
        System.out.println(strGson);
        //json转换为基本数据类型
        int num = gson.fromJson(intGson, int.class);
        System.out.println(num);
        String string = gson.fromJson(strGson,String.class);
        System.out.println(string);
        Boolean correction = gson.fromJson("true",Boolean.class);
        System.out.println(correction);
        //array  to  json
        String[] strings = {"devin", "kevin", "nevin"};
        String stringsJson = gson.toJson(strings);
        System.out.println(stringsJson);
        int[][] intArrays = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9, 0}};
        String intArraysJson = gson.toJson(intArrays);
        System.out.println(intArraysJson);
        //json to array
        String[] stringArray = gson.fromJson(stringsJson,String[].class);
        for (String str : stringArray) {
            System.out.println(str);
        }
        int[][] intArray = gson.fromJson(intArraysJson, int[][].class);
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {
                System.out.print(intArray[i][j] + " ");
            }
        }
        System.out.println();
        // map to json
        Map<String,Object> map = new HashMap<>();
        map.put("name","devin");
        map.put("age",3);
        map.put("sex", "male");
        String mapJson = gson.toJson(map);
        System.out.println(mapJson);
        // json to map
        Type mapType = new TypeToken<Map<String,Object>>(){}.getType();
        Map<String,Object> json2map = gson.fromJson(mapJson,mapType);
        System.out.println(json2map.get("name") + " " + json2map.get("age") + " " + json2map.get("sex"));
        //collection to json
        List<Object> list = new ArrayList<>();
        list.add(map);
        list.add("devin");
        list.add(111);
        String listJson = gson.toJson(list);
        System.out.println(listJson);
        //json to collection
        Type listType = new TypeToken<List<Object>>(){}.getType();
        List<Object> json2list = gson.fromJson(listJson,listType);
        for (Object object : json2list) {
            System.out.println(object);
        }
        //bean to json
        Student student = new Student();
        student.setName("devin");
        student.setAge(22);
        student.setSex("male");
        String studentJson = gson.toJson(student);
        System.out.println(studentJson);
        //json to bean
        Student json2student = gson.fromJson(studentJson,Student.class);
        System.out.println(json2student.getName() + " " + json2student.getAge() + " " + json2student.getSex());
        //只转换有初始化的属性
        Student student1 = new Student();
        student1.setAge(100);
        System.out.println(gson.toJson(student1));
    }

}
