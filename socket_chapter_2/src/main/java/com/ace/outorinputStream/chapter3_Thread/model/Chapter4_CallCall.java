package com.ace.outorinputStream.chapter3_Thread.model;

import java.util.concurrent.Callable;

public class Chapter4_CallCall implements Callable<Integer>{
	
	private String fileName ;
	private String threadName;
	
	private int[] data;
	private int start;
	private int end;
	
	public  Chapter4_CallCall() {
	}
	
	public  Chapter4_CallCall(String fileName,String threadName) {
		this.fileName = fileName;
		this.threadName = threadName;
	}
	
	public  Chapter4_CallCall(int[] date,int start,int end) {
		this.data = date;
		this.start = start;
		this.end = end;
	}


	

	@Override
	public Integer call() throws Exception {
		
		int max = Integer.MIN_VALUE;
		for(int i = start; i < end;i++) {
			if(data[i] > max) {
				max = data[i];
			}
		}
		System.out.println(this.getThreadName());
		return max;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
	

}
