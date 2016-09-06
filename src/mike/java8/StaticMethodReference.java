package mike.java8;

/**
 * Created by Devin on 8/15/2016.
 */
public class StaticMethodReference {
    public static void main(String[] args) {
        Converter<String,Integer> converter = new Converter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return StaticMethodReference.String2Int(from);
            }
        };
        System.out.println(converter.convert("110"));

        //方法引用之静态方法引用
        Converter<String,Integer> converter1 = StaticMethodReference::String2Int;
        System.out.println(converter1.convert("120"));

        Converter<String,Integer> converter2 = new Converter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return new Helper().String2Int(from);
            }
        };
        System.out.println(converter2.convert("130"));

        //方法引用之实例方法引用
        Converter<String,Integer> converter3 = new Helper()::String2Int;
        System.out.println(converter3.convert("140"));
    }
    @FunctionalInterface
    interface Converter<F,T>{
        T convert(F from);
    }

    static int String2Int(String from){
        return Integer.parseInt(from);
    }

    static class Helper{
        public int String2Int(String from){
            return Integer.valueOf(from);
        }
    }


}
