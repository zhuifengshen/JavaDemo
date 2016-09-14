package json.jsonlib;

/**
 * Created by Devin on 2016/9/13.
 */
public class Person {
    private String name;
    public Person(){

    }
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
