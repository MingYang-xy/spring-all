package com.example.mingyang.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * MyListener
 * 要监听spring refresh之前的事件，需要在spring.factories中配置
 *
 * @author XuYang
 * @since 2024/5/30 16:49
 */
public class MyApplicationListener implements ApplicationListener<ApplicationStartingEvent> {
	/**
	 * Handle an application event.
	 *
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("MyListener:" + event);
	}
}
