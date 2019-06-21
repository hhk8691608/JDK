package com.ace.outorinputStream.chapter1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 

 * @ClassName: chapter_1

 * @Description: 
 * 输出流 ----->> java.io.OutputStream
 * 完成对输出流的基本操作
 * api：
 * public abstract void write(int b);
 * public void write(byte[] data)
 * public void write(byte[] data,int offset,int length)
 * public void flush()
 * public void close()
 * 

 * @author: admin

 * @date: 2019年6月20日 上午10:58:14
 */
public class chapter_1 {
	
	public static String tempStr = "hello World";
	public final static String pathName = "D:\\TeamFile\\temp.txt";
	public static OutputStream os = null;
	
	
	//public abstract void write(int b);
	public static void outByteInt() {
		int b = 100;
		try(OutputStream os = new FileOutputStream(new File(pathName))){
			os.write(b);
			os.close();
			
		}catch (Exception e) {

		}
		
	}
	
	
//	 * public void write(byte[] data)
	public static void outByteArr() {
	
		try {
			byte[] b =tempStr.getBytes();
			os = new FileOutputStream(new File(pathName));
			os.write(b);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(os != null) {
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

//	public void write(byte[] data,int offset,int length)
	public static void outByteArrLength() throws IOException {
		
		try {
			int off = 0;
			int len = 1024;
			byte[] b = tempStr.getBytes();
			os = new FileOutputStream(new File(pathName));
			os.write(b, off, b.length);
			
		} finally {
			os.close();
		}
		
	}
	
	public static void main(String[] args) {
		

		try {
//			outByteInt();
//			outByteArr();
			outByteArrLength();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
