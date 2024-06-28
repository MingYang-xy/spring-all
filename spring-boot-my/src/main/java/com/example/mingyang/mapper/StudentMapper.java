package com.example.mingyang.mapper;

import com.example.mingyang.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 学生Mapper接口
 *
 * @author XuYang
 * @since 2024-06-19 15:11:03
 */
@Mapper
public interface StudentMapper {
	/**
	 * 查询学生
	 *
	 * @param id 学生主键
	 * @return 学生
	 */
	Student selectStudentById(Long id);

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

	/**
	 * 批量新增学生
	 *
	 * @param studentList 学生列表
	 * @return 受影响的行数
	 */
	int batchInsertStudent(List<Student> studentList);

	/**
	 * 修改学生
	 *
	 * @param student 学生
	 * @return 受影响的行数
	 */
	int updateStudent(Student student);

	/**
	 * 删除学生
	 *
	 * @param id 学生主键
	 * @return 受影响的行数
	 */
	int deleteStudentById(Long id);

	/**
	 * 批量删除学生
	 *
	 * @param ids 需要删除的数据主键集合
	 * @return 受影响的行数
	 */
	int deleteStudentByIds(String[] ids);
}
