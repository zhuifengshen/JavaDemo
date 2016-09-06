package mike.nio;// $Id$

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyFile
{
  static public void main( String args[] ) throws Exception {
    if (args.length<2) {
      System.err.println( "Usage: java CopyFile infile outfile" );
      System.exit( 1 );
    }

    String infile = args[0];
    String outfile = args[1];

    FileInputStream fin = new FileInputStream( infile );
    FileOutputStream fout = new FileOutputStream( outfile );
    //新建输入输出通道
    FileChannel fcin = fin.getChannel();
    FileChannel fcout = fout.getChannel();
    //创建一个缓冲区
    ByteBuffer buffer = ByteBuffer.allocate( 1024 );

    while (true) {
      buffer.clear();//重设缓冲区

      int r = fcin.read( buffer );//输入通道读入缓冲区

      if (r==-1) {
        break; //读取结束则跳出循环
      }

      buffer.flip();//将缓冲区数据写入输出通道

      fcout.write( buffer );//输出通道将数据写入文件
    }
  }
}
