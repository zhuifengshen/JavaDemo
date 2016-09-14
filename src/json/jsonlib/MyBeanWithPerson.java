package json.jsonlib;

import java.util.List;
import java.util.Map;

/**
 * Created by Devin on 2016/9/13.
 */
public class MyBeanWithPerson {
    private List<Person> list;
    private Map<String,Person> map;

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public Map<String, Person> getMap() {
        return map;
    }

    public void setMap(Map<String, Person> map) {
        this.map = map;
    }
}
