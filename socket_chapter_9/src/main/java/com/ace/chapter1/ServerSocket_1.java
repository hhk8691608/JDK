package com.ace.chapter1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.sampled.Port;

/**
 * 


 * @Description: 
 * 使用一个回车/换行对来结束这一行.网络服务器中几乎都会这样做，需要显示选择这个行结束符，而不是使用系统的行分隔符.
 * 结束处理时一定要关闭socket
 * 


 */
public class ServerSocket_1 {
	
	
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		ServerSocket server = new ServerSocket(8899);
//		System.out.println("服务器 启动...............");
//		while(true) {
//			
//			Socket connection = server.accept();
//			System.out.println("服务器得到请求  == "+connection.getPort());
//			OutputStream out = connection.getOutputStream();
//			String str = "hello world";
//			out.write(str.getBytes());
//			out.flush();
//			connection.close();
//			System.out.println("服务器 发送结束...............");
//		}
//		
//		
//	}
	
	
	/**
	 * @Description: 
	 * 完成socket客户端和服务端的通讯 
	 * 基本完成服务端写出操作
	 * 小问题---》》该段代码本地多次请求服务端时，会出现请求进行中的情况，无法获取结果，偶尔出现的情况
	 */
	private void server_socket1() {
		System.out.println("服务器启动..............................");
		try {
			ServerSocket server = new ServerSocket(8899);
			while(true) {
					Socket connection = null;
					try {
						connection =  server.accept();
						OutputStream out = connection.getOutputStream();
						Writer wirter = new OutputStreamWriter(out);
						System.out.println("服务器得到请求  == "+connection.getPort());
						Date now = new Date();
						wirter.write(now.getTime()+"");
						wirter.flush();
					}catch (IOException e) {
						e.printStackTrace();
					}finally {
						if(connection != null)
							connection.close();
					}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
		}
		
	}
	
	
	
	/**
	 * @Description: 
	 * 完成socket客户端和服务端的通讯 
	 * 基本完成服务端读入操作
	 */
	private static void server_socket2() throws IOException {
		
		ServerSocket server = null;
		try {
			
			server = new ServerSocket(8899);
			System.out.println("服务器 启动...............");
			while(true) {
				try(Socket conn = server.accept()) {
					System.out.println("服务器 监听 8899 端口...............");
					BufferedInputStream bis = new BufferedInputStream( conn.getInputStream() );
					byte[] b = new byte[512];
					int flag = 0;
					String str ;
					while( (flag = bis.read(b)) != -1) {
						str = new String(b);
						System.out.println(str);
					}
					System.out.println("服务器 监听 8899 端口 读取结束...............");
				} catch (Exception e) {
				}
			}
			
		} finally {
			if(server!=null) {
				server.close();
			}
		}
		
		
	}
	
	
	/**
	 * @Description: 
	 * 完成socket客户端和服务端的通讯 
	 * 基本完成服务端读入写出操作
	 * 失败了
	 */
	private static void server_socket3() throws IOException {
		
		ServerSocket server = null;
		try {
			
			server = new ServerSocket(8899);
			System.out.println("服务器 启动...............");
			while(true) {
				try(Socket conn = server.accept()) {
					System.out.println("服务器 监听 8899 端口...............");
					BufferedInputStream bis = new BufferedInputStream( conn.getInputStream() );
					byte[] b = new byte[512];
					int flag = 0;
					String str ;
					while( (flag = bis.read(b)) != -1) {
						str = new String(b);
						System.out.println("客户端的请求参数是"+str);
					}
					conn.shutdownInput();
					
					BufferedOutputStream bos = new BufferedOutputStream(conn.getOutputStream());
					String code = "行动案号是"+(new Random().nextDouble()*10000);
					bos.write(code.getBytes());
					bos.flush();
					conn.shutdownOutput();
					
				} catch (Exception e) {
				}
			}
			
		} finally {
			if(server!=null) {
				server.close();
			}
		}
		
		
	}
	
	
	
	/**
	 * @throws IOException 
	 * @Description: 
	 * 完成socket客户端和服务端的通讯 
	 * 多线程服务器(线程池)
	 * 
	 */
	private static void dumpThreadSocket() throws IOException {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		try(ServerSocket server = new ServerSocket(8899)){
			while(true) {
				Socket conn = server.accept();
				pool.submit(new RunHandler(conn));
			}
			
		}
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		try {
//			server_socket2();
//			server_socket3();
			dumpThreadSocket();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
