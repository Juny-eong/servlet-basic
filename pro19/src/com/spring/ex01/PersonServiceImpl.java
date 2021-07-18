package com.spring.ex01;

public class PersonServiceImpl implements PersonService {
	
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("name: " + name);
		System.out.println("age: " + age);
	}
	
	
}
