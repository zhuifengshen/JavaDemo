package json;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Devin on 2016/9/12.
 */
public class JSONTokenerTest {
    public static void main(String[] args) throws FileNotFoundException {
        readJsonFile();
    }
    public static void readJsonFile() throws FileNotFoundException {
        JSONTokener jsonTokener = new JSONTokener(new FileReader(new File("json.txt")));
        JSONObject jsonObject = new JSONObject(jsonTokener);
        System.out.println(jsonObject);
        System.out.println("姓名：" + jsonObject.getString("name"));
        System.out.println("性别:" + jsonObject.getString("sex"));
        System.out.println("年龄:" + jsonObject.getInt("age"));
    }
}
