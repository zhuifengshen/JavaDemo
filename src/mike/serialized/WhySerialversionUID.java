package mike.serialized;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by Devin on 2016/7/29.
 */
public class WhySerialversionUID {
    public static void main(String[] args) throws Exception{
        //Person devin = new Person();
        //devin.setName("devinzhang");
        //ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("devin.file"));
        //objectOutputStream.writeObject(devin);
        //objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("devin.file"));
        Person devinzhang = (Person)objectInputStream.readObject();
        System.out.println("Hi, my name is " + devinzhang.getName());
        System.out.println("Hi, my name is " + devinzhang.getAddress());
        objectInputStream.close();
    }
}
