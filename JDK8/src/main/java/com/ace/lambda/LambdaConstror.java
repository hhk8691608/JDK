package com.ace.lambda;

import java.io.PrintStream;
import java.util.function.Consumer;

import org.junit.Test;

/***
 * 

方法引用
若Lambda体中
构造器引用
 */
public class LambdaConstror {

	
	
	
	
	
	
	@Test
	public void test1() {
		PrintStream ps1 = System.out;
		Consumer<String> con = (x) -> ps1.println(x);
		
		
		
		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
		
		Consumer<String> con2 = System.out::println;
		con2.accept("asdf");
	}
	
	
	
	
	
	
	
	
	
}
