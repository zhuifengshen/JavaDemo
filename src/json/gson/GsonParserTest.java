package json.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by Devin on 2016/9/14.
 */
public class GsonParserTest {
    public static void main(String[] args) {
        //要解析json数据
        String json = "{'roomname':[{'PCnum':0,'num':2,'name':'biubiubiu','time':'Dec 22, 2015'},"
                + "{'PCnum':0,'num':1,'name':'jtz','time':'Dec 18, 2015'},"
                + "{'PCnum':0,'num':0,'name':'JTZen9','time':'Dec 22, 2015'}]}";
        Gson gson = new Gson();
        Type type = new TypeToken<JsonBean>(){}.getType();
        JsonBean jsonBean = gson.fromJson(json,type);
        System.out.println(jsonBean.roomname.size());
        for (int i = 0; i < jsonBean.roomname.size(); i++) {
            System.out.println(jsonBean.roomname.get(i).name + " " + jsonBean.roomname.get(i).time);
        }
    }
}
