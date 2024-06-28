package com.example.mingyang.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Date;

/**
 * 实现了HandlerMethodArgumentResolver：是webmvc包提供的，handler是指业务中的controller，这就是controller的方法参数解析器
 *
 * @author XuYang
 * @since 2024/6/20 16:38
 */
@Component
public class MyDateArgumentResolver implements HandlerMethodArgumentResolver {

	/**
	 * 处理Date参数
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return Date.class.getName().equals(parameter.getParameterType().getName());
	}

	/**
	 * 解析逻辑
	 */
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
								  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// 下面是使用参数解析器自己解析Date参数的写法，不够灵活，会有很多异常情况需要考虑。
		// 这种情况适合通过@InitBinder，定义一种特定类型的binder方法，在RequestParamMethodArgumentResolver中，会将参数名
		// 参数值都解析好，再去调用我们定义的binder方法，就不用我们自己解析了。
		// resolveArgument这里适合这样的参数：不需要从前端传入，而是从后端某处获取，比如@CurrentUser注解，直接获取当前对象。
		// String parameterName = parameter.getParameterName();
		// if (parameterName == null) {
		// 	throw new ServiceException("参数名不能为空！");
		// }
		// String[] parameterValues = webRequest.getParameterValues(parameterName);
		// if (parameterValues == null || parameterValues.length == 0) {
		// 	throw new ServiceException("参数值不能为空！");
		// }
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// return LocalDate.parse(parameterValues[0], formatter);
		return new Date();
	}
}
