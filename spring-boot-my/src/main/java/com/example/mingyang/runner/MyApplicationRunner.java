package com.example.mingyang.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * MyRunner
 *
 * @author XuYang
 * @since 2024/5/31 8:58
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("MyApplicationRunner.....");
	}
}
