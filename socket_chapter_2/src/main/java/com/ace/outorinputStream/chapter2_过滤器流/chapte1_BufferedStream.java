package com.ace.outorinputStream.chapter2_过滤器流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 
 * 
 * @ClassName: chapte1_缓冲流
 * 
 * @Description: 缓冲流 BufferedOutputStream/BufferedInputStream
 *               BufferedOutputStream --->
 *               把写入数据都写入到缓冲区中(一个叫buf的保护字节数组字段),直到缓冲区满了或者刷新输出流.，它才将数据一次性全部写入到底层输出流.发送数据刷新数据流很重要。
 *               BufferedInputStream --->
 *               该类也有一个叫buf的保护字节数组字段,当某个流调用read时,它会尝试从缓冲区中读取获得请求的数据。只有当缓冲区中没有数据，才会去底层流源中读取数据，这时会尽可能的从源中读取尽可能多的数据存入缓冲区中，而不管是否马上需要使用到这些数据。
 *               API： public BufferedInputStream(InputStream in); public
 *               BufferedInputStream(InputStream in,int bufferSize); public
 *               BufferedOutputStream(OutputStream out); public
 *               BufferedOutputStream(OutputStream out,int bufferSize);
 *               第一个参数是底层流，第二个参数是指定缓冲区中的字节数，输入流缺省是2048直接，输出流是512字节 缓冲流可持续读写源
 * 
 */
public class chapte1_BufferedStream {

	public final static String pathName = "D:\\TeamFile\\temp.txt";

	public final static String pathName1 = "D:\\TeamFile\\1.txt";

//	public BufferedInputStream(InputStream in)
	public static void bufferedInputStreamIn() throws Exception {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(pathName)));
		int flg = 0;
		byte[] byteArr = new byte[bis.available()];
		while ((flg = bis.read(byteArr)) != -1) {

			String str = new String(byteArr);
			System.out.println(str);

		}

	}

//	BufferedInputStream(InputStream in,int bufferSize)
	public static void bufferedInputStreamInSize() throws Exception {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(pathName)), 219);
		int flg = 0;
		byte[] byteArr = new byte[bis.available()];
		while ((flg = bis.read(byteArr)) != -1) {

			String str = new String(byteArr);
			System.out.println(str);

		}

	}

//	public BufferedOutputStream(OutputStream out);
	public static void bufferedOutputStreamOut() throws Exception {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(pathName)));
		String str = "hello world";
		bos.write(str.getBytes());
		bos.close();
	}

//	public BufferedOutputStream(OutputStream out,int bufferSize);
	public static void bufferedOutputStreamOutBufferSize() throws Exception {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(pathName), 1024);
		String str = "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world";
		bos.write(str.getBytes());
		bos.close();
	}

	public static void main(String[] args) {
		try {
//			bufferedInputStreamIn();
//			bufferedInputStreamInSize();
//			bufferedOutputStreamOut();
			bufferedOutputStreamOutBufferSize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
