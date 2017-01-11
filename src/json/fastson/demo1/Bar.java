package json.fastson.demo1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2017/1/11 14:51
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class Bar {
    public static SerializeConfig serializeConfig = new SerializeConfig();
    private String barName;
    private int barAge;
    private Date barDate = new Date();

    static{
        serializeConfig.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd"));
    }
    {
        Random random = new Random();
        barName = "bar_" + String.valueOf(random.nextFloat());
        barAge = random.nextInt();
    }

    public static void main(String[] args) {
        Object object = JSON.toJSON(new Bar());
        System.out.println(JSON.toJSONString(new Bar(), true));
        System.out.println(JSON.toJSONString(new Bar(), serializeConfig));
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public int getBarAge() {
        return barAge;
    }

    public void setBarAge(int barAge) {
        this.barAge = barAge;
    }

    public Date getBarDate() {
        return barDate;
    }

    public void setBarDate(Date barDate) {
        this.barDate = barDate;
    }

    @Override
    public String toString(){
        return "Bar{" + "barName:" + barName + ", barAge:" + barAge + ", barDate:" + barDate + "}";
    }
}
