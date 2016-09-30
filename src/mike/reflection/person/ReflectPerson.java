package mike.reflection.person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/9/30 17:23
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 *
 * 动态获取信息以及动态调用对象方法的功能称为Java语言的反射机制

 * 动态性质:
 运行时生成对象实例;
 运行期间调用方法；
 运行时更改属性

 * Java反射API用来生成在当前JAVA虚拟机中的类、接口或者对象的信息:
 Class类:反射的核心类，可以获取类的属性，方法等内容信息。
 Field类:Java.lang.reflect.表示类的属性，可以获取和设置类的中属性值。
 Method类:Java.lang.reflect。表示类的方法，它可以用来获取类中方法的信息或者执行方法
 Construcor类:Java.lang.reflect。表示类的构造方法。

 * Java反射机制能实现的功能:
 在运行时判断任意一个对象所属的类
 在运行时构造任意一个类的对象
 在运行时判断任意怀个类所具有的方法和属性
 在运行时调用任意一个对象的方法
 生成动态代理
 */

public class ReflectPerson {
    public static void main(String[] args) throws ClassNotFoundException {
        //class对象
        String classpath ="mike.reflection.person.Person";
        Class personClass = Class.forName(classpath);
        //Class person = new Person().getClass();
        //Class person = Person.class;
        //method数组
        Method[] methods = personClass.getDeclaredMethods();//getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());//toString();
        }
        //field属性
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());//toString();
        }
        //constructor构造器
        Constructor[] constructors = personClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            //System.out.println(constructor.getName());
            System.out.println(constructor.toString());
        }
    }
}
