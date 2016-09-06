package mike.nio;// $Id$

import java.nio.*;

public class UseFloatBuffer
{
  static public void main( String args[] ) throws Exception {
    FloatBuffer buffer = FloatBuffer.allocate( 10 );//创建缓冲区

    for (int i=0; i<buffer.capacity(); ++i) { //缓冲区大小
      float f = (float)Math.sin( (((float)i)/10)*(2*Math.PI) );
      buffer.put( f );
    }

    buffer.flip();//缓冲区数据写入输出通道

    while (buffer.hasRemaining()) { //判断缓冲区是否还有数据
      float f = buffer.get();
      System.out.println( f );
    }
  }
}
