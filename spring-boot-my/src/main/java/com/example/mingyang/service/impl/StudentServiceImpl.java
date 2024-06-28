package com.example.mingyang.service.impl;

import com.example.mingyang.domain.Student;
import com.example.mingyang.mapper.StudentMapper;
import com.example.mingyang.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	@Autowired
	private TransactionTemplate transactionTemplate;

	/**
	 * 查询学生列表
	 *
	 * @param student 学生
	 * @return 学生
	 */
	@Override
	public List<Student> selectStudentList(Student student) {
		// 生成三个Student对象，封装成list返回
		Random random = new Random();
		ArrayList<Student> students = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			student.setId((long) random.nextInt(1000));
			student.setUserName("学生" + i);
			student.setAge(random.nextInt(100));
			students.add(student);
		}
		return students;
	}

	/**
	 * 事务失效场景：非事务方法直接this调用事务方法，会失效。但是事务方法直接调非事务方法不会失效，因为执行之前已经tryCatch
	 * 直接注入TransactionTemplate可以使用其中的execute方法，实现事务管理
	 */
	@Override
	public int insertStudent(Student student0) {
		Integer resultRows = transactionTemplate.execute(status -> {
			int effectedRows = 0;
			Student student = new Student();
			student.setAge(100);
			student.setUserName("mingyang");
			student.setGender("1");
			effectedRows += studentMapper.insertStudent(student);
			Student student1 = new Student();
			student1.setAge(1001);
			student1.setUserName("mingyang1");
			student1.setGender("0");
			effectedRows += studentMapper.insertStudent(student1);
			return effectedRows;
		});
		return resultRows == null ? 0 : resultRows;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertStudent2(Student s2) {
		int effectedRows = 0;
		Student student = new Student();
		student.setAge(100);
		student.setUserName("mingyang");
		student.setGender("1");
		effectedRows += studentMapper.insertStudent(student);
		effectedRows += insertStudent3();
		return effectedRows;
	}

	private int insertStudent3() {
		Student student = new Student();
		student.setAge(100);
		student.setUserName("mingyang");
		student.setGender("1");
		studentMapper.insertStudent(student);
		return 1 / 0;
	}
}
