package com.ace.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 
	java内置四大核心函数式接口
	1.Consumer<T> 消费型接口 对类型为T的对象应用操作，包含方法 : void accept(T t);
	2.Supplier<T> 供给型接口  返回类型是T的对象，包含方法 ： T get（）
	3.Function<T,R> 函数式接口 对类型为T 的对象应用操作并返回结果，结果为R类型的对象，包含方法 R apply(T t); 
	4.Predicate<T> 断定型接口 确定类型为T的对象是否满足某约束，并返回boolean值
 */
public class LambdaJDKFunc {


	
	
	@Test
	public void test4() {
		
		List<String> sourceList = Arrays.asList("hello","atkjdsf","zxcvz","d","sfgszcx");
		List<String> strList = testPredicate(sourceList, (s) ->s.length() > 3 );
		for(int i=0;i<strList.size();i++) {
			String value = strList.get(i);
			System.out.println(value);
		}
	}
	
	
	
	private List<String> testPredicate(List<String> list,Predicate<String> func) {
		
		List<String> strList = new ArrayList<>();
		for(String str :list) {
			if(func.test(str)) {
				strList.add(str);
			}
		}
		
		return strList;
		
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	public void test3() {
		String source = "hello world    ";
		String result = testFunction(source,(m)->{
			return m.substring(2,7);
		});
		System.out.println(result);
		
	}
	
	
	private String testFunction(String source,Function<String,String> myfunc) {
		
		return myfunc.apply(source);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void test2() {
		
		List<Integer> result = testSupplier(10, ()->(int) (Math.random() * 100));
		
		for(int i=0;i<result.size();i++) {
			Integer value = result.get(i);
			System.out.println(value);
		}
		
		
	}
	
	private List<Integer> testSupplier(int num,Supplier<Integer> func) {
		
		List<Integer> result = new ArrayList<>();
		
		for(int i=0;i<num;i++) {
			Integer value = func.get();
			result.add(value);
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void test1() {
		String keyValue = "hello world!!!";
		test_consumer(keyValue, (m)->{
			System.out.println("每次大喊："+m);
		});
		
	}
	
	private void test_consumer(String keyValue,Consumer<String> func) {
		
		func.accept(keyValue);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
