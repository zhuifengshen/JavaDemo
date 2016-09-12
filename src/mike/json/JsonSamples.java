package mike.json;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Devin on 2016/9/8.
 */
public class JsonSamples {
    public static void main(String[] args) throws IOException {
        //URL url = new URL("https://graph.facebook.com/search?q=java&type=post");
        //JsonReader jsonReader = Json.createReader(is);
        //InputStream inputStream = url.openStream();
        //JSONParser parser = Json.createParser(inputStream);

        constructorTest();
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
}
