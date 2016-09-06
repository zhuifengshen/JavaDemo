package mike.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Devin on 8/18/2016.
 */
public class SocketClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 2016);
            socket.setSoTimeout(1000);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage = "";
            while (!serverMessage.startsWith("bye")){
                BufferedReader systemBuff = new BufferedReader(new InputStreamReader(System.in));
                printWriter.println(systemBuff.readLine());
                //printWriter.flush();
                serverMessage = bufferedReader.readLine();
                System.out.println("Server say: " + serverMessage);
            }
            System.out.println("Client " + Thread.currentThread().getName() + " close");
            printWriter.close();
            bufferedReader.close();
            socket.close();
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
