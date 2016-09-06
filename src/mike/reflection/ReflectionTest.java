package mike.reflection;

import java.lang.reflect.*;
import java.util.List;

/**
 * Created by Devin on 2016/7/19.
 */
public class ReflectionTest {
    public List<String> stringList = null;

    protected List<Integer> intList = null;

    public List<String> getStringList(){
        return stringList;
    }
    public void setStringList(List<String> list){
        this.stringList = list;
    }

    public static void main(String[] args)throws Exception{
        //数组反射
        int[] intArray = (int[]) Array.newInstance(int.class, 3);
        Array.set(intArray, 0, 123);
        Array.set(intArray, 1, 234);
        Array.set(intArray, 2, 345);
        System.out.println("intArray[0] = " + Array.get(intArray, 0));
        System.out.println("intArray[1] = " + Array.get(intArray, 1));
        System.out.println("intArray[2] = " + Array.get(intArray, 2));
        //获取数组Class对象
        Class stringArrayClass = String[].class;
        Class intArrayClass = Class.forName("[I");
        Class strArrayClass = Class.forName("[Ljava.lang.String;");
        System.out.println(stringArrayClass);
        System.out.println(intArrayClass);
        System.out.println(strArrayClass);
        System.out.println(strArrayClass.isArray());
        //获取数组成员类型
        String[] strings = new String[3];
        Class stringsArrayClass = strings.getClass();
        Class stringArrayComponentType = stringArrayClass.getComponentType();
        System.out.println(stringArrayComponentType);

        //泛型方法返回类型
        Method getterMethod = ReflectionTest.class.getMethod("getStringList", null);
        Type returnType = getterMethod.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
                printGenericType((ParameterizedType)returnType);
        }
        //泛型方法参数类型
        Method setterMethod = ReflectionTest.class.getMethod("setStringList", List.class);
        Type[] genericParameterTypes = setterMethod.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes){
            if (genericParameterType instanceof ParameterizedType){
                printGenericType((ParameterizedType)genericParameterType);
            }
        }
        //泛型变量类型
        Field field = ReflectionTest.class.getField("stringList");
        Type genericFieldType = field.getGenericType();
        if(genericFieldType instanceof ParameterizedType){
            printGenericType((ParameterizedType)genericFieldType);
        }
        //protected/private泛型变量访问方法
        Field intField = ReflectionTest.class.getDeclaredField("intList");
        intField.setAccessible(true);
        Type genericIntFieldType = intField.getGenericType();
        if(genericIntFieldType instanceof ParameterizedType){
            printGenericType((ParameterizedType)genericFieldType);
        }
    }

    public static void printGenericType(ParameterizedType parameterizedType){
        Type[] argumentTypes = parameterizedType.getActualTypeArguments();
        for(Type argumentType : argumentTypes){
            Class argumentTypeClass = (Class)argumentType;
            System.out.println("泛型参数类型：" + argumentTypeClass);
        }
    }
    //获取类中Getter和Setter方法
    public static void printGettersSetters(Class aClass){
        Method[] methods = aClass.getMethods();
        for(Method method : methods){
            if(isGetter(method)) System.out.println("Getter:" + method);
            if(idSetter(method)) System.out.println("Setter:" + method);
        }
    }

    public static boolean isGetter(Method method){
        if (!method.getName().startsWith("get")) return false;
        if(method.getParameterTypes().length != 0) return false;
        if(void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean idSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        return true;
    }
}
