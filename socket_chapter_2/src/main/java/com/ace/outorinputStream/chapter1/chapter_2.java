package com.ace.outorinputStream.chapter1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 

 * @ClassName: chapter_2

 * @Description: 
 * 输入流 --->>> java.io.InputStream
 * public abstract int read();
 * public int read(byte[] input);
 * public int read(byte[] input,int offset ,int length);
 * public long skip(long n);
 * pulbic int available();
 * public void close();
 * 
 * ----> byte[] 缓冲区，用于在内存在保存数据，其实就是最终能获取的大小数据块,
 * read() ----> 在循环中读取其实也只是在往byte数组中添加数据，一旦超过数量byte的大小则停止读取

 * @author: admin

 * @date: 2019年6月20日 上午11:18:28
 */
public class chapter_2 {
	
	public final static String pathName = "D:\\TeamFile\\temp.txt";
	
	
//	public abstract int read();  ------》》》read() 读一次游标就会向下移动一位
	public static void readByEmpty() throws FileNotFoundException, IOException {
	
		try {
			int flag = 0;
			InputStream is = new FileInputStream(pathName);
			while((flag = is.read()) != -1) {
				char c = (char)flag; 
				System.out.print(c);
			}
 			
		}  catch (Exception e) {
		}
		
	}
	
	
//	public abstract int read();
	public static void readByEmpty1() throws FileNotFoundException, IOException {
		
		try {
			InputStream is = new FileInputStream(new File(pathName));
			byte[] b = new byte[is.available()];

			for(int i=0;i<b.length;i++) {
				int tb = is.read();
				if(tb == -1) {
					break;
				}
				b[i] = (byte)tb;
				
			}
			
			System.out.println( new String(b,"utf-8"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
//	public abstract int read();
	public static void readByEmpty2() throws FileNotFoundException, IOException {
		
		try {
			int index = 0;
			int flag = 0;
			InputStream is = new FileInputStream(pathName);
			byte[] b = new byte[is.available()];
			while(( flag = is.read()) != -1) {
				b[index ++] = (byte)flag;
			}
 			System.out.println(new String(b));
		}  catch (Exception e) {
		}
		
	}
	

//	public int read(byte[] input);
//	byte[] 每次读取其实只是往byte[]添加字节，一旦byte满了则停止读取
	public static void readByteArr() {
		try {
			InputStream is = new FileInputStream(new File(pathName));
			byte[] input = new byte[is.available()];
			int flagIndex = 0;
			while(	( flagIndex = is.read(input) ) != -1) {
				String str = new String(input,"UTF-8");
				System.out.println(str);
			}
		} catch (Exception e) {
		}
	}
	
//	public int read(byte[] input,int offset ,int length);
	public static void readByArrLeng() {
		
		try {
			InputStream is = new FileInputStream(pathName);
			byte[] tempArr = new byte[is.available()];
			int index = 0;
			while( (index = is.read(tempArr,0,tempArr.length)) != -1) {
				String str = new String(tempArr,"UTF-8");
				System.out.println(str);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		try {
//			readByEmpty();
//			readByEmpty2();
			readByteArr();
//			readByArrLeng();
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	
	

}
