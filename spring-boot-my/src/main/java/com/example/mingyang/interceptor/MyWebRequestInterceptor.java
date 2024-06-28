package com.example.mingyang.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * MyWebRequestInterceptor
 *
 * @author XuYang
 * @since 2024/6/21 14:06
 */
@Component
public class MyWebRequestInterceptor implements WebRequestInterceptor {
	@Override
	public void preHandle(WebRequest request) throws Exception {
		System.out.println("MyWebRequestInterceptor preHandle");
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		System.out.println("MyWebRequestInterceptor postHandle" + model);
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		System.out.println("MyWebRequestInterceptor afterCompletion" + ex);
	}
}
