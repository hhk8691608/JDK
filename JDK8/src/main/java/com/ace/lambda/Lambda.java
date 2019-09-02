package com.ace.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

import com.ace.lambda.inter.MapRduce;

/**
 * 

 * @ClassName: Lambda

 Lambda表达式基本语法 
 ->  该操作符称为箭头操作或者Lambda操作符
 左侧：lambda表达式的参数列表
 右侧：lambda表达式中所需执行的功能，即lamdba执行体
 
 语法格式一 ： 无参数，无返回值
 ()->System.out.println("Hello Lambda");
 
 语法格式二 ： 有一个参数，并且没有返回值
 (x) -> System.out.println(x);
 
 语法格式三：若只有一个参数，小括号可以省略不写
 x -> System.out.println(x);
 
 语法格式四：有两个以上的参数，有返回值，并且lambda体中有多条语句
 
 
 语法格式五：若lambda体中只有一条语句，return和大括号都可以省略不写
 
 语法格式六：lambda表达式的参数列表的数据类型可以省略不写，因为jvm会通过上下文推断出，数据类型，即类型推断
 
 lambda表达式需要函数式接口的支持
 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，
 可以使用注解@FunctionalInterface  修饰
 可以检查是否是函数式接口
 
 
 */
public class Lambda {
	
	
	
	
	
	@Test
	public void test1() {
		
		
		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello World !");
			}
			
		};
		r.run();
		System.out.println("-----------------");
		
		Runnable r1 = () -> System.out.println("hello lambda!!");
		r1.run();
		
	}
	
	
	

	@Test
	public void test2() {
		Consumer<String> con = x ->System.out.println(x);
		con.accept("arvin now");
	}
	
	
	
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y)->{
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
		System.out.println(com.toString());
	}
	
	
	@Test
	public void test4() {
		Comparator<Integer> com = (x,y)->Integer.compare(x, y);
		System.out.println(com.toString());
	}
	
	
	
	@Test
	public void test5() {
		
		Integer result = operation(100, (x)-> (x * x));
		System.out.println(result);
		
	}
	
	public Integer operation(Integer num,MapRduce mapduce) {
		return mapduce.getValue(num);
	}
	
	
	
	
	
	
	

}
