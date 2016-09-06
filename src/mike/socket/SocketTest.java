package mike.socket;

import java.io.IOException;
import java.net.*;

/**
 * Created by Devin on 8/18/2016.
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println(ip.isReachable(2000));
        System.out.println(ip.getHostAddress());
        InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
        System.out.println(local.isReachable(2000));
        System.out.println(local.getCanonicalHostName());

        String keyword = URLDecoder.decode("%E6%9D%8E%E5%88%9A+j2ee","UTF-8");
        System.out.println(keyword);
        String urlString = URLEncoder.encode("张楚昭", "GBK");
        System.out.println(urlString);

        String url = "www.baidu.com/s";
        String param = "wd=百度";
        String urlName = url + "?" + param;
        URL realUrl = new URL(urlName);
        URLConnection connection = realUrl.openConnection();
        connection.setRequestProperty("accept","*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        connection.connect();
        //connection.setDoOutput(true);
        //connection.setDoInput(true);
        //out = new PrintWriter(connection.getOutputStream());
        //out.print(param);

        String string = "bye";
        string.indexOf("bye");
    }
}
