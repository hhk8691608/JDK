package com.ace.outorinputStream.chapter2_过滤器流;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;

/**
 * 
 * 
 * @ClassName: chapter5_Reader
 * 
 * @Description: 作用是将“字节输入流”转换成“字符输入流”。它继承于Reader。 API: ready() --->>
 * 
 * 
 * 
 */
public class chapter5_Reader {

	public final static String pathName = "D:\\TeamFile\\4.txt";
	public final static String pathName1 = "D:\\TeamFile\\temp.txt";
	public final static String pathName2 = "D:\\TeamFile\\temp1.txt";

	public static void inputStreamReader() throws Exception {

		Reader isr = new InputStreamReader(new FileInputStream(pathName));
		char[] input = new char[1024];
		int flag = 0;
		while ((flag = isr.read(input)) != -1) {
			String str = new String(input);
			System.out.println(str);
		}
		isr.close();

	}

//	public int read(char cbuf[], int offset, int length) 
	public static void readCharArrOffsetLength() throws Exception {

		Reader isr = new InputStreamReader(new FileInputStream(pathName1), "UTF-8");

		char cbuf[] = new char[1024];
		int offset = 0;
		int length = cbuf.length;
		int flag = 1;
		while ((flag = isr.read(cbuf, offset, length)) != -1) {
			String strr = new String(cbuf);
			System.out.println(strr);
		}
		isr.close();

	}

	public static void BufferedReader() throws Exception {

		Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathName2), "UTF-8"));
		char[] text = new char[1024];
		int off = 0;
		int len = text.length;
		int flag = 1;
		while ((flag = reader.read(text, off, len)) != -1) {
			String strr = new String(text);
			System.out.println(strr);
		}
		reader.close();
	}

//	InputStreamReader ---->>> public String readLine()
	public static void BufferedReaderReadLine() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathName2), "UTF-8"));
		char[] text = new char[1024];
		int off = 0;
		int len = text.length;
		int flag = 1;
		StringBuffer sb = new StringBuffer();
		String read = null;
		while ((read = reader.readLine()) != null) {
			sb.append(read);
		}
		System.out.println(sb.toString());
		reader.close();
	}

	public static void main(String[] args) {
		try {
//			inputStreamReader();
//			readCharArrOffsetLength();
//			BufferedReader();
			BufferedReaderReadLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
