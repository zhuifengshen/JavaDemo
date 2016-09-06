package mike.thread;

/**
 * Created by Devin on 2016/7/21.
 */
public class ThreadDemo extends Thread{
    private int ticket = 5;
    public void run(){
        for(int i = 0; i < 10; i++){
            if(ticket > 0){
                System.out.println("ticket=" + ticket--);
            }
        }
    }

    public static void main(String[] args){
        new ThreadDemo().start();
        new ThreadDemo().start();
        new ThreadDemo().start();
        new ThreadDemo().start();
        RunnableThread runnableThread = new RunnableThread();
        new Thread(runnableThread).start();
        new Thread(runnableThread).start();
        new Thread(runnableThread).start();

    }
}

class RunnableThread implements Runnable{
    private int ticket = 5;
    public void run(){
        for (int i = 0; i < 10; i++){
            if (ticket > 0){
                System.out.println("票数：" + ticket--);
            }
        }
    }

}