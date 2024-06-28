package com.example.mingyang.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class RequestHandledEventListener implements ApplicationListener<ServletRequestHandledEvent> {
	@Override
	public void onApplicationEvent(ServletRequestHandledEvent event) {
		// 在这里处理 ServletRequestHandledEvent
		System.out.println("Request handled: " + event.getRequestUrl());
	}
}