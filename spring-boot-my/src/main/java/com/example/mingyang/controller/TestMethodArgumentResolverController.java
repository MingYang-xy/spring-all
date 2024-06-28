package com.example.mingyang.controller;

import com.example.mingyang.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TestMethodArgumentResolverController
 *
 * @author XuYang
 * @since 2024/6/20 16:49
 */
// @RestController
// @RequestMapping("/arg")
public class TestMethodArgumentResolverController {

	@RequestMapping("/student")
	public String student(Student student) {
		System.out.println(student);
		return "success";
	}
}
