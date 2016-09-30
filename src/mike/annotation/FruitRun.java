package mike.annotation;

/**
 * Created by Devin on 2016/7/19.
 */
public class FruitRun {
    //@SuppressWarnings({"deprecation"})
    public static void main(String[] args) {
        AppleService appleService=new AppleService();
        appleService.showTaste();
        appleService.showTaste(0);
        appleService.showTaste(2);
    }
}
