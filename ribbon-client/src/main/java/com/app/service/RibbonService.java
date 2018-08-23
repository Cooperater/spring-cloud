
package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @classname:RibbonService.java
 * @author luan
 * description:TODO
 * date:2018年8月21日下午6:19:26
 */
@Service
public class RibbonService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "helloError")
	public String hello(String name){
		return restTemplate.getForObject("http://eureka-client/hello?name="+name, String.class);
		
	}
	
	public String helloError(String name){
		return "hi ! "+name+"  服务器出现异常，熔断开始执行.......";
		
	}
}
