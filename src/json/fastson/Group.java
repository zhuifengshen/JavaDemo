package json.fastson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2017/1/11 10:24
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class Group {
    private Long id;
    private String name;
    @JSONField(name = "user_list")
    private List<User> users = new ArrayList<>();

    public List<User> getUsers(){
        return users;
    }
    public void setUsers(List<User> users){
        this.users = users;
    }
    public void addUser(User user){
        users.add(user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
