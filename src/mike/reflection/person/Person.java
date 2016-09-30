package mike.reflection.person;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/9/30 17:19
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class Person {
    private String name;
    private String gender;
    private int age;
    public Person(){

    }
    public Person(String name, String gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
