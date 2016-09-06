package mike.innerclass;

/**
 * Created by Devin on 2016/7/14.
 */
public class OuterClass {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public class InnerClass{
        public InnerClass(){
            name = "devin";
            age = 23;
        }
        public void innerDisplay(){
            System.out.println("InnerClass -> name:" + getName() + ";age:" + getAge());
        }
        public OuterClass getOuterClass(){
            return OuterClass.this;
        }
    }

    public InnerClass getInnerClass(){
        return new InnerClass();
    }

    public void outterDisplay(){
        System.out.println("OuterClass -> name:" + getName() + ";age:" + getAge());
    }

    public static void main(String[] args){
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.getInnerClass();//outerClass.new InnerClass();
        innerClass.innerDisplay();
        innerClass.getOuterClass().outterDisplay();

        OuterClass.InnerClass innerClass1 = outerClass.new InnerClass();

    }
}
