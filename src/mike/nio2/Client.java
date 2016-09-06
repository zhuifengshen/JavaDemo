package mike.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by Devin on 8/22/2016.
 */
public class Client {
    private Selector selector;

    public void initClient(String ip, int port) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress(ip, port));
        this.selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }

    public void listen() throws IOException {
        while (true){
            selector.select();//阻塞方法,直到事件的到来
            Iterator iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = (SelectionKey)iterator.next();
                iterator.remove();
                if (key.isConnectable()){
                    SocketChannel socketChannel = (SocketChannel)key.channel();
                    if (socketChannel.isConnectionPending()){
                        socketChannel.finishConnect();
                    }
                    socketChannel.configureBlocking(false);
                    socketChannel.write(ByteBuffer.wrap(new String("大哥大,我是胡汉三,我又回来了").getBytes()));
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if (key.isReadable()){
                    read(key);
                }
            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel)key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        socketChannel.read(buffer);
        byte[] data = buffer.array();
        System.out.println("大哥大回复:" + new String(data));
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.initClient("localhost", 2016);
        client.listen();
    }
}
