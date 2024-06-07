package com.example.mingyang.study;

import com.example.mingyang.MyStudyApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * ResourceStudy
 *
 * @author XuYang
 * @since 2024/5/31 15:41
 */
public class ResourceStudy {
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(MyStudyApplication.class, args);

		// Resource：各种各样的文件：class文件，yaml文件读取到后都叫Resource
		// 配置类使用@ImportResource可以在springboot项目中使用xml定义bean
		Resource[] resources = context.getResources("classpath*:META-INF/spring.factories");
		for (Resource resource : resources) {
			System.out.println("resource = " + resource);
		}
	}
}
