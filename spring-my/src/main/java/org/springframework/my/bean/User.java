package org.springframework.my.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User
 *
 * @author XuYang
 * @since 2024/5/30 9:38
 */
@Component
public class User {

	private final Log logger = LogFactory.getLog(getClass());

	public User() {
		logger.info("user的构造方法执行了");
	}

	@Autowired
	public User(CustomBean customBean) {
		logger.info("user的带Autowired的构造方法执行了，并且注入了bean：" + customBean);
		this.customBean = customBean;
	}

	private String name;

	private int age;

	private CustomBean customBean;

	public CustomBean getCustomBean() {
		return customBean;
	}

	public void setCustomBean(CustomBean customBean) {
		this.customBean = customBean;
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
}
