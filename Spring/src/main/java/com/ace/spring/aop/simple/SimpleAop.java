package com.ace.spring.aop.simple;

import java.lang.reflect.Proxy;

import com.ace.spring.aop.simple.iterface.Advice;

public class SimpleAop {
	
	public static Object getProxy(Object bean,Advice advice) {
		
		return Proxy.newProxyInstance(SimpleAop.class.getClassLoader(), bean.getClass().getInterfaces(), advice);
	}

}
