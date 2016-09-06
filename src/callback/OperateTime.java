package callback;

/**
 * Created by Devin on 8/23/2016.
 */
public class OperateTime {
    public double getTime(CallbackInterface callback){
        long start = System.currentTimeMillis();
        callback.executeMethod();
        long end = System.currentTimeMillis();
        return end - start;
    }
}
