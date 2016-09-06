package mike.demo;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by Devin on 2016/7/8.
 */
public class HelloApp {
    public static void main(String[] args) throws IOException {
        //byte[] bWrite = {1, 2, 3, 4 ,5};
        //OutputStream os = new FileOutputStream("test.txt");
        //for(int xx = 0; xx < bWrite.length; xx++){
        //    os.write(bWrite[xx]);
        //}
        //os.close();
        //System.out.println("hello");
        //
        //InputStream is = new FileInputStream("test.txt");
        //int size = is.available();
        //
        //for (int i = 0; i < size; i++){
        //    System.out.println((char)is.read() + " ");
        //}
        //is.close();

        //File file = new File("test.txt");
        //FileOutputStream fop = new FileOutputStream(file);
        //OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        //writer.append("中午输入");
        //writer.append("\r\n");
        //writer.append("English");
        //writer.close();
        //fop.close();
        //
        //FileInputStream fip = new FileInputStream(file);
        //InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        //StringBuffer sb = new StringBuffer();
        //while (reader.ready()){
        //    sb.append((char)reader.read());
        //}
        //System.out.println(sb.toString());
        //reader.close();
        //fip.close();

        //Scanner scan = new Scanner(System.in);
        //System.out.println("next方式接收：");
        //if(scan.hasNext()){
        //    String str1 = scan.next();
        //    System.out.println("输出数据为：" + str1);
        //}
        Enumeration days;
        Vector dayNames = new Vector();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }

        Hashtable balance = new Hashtable();
        Enumeration names;
        String str;
        double bal;
        balance.put("zhang", new Double(323.23));
        balance.put("chu", new Double(3224332.32));
        balance.put("zhao", new Double(324132.4534));
        names = balance.keys();
        while (names.hasMoreElements()){
            str = (String)names.nextElement();
            System.out.println(str + ":" + balance.get(str));
        }
        System.getProperties();
    }
    //泛型方法
    public static <E> void printArray(E[] inputArray){
        for(E element : inputArray){
            System.out.println(element);
        }
        System.out.println();
    }
    //Max
    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;
        if(y.compareTo(max) > 0){
            max = y;
        }
        if(z.compareTo(max) > 0){
            max = z;
        }
        return max;
    }
}
