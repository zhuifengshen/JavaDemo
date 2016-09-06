package mike.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Devin on 8/18/2016.
 * 客户端循环可以不停输入向服务器发送消息，并且启一个线程，专门用来监听服务器端发来的消息并打印输出
 */
public class ShareSocketClient extends Socket{
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 2016;

    private Socket client;
    private PrintWriter out;
    private BufferedReader input;

    /**
     * 与服务器建立连接,并输入发送信息
     * @throws IOException
     */
    public ShareSocketClient() throws IOException {
        super(SERVER_IP, SERVER_PORT);
        client = this;
        out = new PrintWriter(client.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(System.in));//new BufferedReader(new InputStreamReader(client.getInputStream()));
        //新建线程,用来监听服务端发送过来的消息并打印输出
        new ReadServerMessagThread();
        //激活连接
        out.println("服务器哥哥,我来了");
        System.out.println("正在连接服务器,请稍候...");
        //循环不停向服务器发送消息
        String clientInput = "";
        while (true && !("bye").equals(clientInput)){
            clientInput = input.readLine();
            out.println(clientInput);
        }
    }

    /**
     * 内部线程类,专门用来监听服务端发送过来的消息并打印输出
     */
    private class ReadServerMessagThread extends Thread{
        private BufferedReader reader;

        public ReadServerMessagThread(){
            try {
                //获取输入流
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                start();//启动
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run(){
            try{
                while (true){
                    String message = reader.readLine();
                    if ("byeClient".equals(message)){ //客户端发送"bye"申请退出,服务端返回确认退出
                        break;
                    }else {
                        System.out.println(message); //输出服务端发送过来的消息
                    }
                }
                input.close();
                out.close();
                client.close();
            }catch (IOException io){
                io.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        try {
            new ShareSocketClient(); //启动客户端
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
