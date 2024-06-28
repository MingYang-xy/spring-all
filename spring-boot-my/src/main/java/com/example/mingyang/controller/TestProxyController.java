package com.example.mingyang.controller;

import com.example.mingyang.domain.Student;
import com.example.mingyang.exception.ServiceException;
import com.example.mingyang.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 测试什么时候生成代理对象
 * 实测：只有当前类或者类中的方法存在能够匹配的切面时才会生成代理对象
 * 也就是说，如果一个类中没有任何方法使用了AOP，那么这个类就不会生成代理对象。
 * 业务中：@Transactional、@RequiresPermissions、@RequiresRoles注解都用到了AOP，因此会生成代理对象。
 *
 * @author XuYang
 * @since 2024-06-19 15:11:03
 */
@Controller
@RequestMapping("/student")
public class TestProxyController {

	@Autowired
	private IStudentService studentService;

	/**
	 * 查询学生列表
	 */
	@ResponseBody
	@RequestMapping("/list/{id}")
	public List<Student> list(@PathVariable("id") String id, Student student, Date now) {
		System.out.println("id = " + id);
		System.out.println("now = " + now);
		return studentService.selectStudentList(student);
	}

	/**
	 * 查询学生列表
	 */
	@GetMapping("/list")
	public String list1() {
		return "/list";
	}

	/**
	 * 查询学生列表
	 */
	@ResponseBody
	@RequestMapping("/ex")
	public List<Student> list(Date now) {
		// 配置好@InitBinder之后，前端再传入now参数时就会自动绑定到Date类型的now上
		System.out.println("now = " + now);
		throw new ServiceException("测试异常!");
	}

	/**
	 * 新增保存学生
	 */
	@ResponseBody
	@RequestMapping("/add")
	public int add(Student student) {
		return studentService.insertStudent(student);
	}

	/**
	 * 新增保存学生
	 */
	@ResponseBody
	@RequestMapping("/add2")
	public int add2(Student student) {
		return studentService.insertStudent2(student);
	}
}
