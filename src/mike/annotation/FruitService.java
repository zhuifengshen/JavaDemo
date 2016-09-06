package mike.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devin on 2016/7/19.
 */
public class FruitService {
    //@SuppressWarnings(value={ "rawtypes", "unchecked" })
    @SuppressWarnings(value={"rawtypes", "unchecked"})
    public static  List<String> getFruitList(){
        List<String> fruitList=new ArrayList();
        return fruitList;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static  List<String> getFruit(){
        List<String> fruitList=new ArrayList();
        return fruitList;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args){
        List<String> strList=new ArrayList<String>();
    }
}
