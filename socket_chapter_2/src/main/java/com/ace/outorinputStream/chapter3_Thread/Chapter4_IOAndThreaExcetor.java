package com.ace.outorinputStream.chapter3_Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.ace.outorinputStream.chapter3_Thread.model.Chapter4_CallCall;

/**
 * 采用线程池来开发
 * 基于Casll 接口
 *	
 */
public class Chapter4_IOAndThreaExcetor {
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		int[] data = {25,12,3,14,54,5,89,67,234,123,1635,26354,25,135,2};
		
	
		Chapter4_CallCall task = new Chapter4_CallCall(data,0,data.length/2);
		Chapter4_CallCall task1 = new Chapter4_CallCall(data,data.length/2,data.length);
		
		
		ExecutorService service =  Executors.newFixedThreadPool(2);
		
		Future<Integer> future1 = service.submit(task);
		Future<Integer> future2 = service.submit(task1);
		
		System.out.println(Math.max(future1.get(), future2.get()));
		
	}

}
