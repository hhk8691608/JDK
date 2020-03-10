package com.ace.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.ace.lambda.inter.Employee;
import org.junit.Test;

public class JDK8Stream {
	
	@Test
	public void test1() {
//		通过collection系列集合提供的stream()或 parallelStream()
		List<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();
//		通过 Arrays 中的静态方法 stream() 获取数组流
		String[] strs = new String[10];
		Stream<String> stream2 = Arrays.stream(strs);
//		通过stream类中的静态方法of()
		Stream<String> stream3 = Stream.of("aa","bb","cc");
//		创建无限流
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+2);
		stream4.forEach(System.out::println);
		
		
		
		
		
	}
	
	
	
	/***
	 筛选和切片
	 filter-接受lambda，从流中排出某些元素
	 limit - 截断流，使其元素不超过给定数量
	 skip(n) - 跳过元素，返回一个扔掉了n个元素的流，若流中元素不足n个，这返回一个空流，和limit互补
	 distinct - 筛选 通过流所生成元素的hashCode（）和 equals 去除重复元素
	
	
	映射
		map - 接受Lambda 将元素转换成其他形式或者提取信息，接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
		flatMap -- 接受一个函数作为参数，将流中的每个值都换成另外一个流，然后把所有流连接成一个流
	
	 */
	
	@Test
	public void test2() {
	
		List<String> list = Arrays.asList("aaa","bbbb","cccc","ddd");
		list.stream().map((str) -> str.toUpperCase())
		.forEach(System.out::println);
		
	}
	
	
	
	public Stream<Character> filterCharacter(String str){
		
		List<Character> list = new ArrayList<Character>();
		for(Character ch : str.toCharArray()) {
			list.add(ch);
		}
		return list.stream();
		
	}



	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 59, 6666.66),
			new Employee(101, "张三", 18, 9999.99),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "李八", 8, 7777.77),
			new Employee(104, "胡一", 8, 7777.77),
			new Employee(104, "胡一", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);


	/**
	 * @Author Ace
	 * @Description
	 * //1. Collection 提供了两个方法  stream() 与 parallelStream()
	 * //2. 通过 Arrays 中的 stream() 获取一个数组流
	 * //3. 通过 Stream 类中静态方法 of()
	 * 	//4. 创建无限流
	 * @Date 2020/3/10 8:52
	 * @Param []
	 * @return void
	**/
	@Test
	public void test11() {

		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();//获取一个顺序流
		Stream<String> parallelStream = list.parallelStream();//获取一个并行流

		//2. 通过 Arrays 中的 stream() 获取一个数组流
		Integer[] nums = new Integer[10];
		Stream<Integer> stream1 = Arrays.stream(nums);
		stream1.forEach(System.out::println);


		//3. 通过 Stream 类中静态方法 of()
		Stream<String> stream2 = Stream.of("A","B","C","D","E");
		stream2.forEach(System.out::println);

		//4. 创建无限流
		//迭代
		Stream<Integer> stream3 = Stream.iterate(0, (x)->x+2).limit(10);
		stream3.forEach(System.out::println);

		//生成
		Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
		stream4.forEach(System.out::println);

	}




	/**
	 * @Author Ace
	 * @Description
	 * Stream 的中间操作
	 * 筛选与切片
	 * 		filter——接收 Lambda ， 从流中排除某些元素。
	 * 		limit——截断流，使其元素不超过给定数量。
	 * 		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
	 * 		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 * @Date 2020/3/10 9:19
	 * @Param []
	 * @return void
	**/
	@Test
	public void test12() {

		Stream<Employee> stream = emps.stream()
				.filter((e)->{
					System.out.println("中间操作");
					return e.getAge() <= 35;
				});

		//只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
		stream.forEach(System.out::println);
	}



	@Test
	public void test13() {

		Iterator<Employee> it = emps.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}

	}

	@Test
	public void test14() {
		emps.stream().filter((e)->{
			System.out.println("短路！！");
			return e.getSalary() >= 5000;
		}).limit(3)
				.forEach(System.out::println);

	}


	@Test
	public void test15(){
		emps.parallelStream()
				.filter((e) -> e.getSalary() >= 5000)
				.skip(2)
				.forEach(System.out::println);
	}


	@Test
	public void test16(){
		emps.stream()
				.distinct()
				.forEach(System.out::println);
	}
	
	
	
	
	

}
