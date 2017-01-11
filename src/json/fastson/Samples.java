package json.fastson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import json.fastson.demo1.Bar;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2017/1/11 10:27
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class Samples {
    public static void main(String[] args) {
        //demo1();
        //demo2();
        //map2JSON();
        array2JSON();
        //toJsonString();
        //parseJsonString();

    }
    //构建JSONObject
    public static void demo1(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aa", "11");
        jsonObject.put("bb", "22");
        jsonObject.put("cc", "33");
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
        System.out.println(JSONObject.parseObject(jsonString).get("bb"));
    }
    //获取节点值
    public static void demo2(){
        String jsonString = "{'area':{'area':'1','pagetype':'home'},'pagetype':'home'}";
        System.out.println(((Map)JSONObject.parseObject(jsonString).get("area")).get("area"));
        Map<String, Object> userMap = JSON.parseObject(jsonString, new TypeReference<Map<String, Object>>(){});
        System.out.println(JSON.toJSONString((Map)userMap.get("area")));
        System.out.println(JSON.toJSONString(userMap.get("pagetype")));
    }

    public static void map2JSON(){
        Map map = new HashMap();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        String mapJson = JSON.toJSONString(map);
        System.out.println(mapJson);

        Map map1 = JSON.parseObject(mapJson);
        for (Object object : map.entrySet()){
            Map.Entry<String, String> entry = (Map.Entry<String, String>)object;
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void array2JSON(){
        Bar[] bars = {new Bar(), new Bar(), new Bar()};
        String barJson = JSON.toJSONString(bars, true);
        System.out.println(barJson);
        JSONArray jsonArray = JSON.parseArray(barJson);
        for (Object object :jsonArray){
            System.out.println(object);
        }
        System.out.println(jsonArray);
    }

    //序列化
    public static void toJsonString(){
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");
        guestUser.setAge(1);

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");
        rootUser.setAge(99);

        group.addUser(guestUser);
        group.addUser(rootUser);

        String userJson = JSON.toJSONString(rootUser);
        System.out.println(userJson);
        String groupJson = JSON.toJSONString(group);
        System.out.println(groupJson);
    }
    //反序列化
    public static void parseJsonString(){
        //String jsonString = "{\"id\":0,\"name\":\"admin\",\"users\":[{\"id\":2,\"name\":\"guest\"},{\"id\":3,\"name\":\"root\"}]}";
        String jsonString = "{\"id\":0,\"name\":\"admin\",\"user_list\":[{\"id\":2,\"name\":\"guest\"},{\"id\":3,\"name\":\"root\"}]}";
        Group group = JSON.parseObject(jsonString, Group.class);
        System.out.println("Group ID: " + group.getId() + " Group Name: " + group.getName() + " Group User: " + group.getUsers());
    }

    public static void dateTimeFormat(){
        System.out.println(JSON.toJSONString(new Date()));
        System.out.println(JSON.toJSONString(new Date(), true));
        System.out.println(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
        System.out.println(JSON.toJSONStringWithDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));

    }
}
