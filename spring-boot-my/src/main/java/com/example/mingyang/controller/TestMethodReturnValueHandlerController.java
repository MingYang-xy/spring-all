package com.example.mingyang.controller;

import com.example.mingyang.domain.Student;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TestMethodReturnValueHandlerController
 *
 * @author XuYang
 * @since 2024/6/20 17:50
 */
// @Controller
// @RequestMapping("/return")
public class TestMethodReturnValueHandlerController {

	@RequestMapping("student")
	public String student() {
		Student student = new Student();
		student.setAge(100);
		student.setUserName("mingyang");
		student.setGender("1");
		return "student";
	}

	/**
	 * 加了@ResponseBody会被{@link AbstractJackson2HttpMessageConverter}将响应头改为application/json;charset=UTF-8
	 * 使用Jackson将对象转为字符串
	 *
	 * @author XuYang
	 * @since 2024/6/20 18:13
	 */
	@RequestMapping("student1")
	@ResponseBody
	public Student student1() {
		Student student = new Student();
		student.setAge(100);
		student.setUserName("mingyang");
		student.setGender("1");
		return student;
	}
}
