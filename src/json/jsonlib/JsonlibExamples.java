package json.jsonlib;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by Devin on 2016/9/13.
 */
public class JsonlibExamples {
    //Java Bean 转换成JSON对象
    public static void testBean2Json(){
        MyBean bean = new MyBean();
        bean.setId("001");
        bean.setName("银行卡");
        bean.setDate(new Date());
        List cardNum = new ArrayList();
        cardNum.add("农行");
        cardNum.add("中国");
        cardNum.add("工商");
        bean.setCardNum(cardNum);
        JSONObject jsonObject = JSONObject.fromObject(bean);
        System.out.println(jsonObject);
    }
    //将普通类型的JSON字符串转换成JSON
    public static void testJson2Object() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String json = "{name='json',bool:true,int:1,double:2.2,func:function(a){ return a;},array:[1,2]}";
        JSONObject jsonObject = JSONObject.fromObject(json);
        System.out.println(jsonObject);

        Object bean = JSONObject.toBean(jsonObject);
        System.out.println(PropertyUtils.getProperty(bean,"name"));
        System.out.println(PropertyUtils.getProperty(bean,"func"));
        List arrayList = (List)JSONArray.toCollection(jsonObject.getJSONArray("array"));
        for (Object o : arrayList) {
            System.out.println(o);
        }
    }
    //将复合类型的JSON字符串转换成复合对象
    public static void testJson2Bean(){
        String personList = "{list:[{name:'devin'},{name:'kevin'}]}";
        Map personMap = new HashMap();
        personMap.put("list",Person.class);
        MyBeanWithPerson diyBean = (MyBeanWithPerson)JSONObject.toBean(JSONObject.fromObject(personList),MyBeanWithPerson.class,personMap);
        System.out.println(diyBean);
        List list = diyBean.getList();
        for (Object o : list) {
            if (o instanceof Person){
                Person person = (Person)o;
                System.out.println(person.getName());
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //testBean2Json();
        //testJson2Object();
        testJson2Bean();
    }
}
