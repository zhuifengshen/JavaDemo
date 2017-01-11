package json.fastson;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2017/1/11 10:23
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class User {
    @JSONField(ordinal = 1)
    private Long id;
    @JSONField(ordinal = 2)
    private String name;
    //@JSONField(serialize = false)
    @JSONField(ordinal = 3)
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
