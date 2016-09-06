package mike.innerinterface;

/**
 * Created by Devin on 8/23/2016.
 */
public class MyMap implements Map {
    @Override
    public void clear() {

    }

    class MyEntry implements Map.Entry{
        @Override
        public int getKey() {
            return 10;
        }
    }

    class nonStaticInner{
        public void func(){
            System.out.println("non static inner class");
        }
    }

    static class staticInner{
        public void func(){
            System.out.println("static inner class");
        }
    }

    public static void main(String[] args) {
        Map.Entry myEntry = new MyMap().new MyEntry();//实现内部接口后,MyEntry相当于内部类
        System.out.println(myEntry.getKey());
        new MyMap().new nonStaticInner().func();//一个类的非静态内部类，必须要先有包裹类的对象才能实例化这个内部类
        new MyMap.staticInner().func();//一个类的静态内部类，因为是静态的，所有不需要有包裹类的对象就可以实例化这个内部类
    }
}
