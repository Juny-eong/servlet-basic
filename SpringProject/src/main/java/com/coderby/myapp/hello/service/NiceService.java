package com.coderby.myapp.hello.service;

import org.springframework.stereotype.Service;

@Service
public class NiceService implements IHelloService {

	@Override
	public String sayHello(String name) {
		System.out.println(">>>>LOG : " + new java.util.Date());
		String message = "Hello~ " + name;
		return message;
	}

	@Override
	public String sayGoodbye(String name) {
		String message = "goodbye~ " + name;
		return message;
	}
	
}
