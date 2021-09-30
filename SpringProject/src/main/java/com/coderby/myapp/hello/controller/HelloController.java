package com.coderby.myapp.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.coderby.myapp.hello.service.IHelloService;

@Controller
public class HelloController {

	//	IHelloService helloService = new HelloService(); // ���� ��ü ���� - tightly coupled
	//	@Inject // = Autowired (�⺻������ ������ �̸��� ���� ���� ����)
	@Autowired
	@Qualifier("helloService") // ���� Ŭ������ ���� ���� ���, ������ ���� �̸� ���� ����
	IHelloService helloService;

//	public HelloController(IHelloService helloService) {
//		this.helloService = helloService;
//	}

	public void hello(String name) {
		System.out.println("HelloController: " + helloService.sayHello(name));
	}
	
	public void goodbye(String name) {
		System.out.println("HelloController: " + helloService.sayGoodbye(name));
	}

}
