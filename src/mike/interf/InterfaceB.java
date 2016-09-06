package mike.interf;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

/**
 * Created by Devin on 8/22/2016.
 */
public interface InterfaceB {
    int num = 2222;
    String key2 = "减法";
    int minus(int x, int y);
    byte[] decryt(String src) throws Base64DecodingException;
    int get();
}
