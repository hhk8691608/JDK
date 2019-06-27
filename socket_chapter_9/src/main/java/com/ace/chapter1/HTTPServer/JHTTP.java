package com.ace.chapter1.HTTPServer;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @Description: 
 * 完整的http服务器
 * 
 */
public class JHTTP {
	
	private static final Logger logger = Logger.getLogger(JHTTP.class.getCanonicalName());
	private static final int NUM_THREADS = 50;
	private static final String INDEX_FILE = "index.html";
	
	private File rootDirectory;
	private int port;
	
	public JHTTP(File rootDirectory,int port)throws IOException{
		
		if(!rootDirectory.isDirectory()) {
			throw new IOException(rootDirectory+" does not exist as a directory");
		}
		this.rootDirectory = rootDirectory;
		this.port = port;
	}
	
	
	public void start() throws IOException{
		ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
		try(ServerSocket server = new ServerSocket()){
			logger.info("Acception connections on port "+ server.getLocalPort());
			logger.info("Document Root: "+rootDirectory);
			
			while(true) {
				
				try {
					Socket request = server.accept();
					Runnable r = new RequestProcessor(rootDirectory,INDEX_FILE,request);
					pool.submit(r);
					
				} catch (Exception e) {
					logger.log(Level.WARNING,"Error accepting connection ",e);
				}
				
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		File docroot;
		try {
			docroot = new File(args[0]);
		} catch (Exception e) {
			return ;
		}
		
		int port;
		try {
			port = Integer.parseInt(args[1]);
			if(port <0 || port > 65535)
				port = 80;
			
		} catch (Exception e) {
				port = 80;
		}
		
		try {
			JHTTP webserver = new JHTTP(docroot,port);
			webserver.start();
		} catch (Exception e) {

		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public File getRootDirectory() {
		return rootDirectory;
	}

	public void setRootDirectory(File rootDirectory) {
		this.rootDirectory = rootDirectory;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	
	
	
	

}
