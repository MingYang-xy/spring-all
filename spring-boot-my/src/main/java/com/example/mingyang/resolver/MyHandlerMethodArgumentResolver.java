package com.example.mingyang.resolver;

import com.example.mingyang.domain.Student;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * 实现了HandlerMethodArgumentResolver：是webmvc包提供的，handler是指业务中的controller，这就是controller的方法参数解析器
 *
 * @author XuYang
 * @since 2024/6/20 16:38
 */
@Component
public class MyHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	/**
	 * 传入当前参数，如果返回false，表示当前解析器不支持处理该参数，如果返回true，表示可以处理，并且会执行后续的解析逻辑。
	 * 每个参数都会挨个传入解析器的supportsParameter方法，一旦有一个解析器表示能够处理，就会break，就不会继续执行下去。
	 * 因此，参数解析器的顺序至关重要，越靠前的优先级越高。
	 * springMVC有二十多个默认的参数解析器，自定义的解析器被放在倒数第四个（后面还有三个大范围的参数解析器）
	 * 初始化参数解析器见 {@link RequestMappingHandlerAdapter} 的getDefaultArgumentResolvers()
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return Student.class.getName().equals(parameter.getParameterType().getName());
	}

	/**
	 * 解析逻辑
	 */
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		Student student = new Student();
		student.setGender("1");
		student.setUserName("asdasdasda");
		return student;
	}
}
