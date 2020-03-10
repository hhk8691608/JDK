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





	/**
	 * @Author Ace
	 * @Description
	 * Consumer<T> 消费型接口 对类型为T的对象应用操作，包含方法 : void accept(T t);
	 * @Date 2020/3/9 14:35
	 * @Param []
	 * @return void
	**/
	@Test
	public void test11() {

		String keyValue = "hello consumer !!";
		showConsumer(keyValue, (v)-> System.out.println("hello key , key = "+v));

	}


	private void showConsumer(String keyValue , Consumer<String> func){
		func.accept(keyValue);
	}

	@Test
	public void test21() {

		String keyValue = "hello consumer !!";
		Consumer<String> process = (x) ->{
			System.out.println("hello key , key = "+x);
		};
		process.accept(keyValue);

	}


	/**
	 * @Author Ace
	 * @Description
	 * Supplier<T> 供给型接口  返回类型是T的对象，包含方法 ： T get（）
	 * @Date 2020/3/9 14:46
	 * @Param []
	 * @return void
	**/
	@Test
	public void test12() {

		String keyValue = "Supplier";
		String result =	showSupplier(()->{
			String tempStr = "new str Supplier";
			return tempStr;
		});
		System.out.println("result = "+result);

	}

	private String showSupplier(  Supplier<String> func) {
		return  func.get();
	}


	@Test
	public void test22() {
		String keyValue = "Supplier";
		Supplier<String> process = () -> {
			return "down";
		};
		String result =	process.get();

		System.out.println("result = "+result);
	}



	/**
	 * @Author Ace
	 * @Description
	 * Function<T,R> 函数式接口 对类型为T 的对象应用操作并返回结果，结果为R类型的对象，包含方法 R apply(T t);
	 * @Date 2020/3/9 15:05
	 * @Param []
	 * @return void
	**/
	@Test
	public void test13() {

		String keyValue = "Supplier";
		Integer result = showFunction(keyValue,(x)->{
			String tempResult = "new Str  "+x;
			return tempResult.length();
		});
		System.out.println(result);
	}


	public Integer showFunction(String str,Function<String,Integer> myfunc){
		return myfunc.apply(str);
	}

	@Test
	public void test23() {

		String keyValue = "Supplier123456798";
		Integer result = 0;
		Function<String,Integer> process = (x) -> {

			if(x.length() > 10){
				return x.length();
			}
			return 0;
		};
		result = process.apply(keyValue);
		System.out.println(result);
	}



	/**
	 * @Author Ace
	 * @Description
	 * Predicate<T> 断定型接口 确定类型为T的对象是否满足某约束，并返回boolean值
	 * @Date 2020/3/9 15:11
	 * @Param []
	 * @return void
	**/
	@Test
	public void test14() {

		Integer keyValue = 1000;
		boolean result = showPredicate(keyValue,(x)->{
			if(x > 10){
				return false;
			}
			return true;
		});
		System.out.println(result);
	}

	private boolean showPredicate(Integer value,Predicate<Integer> myfunc){
		return  myfunc.test(value);
	}


	@Test
	public void test24() {

		Integer keyValue = 1000;
		Predicate<Integer> process = (x)->{
			if(x > 10){
				return true;
			}
			return false;
		};
		System.out.println("result = "+process.test(keyValue));
	}


}
