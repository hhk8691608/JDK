package com.ace.spring.aop.simple.iterface.impl;

import com.ace.spring.aop.simple.iterface.MethodInvocation;

public class MethodInvocationImpl implements MethodInvocation{

	@Override
	public void invoke() {
		System.out.println("this is proxy method");
	}

}
