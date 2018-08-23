/**
 * 
 */
package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

/**
 * @classname:FeignConfig.java
 * @author luan
 * description:Feign配置类
 * date:2018年8月23日上午11:11:08
 */
@Configuration
public class FeignConfig {
	@Bean
	public Retryer feignRetryer(){
		Retryer retryer = new Retryer.Default();
		return retryer;
		
	}

}
