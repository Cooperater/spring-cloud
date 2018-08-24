/**
 * 
 */
package com.app.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * @classname:FallBackProvider.java
 * @author luan
 * description:路由端的熔断回滚
 * date:2018年8月24日下午3:31:07
 */
@Component
class FallBackProvider implements ZuulFallbackProvider{

	@Override
	public String getRoute() {
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {

				HttpHeaders hearders = new HttpHeaders();
				hearders.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return hearders;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("There was a error.I am fallback".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				return "OK. I am sure it is OK.";
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				return 200;
			}
			
			@Override
			public void close() {
			}
		};
	}

	
}
