package mike.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by Devin on 8/18/2016.
 */
public class FileClient extends Socket {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 2016;

    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;

    public FileClient(){
        try {
            client = new Socket(SERVER_IP, SERVER_PORT);
            //向服务端传送的文件
            File file = new File("D:/test.java");
            //文件输入流
            fis = new FileInputStream(file);
            dos = new DataOutputStream(client.getOutputStream());
            //传送文件名和文件大小
            dos.writeUTF(file.getName());
            dos.flush();
            dos.writeLong(file.length());
            dos.flush();
            //读取文件流并写入输出流
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = fis.read(bytes, 0, bytes.length)) > 0){
                dos.write(bytes, 0, length);
                dos.flush();
            }
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            try{
                if (fis != null) fis.close();
                if (dos != null) dos.close();
                client.close();
            }catch (IOException io){
                io.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FileClient();
    }

}
