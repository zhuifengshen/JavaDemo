package mike.interf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Devin on 8/22/2016.
 */
public abstract class Test {
    public static void main(String[] args) {
        System.out.println(123);
        Map map = new HashMap<>();
    }


     interface Entry{
        int getKey();
    }
}
