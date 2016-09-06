package mike.test;

/**
 * Created by Devin on 8/17/2016.
 */
public interface Inter {
    //String toString();
    boolean equals(Object obj);
    void finalize() throws Throwable;
    int hashCode();
    Object clone() throws ClassNotFoundException;

    String hello();
}
