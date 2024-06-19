package com.example.mingyang.service.impl;

import com.example.mingyang.domain.Student;
import com.example.mingyang.mapper.StudentMapper;
import com.example.mingyang.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学生Service业务层处理
 *
 * @author XuYang
 * @since 2024-06-19 15:11:03
 */
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentMapper studentMapper;

	/**
	 * 查询学生列表
	 *
	 * @param student 学生
	 * @return 学生
	 */
	@Override
	public List<Student> selectStudentList(Student student) {
		return studentMapper.selectStudentList(student);
	}

	/**
	 * 新增学生
	 *
	 * @param student 学生
	 * @return 受影响的行数
	 */
	@Override
	@Transactional
	public int insertStudent(Student student) {
		studentMapper.insertStudent(student);
		int i = 1 / 0;
		return i;
	}

}
