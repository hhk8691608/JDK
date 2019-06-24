package com.ace.outorinputStream.chapter3_Thread.model;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Chapter3_CallRun implements Runnable {
	

	
	
		private String fileName ;
		private String threadName;
		
		public Chapter3_CallRun() {}
		
		public Chapter3_CallRun(String fileName,String threadName) {
				this.fileName = fileName;
				this.threadName = threadName;
		}
		

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		@Override
		public void run() {
			
			try {
				StringBuffer sb = new StringBuffer(); 
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
				int flag = 0;
				byte[] input = new byte[1024];
				while( ( flag = bis.read(input, 0,1024) ) != -1) {
					String str = new String(input);
					sb.append(str);
				}	
				System.out.println("this current ThreadName is -------------- >>>> "+threadName +" input Content ===========  >>>>> " + sb);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

}
