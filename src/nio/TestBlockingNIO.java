package nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TestBlockingNIO {

    @Test
    public void client() throws IOException {
        String str = "Hello World";
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        // 分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();
        while(socketChannel.read(buf) != -1){
            socketChannel.write(buf);
        }
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //获取客户端连接的通道
        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        //接受客户端的数据
        socketChannel.read(buf);
        byte[] bytes = buf.array();
        System.out.println(new String(bytes).trim());
    }
}
