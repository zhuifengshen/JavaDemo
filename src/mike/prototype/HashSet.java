//package mike.prototype;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//
///**
// * Created by Devin on 2016/7/27.
// */
//public class HashSet {
//    /**
//     * 默认构造函数         * 初始化一个空的HashMap，并使用默认初始容量为16和加载因子0.75。
//     */
//    public HashSet() {
//        map = new HashMap<>();
//    }
//
//    /**
//     * 构造一个包含指定 collection 中的元素的新 set。
//     */
//    public HashSet(Collection<? extends E> c) {
//        map = new HashMap<>(Math.max((int) (c.size() / .75f) + 1, 16));
//        addAll(c);
//    }
//
//    /**
//     * 构造一个新的空 set，其底层 HashMap 实例具有指定的初始容量和指定的加载因子
//     */
//    public HashSet(int initialCapacity, float loadFactor) {
//        map = new HashMap<>(initialCapacity, loadFactor);
//    }
//
//    /**
//     * 构造一个新的空 set，其底层 HashMap 实例具有指定的初始容量和默认的加载因子（0.75）。
//     */
//    public HashSet(int initialCapacity) {
//        map = new HashMap<>(initialCapacity);
//    }
//
//    /**
//     * 在API中我没有看到这个构造函数，今天看源码才发现（原来访问权限为包权限，不对外公开的）         * 以指定的initialCapacity和loadFactor构造一个新的空链接哈希集合。         * dummy 为标识 该构造函数主要作用是对LinkedHashSet起到一个支持作用
//     */
//    HashSet(int initialCapacity, float loadFactor, boolean dummy) {
//        map = new LinkedHashMap<>(initialCapacity, loadFactor);
//    }
//}
