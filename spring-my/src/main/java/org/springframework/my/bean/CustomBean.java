package org.springframework.my.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CustomBean
 *
 * @author XuYang
 * @since 2024/6/6 9:46
 */
public class CustomBean {

	private final Log logger = LogFactory.getLog(getClass());

	private String name;

	private int age;

	public CustomBean() {
		logger.info("CustomBean的构造方法执行了");
	}

	public Log getLogger() {
		return logger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "CustomBean{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
