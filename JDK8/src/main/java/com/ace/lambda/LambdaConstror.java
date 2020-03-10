package com.ace.lambda;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

import com.ace.lambda.inter.Employee;
import org.junit.Test;

/*
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 *
 * 1. 对象的引用 :: 实例方法名
 *
 * 2. 类名 :: 静态方法名
 *
 * 3. 类名 :: 实例方法名
 *
 * 注意：
 * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 *
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 *
 * 1. 类名 :: new
 *
 * 三、数组引用
 *
 * 	类型[] :: new;
 *
 *
 */
public class LambdaConstror {






	//对象的引用 :: 实例方法名
	@Test
	public void test1() {
		PrintStream ps1 = System.out;
		Consumer<String> con = (x) -> ps1.println(x);
		con.accept("123");
		
		
		
		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
		con1.accept("hello world");
		
		Consumer<String> con2 = System.out::println;
		con2.accept("asdf");
	}



	//对象的引用 :: 实例方法名
	@Test
	public void test2(){
		Employee  employee = new Employee("arvin",18,1,2563.0);
		Supplier<Employee> employeeSupplier = ()->{
			return  employee;
		};
		System.out.println(employeeSupplier.get().getName());

		System.out.println("-------------------------");
		Supplier<String> stringSupplier = ()-> employee.getName();
		System.out.println("name = "+stringSupplier.get());

		System.out.println("========================");
		Supplier<Integer> integerSupplier = employee::getAge;
		System.out.println("Integer = "+integerSupplier.get());



	}

	//类名 :: 静态方法名
	@Test
	public void test3(){

		BiFunction<Double,Double,Double> fun = (x,y) -> Math.max(x,y);
		System.out.println(fun.apply(1.5, 22.2));

		System.out.println("--------------------------------------------------");

		BiFunction<Double,Double,Double> fun2 = Math::max;
		System.out.println(fun2.apply(1.5, 0.2));

	}

	//类名 :: 静态方法名
	@Test
	public void test4() {

		Comparator<Integer> com = (x, y) -> Integer.compare(x,y);
		System.out.println("result = "+com.compare(11,22));
		System.out.println("-------------------------------------");


		Comparator<Integer> com2 = Integer::compare;
		System.out.println("result = "+com2.compare(111,22));
	}


	//类名 :: 实例方法名
	@Test
	public void test5() {

		BiPredicate<String,String> bp = (x, y) -> x.equals(y);
		System.out.println(bp.test("abcde", "abcde"));

		System.out.println("-----------------------------------------");


		BiPredicate<String,String> bp1 = String::equals;
		System.out.println(bp.test("111", "222"));

	}


	//构造器引用
	@Test
	public void test6(){

		Function<String,Employee> fun = Employee::new;
		Employee employee1 =fun.apply("lily");
		employee1.toString();
		System.out.println("name = "+employee1.getName());


		BiFunction<String, Integer, Employee> fun2 = Employee::new;
		Employee employee2 = fun2.apply("rambo",29);
		employee2.toString();
		System.out.println("name = "+employee2.getName()+",age = "+employee2.getAge());

	}

	//构造器引用
	@Test
	public void test7(){
		Supplier<Employee> sup = () -> new Employee("jay");
		System.out.println(sup.get());

		System.out.println("------------------------------------");

		Supplier<Employee> sup2 = Employee::new;
		System.out.println(sup2.get());
	}

	//数组引用
	@Test
	public void test8(){
		Function<Integer, String[]> fun = (args) -> new String[args];
		String[] strs = fun.apply(10);
		System.out.println(strs.length);

		System.out.println("--------------------------");
		Function<Integer, String[]> fun1 = String[]::new;
		String[] strings = fun1.apply(100);
		System.out.println(strings.length);


	}




}
