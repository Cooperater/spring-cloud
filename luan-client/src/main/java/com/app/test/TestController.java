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
		System.out.println("现在是luan-celient,端口号"+port+"为您服务：");
		String result = "hi ! "+name+" 现在是luan-celient,端口号"+port+"为您服务";
		return result;
		
	}
}
