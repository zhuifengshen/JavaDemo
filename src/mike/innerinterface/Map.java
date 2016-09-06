package mike.innerinterface;

/**
 * 内部接口
 * 一种对那些在同一个地方使用的接口进行逻辑上分组
 * 嵌套接口可以增强代码的易读性和可维护性
 * 内部接口,不管有没有声明static,都是静态的,同时不管有没有声明public,可见性都是public
 */
public interface Map {
    //内部接口
    interface Entry{
        int getKey();
    }
    void clear();
}
