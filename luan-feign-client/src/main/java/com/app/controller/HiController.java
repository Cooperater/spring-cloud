/**
 * 
 */
package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.HiService;

/**
 * @classname:HiController.java
 * @author luan
 * description:TODO
 * date:2018年8月23日上午11:38:48
 */
@RestController
public class HiController {
	@Autowired
	HiService hiservice;
	@GetMapping("/hello")
public String sayHi(@RequestParam(defaultValue = "luanyi",required = false) String name){
		System.out.println("现在是Feign-celient为您服务：");
	return hiservice.sayHi(name);
		
	}

}
