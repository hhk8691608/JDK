package com.ace.outorinputStream.chapter3_Thread;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ace.outorinputStream.chapter3_Thread.model.Chapter3_CallRun;

/**
 * 采用线程池来开发
 *	基于Runnable 接口
 */
public class Chapter3_IOAndThreadExcetor {

	
	
	public static ExecutorService servicePool = Executors.newFixedThreadPool(3);
	private static String pathPrv = "D:\\TeamFile\\temp";
	private static String threadPrv = "thread";
	
	
	

	public static void main(String[] args) {
		
		for(int i=1; i<=5;i++) {
			
			String fileName = pathPrv+i+".txt";
			String threadName = threadPrv+i;
			Chapter3_CallRun cr = new Chapter3_CallRun(fileName,threadName);
			servicePool.execute(cr);
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
