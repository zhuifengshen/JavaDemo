package callback;

/**
 * Created by Devin on 8/23/2016.
 */
public class OperateMethod implements CallbackInterface{
    public void testMethod(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void executeMethod() {
        new OperateMethod().testMethod();
    }

    public static void main(String[] args) {
        double comsumeTime = new OperateTime().getTime(new OperateMethod());
        System.out.println("程序运行时间:" + comsumeTime);
    }
}
