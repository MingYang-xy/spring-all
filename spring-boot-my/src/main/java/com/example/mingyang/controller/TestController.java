package com.example.mingyang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author XuYang
 * @since 2024/6/7 17:01
 */
@RestController
@RequestMapping("hello")
public class TestController {

	@RequestMapping
	public String test(){
		return "hello world";
	}
}
