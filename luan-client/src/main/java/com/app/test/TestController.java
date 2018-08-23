package com.app.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${server.port}")
	String port;
	@GetMapping("hello")
	public String hello(@RequestParam String name){
		return "hi!  "+name+", I am form port:"+port;
		
	}
}
