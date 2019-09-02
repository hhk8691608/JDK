package com.ace.spring.aop.simple.iterface.impl;

import com.ace.spring.aop.simple.iterface.HelloService;

public class HelloServiceImpl implements HelloService{

	@Override
	public void sayHelloWorld() {
		
		System.out.println("hello world");
		
	}

}
