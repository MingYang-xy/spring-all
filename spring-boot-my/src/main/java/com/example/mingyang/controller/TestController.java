package com.example.mingyang.controller;

import com.example.mingyang.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TestController
 *
 * @author XuYang
 * @since 2024/6/7 17:01
 */
@RestController
@RequestMapping("/hello")
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("/test1")
	public String test1(){
		return testService.test();
	}

	@GetMapping("/test2")
	public String test2(){
		return testService.test();
	}
}
