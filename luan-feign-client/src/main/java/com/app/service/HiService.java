/**
 * 
 */
package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.test.EurekaFeignClient;

/**
 * @classname:HiService.java
 * @author luan
 * description:TODO
 * date:2018年8月23日上午11:30:11
 */
@Service
public class HiService {
	@Autowired
	EurekaFeignClient eurekaFeignClient;
	public String sayHi(String name){
		return eurekaFeignClient.sayHiFromClientEureka(name);
		
	}

}
