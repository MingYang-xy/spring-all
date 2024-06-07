package com.example.mingyang.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;

/**
 * MyEvnPostProcessor
 *
 * @author XuYang
 * @since 2024/5/31 15:01
 */
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

	/**
	 * 简单演示配置文件加密
	 *
	 * @param environment springboot的配置环境
	 * @param application springboot的application
	 */
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		MutablePropertySources mutablePropertySources = environment.getPropertySources();
		// 解密前
		String rawPassword = environment.getProperty("mysql.password");
		System.out.println("rawPassword = " + rawPassword);
		mutablePropertySources.forEach(System.out::println);
		for (PropertySource<?> propertySource : mutablePropertySources) {
			// 我们自己写的配置文件如application.properties、application.yml经由spring处理后都封装成了下面这个类
			if (propertySource instanceof OriginTrackedMapPropertySource) {
				HashMap<String, Object> decryptedConfig = new HashMap<>();
				for (String propertyName : ((OriginTrackedMapPropertySource) propertySource).getPropertyNames()) {
					// 模拟加解密逻辑
					if (propertyName.contains("password")) {
						// 这里只记录需要解密的配置
						decryptedConfig.put(propertyName, "123456");
					}
				}
				// 将解密后的集合放到源集合之前，即解密后配置优先级比源配置优先级更高，同时不影响env的原有顺序。
				OriginTrackedMapPropertySource source =
						new OriginTrackedMapPropertySource("DECRYPTED : " + propertySource.getName(), decryptedConfig);
				mutablePropertySources.addBefore(propertySource.getName(), source);
			}
		}
		// 解密后
		String decryptedPassword = environment.getProperty("mysql.password");
		System.out.println("decryptedPassword = " + decryptedPassword);
		mutablePropertySources.forEach(System.out::println);
	}
}
