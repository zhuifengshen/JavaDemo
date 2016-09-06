package callback.callphone;

/**
 * Created by Devin on 8/23/2016.
 */
public class XiaoWang implements CallBack {
    private XiaoLi xiaoLi;

    public XiaoWang(XiaoLi xiaoLi){
        this.xiaoLi = xiaoLi;
    }

    public void askQuestion(final String question){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    xiaoLi.executeMessage((CallBack)XiaoWang.this, question);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        play();
    }

    private void play() {
        System.out.println("小王: 知道答案了马上通知我, 我先去逛街了");
    }

    @Override
    public void solve(String result) {
        System.out.println("小王:收到小李子的回复 - - ->" + result);
    }
}
