package mike.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by Devin on 8/22/2016.
 */
public class Server {
    private Selector selector;
    public void initServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        this.selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    public void listen() throws IOException {
        System.out.println("服务器启动成功...");
        while(true){
            selector.select();
            Iterator iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = (SelectionKey)iterator.next();
                iterator.remove();//只能在next方法之后调用
                if (key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel)key.channel();
                    SocketChannel channel = server.accept();
                    channel.configureBlocking(false);
                    channel.write(ByteBuffer.wrap(new String("嗨,devin,服务器已经接受你的连接请求了").getBytes()));
                    channel.register(this.selector,SelectionKey.OP_READ);
                }else if (key.isReadable()){
                    read(key);
                }
            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel)key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        channel.read(buffer);
        byte[] data = buffer.array();
        String message = new String(data).trim();
        System.out.println("服务端收到信息:" + message);
        buffer.flip();
        channel.write(buffer);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.initServer(2016);
        server.listen();
    }
}
