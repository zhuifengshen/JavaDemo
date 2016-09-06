package mike.prototype;

import java.util.Map;

/**
 * Created by Devin on 2016/7/21.
 */
/*


public class HashMap<K, V> {
    Entry<K, V>[] table = null;
    public HashMap(int initialCapacity, float loadFactor){
        if (initialCapacity < 0) throw new IllegalArgumentException("Illegal initial capacity:" + initialCapacity);
        if(initialCapacity > MAXMUM_CAPACITY)   initialCapacity = MAXMUM_CAPACITY;
        if(loadFactor <= 0 || Float.isNaN(loadFactor)) throw new IllegalArgumentException("Illegal laod factor:" + loadFactor);
        int capacity = 1;
        while(capacity < initialCapacity){
            capacity <<= 1;
        }
        this.loadFactor = loadFactor;
        threshold = (int)(capacity * loadFactor);
        table = new Entry[capacity];
        init();
    }

    //Entry内部类
    static class Entry<K, V> implements Map.Entry<K, V>{
        final K key;
        V value;
        Entry<K, V> next;
        final int hash;

        Entry(int h, K k, V v, Entry<K, V> n){
            value = v;
            next = n;
            key = k;
            hash = h;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }

    //添加元素
    public V put(K key, V value){
        if(key == null){
            return putForNullKey(value);
        }
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for(Entry<K, V> e = table[i]; e != null; e = e.next){
            Object k;
            if(e.hash == hash && ((k = e.key) == key || key.equals(k))){
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        addEntry(hash, key, value, i);
        return null;
    }
    static int hash(int h){
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    static int indexFor(int h, int length){
        return h & (length -1);
    }

    void addEntry(int hash, K key, V value, int bucketIndex){
        Entry<K, V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
        if (size++ >= threshold){
            resize(2 * table.length);
        }
    }

    public  V get(Object key){
        if(key == null){
            return getForNullKey();
        }
        int hash = hash(key.hashCode());
        for(Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next){
            Object k;
            if(e.hash == hash && ((k = e.key) == key || key.equals(k))){
                return e.value;
            }
        }
        return null;
    }
}
 */