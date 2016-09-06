package mike.test;

import java.util.ArrayList;

/**
 * Created by Devin on 8/17/2016.
 */
public class InterTest implements Inter {
    //@Override
    //public String toString() {
    //    return super.toString();
    //}

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public void finalize() throws Throwable {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public String hello() {
        return null;
    }

    public InterTest() {
        super();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("inter");
        Inter inter = null;
        Object object = inter;
        inter.toString();
        inter.clone();
        ArrayList arrayList;
    }
}
