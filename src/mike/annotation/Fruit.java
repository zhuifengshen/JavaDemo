package mike.annotation;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2016/9/21 15:43
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class Fruit{
    public void displayName(){
        System.out.println("水果的名字是：*****");
    }
}
class Orange extends Fruit{
    @Override
    public void displayName(){
        System.out.println("水果的名字是：桔子");
    }
}

//class Peach extends Fruit{
//    @Override
//    public void displayname(){
//        System.out.println("水果的名字是：桃子");
//    }
//}