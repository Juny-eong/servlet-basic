package com.spring.ex02;

import com.spring.ex01.PersonService;

public class PersonServiceImpl implements PersonService {
	private String name;
	private int age;
	
	public PersonServiceImpl(String name) {
		this.name = name;
	}
	
	public PersonServiceImpl(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		
	}
}
