package com.example.mingyang.exception;

import com.example.mingyang.domain.Student;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * MyExceptionHandler
 *
 * @author XuYang
 * @since 2024/6/26 14:17
 */
@RestControllerAdvice
public class MyExceptionHandler {

	/**
	 * 初始化绑定器，也就是参数的绑定器，针对一些spring原本没有处理的参数，比如Date类型，我们可以自己定义绑定器
	 * 写在@RestControllerAdvice标记的类中的InitBinder全局有效，写在普通controller中的仅当前controller有效
	 * 这里的registerCustomEditor，是在默认的@RequestParamster参数解析器中的逻辑调用的。因此，如果前面定义了针对Date类型参数的
	 * 参数解析器，就不会进入本方法。因为@RequestParamster参数解析器是兜底解析器，优先级最低。
	 * 这种写法适合解析需要从前端传入数据的参数，resolveArgument适合解析从后端获取的参数。
	 *
	 * @param binder 绑定器
	 * @author XuYang
	 * @since 2024/6/26 14:54
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(new Date());
			}
		});
	}


	/**
	 * 这里的方法的执行逻辑跟正常执行controller方法一个样，会去正常解析参数和处理返回值
	 * 所以这里的方法参数一样可以加一些controller中的注解
	 *
	 * @param e       异常
	 * @param student 自定义的参数
	 * @author XuYang
	 * @since 2024/6/26 14:48
	 */
	@ExceptionHandler(ServiceException.class)
	public Map<String, String> handleServiceException(ServiceException e, Student student) {
		System.out.println(student);
		HashMap<String, String> result = new HashMap<>();
		result.put("code", "500");
		result.put("msg", e.getMessage());
		return result;
	}

}
