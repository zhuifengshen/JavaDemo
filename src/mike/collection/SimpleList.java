package mike.collection;

import java.util.Arrays;

/**
 * Created by Devin on 2016/7/29.
 */
public class SimpleList<T> {
    private Object[] elements;
    private int size=0;
    private int MAX_NUM = 66357;

    public SimpleList(){
        elements = new Object[16];
        System.out.println("默认数组长度:"+elements.length);
    }
    public SimpleList(int n){
        int tmp = 1;
        while ( tmp <= n){
            tmp <<= 1;
        }
        this.elements = new Object[tmp];
        System.out.println("自定义数组长度:" + elements.length);
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    public void add(T e){
        ensureCapacity(size+1);
        elements[size++] = e;
    }

    private void ensureCapacity(int minCapacity){
        if (minCapacity > elements.length){
            int newLength = elements.length + elements.length >> 1;
            if (newLength < minCapacity){
                int tmp = 1;
                while (tmp < minCapacity){
                    tmp <<= 1;
                }
                newLength = tmp;
            }
            if (minCapacity > MAX_NUM || newLength > MAX_NUM){
                newLength = Integer.MAX_VALUE;
            }
            Arrays.copyOf(elements, newLength);
        }
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("访问位置" + index + "越界");
        }
        return (T)elements[index];
    }
    public boolean remove(Object object){
        if (object == null){
            for (int i=0; i < size; i++){
                if (elements[i] == null){
                    System.arraycopy(elements,i + 1, elements, i, size - i -1);
                    size--;
                    return true;
                }
            }
        }else {
            for (int i = 0; i < size; i++){
                if (elements[i].equals(object)){
                    System.arraycopy(elements,i + 1, elements, i, size - i -1);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public T remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("访问位置" + index + "越界");
        }
        T oldValue = (T)elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index -1);
        size--;
        return oldValue;
    }


    public static void main(String[] args){
        SimpleList<Integer> simpleList = new SimpleList(17);
        System.out.println(simpleList.isEmpty());
        simpleList.add(1);
        simpleList.add(3);
        simpleList.add(4);
        System.out.println("------------------------------");
        for (int i = 0; i < simpleList.size(); i++){
            System.out.println(simpleList.get(i));
        }
        simpleList.remove(Integer.valueOf(4));
        System.out.println("------------------------------");
        for (int i = 0; i < simpleList.size(); i++){
            System.out.println(simpleList.get(i));
        }
        System.out.println(simpleList.remove(Integer.valueOf(0)));
        System.out.println("------------------------------");
        for (int i = 0; i < simpleList.size(); i++){
            System.out.println(simpleList.get(i));
        }
    }
}
