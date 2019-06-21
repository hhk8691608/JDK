package com.ace.outorinputStream.chapter2_过滤器流;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 
 * 
 * @ClassName: chapter2_PrintStream
 * 
 * @Description: printStream
 * 
 */
public class chapter2_PrintStream {

	public final static String pathName = "D:\\TeamFile\\temp1.txt";

	public static String str = "写完数据的时候要记得关闭流。关闭流的同时，也会关闭OutputStream的实例。关闭流可以调用它的close()方法";

	public static void printStreamByPrint() throws Exception {

		PrintStream ps = new PrintStream(new FileOutputStream(pathName));
		ps.println(str);
		ps.print("hello world");

	}

	public static void main(String[] args) {
		try {
			printStreamByPrint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
