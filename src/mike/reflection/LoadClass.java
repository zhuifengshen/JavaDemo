package mike.reflection;

/**
 * Created by Devin on 2016/7/20.
 */
public class LoadClass {
    public static void main(String[] args){
        Object object = null;
        ClassLoader classLoader = LoadClass.class.getClassLoader();
        try{
            Class aClass = classLoader.loadClass("mike.reflection.PrivateObject");
            System.out.println("aClass's name:" + aClass.getName());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
