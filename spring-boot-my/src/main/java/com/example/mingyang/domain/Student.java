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
	 *id
	 */
	private Long id;
	/**
	 * 姓名
	 */

	private String userName;
	/**
	 * 年龄
	 */

	private Long age;

	/**
	 * 性别
	 */
	private String gender;


	// public Long getId() {
	// 	return id;
	// }
	//
	// public void setId(Long id) {
	// 	this.id = id;
	// }
	//
	// public String getUserName() {
	// 	return userName;
	// }
	//
	// public void setUserName(String userName) {
	// 	this.userName = userName;
	// }
	//
	// public Long getAge() {
	// 	return age;
	// }
	//
	// public void setAge(Long age) {
	// 	this.age = age;
	// }
	//
	// public String getGender() {
	// 	return gender;
	// }
	//
	// public void setGender(String gender) {
	// 	this.gender = gender;
	// }
	//
	// @Override
	// public String toString() {
	// 	return "Student{" +
	// 			"id=" + id +
	// 			", userName='" + userName + '\'' +
	// 			", age=" + age +
	// 			", gender='" + gender + '\'' +
	// 			'}';
	// }
}
