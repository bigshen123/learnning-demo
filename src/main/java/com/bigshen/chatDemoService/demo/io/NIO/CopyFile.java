package com.bigshen.chatDemoService.demo.io.NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description:NIO 实现高效文件复制
 * @Author: BIGSHEN
 * @Date: 2019/12/28 17:22
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile=new RandomAccessFile("fromFile.txt","rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        // 将 fromFile 文件找那个的数据转移到 toFile 中去
        System.out.println("before transfer: " + readChannel(toChannel));
        //transferTo方法简化copy代码
        fromChannel.transferTo(position, count, toChannel);
        System.out.println("after transfer : " + readChannel(toChannel));
        fromChannel.close();
        fromFile.close();
        toChannel.close();
        toFile.close();

    }

    private static String readChannel(FileChannel channel) throws IOException {
        ByteBuffer buffer=ByteBuffer.allocate(32);
        buffer.clear();
        //将 channel 读取位置设为 0，也就是文件开始位置
        channel.position(0);
        channel.read(buffer);
        // 再次将文件位置归零
        channel.position(0);

        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        return new String(bytes);
    }
}
