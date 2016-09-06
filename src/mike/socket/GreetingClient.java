package mike.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by Devin on 2016/7/13.
 */
public class GreetingClient {
    public static void main(String[] args){
        String serverName = "localhost";
        int port = 6666;
        try{
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just connect to " + client.getRemoteSocketAddress());
            OutputStream outputStream = client.getOutputStream();
            DataOutputStream dataOutputStream= new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("Hello from " + client.getLocalAddress());

            InputStream inputStream = client.getInputStream();
            DataInputStream dataInputStream =new DataInputStream(inputStream);
            System.out.println("Server says:" + dataInputStream.readUTF());
            client.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
