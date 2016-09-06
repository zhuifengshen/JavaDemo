package mike.socket;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Devin on 8/18/2016.
 */
public class FileServer extends ServerSocket {
    private static final int PORT = 2016;
    private ServerSocket serverSocket;
    private Socket client;
    private DataInputStream dis;
    private FileOutputStream fos;

    public FileServer() throws IOException{
        try {
            serverSocket = new ServerSocket(PORT);
            while(true){
                client = serverSocket.accept();
                //获取文件输入流
                dis = new DataInputStream(client.getInputStream());
                String filename = dis.readUTF();
                long fileLength = dis.readLong();
                //新建文件输出流
                fos = new FileOutputStream(new File("d:/test" + filename));
                //读取文件输入流并输出至输出流
                byte[] bytes = new byte[1024];
                int transLen = 0;
                System.out.println("- - - 开始接收文件<" + filename + ">, 文件大小为<" + fileLength + "> - - -");
                while (true){
                    int read = dis.read(bytes);
                    if (read == -1) break; //-1表示文件读取结束
                    transLen += read;
                    System.out.println("接收文件进度: " + 100 * transLen / fileLength + "% ..."); //根据文件大小计算上传速度
                    fos.write(bytes, 0, read);
                    fos.flush();
                }
                System.out.println("- - - 接收文件<" + filename + ">成功 - - -");
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (dis != null) dis.close();
                if (fos != null) fos.close();
            }catch (IOException io){
                io.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new FileServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
