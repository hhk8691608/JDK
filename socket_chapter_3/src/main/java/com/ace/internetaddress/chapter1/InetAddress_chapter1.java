package com.ace.internetaddress.chapter1;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 

 * @ClassName: InetAddress

 * @Description: 
 * 
 * 

 */
public class InetAddress_chapter1 {
	
	
	public void inetAddressGetByName() {
		
		try {
//			https://www.youtube.com/
			String strIp = "14.215.177.39";
			String strUrlName = "www.baidu.com";
			
			InetAddress address = InetAddress.getByName(strUrlName);
			System.out.println(address.getHostName());
			System.out.println(address.getAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
			
			
		} catch (Exception e) {
		}
		
		
	}

}
