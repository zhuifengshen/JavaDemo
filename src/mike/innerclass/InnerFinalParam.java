package mike.innerclass;

/**
 * Created by Devin on 2016/7/14.
 * 匿名方法内部类是可以作为返回对象被别人持有的。不过，这个时候，方法已经运行结束，而方法中的变量是保存在栈里面的，同样生命周期也结束了。这个时候，如果匿名内部类还使用到方法里面的变量的话，会产生歧义。
 基于这个原因，java用了拷贝的方式来解决这个问题。拷贝了，又会照成不一致问题，所以干脆就用了final。
 */
public class InnerFinalParam {
    public Job getJob(){
        final int i = 1;
        return  new Job() {
            @Override
            public void print() {
                System.out.println(i);
            }
        };
    }
}

interface Job{
    void print();
}