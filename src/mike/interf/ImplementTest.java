package mike.interf;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * Created by Devin on 8/22/2016.
 */
public class ImplementTest implements InterfaceC {
    @Override
    public int add(int x, int y) {
        return x+y;
    }

    @Override
    public String encryt(byte[] result) {
        return Base64.encode(result);
    }

    @Override
    public int minus(int x, int y) {
        return x-y;
    }

    @Override
    public byte[] decryt(String src) throws Base64DecodingException {
        return Base64.decode(src);
    }

    @Override
    public double divide(int x, int y) {
        return x/y;
    }

    @Override
    public int get() {
        return 1;
    }

    public void print(){
        System.out.println(key1 + " " + key2 + " " + InterfaceA.num);
    }

    public static void main(String[] args) {
        System.out.println(new ImplementTest().get());
    }
}
