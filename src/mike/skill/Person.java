package mike.skill;

/**
 * Created by Devin on 2016/7/18.
 */
public class Person {
    private int age;
    private int sex;    //0：男，1：女
    private String name;
    private final int PRIME = 37;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    Person(int age, int sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    /**
     * 省略getter、setter方法
     **/
    @Override
    public int hashCode() {
        System.out.println("调用hashCode方法...........");
        int hashResult = 1;
        hashResult = (hashResult + Integer.valueOf(age).hashCode() + Integer.valueOf(sex).hashCode()) * PRIME;
        hashResult = PRIME * hashResult + ((name == null) ? 0 : name.hashCode());
        System.out.println("name:" + name + " hashCode:" + hashResult);
        return hashResult;
    }

    /**
     * 重写hashCode()
     */
    public boolean equals(Object obj) {
        System.out.println("调用equals方法...........");
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Person person = (Person) obj;
        if (getAge() != person.getAge() || getSex() != person.getSex()) {
            return false;
        }
        if (getName() != null) {
            if (!getName().equals(person.getName())) {
                return false;
            }
        } else if (person != null) {
            return false;
        }
        return true;
    }
}