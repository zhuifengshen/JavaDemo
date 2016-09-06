package mike.nio2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Devin on 8/19/2016.
 */
public class BufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile dataFile = new RandomAccessFile("devin.file", "rw");
        FileChannel dataChannel = dataFile.getChannel();
        ByteBuffer dataBuffer = ByteBuffer.allocate(8);
        int bytesRead = dataChannel.read(dataBuffer);
        while (bytesRead != -1){
            dataBuffer.flip();//从写状态切换为读状态
            while(dataBuffer.hasRemaining()){
                System.out.println((char)dataBuffer.get());
            }
            dataBuffer.clear();
            bytesRead = dataChannel.read(dataBuffer);
        }
        dataFile.close();
    }
}
