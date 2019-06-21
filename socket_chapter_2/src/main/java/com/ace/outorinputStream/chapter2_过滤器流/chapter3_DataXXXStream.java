package com.ace.outorinputStream.chapter2_过滤器流;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 
 * 
 * @ClassName: chapter3_DataXXXStream
 * 
 * @Description: DataInputStream/DataOutputStream DataXXXStream
 *               是用来装饰其它输入流，它“允许应用程序以与机器无关方式从底层输入/输出流中读/写基本 Java 数据类型”
 *               writeBoolean(boolean b) writeByte(int b) writeShort(int s)
 * 
 */
public class chapter3_DataXXXStream {

	public final static String pathName = "D:\\TeamFile\\3.txt";

	public static void main(String[] args) {
		try {
			writeBoolean();
//			readBoolean();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeBoolean() throws Exception {

		DataOutputStream dos = new DataOutputStream(new FileOutputStream(pathName));
		dos.write(new String("hello World").getBytes());
		dos.close();

	}

	public static void readBoolean() throws Exception {

		DataInputStream dis = new DataInputStream(new FileInputStream(pathName));
		byte[] input = new byte[dis.available()];
		int gl = 0;
		System.out.println(dis.readBoolean());
		dis.close();

	}

}
