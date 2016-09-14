package json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Devin on 2016/9/12.
 */
public class JSONParser {
    public static void main(String[] args) throws FileNotFoundException {
        JSONTokener jsonTokener = new JSONTokener(new FileReader(new File("json.txt")));
        //获取整个JSON的内容，因为最外层是数组，所以使用JSONArray来构造
        JSONArray jsonArray = new JSONArray(jsonTokener);
        System.out.println(jsonArray);

        //这个JSONArray只有一个JSONObject,标记为jsonObject1
        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
        System.out.println(jsonObject1);

        //jsonObject1中只包含一个institute字段,标记为jsonObject2
        JSONObject jsonObject2 = jsonObject1.getJSONObject("institute");
        System.out.println(jsonObject2);

        //jsonObject2包含name字段和grdle字段,其中gradle字段为一个JSONArray
        String instituteName = jsonObject2.getString("name");
        System.out.println("学院名称:" + instituteName);
        JSONArray gradleArray = jsonObject2.getJSONArray("gradle");
        System.out.println(gradleArray);

        //gradleArray中包含三个对象,我们获取第二个对象sophomore
        JSONObject sophomoreObject = gradleArray.getJSONObject(1);
        System.out.println(sophomoreObject);

        //sophomoreObject对象中包含字段name和class,其中class字段为JSONArray
        String sophomoreName = sophomoreObject.getString("name");
        System.out.println("大二名称:" + sophomoreName);
        JSONArray classArray = sophomoreObject.getJSONArray("class");
        System.out.println(classArray);

        //classArray包含三个对象,我们获取第二个对象
        JSONObject No2Object = classArray.getJSONObject(1);

        //No2Object包含两个字段no.和students
        int classNum = No2Object.getInt("no.");
        int studentNum = No2Object.getInt("students");
        System.out.println("学院:" + instituteName + " 年级:" + sophomoreName + " " + classNum + " 班的人数:" + studentNum);

    }
}
