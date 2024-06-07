package org.springframework.my.controller;

import org.springframework.stereotype.Controller;

/**
 * HelloController
 *
 * @author XuYang
 * @since 2024/5/29 14:47
 */
@Controller
public class HelloController {

	private String name;

	public int deduce(int a, int b) {
		return a - b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
