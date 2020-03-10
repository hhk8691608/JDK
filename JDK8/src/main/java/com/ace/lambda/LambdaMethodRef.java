package com.ace.lambda;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.ace.lambda.inter.Employee;

public class LambdaMethodRef {
	
//	对象::实例方法名
	@Test
	public void test1() {
		
		PrintStream ps1 = System.out;
		Consumer<String> con = (x) -> ps1.println(x);
		con.accept("123456");
		
		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
		con1.accept("qwer");
		
		Consumer<String> con2 = System.out::println;
		con2.accept("accc");
		
	}
	
//	对象::实例方法名
	@Test
	public void test2() {
		
		Employee em = new Employee();
		em.setAge(28);
		Supplier<Integer> sup = em::getAge;
		Integer num = sup.get();
		System.out.println(num);
		
	}
	
//	类::静态方法名
	@Test
	public void test3() {
		
		Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
		Comparator<Integer> com2 = Integer::compare;
		int num = com2.compare(10, 20);
		System.out.println(num);
		
	}
	
//	类::实例方法名
	@Test
	public void test4() {
		
		BiPredicate<String,String> bp = (x, y) -> x.equals(y);
		BiPredicate<String,String> bp2 = String::equals;
		
		boolean isFlat = bp2.test("a", "d");
		System.out.println(isFlat);
		
	}
//	构造器引用
	@Test
	public void test5() {
		
		Supplier<Employee> sup = Employee::new;
		Employee emp = sup.get();
		System.out.println(emp);
		
	}
	
//	构造器引用
	@Test
	public void test6() {
		
		Function<String, Employee> sup = Employee::new;
		Employee emp = sup.apply("arvin");
		System.out.println(emp);
		
	}
	
//	数组引用
	@Test
	public void test7() {
		
		Function<Integer,String[]> fun2 = String[]::new;
		String[] strs2 = fun2.apply(30);
		System.out.println(strs2.length);
		
	}
	
}
