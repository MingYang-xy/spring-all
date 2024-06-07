package org.springframework.my.bean;


import jakarta.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




/**
 * Hello
 *
 * @author XuYang
 * @since 2024/5/21 17:54
 */
public class Hello {

	private final Log logger = LogFactory.getLog(getClass());

	@Resource
	private User user;

	public void init() {
		logger.info("Hello的init初始化方法，通过@Bean指定的");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
