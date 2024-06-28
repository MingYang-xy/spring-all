package com.example.mingyang.controller;

import com.example.mingyang.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TestController
 *
 * @author XuYang
 * @since 2024/6/7 17:01
 */
// @RestController
// @RequestMapping("/hello")
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("/test1")
	public String test1(String na) {
		System.out.println(na);
		return testService.test();
	}

	@GetMapping("/test2")
	public String test2() {
		System.out.println("执行主要逻辑...");
		return "ok";
	}

	@RequestMapping("/test3")
	public String test3() {
		return "3";
	}

	@RequestMapping("/test4")
	private String test4() {
		return testService.test();
	}
}
