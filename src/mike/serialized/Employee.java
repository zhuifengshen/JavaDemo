package mike.serialized;

import java.io.Serializable;

/**
 * Created by Devin on 2016/7/13.
 */
public class Employee implements Serializable{
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public void mailCheck(){
        System.out.println("Mailing a check to" + name + " " + address);
    }
}
