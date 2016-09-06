package mike.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Devin on 8/16/2016.
 */
public class TypeInferenceTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        Vector vector = new Vector<String>();
        Vector<Integer> vector1 = vector;
    }
}
