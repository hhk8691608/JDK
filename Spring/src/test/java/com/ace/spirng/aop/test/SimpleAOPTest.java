package com.ace.spirng.aop.test;

import org.junit.Test;

import com.ace.spring.aop.simple.iterface.Advice;
import com.ace.spring.aop.simple.iterface.BeforeAdvice;
import com.ace.spring.aop.simple.iterface.HelloService;
import com.ace.spring.aop.simple.iterface.MethodInvocation;
import com.ace.spring.aop.simple.iterface.impl.HelloServiceImpl;
import com.ace.spring.aop.simple.iterface.impl.MethodInvocationImpl;
import com.ace.spring.aop.simple.SimpleAop;

public class SimpleAOPTest {
	
	@Test
    public void getProxy() throws Exception {
        // 1. 创建一个 MethodInvocation 实现类
//        MethodInvocation logTask = () -> System.out.println("log task start");
		MethodInvocation logTask = new MethodInvocationImpl();
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();
        
        // 2. 创建一个 Advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);
        
        // 3. 为目标对象生成代理
        HelloService helloServiceImplProxy = (HelloService) SimpleAop.getProxy(helloServiceImpl,beforeAdvice);
        
        helloServiceImplProxy.sayHelloWorld();
    }

}
