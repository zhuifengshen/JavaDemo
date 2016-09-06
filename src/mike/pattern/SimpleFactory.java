package mike.pattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Devin on 2016/7/20.
 */
public class SimpleFactory {
    public static void main(String[] args) throws ClassNotFoundException, IOException{
        Fruit fruit = FruitFactory.getInstance("apple");
        fruit.eat();
        Properties fruitList = InitFruitList.getFruitList();
        Fruit newFruit = NewFruitFactory.getInstance(fruitList.getProperty("orange"));
        if (newFruit != null){
            newFruit.eat();
        }
    }
}

interface Fruit{
    public abstract void eat();
}

class Apple implements Fruit{
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}

class Orange implements Fruit{
    @Override
    public void eat() {
        System.out.println("eat orange");
    }
}
//创建水果列表子类，用户直接调用添加新水果品种
class InitFruitList{
    public static Properties getFruitList() throws ClassNotFoundException, IOException{
        Properties fruitList = new Properties();
        File file = new File("file.properties");
        if(file.exists()){
            fruitList.load(new FileInputStream(file));
        }else {
            fruitList.setProperty("apple","mike.pattern.factory.Apple");
            fruitList.setProperty("orange","mike.pattern.factory.Orange");
            fruitList.store(new FileOutputStream(file), "Fruit Class");
        }
        return fruitList;
    }
}
//简单工厂模式，添加新水果子类，我们则需要修改工厂类
class FruitFactory{
    public static Fruit getInstance(String friutName){
        Fruit fruit = null;
        if ("apple".equals(friutName)){
            fruit = new Apple();
        }
        if ("orange".equals(friutName)){
            fruit = new Orange();
        }
        return fruit;
    }
}
//通过反射调用，我们可以添加任意多水果种类而不需修改工厂类
class NewFruitFactory{
    public static Fruit getInstance(String fruitName){
        Fruit fruit = null;
        try{
            fruit = (Fruit)Class.forName(fruitName).newInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return fruit;
    }
}
