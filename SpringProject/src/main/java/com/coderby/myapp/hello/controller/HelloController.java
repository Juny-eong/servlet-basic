package com.coderby.myapp.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.coderby.myapp.hello.service.IHelloService;

@Controller
public class HelloController {

	//	IHelloService helloService = new HelloService(); // 직접 객체 생성 - tightly coupled
	//	@Inject // = Autowired (기본적으로 변수의 이름과 같은 빈을 주입)
	@Autowired
	@Qualifier("helloService") // 구현 클래스가 여러 개인 경우, 주입할 빈의 이름 지정 가능
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
