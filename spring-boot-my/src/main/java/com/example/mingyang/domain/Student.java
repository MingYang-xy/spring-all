package com.example.mingyang.domain;

import lombok.Data;

/**
 * 学生对象 student
 *
 * @author XuYang
 * @since 2024-06-19 15:11:03
 */
@Data
public class Student {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 姓名
	 */

	private String userName;
	/**
	 * 年龄
	 */

	private Integer age;

	/**
	 * 性别
	 */
	private String gender;
}
