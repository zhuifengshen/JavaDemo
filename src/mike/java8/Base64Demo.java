package mike.java8;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by Devin on 2016/7/14.
 * 对Base64的支持最终成了Java 8标准库的一部分，非常简单易用：
 * Base64.getUrlEncoder() / Base64.getUrlDecoder(), Base64.getMimeEncoder() / Base64.getMimeDecoder() / Base64.getEncoder() / Base64.getDecoder()
 *
 */
public class Base64Demo {
    public static void main(String[] args){
        try{
            String base64encodeedString = Base64.getEncoder().encodeToString("ZhangChuZhao 张楚昭".getBytes("utf-8"));
            System.out.println("Base64加密后的字符串：" + base64encodeedString);

            byte[] base64decodeBytes = Base64.getDecoder().decode(base64encodeedString);
            System.out.println("原始字符串：" + new String(base64decodeBytes, "utf-8"));

            base64encodeedString = Base64.getUrlEncoder().encodeToString("www.baidu.com?search".getBytes("utf-8"));
            System.out.println("Base64加密后的UIL:" + base64encodeedString);

            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < 10; i++){
                stringBuilder.append(UUID.randomUUID().toString());
            }
            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodeString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64加密后的MIME:" + mimeEncodeString);

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

    }
}
