
package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	public String hello(String name){
		return restTemplate.getForObject("http://eureka-client/hello?name="+name, String.class);
		
	}
}
