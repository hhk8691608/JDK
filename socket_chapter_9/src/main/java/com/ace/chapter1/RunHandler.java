package com.ace.chapter1;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Logger;

public class RunHandler implements Runnable{
	
	public static final Logger LOG = Logger.getLogger("RunHandler");
	
	private Socket socket;
	
	public RunHandler() {
	}
	
	public RunHandler(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {
		try {
			 
			OutputStream out = socket.getOutputStream();
			Date date = new Date();
			DataOutputStream bos = new DataOutputStream(out);
			bos.writeUTF(date+"");
			bos.flush();
			out.close();
			bos.close();
			LOG.info("data : "+date);
			
		}catch (Exception e) {
		}finally {
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
