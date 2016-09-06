package mike.reflection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Devin on 2016/7/20.
 */
public class MyObjectClassLoader extends ClassLoader {
    public MyObjectClassLoader(ClassLoader patent){
        super(patent);
    }
    public Class loadClass(String name)throws ClassNotFoundException{
        if(!"mike.reflection.MyObject".equals(name)){
            System.out.println("mike.reflection.MyObject类不存在" + name);
            return super.loadClass(name);
        }
        try{
            String url = "file:E:\\JavaEEProjects\\JavaDemo\\out\\production\\JavaDemo\\mike\\reflection\\MyObject.class";
            URL myUrl = new URL(url);
            URLConnection connection = myUrl.openConnection();
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = inputStream.read();
            while (data != -1){
                buffer.write(data);
                data = inputStream.read();
            }
            inputStream.close();
            byte[] classData = buffer.toByteArray();
            return defineClass("mike.reflection.MyObject", classData, 0, classData.length);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        ClassLoader parentClassLoader = MyObjectClassLoader.class.getClassLoader();
        MyObjectClassLoader classLoader = new MyObjectClassLoader(parentClassLoader);
        Class myObjectClass = classLoader.loadClass("mike.reflection.MyObject");
        MyObjectInterface object1 = (MyObjectInterface)myObjectClass.newInstance();
        MyObjectSuperClass object2 = (MyObjectSuperClass)myObjectClass.newInstance();

        classLoader = new MyObjectClassLoader(parentClassLoader);
        myObjectClass = classLoader.loadClass("mike.reflection.MyObject");
        object1 = (MyObjectInterface)myObjectClass.newInstance();
        object2 = (MyObjectSuperClass)myObjectClass.newInstance();
        System.out.println("类加载器");
    }

}
