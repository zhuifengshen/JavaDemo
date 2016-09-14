package json.jsonlib;


import net.sf.json.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.sf.json.JSONArray.fromObject;

/**
 * Created by Devin on 2016/9/13.
 */
public class JsonlibTest {
    public static void main(String[] args) {
        //jsonObjectTest();
        //jsonArrayTest();
        //putMethodTest();
        //jsonParserTest();
        //json2bean();
        //json2list();
        jsonConfigTest();
    }

    public static void jsonArrayTest(){
        JSONArray jsonStrArray = fromObject("['devin','kevin','zevin']");
        System.out.println(jsonStrArray);
        //array
        boolean[] boolArray = new boolean[]{true,false,true};
        JSONArray jsonArray = fromObject(boolArray);
        System.out.println(jsonArray);
        //collection
        List list = new ArrayList();
        list.add("first");
        list.add("second");
        list.add("third");
        JSONArray jsonList = fromObject(list);
        System.out.println(jsonList);
    }

    public static void jsonObjectTest(){
        //String构造JSONObject
        String strJson = "{'name':'devin','age':22','sex':'male'}";
        JSONObject jsonStr = JSONObject.fromObject(strJson);
        System.out.println(jsonStr);
        //map
        Map map = new HashMap();
        map.put("name","devin");
        map.put("age",22);
        map.put("sex","male");
        map.put("bool",Boolean.TRUE);
        map.put("int",new Integer(110));
        map.put("arr", new String[]{"aaa", "bbb", "ccc"});
        map.put("func", "function(i){return this.arr[i];}");
        JSONObject jsonMapObject = JSONObject.fromObject(map);
        System.out.println(jsonMapObject);
        //bean
        Student student = new Student();
        student.setName("devin");
        student.setSex("male");
        student.setAge(11);
        JSONObject jsonBeanObject = JSONObject.fromObject(student);
        System.out.println(jsonBeanObject);
        //list
        List<Object> list = new ArrayList<>();
        list.add(map);
        list.add(student);
        list.add(jsonStr);
        JSONArray jsonListArray = fromObject(list);
        System.out.println(jsonListArray);
    }

    public static void putMethodTest(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "deivn");
        map.put("age",33);
        map.put("sex","male");

        Student student = new Student();
        student.setAge(44);
        student.setName("devin1");
        student.setSex("sex");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("people","zhangchuzhao");
        System.out.println(jsonObject);
        jsonObject.put("student",student);
        System.out.println(jsonObject);
        jsonObject.put("worker",map);
        System.out.println(jsonObject);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(121);
        jsonArray.add("devin");
        jsonArray.add(0,student);
        jsonArray.add(map);
        System.out.println(jsonArray);
    }

    public static void jsonParserTest(){
        String jsonData = "{'name':'devin','age':2}";
        JSONObject jsonObject = JSONObject.fromObject(jsonData);
        System.out.println(jsonObject);
        String name = jsonObject.getString("name");
        System.out.println(name);
        int age = jsonObject.getInt("age");
        System.out.println(age);

        String sex = jsonObject.optString("sex");
        System.out.println("性别："+sex);
        //String sex1 = jsonObject.getString("sex");
        //System.out.println(sex1);
    }

    public static void json2bean(){
        Student student = new Student();
        student.setName("devin");
        student.setAge(111);
        student.setSex("male");

        JSONObject jsonObject = JSONObject.fromObject(student);
        System.out.println(jsonObject);
        //第一种方法
        Student student1 = (Student)JSONObject.toBean(jsonObject,Student.class);
        System.out.println(student1.getName()+" "+student1.getSex()+" "+student1.getAge());
        //第二种方法
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setRootClass(Student.class);
        Student student2 = (Student)JSONObject.toBean(jsonObject,jsonConfig);
        System.out.println(student2.getName()+" "+student2.getSex()+" "+student2.getAge());
    }

    public static void json2list(){
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("four");
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
        //基本类型 json 2 list
        List<String> list1 = JSONArray.toList(jsonArray);
        System.out.println(list1.get(0));

        List<Student> listStudent = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Student student = new Student();
            student.setName("Devin" + i);
            student.setSex("male");
            student.setAge(11+i);
            listStudent.add(student);
        }
        JSONArray jsonArray1 = JSONArray.fromObject(listStudent);
        System.out.println(jsonArray1);
        //Student类型 json 2 list 方法一
        List<Student> studentList = JSONArray.toList(jsonArray1,Student.class);
        System.out.println(studentList.get(0).getName());

        // 方法二
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setRootClass(Student.class);
        List<Student> studentList1 = (List<Student>)JSONSerializer.toJava(jsonArray1,jsonConfig);
        System.out.println(studentList1.get(2).getName());
    }
    //jsonConfig类是帮助配置序列化过程的实用程序类，可以用它来在json和java对象转换过程中进行一些配置设置。
    public static void jsonConfigTest(){
        Student student = new Student();
        student.setAge(111);
        student.setSex("female");
        student.setName("xu zhi ling");

        JSONObject jsonObject = JSONObject.fromObject(student);
        System.out.println(jsonObject);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"sex","age"});
        JSONObject jsonObject1 = JSONObject.fromObject(student,jsonConfig);
        System.out.println(jsonObject1);
    }
}
