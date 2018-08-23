/**
 * 
 */
package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.RibbonService;

/**
 * @classname:RestController.java
 * @author luan
 * description:TODO
 * date:2018年8月21日下午6:27:28
 */
@RestController
public class RibbonController {

	@Autowired
	RibbonService ribbonService;
	@GetMapping("/hello")
	public String hello(@RequestParam(required = false , defaultValue = "luan") String name){
		return ribbonService.hello(name);
		
	}
}
