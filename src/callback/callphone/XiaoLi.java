package callback.callphone;

/**
 * Created by Devin on 8/23/2016.
 */
public class XiaoLi {

    public void executeMessage(CallBack callback, String question) throws InterruptedException {
        System.out.println("小李: 小王刚刚问了一个很有哲学性的的问题 - - ->" + question);
        System.out.println("小李: 元芳待会就回来,让他帮你解答...");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
        }
        String result = "元芳说答案是2";
        callback.solve(result);
    }
}
