package mike.java8;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Devin on 8/17/2016.
 */
public class ParallelArrays {
    public static void main(String[] args) {
        long[] arrays = new long[10000];
        Arrays.parallelSetAll(arrays, index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrays).limit(20).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.parallelSort(arrays);
        Arrays.stream(arrays).limit(20).forEach(i -> System.out.print(i + " "));
    }
}
