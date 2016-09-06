package mike.test;

/**
 * Created by Devin on 2016/7/13.
 */
public class Mammal implements Animal{

    @Override
    public void eat() {
        System.out.println("Mamal eats");
    }

    @Override
    public void travel() {
        System.out.println("Mammal travels");
    }

    public int numOfLegs(){
        return 2;
    }

    public static void main(String[] args){
        Mammal mammal = new Mammal();
        mammal.eat();
        mammal.travel();
    }
}
