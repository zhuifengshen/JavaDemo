package mike.nio2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Devin on 8/19/2016.
 */
public class ChanelTest {
    public static void main(String[] args) throws IOException {
        //分散读入,聚集输出
        FileChannel dataChannel = new RandomAccessFile("devin.file", "rw").getChannel();
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = {header,body};
        dataChannel.read(bufferArray);
        header.flip();
        body.flip();
        dataChannel.write(bufferArray);
        header.clear();
        body.clear();

        //将数据从源通道传输到FileChannel中:将字节从给定的可读取字节通道传输到此通道的文件中
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();
        //通道间的数据传输 - 选其一即可
        toChannel.transferFrom(fromChannel, position, count);
        fromChannel.transferTo(position, count, toChannel);


        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(2016));
        SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_READ);
        while (true){
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()){
                //SelectionKey theKey = keyIterator.next();
                SelectionKey selectionkey = keyIterator.next();
                if (key.isAcceptable()){

                }else if (key.isConnectable()){

                }else if (key.isReadable()){

                }else if (key.isWritable()){

                }
                keyIterator.remove();
            }
        }
    }
}
