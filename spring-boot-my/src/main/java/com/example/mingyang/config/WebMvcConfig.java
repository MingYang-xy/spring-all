package com.example.mingyang.config;


import com.example.mingyang.interceptor.MyHandlerInterceptor;
import com.example.mingyang.interceptor.MyOncePerRequestFilter;
import com.example.mingyang.interceptor.MyWebRequestInterceptor;
import com.example.mingyang.resolver.MyDateArgumentResolver;
import com.example.mingyang.resolver.MyHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * WebMvcConfig
 *
 * @author XuYang
 * @since 2023/12/8 15:11
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private MyHandlerMethodArgumentResolver myMethodArgumentInterceptor;
	@Autowired
	private MyDateArgumentResolver myDateArgumentResolver;
	@Autowired
	private MyWebRequestInterceptor myWebRequestInterceptor;
	@Autowired
	private MyOncePerRequestFilter myOncePerRequestFilter;
	@Autowired
	private MyHandlerInterceptor myHandlerInterceptor;

	/**
	 * 配置拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myHandlerInterceptor).addPathPatterns("/**");
		registry.addWebRequestInterceptor(myWebRequestInterceptor).addPathPatterns("/**");
	}

	/**
	 * 注册自定义的参数解析器
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		// resolvers.add(myDateArgumentResolver);
		resolvers.add(myMethodArgumentInterceptor);
	}

}
