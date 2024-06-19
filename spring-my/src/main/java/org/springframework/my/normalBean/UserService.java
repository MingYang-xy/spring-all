package org.springframework.my.normalBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserService
 *
 * @author XuYang
 * @since 2024/6/13 16:04
 */
@Component
public class UserService {

	@Autowired
	private UserDao userDao;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
