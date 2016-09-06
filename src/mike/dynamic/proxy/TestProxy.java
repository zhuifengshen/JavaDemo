package mike.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Devin on 2016/7/20.
 */
public class TestProxy {
    public static void main(String[] args){
        ProxyHandler proxy = new ProxyHandler();
        Subject subject = (Subject)proxy.bind(new RealSubject());
        subject.doSomething();

        subject = (Subject)proxy.bind(new NewSubject());
        subject.doSomething();

    }
}

interface Subject{
    public void doSomething();
}

class RealSubject implements  Subject{
    @Override
    public void doSomething() {
        System.out.println("call doSomething()");
    }
}

class NewSubject implements Subject{
    @Override
    public void doSomething() {
        System.out.println("call new subject");
    }
}

class ProxyHandler implements InvocationHandler{
    private Object target;

    public Object bind(Object object){
        this.target = object;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        result = method.invoke(target, args);
        return result;
    }
}