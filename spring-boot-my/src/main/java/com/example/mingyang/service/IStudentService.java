package com.example.mingyang.service;

import com.example.mingyang.domain.Student;

import java.util.List;

/**
 * 学生Service接口
 *
 * @author XuYang
 * @since 2024-06-19 15:11:03
 */
public interface IStudentService {

	/**
	 * 查询学生列表
	 *
	 * @param student 学生
	 * @return 学生集合
	 */
	List<Student> selectStudentList(Student student);

	/**
	 * 新增学生
	 *
	 * @param student 学生
	 * @return 受影响的行数
	 */
	int insertStudent(Student student);

	int insertStudent2(Student student);
}
