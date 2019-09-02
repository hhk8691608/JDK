package com.ace.spring.ioc.simple;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class SimpleIOC {
	
	private Map<String,Object> beanMap = new HashMap<>();
	
	public SimpleIOC(String location) throws Exception {
		loadBeans(location);
	}

	private void loadBeans(String location) throws Exception {
		
		
		InputStream inputStream = new FileInputStream(location);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder(); 
		Document doc = documentBuilder.parse(inputStream);
		
		
		
	}

}
