package com.ace.chapter1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Logger;



/***
 * 	客户端只需要关闭socket
 *
 * 
 * 

 * @ClassName: ClientSocket_1

 * @Description: TODO

 * @author: admin

 * @date: 2019年6月26日 下午2:53:41
 */
public class ClientSocket_1 {
	
	
	public static final Logger LOG = Logger.getLogger("ClientSocket_1");
	
	
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		
//		System.out.println("客户端 发送请求...............");
//		Socket client = new Socket("127.0.0.1",8899);
//		InputStream input = client.getInputStream();
//		byte[] b = new byte[1024];
//		int flag = 0;
//		StringBuffer sb = new StringBuffer();
//		while( (flag = input.read(b) ) != -1) {
//			sb.append(new String(b));
//		}
//		System.out.println("server content : "+sb.toString());
//		client.close();
//		System.out.println("客户端 发送请求结束...............");
//	}
	
	
	/**
	 * @Description: 
	 * 完成socket客户端和服务端的通讯
	 * 客户端读入操作
	 * 小问题---》》该段代码本地多次请求服务端时，会出现请求进行中的情况，无法获取结果，偶尔出现的情况
	 */
	private static void client_socket1() {
		System.out.println("客户端启动..............................");
		Socket client = null;
		Reader br = null;
		try {
			client = new Socket("192.168.232.1",8899);
			InputStream input = client.getInputStream();
			br = new  InputStreamReader(input);
			char[] cbuf = new char[1024];
			int flag = 0;
			StringBuffer sbf = new StringBuffer();
			while( (flag = br.read(cbuf) ) != -1) {
				sbf.append(cbuf);
			}
			System.out.println("服务器响应 : "+sbf.toString());
			input.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(client != null ) {
						client.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("客户端结束..............................");
			
		}
	}
	
	
	
	
	
	/**
	 * @throws IOException 
	 * @Description: 
	 * 完成socket客户端和服务端的通讯
	 * 客户端写出操作
	 */
	private static void client_socket2() throws IOException {
		
		
		try(Socket client = new Socket("127.0.0.1",8899)){
			System.out.println("客户端 启动...............");
			BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream() );
			Random random = new Random();
			int tempData = random.nextInt()*2000;
			String str = ""+tempData;
			bos.write(str.getBytes());
			bos.flush();
			System.out.println("客户端 发送数据 = "+str);
		}
		
	}
	
	
	
	/**
	 * @Description: 
	 * 完成socket客户端和服务端的通讯
	 * 客户端读出写入操作
	 */
	private static void client_socket3() throws IOException {
		
		
		try(Socket client = new Socket("127.0.0.1",8899)){
			System.out.println("客户端 启动...............");
			BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream() );
			Random random = new Random();
			int tempData = random.nextInt()*2000;
			String str = ""+tempData;
			bos.write(str.getBytes());
			bos.flush();
			System.out.println("客户端 发送数据 = "+str);
			client.shutdownOutput();
			
			BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
			byte[] b = new byte[512];
			int flag = 0;
			StringBuffer sb = new StringBuffer();
			while( (flag =  bis.read(b)) != -1) {
				sb.append(b.toString());
			}
			System.out.println("服务器响应内容 = "+sb.toString());
			client.shutdownInput();
			
		}
		
	}
	
	/**
	 * 
	 * @Description: 
	 * 引入日志功能
	 */
	private static void client_socket4() throws IOException {
		
		
		try(Socket client = new Socket("127.0.0.1",8899)){
			System.out.println("客户端 启动...............");
			
			BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
			byte[] b = new byte[1024];
			int flag = 0;
			StringBuffer sb = new StringBuffer();
			while( (flag =  bis.read(b)) != -1) {
				sb.append(new String(b));
			}
			LOG.info("服务器响应内容 = "+sb.toString());
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
//		client_socket1();
//		client_socket2();
//		client_socket3();
		client_socket4();
	}

}
