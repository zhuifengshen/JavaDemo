package mike.serialized;

import java.io.*;

/**
 * Created by Devin on 2016/7/13.
 */
public class SerializeDemo {
    public static void main(String[] args){
        Employee employee = new Employee();
        employee.name = "devin";
        employee.address = "guangzhou";
        employee.SSN = 12344556;
        employee.number = 111;
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("employee.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        /*
            反序列化
         */
        Employee employee1 = null;
        try{
            FileInputStream fileInputStream = new FileInputStream("employee.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            employee1 = (Employee)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }catch (IOException i){
            i.printStackTrace();
            return;
        }catch (ClassNotFoundException c){
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee:");
        System.out.println("Name:" + employee1.name);
        System.out.println("Address:" + employee1.address);
        System.out.println("SSN:" + employee1.SSN);
        System.out.println("Number:" + employee1.number);
    }

}
