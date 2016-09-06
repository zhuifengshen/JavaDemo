package mike.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Devin on 8/18/2016.
 */
public class Server extends ServerSocket {
    private static final int SERVER_PORT = 2016;
    public Server() throws IOException{
        super(SERVER_PORT);
        try{
            while (true){
                Socket socket = accept();
                new CreateServerThread(socket);
            }
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            close();
        }
    }

    class CreateServerThread extends Thread{
        private Socket client;
        private BufferedReader bufferedReader;
        private PrintWriter printWriter;

        public CreateServerThread(Socket socket) throws IOException {
            client = socket;
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(client.getOutputStream(), true);
            System.out.println("Client(" + getName() + ") come in ...");
            start();
        }

        public void run(){
            try {
                String line = bufferedReader.readLine();
                while (!line.equals("bye")){
                    printWriter.println("continue, Client(" + getName() + ")!");
                    System.out.println("Client(" + getName() + ") say:" + line);
                    line = bufferedReader.readLine();
                }
                printWriter.println("bye, Client(" + getName() + ")!");
                System.out.println("Server Service " + getName() + " close");
                printWriter.close();
                bufferedReader.close();
                client.close();
            }catch (IOException io){
                io.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}
