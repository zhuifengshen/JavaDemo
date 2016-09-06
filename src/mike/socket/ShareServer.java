package mike.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Devin on 8/18/2016.
 */
public class ShareServer extends ServerSocket {
    private static final int SERVER_PORT = 2016;

    private static volatile boolean isPrint = false;//是否输出消息的标准,使用volatile修饰以便及时更新输出信息状态
    private static List<String> user_list = new ArrayList<>();//用户集
    private static List<ServerThread> thread_list = new ArrayList<>();//服务器启用的线程集合
    private static LinkedList<String> message_list = new LinkedList<>();//存放消息队列

    /**
     * 创建服务端Socket,监听客户端请求并新建线程处理
     * @throws IOException
     */
    public ShareServer() throws IOException {
        super(SERVER_PORT);
        //创建专门向客户端广播消息的线程
        new PrintOutThread();

        try{
            while (true){
                Socket socket = accept();//监听客户端连接
                new ServerThread(socket);//新建线程处理客户端连接
            }
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            close();
        }
    }
    //内部消息输出线程类,监听是否有新消息需要广播,并广播消息
    private class PrintOutThread extends Thread{
        public PrintOutThread(){
            start();
        }

        @Override
        public void run() {
            while (true){
                if (isPrint){//将缓存在队列中的消息按顺序广播并广播后清除
                    String message = message_list.getFirst();
                    System.out.println(message);
                    for (ServerThread thread : thread_list) {
                        thread.sendMessage(message);
                    }
                    message_list.removeFirst();
                    isPrint = message_list.size() > 0 ? true : false;
                }
            }
        }
    }
    //内部服务器服务线程
    private class ServerThread extends Thread{
        private Socket client;
        private PrintWriter out;
        private BufferedReader in;
        private String name;

        public ServerThread(Socket socket) throws IOException {
            client = socket;
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(in.readLine());//用户首次发生消息后建立连接并提示注册用户名
            out.println("成功连上聊天室，请输入你的名字:");
            start();//启动服务
        }

        @Override
        public void run() {
            try {
                int isFirst = 0;
                String clientMessage = in.readLine();
                while (!("bye").equals(clientMessage)){
                    //查看在线用户列表
                    if ("showuser".equals(clientMessage)){
                        out.println(this.listOnlineUsers());
                        clientMessage = in.readLine();
                        continue;
                    }
                    //第一次服务,保存用户信息
                    if (isFirst++ == 0){
                        name = clientMessage;
                        user_list.add(name);
                        thread_list.add(this);
                        out.println(name + " 你好，可以聊天了...");
                        this.pushMessage("Client<" + name + ">进入聊天室...");
                    }else { //添加用户消息进消息队列
                        this.pushMessage("Client<" + name + "> say: " + clientMessage);
                    }
                    clientMessage = in.readLine();
                }
                out.println("byeClient");
            } catch (IOException e) {
                e.printStackTrace();
            }finally { //客户端断开连接后,关闭服务并清除用户信息
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                thread_list.remove(this);
                user_list.remove(name);
                this.pushMessage("Client<" + name + ">退出了聊天室");
            }
        }
        //添加消息进队列
        private void pushMessage(String message) {
            message_list.addLast(message);
            isPrint = true;
        }
        //显示在线用户列表
        private String listOnlineUsers() {
            String string = "- - - 在线用户列表 - - -\015\012";
            for (int i = 0; i < user_list.size(); i++) {
                string += "[" + user_list.get(i) + "]\015\012";
            }
            string += "- - - - - - - - - - -";
            return string;
        }
        //发送消息
        public void sendMessage(String message) {
            out.println(message);
        }
    }

    public static void main(String[] args) {
        try {
            new ShareServer();//启动服务器
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
