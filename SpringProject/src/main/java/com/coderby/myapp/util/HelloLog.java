package com.coderby.myapp.util;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class HelloLog {

	public static void log() {
		System.out.println(">>>LOG<<< : " + new Date()); 
	}
}
