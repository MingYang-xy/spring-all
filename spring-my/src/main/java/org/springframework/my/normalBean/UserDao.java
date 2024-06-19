package org.springframework.my.normalBean;

import org.springframework.stereotype.Component;

/**
 * UserDao
 *
 * @author XuYang
 * @since 2024/6/13 16:05
 */
@Component
public class UserDao {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
