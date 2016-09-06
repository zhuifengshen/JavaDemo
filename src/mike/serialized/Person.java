package mike.serialized;

import java.io.Serializable;

/**
 * Created by Devin on 2016/7/29.
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 2735089661548963503L;
    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
