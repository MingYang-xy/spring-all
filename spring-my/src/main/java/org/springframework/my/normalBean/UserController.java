package org.springframework.my.normalBean;

import org.springframework.stereotype.Component;

/**
 * UserController
 *
 * @author XuYang
 * @since 2024/6/13 16:04
 */
@Component
public class UserController {

	private String name;

	private UserService userService;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
