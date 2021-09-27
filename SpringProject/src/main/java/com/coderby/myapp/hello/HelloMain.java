package com.coderby.myapp.hello;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.coderby.myapp.hello.controller.HelloController;
import com.coderby.myapp.hello.service.HelloService;
import com.coderby.myapp.hello.service.IHelloService;

public class HelloMain {

	public static void main(String[] args) {
		//		IHelloService helloService = new HelloService();
		//		HelloController controller = new HelloController(helloService);
		//		controller.hello("tempName");

		AbstractApplicationContext context =
				new GenericXmlApplicationContext("application-config.xml");

		HelloController controller = context.getBean("helloController", HelloController.class);
		controller.hello("karl");

		context.close();
	}

}
