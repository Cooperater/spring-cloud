/**
 * 
 */
package com.app.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.config.FeignConfig;

/**
 * @classname:EurekaFeignClient.java
 * @author luan
 * description:测试feign功能是否实现
 * date:2018年8月23日上午11:07:10
 */
@FeignClient(value = "eureka-client" , configuration = FeignConfig.class)
public interface EurekaFeignClient {
	
	@GetMapping("/hello")
	String sayHiFromClientEureka(@RequestParam(value = "name") String name);

}
