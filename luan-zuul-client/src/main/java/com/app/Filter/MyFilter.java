/**
 * 
 */
package com.app.Filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @classname:MyFilter.java
 * @author luan
 * description:路由端的过滤器的demo
 * date:2018年8月24日下午4:35:50
 */
@Component
public class MyFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(MyFilter.class);

	
	@Override
	public boolean shouldFilter() {
		return true;
	}


	@Override
	public String filterType() {
		return "pre";
	}


	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		Object accessToken = request.getParameter("token");
		if(accessToken == null){
			log.warn("token is empty");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			try {
				context.getResponse().getWriter().write("token is empty.....");
			} catch (Exception e) {
				return null;
			}
		}
		log.info("请求没有问题，可以继续执行");
		return "请求没有问题，可以继续执行";
	}
}
