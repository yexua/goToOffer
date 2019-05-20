package nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *  通道（Channel）:用于源节点与目标点的连接。在java NIO中负责缓冲区中数据的传输
 *  Channel本身不存储数据，因此需要配合缓冲区进行传输
 */
public class TestChannel {

    //分散和聚集
    @Test
    public void test4() throws IOException {
        RandomAccessFile rw = new RandomAccessFile("src/CloneNode.java", "rw");

        //获取通道
        FileChannel channel = rw.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024*10);
        // 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel.read(bufs);
        for (ByteBuffer buf : bufs) {
            buf.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("------------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        // 聚集写入
        RandomAccessFile out = new RandomAccessFile("1.java","rw");
        FileChannel outChannel = out.getChannel();

        outChannel.write(bufs);


    }

    // 通道之间的数据传输（直接缓冲区）
    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        inChannel.transferTo(0, inChannel.size(), outChannel);
        //outChannel.transferFrom(inChannel, 0, inChannel.size());
        outChannel.close();
        inChannel.close();

    }

    // 使用直接缓冲区完成文件的复制
    @Test
    public void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        MappedByteBuffer inMapBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        // 直接对缓冲区进行数据的读写操作
        byte[] bytes = new byte[inMapBuf.limit()];
        inMapBuf.get(bytes);
        outMapBuf.put(bytes);

        outChannel.close();
        inChannel.close();
    }

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //获取通道
        FileChannel fisChannel = null;
        FileChannel fosChannel = null;
        try {

            fis = new FileInputStream("o_15.jpg");
            fos = new FileOutputStream("1.jpg");

            fisChannel = fis.getChannel();
            fosChannel = fos.getChannel();

            // 分配指定大小的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //将通道中的数据写到缓冲区中
            while (fisChannel.read(byteBuffer) != -1){
                //切换到 写模式
                byteBuffer.flip();
                fosChannel.write(byteBuffer);
                // 清空缓冲区
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fosChannel){
                try {
                    fosChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != fisChannel){
                try {
                    fisChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
