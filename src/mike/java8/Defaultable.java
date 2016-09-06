package mike.java8;

import java.util.function.Supplier;

/**
 * Created by Devin on 8/16/2016.
 */
public interface Defaultable {
    default String defaultMethod(){
        return "Default implementation.";
    }
}

class Defaultable1 implements Defaultable{

}

class DefaultableImpl implements Defaultable{
    @Override
    public String defaultMethod(){
        return "Override implementation1";
    }
}

class OverridableImpl implements Defaultable{
    @Override
    public String defaultMethod() {
        return "Overridable implementation";
    }
}

interface DefaultableFactory{
    static Defaultable create(Supplier<Defaultable> supplier){
        return supplier.get();
    }
}

class DefaultMethodTest{
    public static void main(String[] args) {
        System.out.println(new DefaultableImpl().defaultMethod());
        System.out.println(new OverridableImpl().defaultMethod());

        System.out.println(DefaultableFactory.create(Defaultable1::new).defaultMethod());
        System.out.println(DefaultableFactory.create(OverridableImpl::new).defaultMethod());
    }
}
