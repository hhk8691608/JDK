package com.ace.buffer.chapter1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

import org.junit.Test;


/**
 * 
 * 缓冲区是NIO 提高给传输文件和通道一起配合使用,存储数据.<br>
 * Buffer<br>
 * ByteBuffer<br>
 * LongBuffer<br>
 * InteigBuffer<br>
 * FloatBuffer<br>
 * DubboBuffer<br>
 */
public class BufferChapter1 {
	
	public static final Logger LOG = Logger.getLogger(BufferChapter1.class.getCanonicalName());
	
	@Test
	public void test000() {
		LOG.info("hello world");
	}
	
	
	/**
	 * position<br> 缓冲区正在操作的位置 默认从0开始。
	 * limit<br>  界面(缓冲区可用大小)
	 * capacity;<br> 缓冲区最大容量，一旦声明不能改变
	 * 
	 * 核心方法:
	 * put() 往buff存放数据
	 * get() 获取数据
	 * 
	 *  */
	@Test
	public void test001() {
		try {
			
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			System.out.println(byteBuffer.position());
			System.out.println(byteBuffer.limit());
			System.out.println(byteBuffer.capacity());
			System.out.println("----------往bytebuff存放数据....----------");
			byteBuffer.put("abcd1".getBytes());
			System.out.println(byteBuffer.position());
			System.out.println(byteBuffer.limit());
			System.out.println(byteBuffer.capacity());
			System.out.println("----------读取值...----------");
			 //开启读取模式
			byteBuffer.flip();
			System.out.println("position:"+byteBuffer.position());
		    System.out.println(byteBuffer.limit());
		    System.out.println(byteBuffer.capacity());
		    byte[] bytes=  new byte[byteBuffer.limit()];
		    byteBuffer.get(bytes);
		    System.out.println(new String(bytes,0,bytes.length));
			
		    System.out.println("----------重复读取----------");
		    byteBuffer.rewind();
		    System.out.println("position:"+byteBuffer.position());
		    System.out.println(byteBuffer.limit());
		    System.out.println(byteBuffer.capacity());
		    byte[] byte2 = new byte[byteBuffer.limit()];
		    byteBuffer.get(byte2);
		    System.out.println(new String(byte2,0,byte2.length));
		    //清空缓冲数据被遗忘值...
		    System.out.println("----------清空缓冲区--------------");
		    byteBuffer.clear();
		    System.out.println("position:"+byteBuffer.position());
		    System.out.println(byteBuffer.limit());
		    System.out.println(byteBuffer.capacity());
		    System.out.println((char)byteBuffer.get());
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	/**
	 * 
	 * @Description: 
	 * reset(重置) &&  make(标记 )
	 * 
	 */
	@Test
	public void test002() {

		String str = "abcd1";
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byteBuffer.put(str.getBytes());
		System.out.println("----------往bytebuff存放数据....----------");
		System.out.println(byteBuffer.position());
		System.out.println(byteBuffer.limit());
		System.out.println(byteBuffer.capacity());
//		System.out.println("----------读取值...----------");
//		byteBuffer.flip();
//		byte[] inputByte = new byte[byteBuffer.limit()];
//		byteBuffer.get(inputByte);
//		System.out.println(byteBuffer.position());
//		System.out.println(byteBuffer.limit());
//		System.out.println(byteBuffer.capacity());
//		System.out.println(new String(inputByte));
		System.out.println("----------mark && reset----------");
		byteBuffer.flip();
		byte[] dst = new byte[byteBuffer.limit()];
		byteBuffer.get(dst,0,2);
//		byteBuffer.mark();
		System.out.println(new String(dst, 0, 2));
		System.out.println(byteBuffer.position());
		byteBuffer.get(dst,2,2);
		System.out.println(new String(dst, 2, 2));
		System.out.println(byteBuffer.position());
		byteBuffer.reset();
		System.out.println("重置恢复到mark位置..");
		System.out.println(byteBuffer.position());

		
	}
	

	/**
	 * @Description: 
	 *	直接缓冲区和非直接缓冲区的区别
	 *	非直接 ： 通过allocate()分配缓冲区，缓冲区建立在jvm内存中，安全性高
	 *	直接：直接通过 allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理内存中，效率高
	 */
	@Test
	public void test003() throws IOException {
		
		
	}
	
	
	/**
	 * @Description: 
	 *	直接缓冲区和非直接缓冲区实例比较
	 *	直接缓冲区
	 */
	@Test
	public void test004() throws IOException {
		long statTime = System.currentTimeMillis();
		
		FileChannel inChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		
		MappedByteBuffer inMappedByte = inChannel.map(MapMode.READ_ONLY	, 0, inChannel.size());
		MappedByteBuffer outMappedByte = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
		
		byte[] dsf = new byte[inMappedByte.limit()];
		inMappedByte.get(dsf);
		outMappedByte.put(dsf);
		inChannel.close();
		outChannel.close();
		long endTime = System.currentTimeMillis();
		System.out.println("操作直接缓冲区耗时时间:"+(endTime-statTime));
	}
	
	
	/**
	 * @Description: 
	 *	直接缓冲区和非直接缓冲区实例比较
	 *	非直接缓冲区 读写操作
	 */
	@Test
	public void test005() throws IOException {
		long statTime = System.currentTimeMillis();
		
		FileInputStream fst = new FileInputStream("1.png");
		FileOutputStream fos = new FileOutputStream("2.png");
		FileChannel inChannel = fst.getChannel();
		FileChannel outChannel = fos.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(1024);
		while(inChannel.read(buf) != -1) {
			buf.flip();
			outChannel.write(buf);
			buf.clear();
		}
		inChannel.close();
		outChannel.close();
		fos.close();
		fst.close();
		long endTime = System.currentTimeMillis();
		System.out.println("操作直接缓冲区耗时时间:"+(endTime-statTime));
	}
	
	
	
	/**
	 * 
	 * @Description: 
	 * 	分散读取聚合写入
	 * 	
	 */
	@Test
	public void test006() throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("test.txt","rw");
		FileChannel channel = raf.getChannel();
		ByteBuffer buf1 = ByteBuffer.allocateDirect(100);
		ByteBuffer buf2 = ByteBuffer.allocateDirect(1024);
		ByteBuffer[] bufs =  {buf1,buf2};
		channel.read(bufs);
		for(ByteBuffer byteBuffer : bufs) {
			byteBuffer.flip();
		}
		System.out.println("------聚集读取---------");
		RandomAccessFile raf2 = new RandomAccessFile("test2.txt","rw");
		FileChannel channel2 = raf2.getChannel();
		channel2.write(bufs);
		raf2.close();
		raf.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
