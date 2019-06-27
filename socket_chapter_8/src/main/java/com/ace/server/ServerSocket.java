package com.ace.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;

public class ServerSocket {
	
	
	public static final Integer PORT = 8899;
	
	public static void main(String[] args) {
		
		server_socket1();
		
	}
	
	/**
	 * @Description: 
	 * 完成socket客户端和服务端的通讯 
	 * 基本完成服务端写出操作
	 */
	private static void server_socket1() {
		System.out.println("服务器启动..............................");
		try {
			java.net.ServerSocket server = new java.net.ServerSocket(PORT);
			while(true) {
					Socket connection = null;
					try {
						connection =  server.accept();
						OutputStream out = connection.getOutputStream();
						Writer wirter = new OutputStreamWriter(out);
						System.out.println("服务器得到请求  == "+connection.getPort());
						Date now = new Date();
						wirter.write(now.toString()+"\r\n");
//						使用一个回车/换行对来结束这一行.网络服务器中几乎都会这样做，需要显示选择这个行结束符，而不是使用系统的行分隔符.
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
	
	

}
