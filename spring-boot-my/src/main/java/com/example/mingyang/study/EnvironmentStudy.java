package com.example.mingyang.study;

import com.example.mingyang.MyStudyApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.io.IOException;

/**
 * EnvironmentStudy
 *
 * @author XuYang
 * @since 2024/5/31 15:42
 */
public class EnvironmentStudy {
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(MyStudyApplication.class, args);
		// Environment：系统环境变量、JVM运行时参数、各种配置文件中的配置信息，统称environment
		ConfigurableEnvironment environment = context.getEnvironment();
		String bannerMode = environment.getProperty("spring.main.bannerMode");
		System.out.println("bannerMode = " + bannerMode);
		// MutablePropertySources：属性配置来源的集合
		// PropertySources：属性配置来源：每个对象代表一种配置来源，如：
		// systemEnvironment表示来自系统环境变量，systemProperties代表来自JVM运行时参数
		// OriginTrackedMapPropertySource表示来自我们自定义的配置文件中的信息，【application.yml，application.properties】
		MutablePropertySources propertySources = environment.getPropertySources();
		for (PropertySource<?> propertySource : propertySources) {
			System.out.println("propertySource = " + propertySource);
		}

	}
}
