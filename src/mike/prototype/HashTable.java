//package mike.prototype;
//
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
//
///**
// * Created by Devin on 2016/7/27.
// */
//public class HashTable {
//
//
//    public Hashtable(int initialCapacity, float loadFactor) {        //验证初始容量
//        if (initialCapacity < 0)
//            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);        //验证加载因子
//        if (loadFactor <= 0 || Float.isNaN(loadFactor))
//            throw new IllegalArgumentException("Illegal Load: " + loadFactor);
//        if (initialCapacity == 0) initialCapacity = 1;
//        this.loadFactor = loadFactor;                //初始化table，获得大小为initialCapacity的table数组
//        table = new Entry[initialCapacity];        //计算阀值
//        threshold = (int) Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);        //初始化HashSeed值
//        initHashSeedAsNeeded(initialCapacity);
//    }
//
//    public synchronized V put(K key, V value) {        // 确保value不为null
//        if (value == null) {
//            throw new NullPointerException();
//        }
//        /*         * 确保key在table[]是不重复的         * 处理过程：
//        * * 1、计算key的hash值，确认在table[]中的索引位置
//        * * 2、迭代index索引位置，如果该位置处的链表中存在一个一样的key，则替换其value，返回旧值         */
//        Entry tab[] = table;
//        int hash = hash(key);    //计算key的hash值
//        int index = (hash & 0x7FFFFFFF) % tab.length;     //确认该key的索引位置        //迭代，寻找该key，替换
//        for (Entry<K, V> e = tab[index]; e != null; e = e.next) {
//            if ((e.hash == hash) && e.key.equals(key)) {
//                V old = e.value;
//                e.value = value;
//                return old;
//            }
//        }
//        modCount++;
//        if (count >= threshold) {  //如果容器中的元素数量已经达到阀值，则进行扩容操作
//            rehash();
//            tab = table;
//            hash = hash(key);
//            index = (hash & 0x7FFFFFFF) % tab.length;
//        }        // 在索引位置处插入一个新的节点
//        Entry<K, V> e = tab[index];
//        tab[index] = new Entry<>(hash, key, value, e);        //容器中元素+1
//        count++;
//        return null;
//    }
//
//    protected void rehash() {
//        int oldCapacity = table.length;        //元素
//        Entry<K, V>[] oldMap = table;        //新容量=旧容量 * 2 + 1
//        int newCapacity = (oldCapacity << 1) + 1;
//        if (newCapacity - MAX_ARRAY_SIZE > 0) {
//            if (oldCapacity == MAX_ARRAY_SIZE) return;
//            newCapacity = MAX_ARRAY_SIZE;
//        }
//        //新建一个size = newCapacity 的HashTable
//        Entry<K, V>[] newMap = new Entry[];
//        modCount++;        //重新计算阀值
//        threshold = (int) Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);        //重新计算hashSeed
//        boolean rehash = initHashSeedAsNeeded(newCapacity);
//        table = newMap;        //将原来的元素拷贝到新的HashTable中
//        for (int i = oldCapacity; i-- > 0; ) {
//            for (Entry<K, V> old = oldMap[i]; old != null; ) {
//                Entry<K, V> e = old;
//                old = old.next;
//                if (rehash) {
//                    e.hash = hash(e.key);
//                }
//                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
//                e.next = newMap[index];
//                newMap[index] = e;
//            }
//        }
//    }
//
//}
//
