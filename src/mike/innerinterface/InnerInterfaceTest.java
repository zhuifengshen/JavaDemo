package mike.innerinterface;

/**
 * Created by Devin on 8/23/2016.
 * 内部嵌套类,就像是我拿出来一样东西,这个东西怎么用是由我来定义的,尽管这东西还有别的用法,但你是不知道的,这有点像类里定义的private,public方法,
 * 但是嵌套接口做的更彻底,它把你能用的类的类型都定义好了.
 */
public class InnerInterfaceTest {
    public static void main(String[] args) {
        InnerInterface innerInterface = new InnerInterface();
        //InnerInterface.TV tv = innerInterface.new TV();
        InnerInterface.View view = innerInterface.getView();
        view.view();
        innerInterface.repaire(view);
        // 如果得到了原代码,知道这个tv是一个InnerInterface.TV的类型,你强制性的将它下传了
        // 但是这破坏了隐藏规则,因为这一权利是留给包的开发者的
        // 因为他们是可以改变具体实现接口的类的名字,及getView()所返回的具体类型的
        InnerInterface.TV alias = (InnerInterface.TV)view;
        alias.view();
        alias.repaire();
    }
}
