package json;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Devin on 2016/9/8.
 */
public class JSONObjectTest {
    public static void main(String[] args) throws IOException {
        //URL url = new URL("https://graph.facebook.com/search?q=java&type=post");
        //JsonReader jsonReader = Json.createReader(is);
        //InputStream inputStream = url.openStream();
        //JSONParser parser = Json.createParser(inputStream);

        //constructorTest();
        putMethodTest();
    }

    public static void constructorTest(){
        String jsonStr = "{'name':'devin','sex':'male','age':21}";
        JSONObject strJson = new JSONObject(jsonStr);
        System.out.println("构造参数为:" + strJson);

        Map<String, Object> map = new HashMap<>();
        map.put("age",21);
        map.put("sex","male");
        map.put("name", "devin1");
        JSONObject mapJson = new JSONObject(map);
        System.out.println("构造参数为Map:" + mapJson);

        Student student = new Student();
        student.setAge(21);
        student.setName("devin2");
        student.setSex("male");
        JSONObject beanJson = new JSONObject(student);
        System.out.println("构造参数为bean:" + beanJson);

    }

    public static void putMethodTest(){
        //简单数据类型
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bookName","thinkInJava");
        jsonObject.put("price", 88);
        System.out.println(jsonObject);
        //添加数组
        JSONObject jsonObject1 = new JSONObject();
        List<Object> list = new ArrayList<Object>();
        for (int i=1; i<=3; i++){
            Map<String,Object> map = new HashMap<>();
            map.put("title","程序设计基础:"+i);
            map.put("price", i*10 + "$");
            list.add(map);
        }
        jsonObject1.put("book",list);
        System.out.println(jsonObject1);

        //bookMap类型不能作为数组
        JSONObject jsonObject2 = new JSONObject();
        Map<String,Object> bookmap = new HashMap<>();
        for (int i=1; i<=3; i++){
            bookmap.put("title","程序设计基础:"+i);
            bookmap.put("price", i*10 + "$");
        }
        jsonObject1.put("book",bookmap);
        System.out.println(jsonObject2);

        //bean类型
        Student student = new Student();
        student.setName("Devin");
        student.setAge(22);
        student.setSex("male");

        //不支持直接put bean类型
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("student",student);
        System.out.println(jsonObject3);

        //构造器支持bean类型
        JSONObject jsonObject4 = new JSONObject(student);
        System.out.println(jsonObject4);

        //支持put JSONObject类型
        JSONObject jsonObject5 = new JSONObject();
        jsonObject5.put("student",jsonObject4);
        System.out.println(jsonObject5);
    }

}
