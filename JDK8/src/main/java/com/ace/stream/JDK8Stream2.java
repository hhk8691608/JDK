package com.ace.stream;

import com.ace.lambda.inter.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/***
 *
 *@Author Mark
 *@Date 2020/3/10 11 13
 *@Source 慕课网
 *@Desciption
 *      allMatch——检查是否匹配所有元素
 * 		anyMatch——检查是否至少匹配一个元素
 * 		noneMatch——检查是否没有匹配的元素
 * 		findFirst——返回第一个元素
 * 		findAny——返回当前流中的任意元素
 * 		count——返回流中元素的总个数
 * 		max——返回流中最大值
 * 		min——返回流中最小值
 *
 * 	 //注意：流进行了终止操作后，不能再次使用
 */
public class JDK8Stream2 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
    );

    @Test
    public void test1(){

        boolean b1 = emps.stream().allMatch((e)-> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = emps.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        boolean b3 = emps.stream().noneMatch( e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);


    }

    @Test
    public void test2(){

        Employee e = emps.stream().findFirst().get();
        System.out.println(e.toString());

        Optional<Employee> op2 = emps.stream().filter((x) -> x.getStatus().equals(Employee.Status.FREE)  ).findAny();
        System.out.println(op2.get());

    }


    @Test
    public void test3(){

        long count = emps.stream().filter( (x) -> x.getStatus().equals(Employee.Status.FREE)).count();
        System.out.println(count);

        Optional<Double> op = emps.stream().map(Employee::getSalary).max(Double::compareTo);
        System.out.println(op.get());


        Optional<Employee> op2 = emps.stream().min( (x,y) ->
            Double.compare(x.getSalary(),y.getSalary())
        );
        System.out.println(op2.get());

    }








    //注意：流进行了终止操作后，不能再次使用
    @Test
    public void test4(){
        Stream<Employee> stream = emps.stream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE));

        long count = stream.count();

        stream.map(Employee::getSalary)
                .max(Double::compare);
    }




}
