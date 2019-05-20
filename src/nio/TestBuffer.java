package nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 缓冲区(Buffer)：在java NIO 中负责数据的存取。缓冲区是数组。用于存储不同数据类型的数据
 *
 * 根据数据类型不同(boolean  除外),提供了相应类型的缓冲区
 *
 * 缓冲区中的五个核心属性
 * capacity（容量）：表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit（界限）：表示缓冲区中可以操作数据的大小。（limit 后数据不能进行读写）
 * position（位置）：表示缓冲区中正在操作数据的位置。
 * mark（标记）：表示记录当前 position 的位置。
 * reset（重置）：可以通过 reset() 恢复到 mark 的位置。
 *
 * 缓冲区存取数据的核心方法
 *  put()：存入数据到缓冲区中。
 *  get()：获取缓冲区中的数据。
 *  flip()：切换读取数据模式。
 *  rewind()：可重复读。
 *  clear()：清空缓冲区，但是缓冲区中的数据依然存在，但是处于“被遗忘”状态。
 */
public class TestBuffer {

    @Test
    public void test3(){
        // 创建直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
    }

    @Test
    public void test2(){
        String str = "Hello World";

    }

    @Test
    public void test(){
        String str = "Hello World";
        //分配一个指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("-----------allocate--------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        // 利用put，存入数据到缓冲区
        byteBuffer.put(str.getBytes());
        System.out.println("-----------put--------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        // 切换到读取数据模式
        byteBuffer.flip();
        System.out.println("-----------flip--------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        // 利用get读取缓冲区的数据
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println("-----------get--------------");
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        // rewind 可重复读
        byteBuffer.rewind();
        System.out.println("-----------rewind--------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        // clear 清空缓冲区，但是缓冲区数据依然存在，但是出于被遗忘状态
        byteBuffer.clear();
        System.out.println("-----------clear--------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }
}
