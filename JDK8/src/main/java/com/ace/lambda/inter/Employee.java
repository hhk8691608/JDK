package com.ace.lambda.inter;

public class Employee {
	
	private String name;
	
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Employee() {
		
	}
	public Employee(String name) {
		this.name = name;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("name is "+name);
		sb.append("age is "+age);
		
		return sb.toString();
	}
	
	
	
	

}
