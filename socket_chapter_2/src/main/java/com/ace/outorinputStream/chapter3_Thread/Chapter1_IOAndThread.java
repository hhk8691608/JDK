package com.ace.outorinputStream.chapter3_Thread;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 

 * @ClassName: Chapter1_IOAndThread

 * @Description: 
 * io结合thread的第一个实例
 * 基于基础Thread类来实现

 */
public class Chapter1_IOAndThread extends Thread{

	private String fileName;
	private InputStream is ;
	private static String pathPrv = "D:\\TeamFile\\";
	
	public Chapter1_IOAndThread() {
		
	}
	
	public Chapter1_IOAndThread(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		
		try {
			is = new BufferedInputStream(new FileInputStream(fileName));
			int flag = 0;
			int off = 0;
			int len = 1024;
			StringBuffer sb = new StringBuffer();
			byte[] input = new byte[len];
			while( (flag = is.read(input, off, len)) != -1 ) {
				sb.append(new String(input));
			}
			System.out.println(fileName+"--------->>>>"+sb.length());
			System.out.println(fileName+"--------->>>>"+sb);
			is.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
	
	}
	
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public InputStream getIs() {
		return is;
	}
	
	public void setIs(InputStream is) {
		this.is = is;
	}
	
	
	
	public static void main(String[] args) {
		
		int len = 5;
		for(int i=1;i<=len;i++) {
			String tempPathName = pathPrv+i+".txt";
			Thread tread = new Chapter1_IOAndThread(tempPathName);
			tread.start();
		}
		
		
	}
	
	
	
	
	
	
}
