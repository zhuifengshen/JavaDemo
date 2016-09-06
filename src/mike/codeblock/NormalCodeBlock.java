package mike.codeblock;

/**
 * Created by Devin on 2016/7/18.
 */
public class NormalCodeBlock {
    //静态代码块
    static{
        System.out.println("执行静态代码块。。。");
    }
    //构造代码块
    {
        System.out.println("执行构造代码块。。。");
    }
    //无参构造函数
    public NormalCodeBlock(){
        System.out.println("执行无参构造函数。。。");
    }
    //有參构造函数
    public NormalCodeBlock(String string){
        System.out.println("执行有參构造函数。。。");
    }
    public static void main(String[] args){
        new NormalCodeBlock();
        System.out.println("---------------");
        new NormalCodeBlock("Hello");
    }
}
