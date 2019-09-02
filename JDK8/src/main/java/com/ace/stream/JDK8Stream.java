package com.ace.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
