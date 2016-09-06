package mike.innerclass;

/**
 * Created by Devin on 2016/7/14.
 * 在使用匿名内部类的过程中，我们需要注意如下几点：

 1、使用匿名内部类时，我们必须是继承一个类或者实现一个接口，但是两者不可兼得，同时也只能继承一个类或者实现一个接口。

 2、匿名内部类中是不能定义构造函数的。

 3、匿名内部类中不能存在任何的静态成员变量和静态方法。

 4、匿名内部类为局部内部类，所以局部内部类的所有限制同样对匿名内部类生效。

 5、匿名内部类不能是抽象的，它必须要实现继承的类或者实现的接口的所有抽象方法。
 */
public class AnonymousInner {
    public void test(Bird bird){
        System.out.println(bird.getName() + "能够飞" + bird.fly() + "米!");
    }

    public static void main(String[] args){
        AnonymousInner anonymousInner = new AnonymousInner();
        anonymousInner.test(new Bird() {
            @Override
            public String getName(){
                return "小燕子";
            }
            @Override
            public int fly() {
                return 10000;
            }
        });
    }
}

abstract class Bird{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}