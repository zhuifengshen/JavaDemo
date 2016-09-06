package mike.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Devin on 8/15/2016.
 */
public class ParallelStream {
    public static void main(String[] args) {
        List<String> bigLists = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            UUID uuid = UUID.randomUUID();
            bigLists.add(uuid.toString());
        }
        long startTime = System.nanoTime();
        long count = bigLists.stream().sorted().count();
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.printf("串行排序:%d ms",millis);

        startTime = System.nanoTime();
        count = bigLists.parallelStream().sorted().count();
        endTime = System.nanoTime();
        millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.printf("并行排序:%d ms",millis);
    }
}
