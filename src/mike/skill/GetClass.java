package mike.skill;

/**
 * Created by Devin on 2016/7/18.
 */
public class GetClass {
    static{
        System.out.println("静态代码块。。。");
    }
    public void testClass() throws Exception{
        GetClass getClass = this.getClass().newInstance();
        getClass.test();
    }

    public void test(){
        System.out.println("test...");
    }
    public static void main(String[] args)throws Exception{
        GetClass getClass = new GetClass();
        getClass.testClass();
    }
}
