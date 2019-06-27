package com.ace.clientSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientSocket_chapter1 {

	public static final Integer PORT = 8899;
	public static final String IP_ADDR = "127.0.0.1";
	public static final Integer TIME_OUT = 15000;
	
	/**
	 * 
	 * @Description: 
	 * 构造但不连接
	 * connect(SocketAddress,timeout)
	 * 	timeout 缺省是0表示永远等待下去
	 * SocketAddress
	 * 	表示一个连接端点，实际使用的都是InetSocketAddress的实例
	 * 	为暂时的socket连接信息提供一个方便的存储
	 *		
	 * 
	 */
	private static void NoConnect() {
			
		try {
			Socket socket = new Socket();
			SocketAddress address = new InetSocketAddress(IP_ADDR,PORT);
			socket.connect(address);
			
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, ParseException {
		
		
		
	}

	
	
	
}
