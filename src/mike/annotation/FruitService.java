package mike.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devin on 2016/7/19.
 */
public class FruitService {


    //@SuppressWarnings({"all"})
    @SuppressWarnings(value={"rawtypes", "unchecked"})
    public static  List<String> getFruitList(){
        List<String> fruitList=new ArrayList();
        return fruitList;
    }

    @SuppressWarnings("unused")
    public static  List<String> getFruit(){
        List<String> fruitList=new ArrayList();
        return fruitList;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args){
        List<String> strList=new ArrayList<String>();
    }
    @SuppressWarnings("all")
    public void addItems(String item){
        List list = new ArrayList();
        list.add(item);
    }

    @SuppressWarnings({"unchecked","unused"})
    public void addItems1(String item){
        List list = new ArrayList();
        list.add(item);
    }


    @SuppressWarnings("unchecked")
    public void addItems2(String item){
        @SuppressWarnings("unused")
        List list = new ArrayList();
        List items = new ArrayList();
        items.add(item);
    }

}
