package com.ace.chapter1.HTTPServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Date;
import java.util.logging.Logger;

public class RequestProcessor implements Runnable{
	
	private final static Logger logger = Logger.getLogger(RequestProcessor.class.getCanonicalName());
	
	private File rootDirectory;
	private String indexFileName = "index.html";
	private Socket connection;
	
	
	public RequestProcessor() {
	}
	public RequestProcessor(File rootDirectory,String indexFileName,Socket connection) {
		this.rootDirectory = rootDirectory;
		this.indexFileName = indexFileName;
		this.connection = connection;
	}

	@Override
	public void run() {
		
		String root = rootDirectory.getPath();
		try {
			OutputStream raw = new BufferedOutputStream(connection.getOutputStream());
			Writer out = new OutputStreamWriter(raw);
			Reader in = new InputStreamReader(new BufferedInputStream( connection.getInputStream()) , "UTF-8");
			StringBuffer requestLine = new StringBuffer();
			while(true) {
				int c = in.read();
				if(c == '\r' || c == '\n')
					break;
				requestLine.append((char)c);
			}
			String get = requestLine.toString();
			
			logger.info(connection.getRemoteSocketAddress() + "  "+ get);
			String[] tokens = get.split("\\s+");
			String method = tokens[0];
			String version = "";
			if(method.equals("GET")) {
				String fileName = tokens[1];
				if(fileName.endsWith("/"))
					fileName += indexFileName;
				String contentType = URLConnection.getFileNameMap().getContentTypeFor(fileName);
				if(tokens.length > 2)
					version = tokens[2];
				File theFile = new File(rootDirectory,fileName.substring(1,fileName.length()));
				
				if(theFile.canRead() && theFile.getCanonicalPath().startsWith(root)) {
					byte[] theData = Files.readAllBytes(theFile.toPath());
					if(version.startsWith("HTTP/")) {
//						sendHeader(out,"HTTP/1.0 200 OK",contentType,theData.length);
					}
					raw.write(theData);
					raw.flush();
				}else {
					
				}
				
				
			}
			
		} catch (Exception e) {
		}finally {
			try {
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	
	private void sendHeader(Writer out ,String responseCode,String contentType,int length) throws IOException {
		
		out.write(responseCode + "\r\n");
		Date now = new Date();
		out.write("Date: "+now+"\r\n");
		out.write("Server: JHHTP 2.0\r\n");
		out.write("Content-length: "+length+"\r\n");
		out.write("Content-type: "+contentType+"\r\n\r\n");
		out.flush();
	}

}
