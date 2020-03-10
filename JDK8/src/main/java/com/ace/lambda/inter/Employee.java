package com.ace.lambda.inter;

public class Employee {
	
	private String name;
	
	private Integer age;

	private Integer id;

	private Double salary;


	private Status status;

	public enum Status {
		FREE, BUSY, VOCATION;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

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

	public Employee(String name,Integer age) {
		this.name = name;
		this.age = age;
	}

	public Employee(String name,Integer age,Integer id,Double salary) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.salary = salary;

	}

	public Employee(Integer id,String name,Integer age,Double salary) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.salary = salary;

	}

	public Employee(int id, String name, int age, double salary, Status status) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name is "+name);
		sb.append(", age is "+age);
		sb.append(", id is "+id);
		sb.append(", salary is "+salary);
		
		return sb.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}





}
