package mike.java8;

/**
 * Created by Devin on 8/15/2016.
 */
interface AnimalFactory<T extends Animal>{
    T create(String name,int age);
}
