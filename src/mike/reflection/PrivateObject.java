package mike.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Devin on 2016/7/19.
 */
public class PrivateObject {
    private String privateString = null;
    public PrivateObject(String string){
        this.privateString = string;
    }
    private String getPrivateString(){
        return this.privateString;
    }

    public static void main(String[] args) throws Exception{
        PrivateObject privateObject = new PrivateObject("The private value");
        Class privateObjectClass = PrivateObject.class;
        Field privateObjectField = privateObjectClass.getDeclaredField("privateString");
        privateObjectField.setAccessible(true);
        String fieldValue = (String)privateObjectField.get(privateObject);
        System.out.println(fieldValue);
        Method privateObjectMethod = privateObjectClass.getDeclaredMethod("getPrivateString", null);
        privateObjectMethod.setAccessible(true);
        String returnValue = (String)privateObjectMethod.invoke(privateObject, null);
        System.out.println(returnValue);
    }

}
