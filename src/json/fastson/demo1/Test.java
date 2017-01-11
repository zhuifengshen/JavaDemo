package json.fastson.demo1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2017/1/11 15:14
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class Test{
    //SerializeConfig：是对序列化过程中一些序列化过程的特殊配置
    private static SerializeConfig serializeConfig = new SerializeConfig();
    static {
        serializeConfig.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Date date = new Date();
        System.out.println(JSON.toJSONString(date, serializeConfig));
        //System.out.println(JSON.toJSONString(foo, true));
        System.out.println(JSON.toJSONString(foo, serializeConfig));
    }
}
